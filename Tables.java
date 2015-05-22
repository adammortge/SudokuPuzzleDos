
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
/**
 * Write a description of class Tables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tables
{
    // instance variables - replace the example below with your own
    private int x;
    private JTable puzzle = new JTable(9,9);
    /**
     * Constructor for objects of class Tables
     */
    public Tables()
    {
        this.JTable();
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void JTable()
    {
       addTable(puzzle);
    }
    
}
