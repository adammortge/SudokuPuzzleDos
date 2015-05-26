import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner 
{
    public static void main(String args[])
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

        JFrame initframe = new JFrame("Enter Knowns");
        initframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initframe.getContentPane().add(new EntryTable(), BorderLayout.CENTER);
        
        
        JPanel panel2 = new JPanel ();
        JButton finished = new JButton("Click When Finished Entering. Leave Unknowns as 0.");
        panel2.add(finished);
        initframe.getContentPane().add(panel2, BorderLayout.SOUTH);
        
        initframe.pack();
        initframe.setVisible(true);
    }
}
