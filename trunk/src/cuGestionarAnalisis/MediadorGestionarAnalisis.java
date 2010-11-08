package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import comun.MediadorSeleccionarMuestra;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorGestionarAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIGestionarAnalisis gestionarAnalisis;
	private MediadorSeleccionarMuestra mediadorSeleccionar;
	private MediadorBuscar mediadorBuscar;
	
	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis() throws Exception {
		super();
		this.gestionarAnalisis = new GUIGestionarAnalisis();
		gestionarAnalisis.setTitle("Gestionar Analisis");
		//gestionarAnalisis.setModal(true);
		this.gestionarAnalisis.setListenerButtons(this);
		show();
	}
		
	public void show(){
		gestionarAnalisis.show();
	}
	
	
	/**
	 * @return the 
	 */
	public GUIGestionarAnalisis getGestionarAnalisis() {
		return gestionarAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.gestionarAnalisis.getJButtonAgregarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			MediadorAnalisis analisis = new MediadorAnalisis();
		}
		if (this.gestionarAnalisis.getJButtonModificarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonModificar");
			
			
		}
		if (this.gestionarAnalisis.getJButtonEliminarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonEliminar");
			
		}
		if (this.gestionarAnalisis.getJButtonCerrar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			gestionarAnalisis.dispose();
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