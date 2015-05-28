import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Where the panels are displayed from and where the buttons have their calls
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeezLemons 
{
    private int [][] values;
    private boolean[][] guesses;
    private EntryTable table;
    private JFrame initframe;
    private JFrame secondframe;
    private PuzzleFrame puzzle;
    /**
     * Has user enter the known numbers in a puzzle
     */
    public DeezLemons()
    {
        initframe = new JFrame("Enter Knowns");
        table = new EntryTable();
        initframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initframe.getContentPane().add(table, BorderLayout.CENTER);

        JPanel panel2 = new JPanel ();

        JButton finished = new JButton("Click When Finished Entering. Leave Unknowns as 0.");
        finished.addActionListener(new NumListener());

        panel2.add(finished);
        initframe.getContentPane().add(panel2, BorderLayout.SOUTH);

        initframe.pack();
        initframe.setVisible(true);
    }

    /**
     * Pulls up the second window which has the 3 buttons and allows you to input guesses.
     */
    private void secondWindow()
    {
        initframe.dispatchEvent(new WindowEvent(initframe, WindowEvent.WINDOW_CLOSING));
        secondframe = new JFrame("Enter Guesses");
        secondframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        puzzle = new PuzzleFrame(values, false);
        secondframe.getContentPane().add(puzzle, BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton clearButton = new JButton("Clear");
        JButton checkButton = new JButton("Check");
        JButton showSolutionButton = new JButton("Show Solution");

        clearButton.addActionListener(new ClearListener());
        checkButton.addActionListener(new CheckListener());
        showSolutionButton.addActionListener(new ShowSolutionListener());

        panel.add(clearButton);
        panel.add(checkButton);
        panel.add(showSolutionButton);

        secondframe.getContentPane().add(panel, BorderLayout.SOUTH);

        secondframe.pack();
        secondframe.setVisible(true);

    }
    /** 
     * So the User can input numbers 
     */
    private class NumListener implements ActionListener
    {
        public NumListener ()
        {
        }

        public void actionPerformed(ActionEvent e)
        {
            values = ValueGetter.getVals(table.getTableModel());
            secondWindow();
        }
    }
    /**
     * So the user can clear the guesses they made leaving the original numbers in the puzzle
     */
    private class ClearListener implements ActionListener
    {
        public ClearListener()
        {
        }

        public void actionPerformed(ActionEvent e)
        {
            values = puzzle.getPuzzle().getOriginal();
            secondframe.dispatchEvent(new WindowEvent(initframe, WindowEvent.WINDOW_CLOSING));
            secondWindow();
        }
    }
    /** 
     * Sends a call to the check method to see if the solution is correct to the one that the created based on 
     * numbers inputed
     */
    private class CheckListener implements ActionListener
    {
        public CheckListener()
        {
        }

        public void actionPerformed(ActionEvent e)
        {
            boolean[][] checker = puzzle.getEvaluation();
            for(int r=0; r<checker.length;r++)
            {
                for(int c=0; c<checker[0].length;c++)
                {
                    if(checker[r][c]==false)
                    {
                        System.out.println("Row " + (r+1) + " and Column " + (c+1) + " is incorrect.");
                        System.out.println();
                    }
                }
            }
        }
    }
    /**
     * This will show the solution to the puzzle
     */
    private class ShowSolutionListener implements ActionListener
    {
        public ShowSolutionListener()
        {
        }

        public void actionPerformed(ActionEvent e)
        {
            int [][] vals = puzzle.getPuzzle().getSolved();
            JFrame thirdframe = new JFrame("Solution");
            thirdframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            PuzzleFrame puzzle2 = new PuzzleFrame(vals, true);
            thirdframe.getContentPane().add(puzzle2, BorderLayout.CENTER);
            thirdframe.pack();
            thirdframe.setVisible(true);
        }
    }
}
