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
	
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Analisis analisis;
	private String numeroTamiz;
	private String nombreMuestra;
	private boolean altaAnalisis = false;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis(String nombreMuestra) {
		super();
		analisis = new Analisis();
		this.nombreMuestra = nombreMuestra;
		this.GUIAnalisis = new GUIAltaAnalisis();
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
	public String getPesoRetenido() {
		return pesoRetenido;
	}

	/**
	 * @return the altaMuestra
	 */
	public GUIAltaAnalisis getAnalisis() {
		return GUIAnalisis;
	}

	/**
	 * @return the altaAnalisis
	 */
	public boolean isAltaAnalisis() {
		return altaAnalisis;
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
     	if (this.GUIAnalisis.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
			analisis.setPesoRetenido(Integer.parseInt(pesoRetenido));//PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
			System.out.println(analisis.toString());
			try {
				control.insertarAnalisis(analisis, nombreMuestra, numeroTamiz);
				altaAnalisis= true;
			} catch (Exception e) {
				e.printStackTrace();
			}
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
				this.GUIAnalisis.setTamiz("Tamiz : "+seleccionarTamiz.getSeleccionado());
				this.numeroTamiz = seleccionarTamiz.getSeleccionado();
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