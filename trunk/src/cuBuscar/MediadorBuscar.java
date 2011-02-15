/**
 * 
 */
package cuBuscar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
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
	private Collection resultado;
	private GUIBuscar GUIBuscar;
	private boolean encotro;
	private Component frame;
	private ControlBuscar control = new ControlBuscar();
	
	/**
	 * Contructor por default.
	 * 
	 */
	public MediadorBuscar(){
		super();
		encotro = false;
		GUIBuscar = new GUIBuscar();
		GUIBuscar.setTitle("Buscar Muestra");
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
		resultado = control.buscarOperadorDeMuestra(GUIBuscar.getBuscar().getText().toUpperCase());
		if (resultado.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontró ninguna muestra con ese Operador de laboratorio","ATENCIÓN", JOptionPane.WARNING_MESSAGE);
		}
		else{
			GUIBuscar.dispose();
		}
	}

	private void buscarPorUbicacion() throws Exception {
		resultado = control.buscarUbicacionMuestra(GUIBuscar.getBuscar().getText().toUpperCase());
		if (resultado.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontró ninguna muestra con esa Ubicación","ATENCIÓN", JOptionPane.WARNING_MESSAGE);
		}
		else{
			encotro=true;
			GUIBuscar.dispose();
		}
	}

	private void buscarPorNombre() throws Exception {
		resultado = control.buscarNombreMuestra(GUIBuscar.getBuscar().getText().toUpperCase());
		if (resultado.isEmpty()){
			JOptionPane.showMessageDialog(frame,"No se encontró ninguna muestra con ese nombre","ATENCIÓN", JOptionPane.WARNING_MESSAGE);
		}
		else{
			encotro=true;
			GUIBuscar.dispose();
			}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIBuscar.getJButtonBuscar() == source || this.GUIBuscar.getjMenuItem1() == source) {
			buscar();
		}
		if (this.GUIBuscar.getJButtonCancelar() == source || this.GUIBuscar.getjMenuItem2() == source){
			GUIBuscar.dispose();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return the busco
	 */
	public boolean seEncontro() {
		return encotro;
	}
	/**
	 * @return the resultado
	 */
	public Collection getResultado() {
		return resultado;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
}
