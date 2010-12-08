package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.MediadorSeleccionarTamiz;

import cuCalcularClasificacion.ControlClasificacion;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Muestra muestra = new Muestra();
	private Analisis analisis;
	private String numeroTamiz;
	private String nombreMuestra;
	private ControlGestionarAnalisis control = new ControlGestionarAnalisis();
	private boolean altaAnalisis = false;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis(String nombreMuestra) {
		super();
		analisis = new Analisis();
		this.nombreMuestra = nombreMuestra;
		obtenerMuestra();
		this.GUIAnalisis = new GUIAltaAnalisis(muestra);
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
	public Analisis getAnalisis() {
		return analisis;
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
	   	if (this.GUIAnalisis.getJButtonAceptar() == source){
			agregarAnalisis();
		}
	   	if (this.GUIAnalisis.getJButtonSeleccionarTamiz() == source){
			seleccionarTamiz();
		}
		if (this.GUIAnalisis.getJButtonSalir() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUIAnalisis.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Tamiz"
	 */
	private void seleccionarTamiz() {
		System.out.println("GestionarAnalisis.actionPerformed() jButtonSeleccionarTamiz");
		try {
			MediadorSeleccionarTamiz seleccionarTamiz = new MediadorSeleccionarTamiz();
			this.GUIAnalisis.setTamiz("Tamiz : "+seleccionarTamiz.getSeleccionado());
			this.numeroTamiz = seleccionarTamiz.getSeleccionado();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Analisis"
	 */
	public void agregarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
		analisis.setPesoRetenido(Integer.parseInt(pesoRetenido));//PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
		System.out.println(analisis.toString());
		try {
			analisis = control.insertarAnalisis(analisis, nombreMuestra, numeroTamiz);
			altaAnalisis= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		GUIAnalisis.dispose();
	}
	
	/**
	 * Permite recuperar una muestra de la base de datos. 
	 */
	public void obtenerMuestra(){
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		try {
			this.muestra = control.obtenerMuestra(muestra.getClass(), nombreMuestra);
		} catch (Exception e) {
			e.printStackTrace();
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