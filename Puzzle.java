import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
/**
 * Creates the frame that allows the user to enter guesses, also creates a puzzle with a solution
 */
public class Puzzle extends JPanel 
{
    private JTable puzzle2;
    private SudokuPuzzle p;
    private boolean [][] guesses;
    
    /**
     * creates a new frame, source is the original entries, it stores this so if cleared this will 
     * show up. Shows a new panel that can be edited.
     */
    public Puzzle(int[][] source)
    {
        p = new SudokuPuzzle(source);
        setLayout(new FlowLayout());
        String[][] nums = new String[9][9];
        for (int x = 0; x < source.length; x++)
        {
            for (int y = 0; y < source[0].length; y++)
            {
                nums[x][y] = new String("" + source[x][y]);
            }
        }
        String[] columnNames = {"","","","","","","","",""};

        puzzle2 = new JTable(nums, columnNames);
        puzzle2.setPreferredScrollableViewportSize(new Dimension(500,500));
        puzzle2.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(puzzle2);
        add(scrollPane);

    }
    /**
     * Allows the values from the table to be passed out of the puzzle window
    */
    public TableModel getTableModel()
    {
        return puzzle2.getModel();
    }
    /**
     * Allows for the puzzle object to be passed out of the puzzle window
     */
    public SudokuPuzzle getPuzzle()
    {
        return p;
    }
    /**
     * Allows for each of the user's guesses to be evaluated against the solution
     */

    public boolean [][] getEvaluation ()
    {
        return p.checkGuess(ValueGetter.getVals(this.getTableModel()));
    }
    
}
