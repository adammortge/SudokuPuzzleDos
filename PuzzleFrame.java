
import java.awt.*;
import javax.swing.*;

public class PuzzleFrame extends JPanel 
{
    JTable puzzle2;
    SudokuPuzzle p;

    public PuzzleFrame(int[][] source, boolean solved)
    {
        p = new SudokuPuzzle(source,solved);
        setLayout(new FlowLayout());
        //puzzle.setTableHeader(null);
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

    //     private boolean isCellEditable(int row,int col)
    //     {
    //         TableModel table = puzzle2.getModel();
    //         for (int i = 0; i < table.getRowCount(); i++) 
    //         {
    //             for (int j = 0; j < table.getColumnCount(); j++) 
    //             {
    //                 if(table.getValueAt!=0)
    //                 {
    //                     return false;
    //                 }
    //                 return true;
    //             }
    //         }
    //     }
}
