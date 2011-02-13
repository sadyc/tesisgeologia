package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import persistencia.domain.OperadorDeLaboratorio;

public class MediadorAltaOperador implements ActionListener, KeyListener, MouseListener{
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
		GUIOperador.setModal(true);
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
		if (this.GUIOperador.getjButtonAgregar() == source || this.GUIOperador.getjMenuItemAgregar()== source) {
			aceptar();
		}
		if (this.GUIOperador.getjButtonCancelar() == source || GUIOperador.getjMenuItemCancelar()==source){
			GUIOperador.dispose();
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
				altaOperador = true;
				}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void insertarUsuario(){
		data[0]= GUIOperador.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUIOperador.getjTextFieldApellido().getText().toUpperCase();
		data[2]= GUIOperador.getjTextFieldDni().getText();
		data[3]= GUIOperador.getjTextFieldEmail().getText().toUpperCase();
		data[4]= GUIOperador.getjTextFieldTelefono().getText();
		operador = new OperadorDeLaboratorio(data[0],data[1],data[2],data[3],data[4]);
		try {
			control.insertarOperador(operador);
			altaOperador = true;
		} catch (Exception e) {
			System.out.println("No inserta Operador Mediador Alta Operador");
			e.printStackTrace();
		}
		GUIOperador.dispose();

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
}
