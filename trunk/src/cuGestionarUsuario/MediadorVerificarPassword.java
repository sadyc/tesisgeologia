package cuGestionarUsuario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JOptionPane;

import persistencia.domain.Usuario;

import cuBuscar.ControlBuscar;
import cuBuscar.GUIBuscar;
import cuLogin.Encriptar;

public class MediadorVerificarPassword implements ActionListener, KeyListener, MouseListener {
	private GUIVerificarPassword GUIVerificarPassword;
	private String dni;
	private boolean correcto;
	private Component frame;
	private ControlGestionarUsuario control = new ControlGestionarUsuario();
	
	/**
	 * Contructor por default.
	 * 
	 */
	public MediadorVerificarPassword (String DNI, String nombreUsuario){
		super();
		dni = DNI;
		correcto = false;
		GUIVerificarPassword = new GUIVerificarPassword();
		GUIVerificarPassword.setTitle("Nombre Usuario: "+nombreUsuario);
		GUIVerificarPassword.setListenerButtons(this);
		GUIVerificarPassword.show();
	}
	
	private void buscar() {
		System.out.println("Verificar.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIVerificarPassword.getPassword().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"El password no puede ser vacio.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		 	else{
		 		Usuario usuario = control.obtenerUsuario(dni);
		 		Encriptar encriptar = new Encriptar();
				String password = "";
				try {
					password = encriptar.hash(GUIVerificarPassword.getPassword().getText());
				} catch (Exception e1) {
					System.out.println("El password es muy extenso!");
					e1.printStackTrace();
				}
				if	(password.compareTo(usuario.getContraseña())!=0){
					JOptionPane.showMessageDialog(frame,"La contraseña es incorrecta.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		 		}
		 		else{
		 			correcto = true;
		 		}
		 	}
		}
		catch (Exception e) {
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIVerificarPassword.getJButtonBuscar() == source || this.GUIVerificarPassword.getjMenuItemAceptar() == source) {
			buscar();
			GUIVerificarPassword.dispose();
		}
		if (this.GUIVerificarPassword.getJButtonCancelar() == source || this.GUIVerificarPassword.getjMenuItemCancelar() == source){
			GUIVerificarPassword.dispose();
		}
	}
		
	/**
	 * @return the busco
	 */
	public boolean getCorrecto() {
		return correcto;
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
