import javax.swing.table.*;
/** 
 * Allows values passed out of a table to be converted into an array of integers which can be
 * passed in elsewhere
 */
public class ValueGetter
{
    public static int [][] getVals(TableModel model)
    {
        int [][] values = new int[9][9];
        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                values[x][y] = Integer.parseInt(model.getValueAt(x,y).toString());
            }
        }
        return values;
    }
}
