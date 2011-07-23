/**
 * 
 */
package cuGestionarUbicacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import comun.Mediador;
import comun.MediadorVersion;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GestionarUbicacion.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */

public class MediadorAltaUbicacion extends Mediador{
	
	private GUIUbicacion GUIUbicacion;
	private Component frame;
	private ControlGestionarUbicacion control = new ControlGestionarUbicacion();
	private boolean alta = false;

	/**
	 * Contructor por defecto.
	 */
	@SuppressWarnings("deprecation")
	public MediadorAltaUbicacion() {
		super();
		GUIUbicacion = new GUIUbicacion();
		GUIUbicacion.setTitle("Alta Ubicación");
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
				aceptar();
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
	public void aceptar() throws Exception{
		try {
			System.out.println("Muestra.actionPerformed() jButtonAceptar");
			if (GUIUbicacion.getjTextFieldCiudad().getText().equals("") || GUIUbicacion.getjTextFieldNombreUbicacion().getText().equals("")){
		 		JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (GUIUbicacion.coordenadasGradosCorrectas()){
					control.insertarUbicacion(GUIUbicacion.getData());
					if (control.yaExiste()) {
						JOptionPane.showMessageDialog(frame,"La ubicación con ese nombre y esa ciudad ya existe. Por favor ingrese otra.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						alta = true;
						GUIUbicacion.dispose();
					}
				}
				else{
					
					if (GUIUbicacion.coordenadasDecimalesCorrectas()){
						control.insertarUbicacion(GUIUbicacion.getData());
						if (control.yaExiste()) {
							JOptionPane.showMessageDialog(frame,"La ubicación con ese nombre y esa ciudad ya existe. Por favor ingrese otra.","Atención!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							alta = true;
							GUIUbicacion.dispose();
						}
					}else{
						JOptionPane.showMessageDialog(frame,"Debe completar los campos grados, minutos y segundos","Atención!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar todos los campos de las coordenadas o no ingrese ninguno","Atención!", JOptionPane.ERROR_MESSAGE);
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
			System.out.print("\07");
		}
		if (GUIUbicacion.getjTextFieldNombreUbicacion().getText().length()==25){
			arg0.consume();
			System.out.print("\07");
		}
	}
	
}
