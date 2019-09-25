package circuitDesignerApplication.controller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import circuitDesignerApplication.Main;
import circuitDesignerApplication.model.ComponentTableModel;


public class Picker extends JFrame {
	private final int width=800;
	private final int height=1200;
	private String selected;
	private JPanel right;
	

	 public Picker() {
		 this.setTitle("Components Picker");
		 this.setSize(new Dimension(width, height));
		 this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		 right = new JPanel() {
	            public void paint(Graphics g) {
	                super.paint(g);
	                Graphics2D g2d = (Graphics2D) g;
	                if (selected != null) {
	                    Main.classForName(selected, 50, 25,2).draw(g2d);
	                }
	            }
	        };
	        GridLayout gl = new GridLayout(0, 1);
	        right.setLayout(gl);
		 this.add(right);
	     this.setLocationRelativeTo(null);
		 this.setVisible(true);
	        
	        
	 }
	 
	 public JScrollPane addTable() {
		 TableModel model = new ComponentTableModel();
		 final JTable table = new JTable(model);
		 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 table.setColumnSelectionAllowed(false);
		 table.setRowSelectionAllowed(true);
		 JScrollPane scrollPane = new JScrollPane(table);
		 table.setFillsViewportHeight(true);
		 
		 table.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 
				 selected = (String) table.getValueAt(((JTable)e.getSource()).getSelectedRow(), 0);
				 if (e.getClickCount() == 2) {
					 JTable target = (JTable) e.getSource();
					 int row = target.getSelectedRow();
					 int column = target.getSelectedColumn();
					 System.out.println("row: " + row + " column: " + column);
					 System.out.println(table.getValueAt(row, 0));
					 circuitDesignerApplication.view.ComponentsViewer.addToList((String) table.getValueAt(row, 0));
					 }
				 }
			 });
		 return scrollPane;
		 }
	 }
