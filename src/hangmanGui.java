import java.awt.BorderLayout;

import javax.swing.* ;

public class hangmanGui
{
    public void display()
    {
    	JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
       JButton button1 = new JButton("Press");
       frame.getContentPane().add(button1);
       frame.setVisible(true);
    }
}