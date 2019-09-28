package circuitDesignerApplication.view;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
	
	private static Sheet sheet;
    private static MouseBar mousepos;
    private static Window ref;
    
    public Window(){
    	
    	ref= this;
    	
        this.setTitle("Circuit Designer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(1200, 800));
        this.setMenuBar(new MenuBar());
        this.add(new FileToolbar(), BorderLayout.NORTH);
        
        sheet = new Sheet(1000,1000);
        JScrollPane thePane = new JScrollPane(sheet);
        this.add(thePane, BorderLayout.CENTER);
        
        ComponentsViewer component= new ComponentsViewer();
        this.add(component,BorderLayout.EAST);
        
        
        mousepos = new MouseBar();
        this.add(mousepos, BorderLayout.SOUTH);
        

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

	/**
	 * @return the mousepos
	 */
	public static MouseBar getMousepos() {
		return mousepos;
	}
	public static void setMousepos(MouseBar mousepos) {
		Window.mousepos = mousepos;
	}

   
   
}
