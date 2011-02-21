package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.OperadorDeLaboratorio;

import comun.Mediador;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GUIOperador al modificar.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class MediadorModificarOperador extends Mediador{
	
	private GUIOperador GUIOperador;
	private boolean modificoOperador;
	private String[] data = new String [7];
	private Component frame;
	private OperadorDeLaboratorio operadorModificar;
	private ControlGestionarOperador control = new ControlGestionarOperador();
	

	/**
	 * Constructor con pasaje de parametros.
	 * @param fila
	 * @throws Exception
	 */
	public MediadorModificarOperador(String[] fila) throws Exception {
		super();
		operadorModificar = (control.obtenerOperador(fila[2]));
		GUIOperador = new GUIOperador(operadorModificar);
		GUIOperador.setTitle("Modificar Operador de Laboratorio");
		GUIOperador.setListenerButtons(this);
		GUIOperador.setKeyListener(this);
		GUIOperador.setModal(true);
		GUIOperador.setLocationRelativeTo(null);
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
				}
			}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar sólo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","Atención!", JOptionPane.ERROR_MESSAGE);
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
			if (control.getExiste()) {
				JOptionPane.showMessageDialog(frame,"El cliente con DNI: "+data[2]+" ya existe. Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificoOperador = true;
				GUIOperador.dispose();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

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
		if (!GUIOperador.getjTextFieldTelefono().getText().isEmpty()){
			char caracter = GUIOperador.getjTextFieldTelefono().getText().charAt(0);
			if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.')){
	             arg0.consume();  
	             System.out.print("\07");
			}
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
