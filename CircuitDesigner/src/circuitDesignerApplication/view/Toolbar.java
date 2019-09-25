package circuitDesignerApplication.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;


public class Toolbar extends JToolBar {
	
	private JButton mousePos;
    private static Toolbar ref;
    private static boolean running = false;
    private static Color inactiveColor = new Color(238,238,238);

    public Toolbar() {
        ref = this;
        this.setLayout(new BorderLayout());
       
        mousePos = new JButton("Mouse Pos");
        mousePos.setEnabled(false);
        mousePos.setPreferredSize(new Dimension(150, 10));
        this.add(mousePos, BorderLayout.LINE_END);
    }
    
    public void changeMousePosition(int x, int y) {
        mousePos.setText("X: " + x + " | Y: " + y);
    }


}
