package comun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que se utiliza para que cada mediador extienda a esta clase. 
 * @author TesisGeologia.
 * @version 1.0
 */
public abstract class Mediador implements ActionListener,MouseListener,ItemListener,KeyListener{
	
	
	/**
	 * Método que permite visualizar la ventana.
	 */
	public void show(){
	}
	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
	public void actionPerformed(ActionEvent arg0) {
	}
	/**
	 * Método que permite realizar acciones dependiendo a los clicks realizados por el mouse en la ventana.
	 */
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
	public void keyPressed(KeyEvent arg0) {
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	
}
