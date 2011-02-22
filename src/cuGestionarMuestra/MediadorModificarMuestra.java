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
import comun.MediadorVersion;

import cuGestionarCliente.MediadorSeleccionarCliente;
import cuGestionarOperador.MediadorSeleccionarOperador;
import cuGestionarUbicacion.MediadorGestionarUbicacion;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Modificar Muestra.
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
	private Usuario usuario;
	private ControlGestionarMuestra control = new ControlGestionarMuestra();
	

	/**
	 * Constructor con pasaje de parametros.
	 * @param fila
	 * @param usuario
	 * @throws Exception
	 */
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
		GUIMuestra.setKeyListener(this);
		GUIMuestra.setLocationRelativeTo(null);
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
		if (GUIMuestra.getVersionMenu()==source){
			MediadorVersion version = new MediadorVersion();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("") || GUIMuestra.getUbicacion().getText().equals("Ubicación(*) : ") || GUIMuestra.getOperador().getText().equals("Operador(*) :") ){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (Float.parseFloat(GUIMuestra.getPeso().getText()) <= 0 || Float.parseFloat(GUIMuestra.getPeso().getText()) > 5000) {
					JOptionPane.showMessageDialog(frame,"El peso de la muestra debe ser mayor a 0 y no puede superar los 5000 gramos","Atención!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (!GUIMuestra.getProfundidadInicial().getText().equals("") && !GUIMuestra.getProfundidadFinal().getText().equals("")){
						if (Float.parseFloat(GUIMuestra.getProfundidadFinal().getText()) < Float.parseFloat(GUIMuestra.getProfundidadInicial().getText())){
							JOptionPane.showMessageDialog(frame,"La Profundidad Final debe ser mayor o igual que la Profundidad Inicial","Atención!", JOptionPane.ERROR_MESSAGE);
						}
						else{
							modificarMuestra();
						}
					}
					else{
						modificarMuestra();
					}
				}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo números en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","Atención!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Una vez verificados que los datos modificados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void modificarMuestra(){
		try {
			data[0]= GUIMuestra.getUbicacion().getText().substring(12);
			data[1]= GUIMuestra.getNombre().getText();
			data[2]= GUIMuestra.getPeso().getText();
			data[3]= GUIMuestra.getProfundidadInicial().getText();
			data[4]= GUIMuestra.getProfundidadFinal().getText();
			data[5]= dniOperadorModificar;
			data[6]= dniClienteModificar;
			data[7]= usuario.getNombreUsuario();
			control.ModificarMuestra(nombreMuestraModificar,ubicacionModificar,data);
			if (control.getExiste()) {
				JOptionPane.showMessageDialog(frame,"La muestra con nombre: "+data[1]+" que se ubica en "+data[0]+", ya existe. Por favor ingrese otra.","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				modificoMuestra = true;
				GUIMuestra.dispose();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Ubicacion"
	 */
	public void seleccionarUbicacion(){
		try {
			MediadorGestionarUbicacion mediadorSelUbic = new MediadorGestionarUbicacion();
			if (mediadorSelUbic.seSelecciono()){
				this.GUIMuestra.setUbicacion("Ubicacion : "+(String)mediadorSelUbic.getSeleccionado()[0]);
			}
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
			if (seleccionarCliente.isSeleccionoCliente()){
				GUIMuestra.setCliente("Cliente : "+(String)seleccionarCliente.getSeleccionado()[0]);
				dniClienteModificar =((String)seleccionarCliente.getSeleccionado()[2]);
			}
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
	public void keyTyped(KeyEvent arg0) {
		if (GUIMuestra.getNombre().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIMuestra.getPeso().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIMuestra.getProfundidadInicial().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		if (GUIMuestra.getProfundidadFinal().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
	}

	
}
