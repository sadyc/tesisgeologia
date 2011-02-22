package cuLimiteConsistencia;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Muestra;

import comun.Mediador;
import comun.MediadorVersion;


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
	private Component frame;
	private boolean altaConsistencia = false;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaLimiteConsistencia(Muestra muestra2) {
		super();
		muestra = muestra2;
		GUILimiteConsistencia = new GUILimiteConsistencia("Limite Consistencia",muestra);
		GUILimiteConsistencia.setLocationRelativeTo(null);
		GUILimiteConsistencia.setModal(true);
		GUILimiteConsistencia.setListenerButtons(this);
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
		if (GUILimiteConsistencia.getVersion()==source){
			MediadorVersion version = new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Consistencia"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		if (GUILimiteConsistencia.getjTextFieldLL().getText().isEmpty() || GUILimiteConsistencia.getjTextFieldLP().getText().isEmpty()){
			JOptionPane.showMessageDialog(frame,"Debe ingresar el L�mite L�quido y el L�mite Pl�stico","Atencion!", JOptionPane.ERROR_MESSAGE);
			
		}else{
		limiteLiquido = GUILimiteConsistencia.getjTextFieldLL().getText();
		limitePlastico = GUILimiteConsistencia.getjTextFieldLP().getText();
		
		try {
			control.insertarConsistencia(Float.parseFloat(limiteLiquido),Float.parseFloat(limitePlastico), muestra);
			altaConsistencia= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		GUILimiteConsistencia.dispose();
	
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}