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

/**
 * @author Leon
 *
 */
public class MediadorModificarUbicacion extends Mediador{
	private GUIUbicacion GUIUbicacion;
	private Component frame;
	private ControlGestionarUbicacion control = new ControlGestionarUbicacion();
	private boolean modifico = false;
	private String nombreUbicacion;
	private String ciudad;
	private String[] data;
	
	
	/**
	 * Contructor por defecto.
	 */
	public MediadorModificarUbicacion(String[] data) {
		super();
		Ubicacion ubicacion = new Ubicacion();
		nombreUbicacion = data[0];
		ciudad = data[1];
		ubicacion.setNombreUbicacion(data[0]);
		ubicacion.setCiudad(data[1]);
		ubicacion.setProvincia(data[2]);
		ubicacion.setLatitud(data[3]);
		ubicacion.setLongitud(data[4]);
		System.out.println(data[1]);
		System.out.println(ubicacion.getCiudad());
		
		GUIUbicacion = new GUIUbicacion(ubicacion);
		GUIUbicacion.setListenerButtons(this);
		GUIUbicacion.setKeyListener(this);
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
				GUIUbicacion.dispose();
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
				control.modificarUbicacion(nombreUbicacion,ciudad,GUIUbicacion.getData());
				data = GUIUbicacion.getData();
				modifico = true;
				
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo numeros en los campos de latitud y longitud","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
   	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean seModificoUbicacion() {
		return modifico;
	}

	public String[] getData() {
		return data;
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (GUIUbicacion.getjTextFieldCiudad().getText().length()==25){ 
			arg0.consume(); 
			System.out.print("\07");
		}
		if (GUIUbicacion.getjTextFieldNombreUbicacion().getText().length()==25){
			arg0.consume();
			System.out.print("\07");
		}
	}
	
	
}
