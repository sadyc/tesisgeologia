/**
 * 
 */
package cuLogin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;



import persistencia.Persistencia;
import persistencia.domain.HMuestra;
import persistencia.domain.CPersona;
import persistencia.domain.DUsuario;

import comun.MediadorPrincipal;

/**
 * @author TesisGeologia
 *
 */
public class MediadorLogin implements ActionListener{
	
	private GUILogin login;
	private Component frame;
	private ControlLogin control;
	private DUsuario persona;
	
	/**
	 * Constructor con parametros
	 * @param nombreVentana
	 * @throws Exception
	 */
	public MediadorLogin (String nombreVentana) throws Exception {
		super();
		login = new GUILogin(true);
		
        login.setLocationRelativeTo(null);
		login.setListenerButtons(this);
		
		login.show();
	}

	
	public void show()	{
		login.pack();
		login.show();
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.login.getjButtonAceptar() == source || this.login.getjMenuItemAgregar() == source){
			try {
				aceptar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.login.getjMenuItemSalir() == source){
			System.out.println("GestionarMediador.actionPerformed() jMenuItemSalir");
			login.dispose();
		}
		if (this.login.getjButtonCancelar() == source){
	   		System.out.println("GestionarMediador.actionPerformed() jButtonCancelar");
	   		login.dispose();	
	   	}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 * @throws Exception 
	 */
	public void aceptar() throws Exception{
		System.out.println("GestionarMediador.actionPerformed() jButtonAceptar");
		String nombreUsuario = login.getJnombreUsuario().getText();
        String password =  login.getJpassword().getText();
        Encriptar encriptar =new Encriptar();
        password = encriptar.hash(password);
        control = new ControlLogin(); 
        DUsuario aux = new DUsuario();
        try {
               	
        	aux = control.obtenerUsuario(nombreUsuario, password);
      
        } catch (Exception e1) {
			JOptionPane.showMessageDialog(frame,"El usuario es incorrecto","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			
		}
        
   		if (login.getJnombreUsuario().getText().equals("")) {
			JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Nombre Usuario'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if (login.getJpassword().getText().equals("")) {
			
				JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Password'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if (control.seEncontro() == false){
					JOptionPane.showMessageDialog(frame,"El usuario es incorrecto","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}else{
					if (password.compareTo(aux.getContraseña()) != 0){
						JOptionPane.showMessageDialog(frame,"El password es incorrecto","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
					}
					else {
	        		        	
						try {
							new MediadorPrincipal("SISTEMA DE CLASIFICACION DE SUELOS",aux);
					} catch (Exception e) {
						e.printStackTrace();
					}
					login.dispose();
				 }
			   }
			}
		}
	}
}
