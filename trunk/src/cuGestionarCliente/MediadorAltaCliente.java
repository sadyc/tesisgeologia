package cuGestionarCliente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.jdo.JDOException;
import javax.swing.JOptionPane;

import persistencia.domain.Cliente;

import comun.Mediador;

import cuGestionarOperador.GUIOperador;

public class MediadorAltaCliente extends Mediador{
	private GUIOperador GUICliente;
	private String[] data = new String [6];
	private Cliente cliente ;
	private Component frame;
	private ControlGestionarCliente control;
	private boolean altaCliente= false;

	
	/**
	 * @param nombreVentana
	 * Constructor con pasaje de parametros.
	 */
	public MediadorAltaCliente(String nombreVentana) {
		super();
		control = new ControlGestionarCliente();
		cliente = new Cliente();
		GUICliente = new GUIOperador();
		GUICliente.setTitle(nombreVentana);
		GUICliente.setListenerButtons(this);
		GUICliente.setModal(true);
		GUICliente.setLocationRelativeTo(null);
		GUICliente.show();
	}
	
	/**
	 * @return the alta cliente
	 */
	public boolean esAltaCliente() {
		return altaCliente;
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
		if (this.GUICliente.getjButtonAgregar() == source || this.GUICliente.getjMenuItemAgregar()== source) {
			aceptar();
		}
		if (this.GUICliente.getjButtonCancelar() == source || GUICliente.getjMenuItemCancelar()==source){
			GUICliente.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("cliente.actionPerformed() jButtonAceptar");
		try{
		 	if (GUICliente.getjTextFieldNombre().getText().equals("") || GUICliente.getjTextFieldDni().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				insertarCliente();
				}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void insertarCliente(){
		data[0]= GUICliente.getjTextFieldNombre().getText();
		data[1]= GUICliente.getjTextFieldApellido().getText();
		data[2]= GUICliente.getjTextFieldDni().getText();
		data[3]= GUICliente.getjTextFieldEmail().getText();
		data[4]= GUICliente.getjTextFieldTelefono().getText();
		cliente = new Cliente(data[0],data[1],data[2],data[3],data[4]);
		try {
			control.insertarCliente(cliente);
			if (control.getExiste()) {
				System.out.println("El objeto ya existe");
				JOptionPane.showMessageDialog(frame,"El cliente con DNI: "+data[2]+" ya existe. Por favor ingrese otro.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				altaCliente = true;
				GUICliente.dispose();
			}
		}
		catch (Exception e) {
			System.out.println("No inserta cliente Mediador Alta cliente");
			e.printStackTrace();
		}
		
		

	}
	
	/**  PARA VALIDAR EL MAIL!
	public boolean validarEmail(String email) {
		// Expressio regular extreta de http://regexlib.com/
		Pattern p = Pattern.compile(\"^([0-9a-zA-Z]([_.w]*[-.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)*([a-zA-Z]{1,9}.)+[a-zA-Z]{2,3})$\");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
	*/
	
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
