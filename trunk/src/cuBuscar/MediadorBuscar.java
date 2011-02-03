/**
 * 
 */
package cuBuscar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Collection;

import javax.swing.JOptionPane;

import comun.Mediador;

import cuGestionarMuestra.MediadorSeleccionarMuestra;



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
		 			buscarPorNombre();
		 		}
		 		if (GUIBuscar.getjComboBox1().getSelectedItem().equals("Ubicacion")){
		 			buscarPorUbicacion();
		 		}
		 		if (GUIBuscar.getjComboBox1().getSelectedItem().equals("Operador Lab")){
		 			buscarPorOperador();
		 		}
		 	}
		}
		catch (Exception e) {
		}
	}

	
	private void buscarPorOperador() throws Exception {
		Collection coleccion = control.buscarOperadorDeMuestra(GUIBuscar.getBuscar().getText());
		if (coleccion.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontro ninguna muestra con ese Operador de laboratorio","ATENCION", JOptionPane.WARNING_MESSAGE);
		}
		else{
			MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra(coleccion); 
		}
	}

	private void buscarPorUbicacion() throws Exception {
		Collection coleccion = control.buscarUbicacionMuestra(GUIBuscar.getBuscar().getText());
		if (coleccion.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontro ninguna muestra con esa ubicacion","ATENCION", JOptionPane.WARNING_MESSAGE);
		}
		else{
			MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra(coleccion); 
		}
		
	}

	private void buscarPorNombre() throws Exception {
		Collection coleccion = control.buscarNombreMuestra(GUIBuscar.getBuscar().getText());
		if (coleccion.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontro ninguna muestra con ese nombre","ATENCION", JOptionPane.WARNING_MESSAGE);
		}
		else{
			MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra(coleccion); 
		}
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
