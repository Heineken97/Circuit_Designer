package circuitDesignerApplication.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ComponentsViewer extends JPanel {
    private static Vector<String> listOfComponents = new Vector<>(0);
    private static JList list;
    
    public ComponentsViewer() {

        list = new JList(listOfComponents);
        JScrollPane pane = new JScrollPane(list);
        
        pane.setPreferredSize(new Dimension(50, this.getPreferredSize().height - 1));

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                }
            }
        });
            
        JButton pick = new JButton("Pick Components");
        pick.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		new Picker();
        		}
        	});
        
        this.add(new JLabel("Component View"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(pick);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(pane);
        this.setBorder(BorderFactory.createLineBorder(Color.red));
    }

    public static void addToList(String s) {
        if (listOfComponents.contains(s)) {
            return;
        }
        listOfComponents.add(s);
        list.updateUI();
    }

}
