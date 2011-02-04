package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorModificarAnalisis  extends Mediador{
	
	private GUIModificarAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Analisis analisis;
	private String numeroTamiz;
	private String nombreMuestra;
	private ControlGestionarAnalisis control ; 
	
	/**
	 * This is the default constructor
	 */
	public MediadorModificarAnalisis(String nombreMuestra,Float f,String numeroTamiz) {
		super();
		control = new ControlGestionarAnalisis();
		this.numeroTamiz = numeroTamiz;
		analisis = new Analisis();
		this.nombreMuestra = nombreMuestra;
		this.GUIAnalisis = new GUIModificarAnalisis(f);
		GUIAnalisis.setTitle("Modificar el peso retenido del tamizado de una Muestra");
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
	public GUIModificarAnalisis getAnalisis() {
		return GUIAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		
     	if (this.GUIAnalisis.getJButtonAceptar() == source){
			aceptar();
		}
		if (this.GUIAnalisis.getJButtonSalir() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUIAnalisis.dispose();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAceptar");
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
		Muestra muestra = new Muestra ();
		muestra.setNombreMuestra(nombreMuestra);
		analisis.setMuestra(muestra);
		try {
			control.ModificarAnalisis(Float.parseFloat(pesoRetenido), nombreMuestra, numeroTamiz);
			control.recalcularAnalisis(analisis);//REcalcular Todo por aca o por otro lado
		} catch (Exception e) {
			e.printStackTrace();
		}
		GUIAnalisis.dispose();
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


	public String[] getData() {
		return null;
	}
}