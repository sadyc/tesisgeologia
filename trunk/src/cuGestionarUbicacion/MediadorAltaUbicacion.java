/**
 * 
 */
package cuGestionarUbicacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Ubicacion;

import comun.Mediador;

import cuCalcularClasificacion.GUIClasificacion;
import cuGestionarMuestra.ControlGestionarMuestra;

/**
 * @author TesisGeologia.
 *
 */

public class MediadorAltaUbicacion extends Mediador{
	
	private GUIUbicacion GUIUbicacion;
	private Component frame;
	private ControlGestionarUbicacion control = new ControlGestionarUbicacion();
	private boolean alta = false;

	/**
	 * Contructor por defecto.
	 */
	public MediadorAltaUbicacion() {
		super();
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
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Ubicacion".
	 * @throws Exception 
	 */
	public void aceptar() throws Exception{
		try {
			System.out.println("Muestra.actionPerformed() jButtonAceptar");
			if (GUIUbicacion.getjTextFieldCiudad().getText().equals("") || GUIUbicacion.getjTextFieldNombreUbicacion().getText().equals("")){
		 		JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				control.insertarUbicacion(GUIUbicacion.getData());
				alta = true;
				GUIUbicacion.dispose();
				
			}
		}
		catch (NumberFormatException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo numeros en los campos de latitud y longitud","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
   	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean esAltaUbicacion() {
		return alta;
	}

	/**
	 * @return the data
	 */
	public String[] getData() {
		return GUIUbicacion.getData();
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (GUIUbicacion.getjTextFieldCiudad().getText().length()==25){ 
			arg0.consume(); 
		}
		if (GUIUbicacion.getjTextFieldNombreUbicacion().getText().length()==25){
			arg0.consume();
		}
	}
	
}
