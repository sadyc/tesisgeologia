package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import persistencia.domain.Analisis;
import persistencia.domain.Tamiz;
import comun.MediadorSeleccionarTamiz;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIAnalisis GUIAnalisis;
	private String data;
	private Analisis analisis;
	private Tamiz tamiz;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis() {
		super();
		this.GUIAnalisis = new GUIAnalisis();
		GUIAnalisis.setTitle("Analisis por Tamiz de una Muestra");
		GUIAnalisis.setModal(true);
		this.GUIAnalisis.setListenerButtons(this);
		show();
	}
		
	public void show(){
		GUIAnalisis.show();
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
		return GUIAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.GUIAnalisis.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			data = GUIAnalisis.getPesoRetenido().getText();
		//	analisis = new Analisis(data);    PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
			GUIAnalisis.dispose();
		}
		if (this.GUIAnalisis.getJButtonSalir() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUIAnalisis.dispose();
		}
		if (this.GUIAnalisis.getJButtonSeleccionarTamiz() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonSeleccionarTamiz");
			try {
				MediadorSeleccionarTamiz seleccionarTamiz = new MediadorSeleccionarTamiz();
				this.GUIAnalisis.setTamiz("Tamiz : "+(String)seleccionarTamiz.getSeleccionado()[0]);
				this.tamiz.setNumeroTamiz((Integer)seleccionarTamiz.getSeleccionado()[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
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