package circuitDesignerApplication.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import circuitDesignerApplication.Main;
import circuitDesignerApplication.controller.Mouse;
import circuitDesignerApplication.model.ComponentTableModel;
import circuitDesignerApplication.model.logicGate.And;
import circuitDesignerApplication.view.images.Images;

public class ComponentsViewer extends JPanel {
	
	private String selected;
	private JPanel componentsRight;
    private static Vector<String> listOfComponents = new Vector<>(0);
    private static JList list;
    
    
    
    public ComponentsViewer() {
    	
 
		list = new JList(listOfComponents);
        JScrollPane pane = new JScrollPane(list);
        pane.setPreferredSize(new Dimension(50, this.getPreferredSize().height - 1));
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	String name = (String) list.getSelectedValue();
                    System.out.println("Item Selected: " + name);
                    Mouse.setComponent(name);
                }
            }
        });
            
        JButton create_component = new JButton("New Component");
        create_component.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		///Falta modificar
        		new Picker();
        		 addToList("Componente");
        		}
        	});
        
        this.add(new JLabel("Component View"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(pane);
        this.add(create_component);
        this.setBorder(BorderFactory.createLineBorder(Color.red));
    }
    public void paint(Graphics g) {
    	super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (selected != null) {
            Main.classForName(selected, 50, 25,2).draw(g2d);
        }
    }
			 

    public static void addToList(String s) {
        if (listOfComponents.contains(s)) {
            return;
        }
        listOfComponents.add(s);
        list.updateUI();
    }

}
