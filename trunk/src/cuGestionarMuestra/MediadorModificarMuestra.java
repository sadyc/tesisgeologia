/**
 * 
 */
package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Usuario;

import comun.Mediador;
import comun.MediadorSeleccionarOperador;

import cuGestionarCliente.MediadorSeleccionarCliente;
import cuGestionarUbicacion.MediadorGestionarUbicacion;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Modificar Muestra
 * @author TesisGeologia
 *
 */
public class MediadorModificarMuestra extends Mediador{
	private GUIMuestra GUIMuestra;
	private boolean modificoMuestra;
	private String[] data = new String [10];
	private Component frame;
	private String nombreMuestraModificar;
	private String ubicacionModificar;
	private String dniOperadorModificar;
	private String dniClienteModificar;
	private OperadorDeLaboratorio operador;
	private Muestra muestra;
	private Usuario usuario;
	private ControlGestionarMuestra control = new ControlGestionarMuestra();
	

	public MediadorModificarMuestra(String[] fila, Usuario usuario) throws Exception {
		super();
		this.usuario = usuario;
		ubicacionModificar = fila[0];
		nombreMuestraModificar = fila[1];
		dniOperadorModificar = (control.obtenerMuestra(fila[1], fila[0])).getOperadorLaboratorio().getDni();
		dniClienteModificar = (control.obtenerMuestra(fila[1], fila[0])).getCliente().getDni();
		String nombreOperador = (control.obtenerMuestra(fila[1], fila[0])).getOperadorLaboratorio().getNombre()+" "+control.obtenerMuestra(fila[1], fila[0]).getOperadorLaboratorio().getApellido();
		String nombreCliente = (control.obtenerMuestra(fila[1], fila[0])).getCliente().getNombre()+" "+control.obtenerMuestra(fila[1], fila[0]).getCliente().getApellido();
		GUIMuestra = new GUIMuestra(fila, nombreOperador, nombreCliente,usuario.getNombreUsuario());
		GUIMuestra.setTitle("Modificar Muestra");
		GUIMuestra.setModal(true);
		GUIMuestra.setListenerButtons(this);
		GUIMuestra.show();
	}
	

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
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
		if (this.GUIMuestra.getJButtonSeleccionarOperador()== source || GUIMuestra.getjMenuItemSeleccionarOperador()==source) {
			seleccionarOperador();
		}
		if (this.GUIMuestra.getJButtonSeleccionarUbicacion()== source || GUIMuestra.getjMenuItemSeleccionarUbicacion()==source) {
			seleccionarUbicacion();
		}
		if (this.GUIMuestra.getSeleccionarCliente()== source || GUIMuestra.getjMenuItemSeleccionarCliente()==source) {
			seleccionarCliente();
		}
		if (this.GUIMuestra.getJButtonAceptar() == source|| GUIMuestra.getjMenuAceptar()==source) {
			aceptar();
		}
		if (this.GUIMuestra.getJButtonCancelar() == source || GUIMuestra.getJButtonCancelar()==source){
			GUIMuestra.dispose();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("") || GUIMuestra.getUbicacion().getText().equals("Ubicacion(*) : ") || GUIMuestra.getOperador().getText().equals("Operador(*) :") ){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (Float.parseFloat(GUIMuestra.getPeso().getText()) <= 0 || Float.parseFloat(GUIMuestra.getPeso().getText()) > 5000) {
					JOptionPane.showMessageDialog(frame,"El peso de la muestra debe ser mayor a 0 y no puede superar los 5000 gramos","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (!GUIMuestra.getProfundidadInicial().getText().equals("") && !GUIMuestra.getProfundidadFinal().getText().equals("")){
						if (Float.parseFloat(GUIMuestra.getProfundidadFinal().getText()) < Float.parseFloat(GUIMuestra.getProfundidadInicial().getText())){
							JOptionPane.showMessageDialog(frame,"La Profundidad Final debe ser mayor o igual que la Profundidad Inicial","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
						}
						else{
							modificarMuestra();
							modificoMuestra = true;
						}
					}
					else{
						modificarMuestra();
						modificoMuestra = true;
					}
				}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo numeros en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void modificarMuestra(){
		try {
			data[0]= GUIMuestra.getUbicacion().getText();
			data[1]= GUIMuestra.getNombre().getText();
			data[2]= GUIMuestra.getPeso().getText();
			data[3]= GUIMuestra.getProfundidadInicial().getText();
			data[4]= GUIMuestra.getProfundidadFinal().getText();
			data[5]= dniOperadorModificar;
			data[6]= dniClienteModificar;
			data[7]= usuario.getNombreUsuario();
			control.ModificarMuestra(nombreMuestraModificar,ubicacionModificar,data);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		GUIMuestra.dispose();
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Ubicacion"
	 */
	public void seleccionarUbicacion(){
		try {
			MediadorGestionarUbicacion mediadorSelUbic = new MediadorGestionarUbicacion();
			this.GUIMuestra.setUbicacion("Ubicacion : "+(String)mediadorSelUbic.getSeleccionado()[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Operador"
	 */
	public void seleccionarOperador(){
		try {
			MediadorSeleccionarOperador seleccionarOperador = new MediadorSeleccionarOperador();
			GUIMuestra.setOperador("Operador : "+(String)seleccionarOperador.getSeleccionado()[0]);
			dniOperadorModificar =((String)seleccionarOperador.getSeleccionado()[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Cliente"
	 */
	public void seleccionarCliente(){
		try {
			MediadorSeleccionarCliente seleccionarCliente = new MediadorSeleccionarCliente();
			GUIMuestra.setCliente("Cliente : "+(String)seleccionarCliente.getSeleccionado()[0]);
			dniClienteModificar =((String)seleccionarCliente.getSeleccionado()[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String[] getData() {
		return data;
	}
	
	/**
	 * retorna true si se modifico la muestra.
	 * @return modificoMuestra.
	 */
	public boolean seModificoMuestra() {
		return modificoMuestra;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
