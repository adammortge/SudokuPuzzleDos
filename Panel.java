
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
/**
 * Write a description of class Panel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panel extends GUI
{
    // instance variables - replace the example below with your own
    private int x;
    private JScrollPane sPuzzle;
    private JPanel window = new JPanel() ;
    private JTable t;
    /**
     * Constructor for objects of class Panel
     */
    public Panel()
    {
       t = Tables();
       this.addTable(t);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public JPanel addTable(JTable t){
        sPuzzle = new JScrollPane(t);
        window.add(sPuzzle);
        return window;
    }
}
