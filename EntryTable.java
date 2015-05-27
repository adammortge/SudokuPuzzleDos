import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.table.AbstractTableModel;

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

        JButton finished = new JButton("Click When Finished Entering. Leave Unknowns as 0.");
        this.add(finished);
    }

    private class ButtonListener implements ActionListener
    {
        public ButtonListener ()
        {
        }

        public void actionPerformed (ActionEvent e)
        {
            throw new Exception("Return vals");
        }
    }

    public int [][] getVals ()
    {
        int [][] values = new int[9][9];
        TableModel model = entered.getModel();
        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                values[x][y] = new Integer(model.getValueAt(x,y));
            }
        }
        return values;
    }
}
