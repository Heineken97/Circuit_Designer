package circuitDesignerApplication.view;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
	
	private static Sheet sheet;
    private static Toolbar tool;
    private static Window ref;
    
    public Window(){
    	
    	ref= this;
    	
        this.setTitle("Circuit Designer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(600, 600));
        this.setMenuBar(new MenuBar());
        this.add(new FileToolbar(), BorderLayout.NORTH);
        
        sheet = new Sheet(1000,1000);
        JScrollPane thePane = new JScrollPane(sheet);
        this.add(thePane, BorderLayout.CENTER);
        
        
        tool = new Toolbar();
        this.add(tool, BorderLayout.SOUTH);
        

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    
	public Toolbar getTool() {
		return tool;
	}
	public static void setTool(Toolbar tool) {
		Window.tool = tool;
	}
   
}
