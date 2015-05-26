import java.awt.*;
import javax.swing.*;

public class EntryTable extends JPanel
{
    JTable entered;

    public EntryTable()
    {
        String [] columnNames = {"","","","","","","","",""};
        Integer[][] init = {{0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0}};
        entered = new JTable (init, columnNames);
        entered.setPreferredScrollableViewportSize(new Dimension(500,500));
        entered.setFillsViewportHeight(true);
    }
}
