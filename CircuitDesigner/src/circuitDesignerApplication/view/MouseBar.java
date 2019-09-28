package circuitDesignerApplication.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;


public class MouseBar extends JToolBar {
	
	private JButton mousePos;
    private static MouseBar ref;
    private static Color inactiveColor = new Color(238,238,238);

    public MouseBar() {
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
