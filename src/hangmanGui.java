import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanGui 
{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JTextArea textArea ;

   public HangmanGui()
   {
      prepareGUI();
   }
   public void display()
   {
      HangmanGui swingControlDemo = new HangmanGui();  
      swingControlDemo.showEventDemo();       
   }
   private void prepareGUI()
   {
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() 
      {
         public void windowClosing(WindowEvent windowEvent)
         {
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel() ;
      controlPanel.setLayout(new FlowLayout()) ;

      mainFrame.add(headerLabel) ;
      mainFrame.add(controlPanel) ;
      mainFrame.add(statusLabel) ;
      mainFrame.setVisible(true) ;  
   }
   private void showEventDemo()
   {
      headerLabel.setText("Control in action: Button") ; 

      JButton okButton = new JButton("OK") ;
      textArea = new JTextArea("Enter answer here") ;
      
      okButton.setActionCommand("OK") ;

      okButton.addActionListener(new ButtonClickListener()) ;

      textArea.setBounds(20,75,250,200);
      
      controlPanel.add(okButton) ;      
      controlPanel.add(textArea) ;

      mainFrame.setVisible(true) ;  
   }
   private class ButtonClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         String command = e.getActionCommand() ;  
         
         if( command.equals( "OK" )) 
         {
            statusLabel.setText(textArea.getText()) ;
         }  	
      }		
   }
}