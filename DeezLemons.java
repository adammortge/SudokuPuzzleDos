import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeezLemons 
{
    int [][] values;
    boolean[][] guesses;
    EntryTable table;
    JFrame initframe;
    JFrame secondframe;
    PuzzleFrame puzzle;
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

    private void funWithJavaPart2()
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
    private class NumListener implements ActionListener
    {
        public NumListener ()
        {
        }

        public void actionPerformed(ActionEvent e)
        {
            values = ValueGetter.getVals(table.getTableModel());
            funWithJavaPart2();
        }
    }
    private class ClearListener implements ActionListener
    {
        public ClearListener()
        {
        }
        public void actionPerformed(ActionEvent e)
        {
            values = puzzle.getPuzzle().getOriginal();
            secondframe.dispatchEvent(new WindowEvent(initframe, WindowEvent.WINDOW_CLOSING));
            funWithJavaPart2();
        }
    }
    private class CheckListener implements ActionListener
    {
        public CheckListener()
        {
        }
        public void actionPerformed(ActionEvent e)
        {
            puzzle.checkGuesses();
        }
    }
    private class ShowSolutionListener implements ActionListener
    {
        public ShowSolutionListener()
        {
        }
        public void actionPerformed(ActionEvent e)
        {
            values = puzzle.getPuzzle().getSolved();
            secondframe.dispatchEvent(new WindowEvent(initframe, WindowEvent.WINDOW_CLOSING));
            funWithJavaPart2();
        }
    }
}
