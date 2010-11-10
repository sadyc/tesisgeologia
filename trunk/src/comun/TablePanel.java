package comun;


/**
 * Created on 01-nov-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Daniel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TablePanel extends JPanel {

	/** table */
	private JTable table = null; 
	
	private DefaultTableModel tableModel = null;

    private JScrollPane scrollPane = null;  
	
    
	
	public TablePanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.scrollPane = new JScrollPane();
		this.tableModel = new DefaultTableModel();
		this.table = new JTable(this.tableModel);	
		this.scrollPane.getViewport().add(this.table, null);
		this.add(this.scrollPane, null);	
	}
	
	
	public void setBoundsTable(int x, int y, int w, int h){
	    this.setBounds(x, y, w, h);
	    this.scrollPane.setBounds( x, y, w-10, h-10);
	    this.table.setBounds(x, y, w-20, h-20);
	}
	
	/**
	 * It load the data in the table
	 * @param data
	 * @param columnName
	 */
	public void setData(Object[][] data, String[] columnName){
		this.tableModel.setDataVector(data, columnName);
//		this.table.setModel(this.tableModel);
		this.repaint();		
	}
	
	/**
	 * It return the selected row
	 * @return
	 */
	public int getSelectedRow(){
		return this.table.getSelectedRow();		
	}
	
	/**
	 * it return one row
	 * @param row
	 * @return
	 */
	public String[] getRow(int row){
		int columnCoun = this.tableModel.getColumnCount();
		String[] auxrow = new String[columnCoun];
		for (int i = 0; i < columnCoun; i++) {
			auxrow[i] =  this.tableModel.getValueAt(row, i).toString();
		}	     	
		return auxrow;
	}
	
	/**
	 * It add one row
	 * @param dataRow
	 */
	public void addRow(String[] dataRow){
		this.tableModel.addRow(dataRow);		
	}
	
	public void removeRow(int nro){
		this.tableModel.removeRow(nro);		
	}
    	
}
