package cuGestionarCliente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import persistencia.domain.Cliente;

import comun.Mediador;

import cuGestionarOperador.GUIOperador;
/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana "Modificar Cliente".
 * @author TesisGeologia
 * @version 1.0
 */
public class MediadorModificarCliente extends Mediador{
	
	private GUIOperador GUICliente;
	private boolean modificoCliente;
	private String[] data = new String [7];
	private Component frame;
	private Cliente clienteModificar;
	private ControlGestionarCliente control = new ControlGestionarCliente();
	
	
	/**
	 * Constructor parametrizado de la clase.
	 * @param fila, arreglo que contiene los datos del cliente.
	 * @throws Exception
	 */
	public MediadorModificarCliente(String[] fila) throws Exception {
		super();
		clienteModificar = (control.obtenerCliente(fila[2]));
		GUICliente = new GUIOperador(clienteModificar);
		GUICliente.setTitle("Modificar Cliente");
		GUICliente.setListenerButtons(this);
		GUICliente.setModal(true);
		GUICliente.setLocationRelativeTo(null);
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

	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
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
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificarCliente();
				}
			}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","Atención!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void modificarCliente(){
		data[0]= GUICliente.getjTextFieldNombre().getText();
		data[1]= GUICliente.getjTextFieldApellido().getText();
		if (!isDni(GUICliente.getjTextFieldDni().getText())){
			System.out.println("El DNI es incorrecto!");
			JOptionPane.showMessageDialog(frame,"El DNI ingresado es Incorrecto. Debe ser de la forma ##.###.###","Atención!", JOptionPane.ERROR_MESSAGE);
			}else{
				data[2]= GUICliente.getjTextFieldDni().getText();
				if (!isEmail(GUICliente.getjTextFieldEmail().getText().toUpperCase()) && (!GUICliente.getjTextFieldEmail().getText().isEmpty())){
					System.out.println("El E-mail es incorrecto!");
					JOptionPane.showMessageDialog(frame,"El e-mail ingresado es Incorrecto. Debe ser de la forma XX@XX.XX","Atención!", JOptionPane.ERROR_MESSAGE);
				}else{
					data[4]= GUICliente.getjTextFieldEmail().getText();
					data[3]= GUICliente.getjTextFieldTelefono().getText();
					Cliente cliente = new Cliente(data[0],data[1],data[2],data[4],data[3]);
					try {	
						control.modificarCliente(clienteModificar.getDni(),cliente);
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
