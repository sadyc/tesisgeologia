/**
 * 
 */
package cuLogin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Usuario;

import comun.Mediador;
import comun.MediadorPrincipal;
import comun.MediadorVersion;

/**
 * @author TesisGeologia
 *
 */
public class MediadorLogin extends Mediador {
	
	private GUILogin login;
	private Component frame;
	private ControlLogin control;
	
	
	/**
	 * Constructor con parámetros
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public MediadorLogin () {
		super();
		login = new GUILogin();
		login.setLocationRelativeTo(null);
		login.setListenerButtons(this);
		login.setKeyListener(this);
		login.pack();
		login.show();
	}

	/**
	 * Método que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.login.getjButtonAceptar() == source || this.login.getjMenuItemAgregar() == source){
			try {
				aceptar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.login.getjMenuItemSalir() == source || this.login.getjButtonCancelar() == source){
			login.dispose();
			System.exit(0);
		}
		if (this.login.getjMenuItemVersion()==source){
			new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	public void aceptar() {
		System.out.println("GestionarMediador.actionPerformed() jButtonAceptar");
		String nombreUsuario = login.getJnombreUsuario().getText();
        String password =  login.getJpassword().getText();
        Encriptar encriptar =new Encriptar();
        try{
        	password = encriptar.hash(password);
        }
		catch (Exception e){
			System.out.println("Error al encriptar password");
		}
        control = new ControlLogin(); 
        Usuario aux = new Usuario();
        try {
               	
        	aux = control.obtenerUsuario(nombreUsuario, password);
      
        } catch (Exception e1) {
			JOptionPane.showMessageDialog(frame,"El usuario es incorrecto","Atención!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			
		}
        
   		if (login.getJnombreUsuario().getText().equals("")) {
			JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Nombre Usuario'","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if (login.getJpassword().getText().equals("")) {
			
				JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Password'","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if (control.yaExiste() == false){
					JOptionPane.showMessageDialog(frame,"El usuario es incorrecto","Atención!", JOptionPane.ERROR_MESSAGE);
				}else{
					if (password.compareTo(aux.getPassword()) != 0){
						JOptionPane.showMessageDialog(frame,"El password es incorrecto","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
	        		        	
						try {
							new MediadorPrincipal("SISTEMA DE CLASIFICACIÓN DE SUELOS",aux);
					} catch (Exception e) {
						e.printStackTrace();
					}
					login.dispose();
				 }
			   }
			}
		}
	}
	public void keyTyped(KeyEvent arg0) {
		if (login.getjTextFieldNombreUsuario().getText().length()==20){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (login.getjTextFieldPassword().getText().length()==15){
			arg0.consume();
			System.out.print("\07");
		}
	}

	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	aceptar();
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
