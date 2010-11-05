package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorGestionarAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIAnalisis analisis;
	private String data;
	
	/**
	 * This is the default constructor
	 */
	public MediadorGestionarAnalisis() {
		super();
		this.analisis = new GUIAnalisis();
		analisis.setTitle("Analisis por Tamiz de una Muestra");
		analisis.setModal(true);
		this.analisis.setListenerButtons(this);
	}
		
	public void show(){
		analisis.show();
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
	public GUIAnalisis getAltaMuestra() {
		return analisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.analisis.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregarMuestra");
			data = analisis.getPesoRetenido().getText();
			analisis.dispose();
		}
		if (this.analisis.getJButtonCancelar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			analisis.dispose();
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