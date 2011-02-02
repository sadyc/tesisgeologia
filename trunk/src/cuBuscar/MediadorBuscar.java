/**
 * 
 */
package cuBuscar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

import comun.Mediador;
import cuGestionarMuestra.ControlGestionarMuestra;



/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana Muestra.
 * 
 * @author TesisGeologia.
 */
public class MediadorBuscar extends Mediador{
	private String[][] resultado;
	private GUIBuscar GUIBuscar;
	private boolean encuentra;
	private Component frame;
	private ControlBuscar control = new ControlBuscar();
	
	/**
	 * Contructor por default.
	 * 
	 */
	public MediadorBuscar(){
		super();
		encuentra = false;
		GUIBuscar = new GUIBuscar();
		GUIBuscar.setTitle("Buscar");
		GUIBuscar.setListenerButtons(this);
		GUIBuscar.show();
	}
	
	private void buscar() {
		System.out.println("Buscar.actionPerformed() jButtonBuscar");
		try{
		 	if (GUIBuscar.getBuscar().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"El campo buscar no puede ser vacio","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		 	else{
		 		if (GUIBuscar.getjComboBox1().getSelectedItem().equals("Nombre Muestra")){
		 			control.buscarNombreMuestra(GUIBuscar.getBuscar().getText());
		 		}
		 	}
		}
		catch (Exception e) {
		}
	}

	
	private void buscarMuestras() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIBuscar.getJButtonBuscar() == source) {
			buscar();
		}
		if (this.GUIBuscar.getJButtonCancelar() == source){
			GUIBuscar.dispose();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
