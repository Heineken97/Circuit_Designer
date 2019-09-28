package circuitDesignerApplication.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class FileToolbar extends JToolBar {
	
	public FileToolbar(){
        JButton exitButton = new JButton();
        exitButton.setText("Exit");
         exitButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent event) {
                System.exit(0);
                }
        	 });
      
         JButton save = new JButton();
         save.setText("Save Design");
         save.setToolTipText("Save Design");

         this.add(save);
         this.add(exitButton);
         
         this.setFloatable(false);
    }
}
