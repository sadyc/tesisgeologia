package cuGestionarCliente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Cliente;

import comun.Mediador;

import cuGestionarOperador.GUIOperador;

public class MediadorModificarCliente extends Mediador{
	
	private GUIOperador GUICliente;
	private boolean modificoCliente;
	private String[] data = new String [7];
	private Component frame;
	private Cliente clienteModificar;
	private ControlGestionarCliente control = new ControlGestionarCliente();
	

	public MediadorModificarCliente(String[] fila) throws Exception {
		super();
		clienteModificar = (control.obtenerCliente(fila[2]));
		GUICliente = new GUIOperador(clienteModificar);
		GUICliente.setTitle("Modificar Cliente");
		GUICliente.setListenerButtons(this);
		GUICliente.setModal(true);
		GUICliente.show();
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
		if (this.GUICliente.getjButtonAgregar() == source|| GUICliente.getjMenuItemAgregar()==source) {
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
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUICliente.getjTextFieldNombre().getText().equals("") || GUICliente.getjTextFieldDni().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificarCliente();
				modificoCliente = true;
				}
			}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void modificarCliente(){
		data[0]= GUICliente.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUICliente.getjTextFieldApellido().getText().toUpperCase();
		data[2]= GUICliente.getjTextFieldDni().getText();
		data[3]= GUICliente.getjTextFieldEmail().getText().toUpperCase();
		data[4]= GUICliente.getjTextFieldTelefono().getText();
		try {
			control.modificarCliente(clienteModificar.getDni(),data);
			if (control.getExiste()) {
				System.out.println("El objeto ya existe");
				JOptionPane.showMessageDialog(frame,"El cliente con DNI: "+data[2]+" ya existe. Por favor ingrese otro.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificoCliente = true;
				GUICliente.dispose();
			}
		} catch (Exception e) {
			System.out.println("No modifica Operador Mediador Modificar Operador");
			e.printStackTrace();
		}
		

	}
	
	public String[] getData() {
		return data;
	}
	
	/**
	 * retorna true si se modifico el Operador.
	 * @return modificoCliente.
	 */
	public boolean seModificoCliente() {
		return modificoCliente;
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
