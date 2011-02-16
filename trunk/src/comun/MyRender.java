package comun;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

class MyRenderer implements TableCellRenderer {
	   public Component getTableCellRendererComponent ( JTable table, Object value, boolean isSelected,
	       boolean hasFocus, int row, int column ) {
	     JTextField editor = new JTextField () ;
	     if ( value != null )
	       editor.setText ( value.toString ()) ;
	     editor.setBackground (( row % 2 == 0 ) ? Color.white : Color.yellow) ;
	     return editor;
	   }
	}