package cuGestionarUsuario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Usuario;

import comun.Mediador;
import comun.MediadorVersion;

import cuLogin.Encriptar;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana para modificar un Usuario.
 * 
 * @author TesisGeologia
 * @version 1.0
 *
 */
public class MediadorModificarUsuario extends Mediador {
	private GUIUsuario GUIUsuario;
	private boolean modificoUsuario;
	private String[] data = new String [10];
	private Component frame;
	private Usuario usuarioModificar;
	private ControlGestionarUsuario control = new ControlGestionarUsuario();
	

	/**
	 * Constructor con pasaje de parametros.
	 * @param fila
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public MediadorModificarUsuario(String[] fila) throws Exception {
		super();
		usuarioModificar = (control.obtenerUsuario(fila[2]));
		GUIUsuario = new GUIUsuario(usuarioModificar);
		GUIUsuario.setTitle("Modificar Usuario");
		GUIUsuario.setListenerButtons(this);
		GUIUsuario.setModal(true);
		GUIUsuario.setLocationRelativeTo(null);
		GUIUsuario.show();
	}
	

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
			
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
				
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
				
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
				
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIUsuario.getjButtonAgregar() == source|| GUIUsuario.getjMenuItemAgregar()==source) {
			aceptar();
		}
		if (this.GUIUsuario.getjButtonCancelar() == source || GUIUsuario.getjMenuItemCancelar()==source){
			GUIUsuario.dispose();
		}
		if (GUIUsuario.getjMenuItemVersion()==source){
			new MediadorVersion();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	@SuppressWarnings("deprecation")
	public void aceptar(){
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIUsuario.getjTextFieldNombre().getText().equals("") || GUIUsuario.getjTextFieldApellido().getText().equals("") || GUIUsuario.getjTextFieldDni().getText().equals("") || GUIUsuario.getjPasswordField().getText().equals("")|| GUIUsuario.getjPasswordField2().getText().equals("")|| GUIUsuario.getjTextFieldNombreUsuario().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (GUIUsuario.getjPasswordField2().getText().compareTo(GUIUsuario.getjPasswordField().getText()) != 0){
					JOptionPane.showMessageDialog(frame,"Los Passwords no son iguales.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					modificarUsuario();
				}
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	@SuppressWarnings("deprecation")
	public void modificarUsuario(){
		data[0]= GUIUsuario.getjTextFieldNombre().getText();
		data[1]= GUIUsuario.getjTextFieldApellido().getText();
		if (!isDni(GUIUsuario.getjTextFieldDni().getText())){
			System.out.println("El DNI es incorrecto!");
			JOptionPane.showMessageDialog(frame,"El DNI ingresado es Incorrecto. Debe ser de la forma ##.###.###","Atención!", JOptionPane.ERROR_MESSAGE);
		}else{
			data[2]= GUIUsuario.getjTextFieldDni().getText();
			data[3]= GUIUsuario.getjTextFieldNombreUsuario().getText(); 
			data[4]= (String)GUIUsuario.getjComboBoxCategoria().getSelectedItem();
			if (!isEmail(GUIUsuario.getjTextFieldEmail().getText().toUpperCase()) && (!GUIUsuario.getjTextFieldEmail().getText().isEmpty())){
				System.out.println("El E-mail es incorrecto!");
				JOptionPane.showMessageDialog(frame,"El e-mail ingresado es Incorrecto. Debe ser de la forma XX@XX.XX","Atención!", JOptionPane.ERROR_MESSAGE);
			}else{
				data[5]= GUIUsuario.getjTextFieldEmail().getText();
				data[6]= GUIUsuario.getjTextFieldTelefono().getText();
				Encriptar encriptar = new Encriptar();
				String password = "";
				try {
					password = encriptar.hash(GUIUsuario.getjPasswordField().getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				data[7]= password;
				try {
					control.modificarUsuario(usuarioModificar.getDni(),usuarioModificar.getNombreUsuario(),data);
					if (control.yaExiste()) {
						JOptionPane.showMessageDialog(frame,"El usuario con DNI: "+data[2]+" y nombre de usuario: "+data[3]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						modificoUsuario = true;
						GUIUsuario.dispose();
					}
	
				} catch (Exception e) {
					System.out.println("No modifica Usuario Mediador Modificar Usuario");
					e.printStackTrace();
				}
			}
		}
	}
	
	public String[] getData() {
		return data;
	}
	
	/**
	 * retorna true si se modifico el usuario.
	 * @return modificoUsuario.
	 */
	public boolean seModificoUsuario() {
		return modificoUsuario;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	
}
