package circuitDesignerApplication.controller;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import circuitDesignerApplication.model.ComponentTableModel;


public class Picker extends JFrame {
	private final int width=800;
	private final int height=1200;
	private String selected;
	

	 public Picker() {
		 this.setTitle("Components Picker");
		 this.setSize(new Dimension(width, height));
		 this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
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
