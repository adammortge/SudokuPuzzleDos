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
    EntryTable table;
    JFrame initframe;
    JFrame secondframe;
    PuzzleFrame puzzle;
    public DeezLemons()
    {
        //         JFrame frame = new JFrame("Sudoku");
        //         
        //         
        //         
        //         //puz gui = new puz();
        //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //         frame.setPreferredSize(new Dimension(600,600));
        //         
        //         frame.getContentPane().add(new puz());
        //         
        //         frame.setVisible(true);
        //         frame.setTitle("SudokuPuzzle");
        
        
        initframe = new JFrame("Enter Knowns");
        table = new EntryTable();
        initframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //initframe.dispatchEvent(new WindowEvent(initframe, WindowEvent.WINDOW_CLOSING));
        secondframe = new JFrame("Enter Guesses");
        secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        puzzle = new PuzzleFrame(values, false);
        secondframe.getContentPane().add(puzzle, BorderLayout.CENTER);
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
           values = table.getVals();
           funWithJavaPart2();
        }
    }
}
