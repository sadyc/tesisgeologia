package cuLimiteConsistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import persistencia.domain.Analisis;
import persistencia.domain.Consistencia;
import persistencia.domain.Muestra;

import comun.MediadorSeleccionarTamiz;

import cuGestionarAnalisis.ControlGestionarAnalisis;


/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaLimiteConsistencia  implements ActionListener,MouseListener,ItemListener  {
	
	private GUILimiteConsistencia GUILimiteConsistencia;
	private Muestra muestra = new Muestra();
	private Consistencia consistencia = new Consistencia();
	private String nombreMuestra;
	private String limiteLiquido;
	private String limitePlastico;
	private boolean altaConsistencia = false;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaLimiteConsistencia(String nombreMuestra) {
		super();
		this.nombreMuestra = nombreMuestra;
		obtenerMuestra();
		this.GUILimiteConsistencia = new GUILimiteConsistencia("Limite Consistencia",muestra);
		GUILimiteConsistencia.setModal(true);
		this.GUILimiteConsistencia.setListenerButtons(this);
		show();
	}
	
		
	public void show(){
		GUILimiteConsistencia.show();
	}
	
	/**
	 * @return the consistencia
	 */
	public Consistencia getConsistencia() {
		return consistencia;
	}

	/**
	 * @return the altaConsistencia
	 */
	public boolean isAltaConsistencia() {
		return altaConsistencia;
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		ControlLimiteConsistencia control = new ControlLimiteConsistencia();
     	if (this.GUILimiteConsistencia.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			limiteLiquido = GUILimiteConsistencia.getLimiteLiquido().getText();
			limitePlastico = GUILimiteConsistencia.getLimitePlastico().getText();
			consistencia.setLimiteLiquido(Float.parseFloat(limiteLiquido));//PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
			consistencia.setLimitePlastico(Float.parseFloat(limitePlastico));
			try {
				consistencia = control.insertarConsistencia(consistencia, nombreMuestra);
				altaConsistencia= true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			GUILimiteConsistencia.dispose();
		}
		if (this.GUILimiteConsistencia.getJButtonSalir() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUILimiteConsistencia.dispose();
		}
	}

	/**
	 * Permite recuperar una muestra de la base de datos. 
	 */
	public void obtenerMuestra(){
		ControlLimiteConsistencia control = new ControlLimiteConsistencia();
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