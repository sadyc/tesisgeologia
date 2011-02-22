package comun;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * @brief Clase que implementa las tablas utilizadas en el sistema. 
 * @author TesisGeologia.
 * @version 1.0
 */
public class TablePanel extends JPanel {

	private JTable table = null; 
	private DefaultTableModel tableModel = null;
    private JScrollPane scrollPane = null;
    private final TableRowSorter<TableModel> modeloOrdenado;
    
   /**
    * Constructor por defecto de la clase.
    */
	public TablePanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.scrollPane = new JScrollPane();
		this.tableModel = new DefaultTableModel();
		this.table = new JTable(tableModel){
			public boolean isCellEditable(int row,int column) { 
			  return false;
			}
		};
		modeloOrdenado = new TableRowSorter<TableModel>(tableModel);
		table.setRowSorter(modeloOrdenado);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setUpdateSelectionOnSort(true);
		table.setVerifyInputWhenFocusTarget(true);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
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
		this.repaint();		
	}
	
	/**
	 * It return the selected row
	 * @return
	 */
	public int getSelectedRow(){
		try{
			return table.convertRowIndexToModel(table.getSelectedRow());		
		}catch (Exception e) {
			return -1;
		}
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

    /**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	

}
