import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.lang.Integer;
/**
 * Creates the original window where the user enters in the known numbers of the puzzle
 */
public class EntryTable extends JPanel
{
    private JTable entered;
    private JButton finished;

    public EntryTable()
    {
        String [] columnNames = {"","","","","","","","",""};
        String[][] init = {{"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"},
                {"0","0","0","0","0","0","0","0","0"}};

        entered = new JTable (init, columnNames);
        entered.setPreferredScrollableViewportSize(new Dimension(500,500));
        entered.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(entered);
        this.add(scrollPane);
    }
    /**
     * Allows for the values that the user enters to be passed out of this window
     */
    
    public TableModel getTableModel()
    {
        return entered.getModel();
    }
}
