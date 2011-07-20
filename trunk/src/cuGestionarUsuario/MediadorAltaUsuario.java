/**
 * 
 */
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
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GUIUsuario.
 * 
 * @author TesisGeologia
 * @version 1.0
 *
 */
public class MediadorAltaUsuario extends Mediador{
	private GUIUsuario GUIUsuario;
	private String[] data = new String [10];
	private Usuario usuario ;
	private Component frame;
	private ControlGestionarUsuario control;
	private boolean altaUsuario= false;

	
	/**
	 * @param nombreVentana
	 * Constructor con pasaje de parametros.
	 */
	@SuppressWarnings("deprecation")
	public MediadorAltaUsuario(String nombreVentana) {
		super();
		control = new ControlGestionarUsuario();
		usuario = new Usuario();
		GUIUsuario = new GUIUsuario();
		GUIUsuario.setTitle(nombreVentana);
		GUIUsuario.setListenerButtons(this);
		GUIUsuario.getjButtonModifPassword().setEnabled(false);
		GUIUsuario.setModal(true);
		GUIUsuario.setLocationRelativeTo(null);
		GUIUsuario.show();
	}
	
	/**
	 * @return the alta usuario
	 */
	public boolean esAltaUsuario() {
		return altaUsuario;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIUsuario.getjButtonAgregar() == source || this.GUIUsuario.getjMenuItemAgregar()== source) {
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
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (GUIUsuario.getjPasswordField2().getText().compareTo(GUIUsuario.getjPasswordField().getText()) != 0){
					JOptionPane.showMessageDialog(frame,"Los Passwords no son iguales.","Atención!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					insertarUsuario();
				}
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	@SuppressWarnings("deprecation")
	public void insertarUsuario(){
		data[0]= GUIUsuario.getjTextFieldNombre().getText();
		data[1]= GUIUsuario.getjTextFieldApellido().getText();
		if (!isDni(GUIUsuario.getjTextFieldDni().getText())){
			System.out.println("El DNI es incorrecto!");
			JOptionPane.showMessageDialog(frame,"El DNI ingresado es Incorrecto. Debe ser de la forma ##.###.###","Atención!", JOptionPane.ERROR_MESSAGE);
		}else{
			data[2]= GUIUsuario.getjTextFieldDni().getText();
			data[3]= GUIUsuario.getjTextFieldNombreUsuario().getText();
			data[4]= (String) GUIUsuario.getjComboBoxCategoria().getSelectedItem();
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
				usuario = new Usuario(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
				try {
					control.insertarUsuario(usuario);
					if (control.yaExiste()) {
						JOptionPane.showMessageDialog(frame,"El usuario con DNI: "+data[2]+" y nombre de usuario: "+data[3]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						altaUsuario = true;
						GUIUsuario.dispose();
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		
		}
	}
	
	public String[] getData() {
		return data;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String args[]){
		new MediadorAltaUsuario("jose");
	}
	
}
