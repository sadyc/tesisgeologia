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
 * @version 1.0
 */

public class MediadorAltaLimiteConsistencia extends Mediador{

	private GUILimiteConsistencia GUILimiteConsistencia;
	private Muestra muestra = new Muestra();
	private ControlLimiteConsistencia control = new ControlLimiteConsistencia();
	private String limiteLiquido;
	private String limitePlastico;
	private Component frame;
	private String [] data = new String [10];
	private boolean altaConsistencia = false;

	/**
	 * This is the default constructor
	 */
	public MediadorAltaLimiteConsistencia(Muestra muestra2) {
		super();
		muestra = muestra2;
		GUILimiteConsistencia = new GUILimiteConsistencia("Límite Consistencia",muestra);
		GUILimiteConsistencia.setLocationRelativeTo(null);
		GUILimiteConsistencia.setModal(true);
		GUILimiteConsistencia.setListenerButtons(this);
		show();
	}

	@SuppressWarnings("deprecation")
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
	 * Método que necesita definir al implementar la interface ActionListener 
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
			new MediadorVersion();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Consistencia"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		if (GUILimiteConsistencia.getjTextFieldLL().getText().isEmpty() || GUILimiteConsistencia.getjTextFieldLP().getText().isEmpty()){
			JOptionPane.showMessageDialog(frame,"Debe ingresar el Límite Líquido y el Límite Plástico","Atención!", JOptionPane.ERROR_MESSAGE);
		}else{
			limiteLiquido = GUILimiteConsistencia.getjTextFieldLL().getText().replace(",",".");
			limitePlastico = GUILimiteConsistencia.getjTextFieldLP().getText().replace(",",".");
			if (Float.parseFloat(limiteLiquido)<Float.parseFloat(limitePlastico)) {
				JOptionPane.showMessageDialog(frame,"El Límite Líquido debe ser mayor al Límite Plástico","Atención!", JOptionPane.ERROR_MESSAGE);
			}else{
				muestra.setLimiteLiquido((limiteLiquido));
				muestra.setLimitePlastico((limitePlastico));
				muestra.calcularIndicePlasticidad();
				data [0] = muestra.getUbicacion().getNombreUbicacion();
				data [1] = muestra.getNombreMuestra();
				data [2] = muestra.getPeso().toString();
				data [3] = muestra.getUbicacion().getCiudad();
				data [4] = muestra.getProfundidadInicial().toString();
				data [5] = muestra.getProfundidadFinal().toString();
				data [6] = limiteLiquido;
				data [7] = limitePlastico;
				data [8] = muestra.getIndicePlasticidad().toString();
				try {
					control.insertarConsistencia(muestra);
					altaConsistencia= true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				GUILimiteConsistencia.dispose();
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

	@Override
	public void keyTyped(KeyEvent e) {

	}
	public String[] getData(){
		return data;
	}
}