/**
 * 
 */
package cuLogin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistencia.Persistencia;
import persistencia.domain.Muestra;

import comun.MediadorPrincipal;

/**
 * @author TesisGeologia
 *
 */
public class MediadorLogin implements ActionListener{
	
	private GUILogin login = null;
	private Component frame;
	private ControlLogin control;
	
	/**
	 * Constructor con parametros
	 * @param nombreVentana
	 * @throws Exception
	 */
	public MediadorLogin (String nombreVentana) throws Exception {
		super();
		this.login = new GUILogin(nombreVentana);
		this.login.setListenerButtons(this);
		show();
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
		if (this.login.getJButtonAceptar() == source){
	   		aceptar();
		}
		if (this.login.getJButtonCancelar() == source){
	   		System.out.println("GestionarMediador.actionPerformed() jButtonCancelar");
	   		login.dispose();	
	   	}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("GestionarMediador.actionPerformed() jButtonAceptar");
		String nombre = login.getNombre().getText();
		System.out.println(login.getNombre().getText());
		try {
			control.obtenerUsuario(login.getNombre().getText(), login.getPassword().getText());
		    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   		if (login.getNombre().getText().equals("")) {
			JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Nombre Usuario'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			if (login.getPassword().getText().equals("")) {
				JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Password'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					new MediadorPrincipal("SISTEMA DE CLASIFICACION DE SUELOS");
				} catch (Exception e) {
					e.printStackTrace();
				}
				login.dispose();
			}
		}
	}
}
