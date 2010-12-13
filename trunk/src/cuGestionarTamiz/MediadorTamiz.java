package cuGestionarTamiz;


import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import persistencia.domain.Tamiz;

import comun.Mediador;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorTamiz  extends Mediador{
	
	private GUITamiz tamiz;
	
	/**
	 * This is the default constructor
	 */
	public MediadorTamiz() {
		super();
		tamiz = new GUITamiz();
		tamiz.setTitle("Tamiz");
		tamiz.setModal(true);
		tamiz.setListenerButtons(this);
		show();
	}
		
	/**
	 * This is the default constructor
	 */
	public MediadorTamiz(Tamiz tamiz) {
		super();
		this.tamiz = new GUITamiz(tamiz);
		this.tamiz.setTitle("Tamiz");
		this.tamiz.setModal(true);
		this.tamiz.setListenerButtons(this);
		show();
	}
	
	public void show(){
		tamiz.show();
	}
	
	/**
	 * @return the altaMuestra
	 */
	public GUITamiz getTamiz() {
		return tamiz;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.tamiz.getJButtonAceptar() == source){
			System.out.println("GestionarTamiz.actionPerformed() jButtonAceptarTamiz");
			tamiz.dispose();
		}
		if (this.tamiz.getJButtonCancelar() == source){
			System.out.println("GestionarTamiz.actionPerformed() jButtonCancelar");
			tamiz.dispose();
		}
	}



	public void itemStateChanged(ItemEvent arg0) {
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
}