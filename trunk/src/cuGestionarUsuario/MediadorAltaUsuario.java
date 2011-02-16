/**
 * 
 */
package cuGestionarUsuario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import persistencia.domain.Usuario;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuLogin.Encriptar;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana Muestra.
 * 
 * @author TesisGeologia
 *
 */
public class MediadorAltaUsuario implements ActionListener, KeyListener, MouseListener{
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
	public MediadorAltaUsuario(String nombreVentana) {
		super();
		control = new ControlGestionarUsuario();
		usuario = new Usuario();
		GUIUsuario = new GUIUsuario();
		GUIUsuario.setTitle(nombreVentana);
		GUIUsuario.setListenerButtons(this);
		GUIUsuario.setModal(true);
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
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
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
					insertarUsuario();
					altaUsuario = true;
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
	public void insertarUsuario(){
		data[0]= GUIUsuario.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUIUsuario.getjTextFieldApellido().getText().toUpperCase();
		data[2]= GUIUsuario.getjTextFieldDni().getText();
		data[3]= GUIUsuario.getjTextFieldNombreUsuario().getText().toUpperCase();
		data[4]= (String) GUIUsuario.getjComboBoxCategoria().getSelectedItem();
		data[5]= GUIUsuario.getjTextFieldEmail().getText().toUpperCase();
		data[6]= GUIUsuario.getjTextFieldTelefono().getText();
		Encriptar encriptar = new Encriptar();
		String password = "";
		try {
			password = encriptar.hash(GUIUsuario.getjPasswordField().getText());
		} catch (Exception e1) {
			System.out.println("El password es muy extenso!");
			e1.printStackTrace();
		}
		data[7]= password;
		usuario = new Usuario(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
		try {
			control.insertarUsuario(usuario);
			if (control.getExiste()) {
				System.out.println("El objeto ya existe");
				JOptionPane.showMessageDialog(frame,"El usuario con DNI: "+data[2]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				altaUsuario = true;
				GUIUsuario.dispose();
			}
			
		} catch (Exception e) {
			System.out.println("No inserta Usuario Mediador Alta Usuario");
			e.printStackTrace();
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
}
