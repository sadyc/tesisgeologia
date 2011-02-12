package cuGestionarUsuario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import cuLogin.Encriptar;

import persistencia.domain.Usuario;

public class MediadorModificarUsuario implements ActionListener, KeyListener, MouseListener {
	private GUIUsuario GUIUsuario;
	private boolean modificoUsuario;
	private String[] data = new String [10];
	private Component frame;
	private Usuario usuarioModificar;
	private ControlGestionarUsuario control = new ControlGestionarUsuario();
	

	public MediadorModificarUsuario(String[] fila) throws Exception {
		super();
		usuarioModificar = (control.obtenerUsuario(fila[2]));
		GUIUsuario = new GUIUsuario(usuarioModificar);
		GUIUsuario.setTitle("Modificar Usuario");
		GUIUsuario.setListenerButtons(this);
		GUIUsuario.setModal(true);
		GUIUsuario.show();
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
		if (this.GUIUsuario.getjButtonAgregar() == source|| GUIUsuario.getjMenuItemAgregar()==source) {
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
					modificarUsuario();
					modificoUsuario = true;
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
	public void modificarUsuario(){
		data[0]= GUIUsuario.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUIUsuario.getjTextFieldApellido().getText().toUpperCase();
		data[2]= GUIUsuario.getjTextFieldDni().getText();
		data[3]= GUIUsuario.getjTextFieldNombreUsuario().getText().toUpperCase(); 
		data[4]= (String)GUIUsuario.getjComboBoxCategoria().getSelectedItem();
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
		System.out.println(String.valueOf(GUIUsuario.getjComboBoxCategoria().getSelectedIndex()));
		try {
			control.modificarUsuario(usuarioModificar.getDni(),data);
			modificoUsuario = true;
		} catch (Exception e) {
			System.out.println("No modifica Usuario Mediador Modificar Usuario");
			e.printStackTrace();
		}
		GUIUsuario.dispose();

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
