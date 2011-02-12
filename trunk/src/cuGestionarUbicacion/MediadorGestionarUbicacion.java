/**
 * 
 */
package cuGestionarUbicacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Ubicacion;

import comun.Mediador;

import cuCalcularClasificacion.GUIClasificacion;
import cuGestionarMuestra.ControlGestionarMuestra;

/**
 * @author TesisGeologia.
 *
 */

public class MediadorGestionarUbicacion extends Mediador{
	
	private GUIUbicacion GUIUbicacion;
	private Object [][] data ;
	private Component frame;
	private Ubicacion ubicacion;
	private ControlGestionarUbicacion control = new ControlGestionarUbicacion();
	private Object [] seleccionado = new Object [4];
	
	
	/**
	 * Contructor por defecto.
	 */
	public MediadorGestionarUbicacion() {
		super();
		String [] columAux = {"Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final"};
		GUIUbicacion = new GUIUbicacion();
		GUIUbicacion.setListenerButtons(this);
		GUIUbicacion.show();
		
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIUbicacion.getjButtonAceptar() == source||GUIUbicacion.getjMenuItemAgregar()==source){
			try {
				aceptar();
			} catch (Exception e) {
				e.printStackTrace();
			}
	   	}
		if (this.GUIUbicacion.getjButtonCancelar()== source || GUIUbicacion.getjMenuItemCancelar()==source){
			GUIUbicacion.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Muestra"
	 * @throws Exception 
	 */
	public void aceptar() throws Exception{
		try {
			System.out.println("Muestra.actionPerformed() jButtonAceptar");
			if (GUIUbicacion.getjTextFieldCiudad().getText().equals("") || GUIUbicacion.getjTextFieldNombreUbicacion().getText().equals("")){
		 		JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				agregarUbicacion();
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo numeros en los campos de latitud y longitud","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
   	}


	private void agregarUbicacion() throws Exception {
		
		control.insertarUbicacion(GUIUbicacion.getData());
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
