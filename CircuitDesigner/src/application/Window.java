package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Window extends JFrame {
	private static Sheet sheet;
    private static SimulateToolbar sim;
    private static String fixedTitle = "Circuit Designer";
    private static String fileName = "Untitled";
    private static String title = fileName+" - "+fixedTitle;
    private static Window ref;
    public Window(){
        ref = this;
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(600, 600));
        this.setJMenuBar(new MenuBar());
        this.add(new FileToolbar(), BorderLayout.NORTH);
        this.add(new Verticalbar(), BorderLayout.WEST);
        sheet = new Sheet(1000,1000);
        JScrollPane thePane = new JScrollPane(sheet);
        this.add(thePane, BorderLayout.CENTER);
        sim = new SimulateToolbar();
        this.add(sim, BorderLayout.SOUTH);
        
//        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
//        this.add(new Toolbar(), BorderLayout.WEST);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
//        this.setFocusable(true);
//        sheet.gridOff();
    }
    
    private void setJMenuBar(MenuBar menuBar) {
		// TODO Auto-generated method stub
		
	}

	public static void changeTitle(String s){
        title = s+" - "+fixedTitle;
        ref.setTitle(title);
    }

	public static SimulateToolbar getSim() {
		return sim;
	}
	public static void setSim(SimulateToolbar sim) {
		Window.sim = sim;
	}

}
