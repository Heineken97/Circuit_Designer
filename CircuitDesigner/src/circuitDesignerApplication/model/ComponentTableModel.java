package circuitDesignerApplication.model;

import javax.swing.table.AbstractTableModel;

import circuitDesignerApplication.Main;

public class ComponentTableModel extends AbstractTableModel {
	private String[] columnNames = {
			"Component",
			};
	private Object[][] data = Main.getData();
	
	public ComponentTableModel() {
		
	}
	@Override
	public int getRowCount() {
		return data.length;
		}

	@Override
	public int getColumnCount() {
		return columnNames.length;
		}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
		}
	public String getColumnName(int col) {
		return columnNames[col];
		}
}
