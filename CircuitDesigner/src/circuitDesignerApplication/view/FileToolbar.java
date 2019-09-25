package circuitDesignerApplication.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class FileToolbar extends JToolBar {
	
	public FileToolbar(){
        JButton exitButton = new JButton();
         exitButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent event) {
                System.exit(0);
                }
        	 });
         
         JButton newFile = new JButton();
         newFile.setToolTipText("New File");
         JButton open = new JButton();
         open.setToolTipText("Open Design");
         JButton save = new JButton();
         save.setToolTipText("Save Design");
       
         
         this.add(newFile);
         this.add(open);
         this.add(save);
         this.add(exitButton);
         
         this.setFloatable(false);
    }
}
