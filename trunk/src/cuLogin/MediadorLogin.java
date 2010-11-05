/**
 * 
 */
package cuLogin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author TesisGeologia
 *
 */
public class MediadorLogin implements ActionListener{
	
	private GUILogin login = null;
	private Component frame;
	
	/**
	 * Constructor con parametros
	 * @param nombreVentana
	 * @throws Exception
	 */
	public MediadorLogin (String nombreVentana) throws Exception {
		super();
		this.login = new GUILogin(nombreVentana);
		this.login.setListenerButtons(this);
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
	   		System.out.println("GestionarMediador.actionPerformed() jButtonAgregar");
	   		if (login.getNombre().getText().equals("") ){
				JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Nombre Usuario'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (login.getPassword().getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Debe completar el campo de 'Password'","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					login.dispose();
				}
			}
		}
		if (this.login.getJButtonCancelar() == source){
	   		System.out.println("GestionarMediador.actionPerformed() jButtonCancelar");
	   		login.dispose();	
	   	}
	}
}
