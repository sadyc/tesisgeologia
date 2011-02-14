package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Usuario;
import cuGestionarUsuario.ControlGestionarUsuario;
import cuGestionarUsuario.GUIUsuario;
import cuLogin.Encriptar;

public class MediadorModificarOperador implements ActionListener, KeyListener, MouseListener {
	
	private GUIOperador GUIOperador;
	private boolean modificoOperador;
	private String[] data = new String [7];
	private Component frame;
	private OperadorDeLaboratorio operadorModificar;
	private ControlGestionarOperador control = new ControlGestionarOperador();
	

	public MediadorModificarOperador(String[] fila) throws Exception {
		super();
		operadorModificar = (control.obtenerOperador(fila[2]));
		GUIOperador = new GUIOperador(operadorModificar);
		GUIOperador.setTitle("Modificar Operador de Laboratorio");
		GUIOperador.setListenerButtons(this);
		GUIOperador.setModal(true);
		GUIOperador.show();
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
		if (this.GUIOperador.getjButtonAgregar() == source|| GUIOperador.getjMenuItemAgregar()==source) {
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
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIOperador.getjTextFieldNombre().getText().equals("") || GUIOperador.getjTextFieldApellido().getText().equals("") || GUIOperador.getjTextFieldDni().getText().equals("")){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificarUsuario();
				modificoOperador = true;
				}
			}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar s�lo n�meros en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void modificarUsuario(){
		data[0]= GUIOperador.getjTextFieldNombre().getText().toUpperCase();
		data[1]= GUIOperador.getjTextFieldApellido().getText().toUpperCase();
		data[2]= GUIOperador.getjTextFieldDni().getText();
		data[3]= GUIOperador.getjTextFieldEmail().getText().toUpperCase();
		data[4]= GUIOperador.getjTextFieldTelefono().getText();
		try {
			control.modificarOperador(operadorModificar.getDni(),data);
			modificoOperador = true;
		} catch (Exception e) {
			System.out.println("No modifica Operador Mediador Modificar Operador");
			e.printStackTrace();
		}
		GUIOperador.dispose();

	}
	
	public String[] getData() {
		return data;
	}
	
	/**
	 * retorna true si se modifico el Operador.
	 * @return modificoOperador.
	 */
	public boolean seModificoOperador() {
		return modificoOperador;
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