import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.lang.Integer;

public class EntryTable extends JPanel
{
    JTable entered;
    JButton finished;

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
    
    public TableModel getTableModel()
    {
        return entered.getModel();
    }
}
