/**
 * 
 */
package comun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que se utiliza para que cada mediador extienda a esta clase. 
 * @author TesisGeologia.
 */
public abstract class Mediador implements ActionListener,MouseListener,ItemListener{
	
	public void init(){
	}

	public void show(){
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {    
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public String[] getData(){
		return null;
	}
}
