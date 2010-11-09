package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import persistencia.domain.Analisis;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIAnalisis guiAnalisis;
	private String data;
	private Analisis analisis;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAnalisis() {
		super();
		this.guiAnalisis = new GUIAnalisis();
		guiAnalisis.setTitle("Analisis por Tamiz de una Muestra");
		guiAnalisis.setModal(true);
		this.guiAnalisis.setListenerButtons(this);
		show();
	}
		
	public void show(){
		guiAnalisis.show();
	}
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the altaMuestra
	 */
	public GUIAnalisis getAnalisis() {
		return guiAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.guiAnalisis.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			data = guiAnalisis.getPesoRetenido().getText();
		//	analisis = new Analisis(data);    PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
			guiAnalisis.dispose();
		}
		if (this.guiAnalisis.getJButtonSalir() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			guiAnalisis.dispose();
		}
		if (this.guiAnalisis.getJButtonSeleccionarTamiz() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonSeleccionarTamiz");
			guiAnalisis.dispose();
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