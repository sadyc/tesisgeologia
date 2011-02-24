package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import comun.Mediador;
import comun.MediadorVersion;

import persistencia.domain.OperadorDeLaboratorio;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GUIOperador.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class MediadorAltaOperador extends Mediador{
	private GUIOperador GUIOperador;
	private String[] data = new String [6];
	private OperadorDeLaboratorio operador ;
	private Component frame;
	private ControlGestionarOperador control;
	private boolean altaOperador= false;

	
	/**
	 * @param nombreVentana
	 * Constructor con pasaje de parametros.
	 */
	public MediadorAltaOperador(String nombreVentana) {
		super();
		control = new ControlGestionarOperador();
		operador = new OperadorDeLaboratorio();
		GUIOperador = new GUIOperador();
		GUIOperador.setTitle(nombreVentana);
		GUIOperador.setListenerButtons(this);
		GUIOperador.setKeyListener(this);
		GUIOperador.setModal(true);
		GUIOperador.setLocationRelativeTo(null);
		GUIOperador.show();
	}
	
	/**
	 * @return the alta operador
	 */
	public boolean esAltaOperador() {
		return altaOperador;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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
		if (this.GUIOperador.getjButtonAgregar() == source || this.GUIOperador.getjMenuItemAgregar()== source) {
			aceptar();
		}
		if (GUIOperador.getjMenuItemVersion()==source){
			new MediadorVersion();
		}
		if (this.GUIOperador.getjButtonCancelar() == source || GUIOperador.getjMenuItemCancelar()==source){
			GUIOperador.dispose();
		}
		if(this.GUIOperador.getjMenuItemVersion() == source){
			new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("Operador.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIOperador.getjTextFieldNombre().getText().equals("") || GUIOperador.getjTextFieldApellido().getText().equals("") || GUIOperador.getjTextFieldDni().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				insertarUsuario();
				}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void insertarUsuario(){
		data[0]= GUIOperador.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUIOperador.getjTextFieldApellido().getText().toUpperCase();
		if (!isDni(GUIOperador.getjTextFieldDni().getText())){
			System.out.println("El DNI es incorrecto!");
			JOptionPane.showMessageDialog(frame,"El DNI ingresado es Incorrecto. Debe ser de la forma ##.###.###","Atención!", JOptionPane.ERROR_MESSAGE);
		}else{
			data[2]= GUIOperador.getjTextFieldDni().getText();
			if (!isEmail(GUIOperador.getjTextFieldEmail().getText().toUpperCase()) && (!GUIOperador.getjTextFieldEmail().getText().isEmpty())){
				System.out.println("El E-mail es incorrecto!");
				JOptionPane.showMessageDialog(frame,"El e-mail ingresado es Incorrecto. Debe ser de la forma XX@XX.XX","Atención!", JOptionPane.ERROR_MESSAGE);
			}else{
				data[3]= GUIOperador.getjTextFieldTelefono().getText();
				data[4]= GUIOperador.getjTextFieldEmail().getText().toUpperCase();
				operador = new OperadorDeLaboratorio(data[0],data[1],data[2],data[3],data[4]);
				try {
					control.insertarOperador(operador);
					if (control.getExiste()) {
						System.out.println("El objeto ya existe");
						JOptionPane.showMessageDialog(frame,"El Operador de Laboratorio con DNI: "+data[2]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						altaOperador = true;
						GUIOperador.dispose();
					}
			
				} catch (Exception e) {
					System.out.println("No inserta Operador Mediador Alta Operador");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @return data
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

	public void keyTyped(KeyEvent arg0) {
		if (GUIOperador.getjTextFieldNombre().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIOperador.getjTextFieldApellido().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIOperador.getjTextFieldDni().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIOperador.getjTextFieldEmail().getText().length()==25){ 
			arg0.consume(); 
			System.out.print("\07");
		}
        if (GUIOperador.getjTextFieldTelefono().getText().length()==25){ 
			arg0.consume(); 
			System.out.print("\07");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

     
}
