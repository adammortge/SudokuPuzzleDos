import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
/**
 * Creates the frame and sends out call to check the puzzle.
 */
public class PuzzleFrame extends JPanel 
{
    private JTable puzzle2;
    private SudokuPuzzle p;
    private boolean [][] guesses;
    
    /**
     * creates a new frame, source is the original entries, it stores this so if cleared this will 
     * show up. Shows a new panel that can be edited.
     */
    public PuzzleFrame(int[][] source, boolean solved)
    {
        p = new SudokuPuzzle(source,solved);
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
    public TableModel getTableModel()
    {
        return puzzle2.getModel();
    }
    
    public SudokuPuzzle getPuzzle()
    {
        return p;
    }
    
    public void checkGuesses ()
    {
        guesses = p.checkGuess(ValueGetter.getVals(this.getTableModel()));
    }
    
    public boolean [][] getEvaluation ()
    {
        this.checkGuesses();
        return guesses;
    }
    
    public void repaint ()
    {
    }
}
