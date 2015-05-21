
/**
 * Write a description of class GUI2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI2 extends JFrame
{    private int cellX=50;
    private int cellY=50;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do 
        // not allow access to the AWT system event queue which JApplets do 
        // on startup to check access. May not be necessary with your browser. 
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        
        

        // provide any initialisation necessary for your JApplet
    }

    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
    }

    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    public void paint(Graphics g)
    {

        String[][] array = new String[9][9];
        //selected cell
        g.setColor(Color.magenta);
        g.fillRect(cellX,cellY,60,60);

        // simple text displayed on applet
        g.setColor(Color.black);
        g.fillRect(0,0,50,590);
        g.fillRect(590,0,50,590);
        g.fillRect(0,0,590,50);
        g.fillRect(0,590,640,50);
        for(int ctr=50; ctr<=600;ctr+=60)
        {
            g.drawLine(ctr,0,ctr,590);
        }
        for(int ctr=50; ctr<=600;ctr+=60)
        {
            g.drawLine(0,ctr,590,ctr);
        }
        g.fillRect(227,0,6,590);
        g.fillRect(407,0,6,590);
        g.fillRect(0,227,590,6);
        g.fillRect(0,407,590,6);

        

        
        
        
        
        
        //         g.setColor(Color.black);
        //         g.drawString("Sample Applet", 20, 20);
        //         g.setColor(Color.blue);
        //         g.drawString("created by BlueJ", 20, 40);
        repaint();
    }

    public class MyListener implements KeyListener 
        {
            public void keyPressed(KeyEvent e)
            {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_RIGHT)
                {
                    cellX+=50;
                }
                repaint();
            }

            public void keyReleased(KeyEvent e)
            {

            }

            public void keyTyped(KeyEvent e)
            {

            }
        }
   

    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }

    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }

    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                {"firstParameter",    "1-10",    "description of first parameter"},
                {"status", "boolean", "description of second parameter"},
                {"images",   "url",     "description of third parameter"}
            };
        return paramInfo;
    }
}
