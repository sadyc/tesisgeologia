package cuGestionarCliente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Cliente;

import comun.Mediador;
import comun.MediadorVersion;

import cuGestionarOperador.GUIOperador;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana "Alta Cliente".
 * @author TesisGeologia
 * @version 1.0
 */
public class MediadorAltaCliente extends Mediador{
	private GUIOperador GUICliente;
	private String[] data = new String [6];
	private Cliente cliente ;
	private Component frame;
	private ControlGestionarCliente control;
	private boolean altaCliente= false;

	
	/**
	 * Constructor con pasaje de parametros.
	 * @param nombreVentana
	 */
	@SuppressWarnings("deprecation")
	public MediadorAltaCliente(String nombreVentana) {
		super();
		control = new ControlGestionarCliente();
		cliente = new Cliente();
		GUICliente = new GUIOperador();
		GUICliente.setTitle(nombreVentana);
		GUICliente.setListenerButtons(this);
		GUICliente.setModal(true);
		GUICliente.setLocationRelativeTo(null);
		GUICliente.setjLabelApellido("Apellido: ");
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

	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUICliente.getjButtonAgregar() == source || this.GUICliente.getjMenuItemAgregar()== source) {
			aceptar();
		}
		if (this.GUICliente.getjButtonCancelar() == source || GUICliente.getjMenuItemCancelar()==source){
			GUICliente.dispose();
		}
		if(this.GUICliente.getjMenuItemVersion() == source){
			new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("cliente.actionPerformed() jButtonAceptar");
		try{
		 	if (GUICliente.getjTextFieldNombre().getText().equals("") || GUICliente.getjTextFieldDni().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				insertarCliente();
				}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void insertarCliente(){
		data[0]= GUICliente.getjTextFieldNombre().getText();
		data[1]= GUICliente.getjTextFieldApellido().getText();
		if (!isDni(GUICliente.getjTextFieldDni().getText())&&!isCuit(GUICliente.getjTextFieldDni().getText())){
			System.out.println("El DNI/CUIT/CUIL es incorrecto!");
			JOptionPane.showMessageDialog(frame,"Recuerde que el DNI ingresado debe respetar el formato '##.###.###' \no el CUIT/CUIL ser de la forma '(30 ó 33)-########-#'","Atención!", JOptionPane.ERROR_MESSAGE);

		}else{
			data[2]= GUICliente.getjTextFieldDni().getText();
			if (!isEmail(GUICliente.getjTextFieldEmail().getText().toUpperCase()) && (!GUICliente.getjTextFieldEmail().getText().isEmpty())){
				System.out.println("El E-mail es incorrecto!");
				JOptionPane.showMessageDialog(frame,"El e-mail ingresado es Incorrecto. Debe ser de la forma XX@XX.XX","Atención!", JOptionPane.ERROR_MESSAGE);
			}else{
				data[4]= GUICliente.getjTextFieldEmail().getText();
				data[3]= GUICliente.getjTextFieldTelefono().getText();
				cliente = new Cliente(data[0],data[1],data[2],data[4],data[3]);
				try {
					control.insertarCliente(cliente);
					if (control.yaExiste()) {
						System.out.println("El objeto ya existe");
						JOptionPane.showMessageDialog(frame,"El cliente con DNI/CUIT/CUIL: "+data[2]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
