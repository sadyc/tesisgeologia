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
import comun.MediadorVersion;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana ModificarUbicacion.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
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
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	public MediadorModificarUbicacion(String[] data) throws Exception {
		super();
		Ubicacion ubicacion = new Ubicacion();
		nombreUbicacion = data[0];
		ciudad = data[1];
		ubicacion.setNombreUbicacion(data[0]);
		ubicacion.setCiudad(data[1]);
		ubicacion.setProvincia(data[2]);
		ubicacion.setLatitud(data[3]);
		ubicacion.setLongitud(data[4]);
		GUIUbicacion = new GUIUbicacion(ubicacion);
		GUIUbicacion.setTitle("Modificar ubicacion");
		GUIUbicacion.setListenerButtons(this);
		GUIUbicacion.setKeyListener(this);
		GUIUbicacion.setLocationRelativeTo(null);
		GUIUbicacion.show();
		
	}
	
	/**
	 * Método que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIUbicacion.getjButtonAceptar() == source||GUIUbicacion.getjMenuItemAgregar()==source){
			try {
				if (GUIUbicacion.getjTabbedPane1().getSelectedIndex()==1){
					aceptarDecimal();	
				}
				else{
					aceptarGrados();
				}
				if (modifico){
					GUIUbicacion.dispose();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	   	}
		if (this.GUIUbicacion.getjButtonCancelar()== source || GUIUbicacion.getjMenuItemCancelar()==source){
			GUIUbicacion.dispose();
		}
		if (GUIUbicacion.getjMenuVersion()==source){
			new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Ubicacion".
	 * @throws Exception 
	 */
	public void aceptarDecimal() throws Exception{
		try {
			if (GUIUbicacion.getjTextFieldCiudad().getText().equals("") || GUIUbicacion.getjTextFieldNombreUbicacion().getText().equals("")){
		 		JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (GUIUbicacion.coordenadasDecimalesCorrectas()){
					control.modificarUbicacion(nombreUbicacion,ciudad,GUIUbicacion.getData());
					if (control.yaExiste()) {
						JOptionPane.showMessageDialog(frame,"La ubicación con esas coordenadas ya existe. Por favor ingrese otra.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						modifico = true;
						GUIUbicacion.dispose();
						data = GUIUbicacion.getData();
					}			
				}
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos de latitud y longitud","Atención!", JOptionPane.ERROR_MESSAGE);
		}
   	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Ubicacion".
	 * @throws Exception 
	 */
	public void aceptarGrados() throws Exception{
		try {
			if (GUIUbicacion.getjTextFieldCiudad().getText().equals("") || GUIUbicacion.getjTextFieldNombreUbicacion().getText().equals("")){
		 		JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (GUIUbicacion.coordenadasGradosCorrectas()){
					control.modificarUbicacion(nombreUbicacion,ciudad,GUIUbicacion.getData());
					if (control.yaExiste()) {
						JOptionPane.showMessageDialog(frame,"La ubicación con esas coordenadas ya existe. Por favor ingrese otra.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						modifico = true;
						GUIUbicacion.dispose();
						data = GUIUbicacion.getData();
					}			
				}
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos de latitud y longitud","Atención!", JOptionPane.ERROR_MESSAGE);
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
