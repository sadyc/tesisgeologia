package comun;

import javax.swing.table.DefaultTableModel;

public class Table extends DefaultTableModel{
	
	public Table (){
		super();
	}
	
	public boolean isCellEditable (int row, int column){
		return false;
	   }
	
	
	
}
