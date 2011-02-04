package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;

import cuGestionarTamiz.MediadorSeleccionarTamiz;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaAnalisis  extends Mediador{
	
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Muestra muestra = new Muestra();
	private Analisis analisis;
	private String[] data= new String[5];
	private String numeroTamiz;
	private String nombreMuestra;
	private ControlGestionarAnalisis control = new ControlGestionarAnalisis();
	private boolean altaAnalisis = false;
	private Component frame;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis(Muestra muestra) {
		super();
		analisis = new Analisis();
		GUIAnalisis = new GUIAltaAnalisis(muestra);
		GUIAnalisis.setTitle("Analisis por Tamiz de una Muestra");
		GUIAnalisis.setModal(true);
		GUIAnalisis.setListenerButtons(this);
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
	 * @return data
	 */
	public String[] getData() {
		return data;
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
		if (this.GUIAnalisis.getJButtonCancelar() == source){
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
			GUIAnalisis.setTamiz(seleccionarTamiz.getSeleccionado());
			numeroTamiz = seleccionarTamiz.getSeleccionado();
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
		if (numeroTamiz==null){
			JOptionPane.showMessageDialog(frame,"No se selecciono ningun Tamiz","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (pesoRetenido.equals("")){
				JOptionPane.showMessageDialog(frame,"No ingreso un peso retenido","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			if (Float.parseFloat(pesoRetenido)> muestra.getPeso()){
				JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar "+muestra.getPeso(),"ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			if (Float.parseFloat(pesoRetenido)>muestra.getPeso()){
				
			}
			else{
				
				analisis.setPesoRetenido(Float.parseFloat(pesoRetenido));//PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
				try {
					data = control.insertarAnalisis(analisis, muestra, numeroTamiz);
					System.out.println(analisis.toString()+"Mediador");
					altaAnalisis= true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				GUIAnalisis.dispose();
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