package circuitDesignerApplication.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static Window reference;
	
	public Window() {
		reference= this;
		reference.setTitle("Circuit Designer");
		reference.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reference.setSize(new Dimension(1200,800));
		reference.setLocationRelativeTo(null);
		reference.setVisible(true);	
	}

}
