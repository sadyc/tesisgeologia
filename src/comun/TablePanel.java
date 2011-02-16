package comun;


/**
 * Created on 01-nov-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * @author Daniel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TablePanel extends JPanel {

	/** table */
	private JTable table = null; 
	
	private Table tableModel = null;

    private JScrollPane scrollPane = null;
    
    private final TableRowSorter<TableModel> modeloOrdenado;
    
   
	
    
	
	public TablePanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.scrollPane = new JScrollPane();
		this.tableModel = new Table();
		this.table = new JTable(tableModel){
			
			public boolean isCellEditable(int row,int column) { 
			  return false;
			}
			
		};
		modeloOrdenado = new TableRowSorter<TableModel>(tableModel);
		table.setRowSorter(modeloOrdenado);
		table.getTableHeader().setReorderingAllowed(false);
	//	table.setDefaultRenderer ( Object.class, new MyRenderer ()) ;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(null);
		this.scrollPane.getViewport().add(this.table, null);
		this.add(this.scrollPane, null);	
	}
	
	public void setBoundsTable(int x, int y, int w, int h){
	    this.setBounds(x, y, w, h);
	    this.scrollPane.setBounds( x, y, w-10, h-10);
	    this.table.setBounds(x, y, w-20, h-20);
	}
	
	public TableRowSorter<TableModel> getSorter(){
		  return modeloOrdenado;
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
    	
	public void addTableMouseListener (MouseListener lis){
		   this.table.addMouseListener(lis);
		 }
		
	public void addTableKeyListener (KeyListener lis){
		this.table.addKeyListener(lis);
	}
	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	

}
