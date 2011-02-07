package cuLimiteConsistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import persistencia.domain.Muestra;

import comun.Mediador;


/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaLimiteConsistencia extends Mediador{
	
	private GUILimiteConsistencia GUILimiteConsistencia;
	private Muestra muestra = new Muestra();
	private ControlLimiteConsistencia control = new ControlLimiteConsistencia();
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
		GUILimiteConsistencia.setLocationRelativeTo(null);
		GUILimiteConsistencia.setModal(true);
		this.GUILimiteConsistencia.setListenerButtons(this);
		show();
	}
	
		
	public void show(){
		GUILimiteConsistencia.show();
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
		if (this.GUILimiteConsistencia.getjButtonAgregar() == source || GUILimiteConsistencia.getAgregar()==source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
     		aceptar();
		}
		if (this.GUILimiteConsistencia.getjButtonCancelar() == source || GUILimiteConsistencia.getCancelar()==source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUILimiteConsistencia.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Consistencia"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		limiteLiquido = GUILimiteConsistencia.getjTextFieldLL().getText();
		limitePlastico = GUILimiteConsistencia.getjTextFieldLP().getText();
		try {
			control.insertarConsistencia(Float.parseFloat(limiteLiquido),Float.parseFloat(limitePlastico), nombreMuestra);
			altaConsistencia= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		GUILimiteConsistencia.dispose();
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