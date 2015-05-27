import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;

public class PuzzleFrame extends JPanel 
{
    JTable puzzle2;
    SudokuPuzzle p;
    boolean [][] guesses;

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
    
    public void repaint ()
    {
    }
}
