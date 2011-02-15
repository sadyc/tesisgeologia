package cuGestionarCliente;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Cliente;

import comun.Mediador;

import cuBuscar.MediadorBuscar;
import cuGestionarOperador.GUIGestionarOperador;


/**
* @author TesisGeología
*/
public class MediadorGestionarCliente extends Mediador{

	private GUIGestionarOperador GUIGestionarCliente = null;
	private Object [] seleccionado = new Object [5];
	private Object [][] data;
	private Component frame;
	private ControlGestionarCliente control = new ControlGestionarCliente();

	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorGestionarCliente() throws Exception {
		super();
		cargarTablaDeCliente();
		GUIGestionarCliente = new GUIGestionarOperador(data);
		GUIGestionarCliente.setTitle("Seleccionar un Cliente");
		GUIGestionarCliente.setListenerButtons(this);
		GUIGestionarCliente.setListenerTable(this);
		GUIGestionarCliente.setMouseListener(this);
		GUIGestionarCliente.setKeyListener(this);
		GUIGestionarCliente.setModal(true);
		GUIGestionarCliente.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeCliente()throws Exception{
		Cliente cliente = new Cliente();
		Class clase = cliente.getClass();
		Collection clientes = control.coleccionClientes(clase);
		Iterator<Cliente> it = clientes.iterator();
		data = new Object [clientes.size()] [5];
		int i = 0;
		while (it.hasNext()){
			cliente = it.next();
			data [i][0]= cliente.getNombre();
			data [i][1]= cliente.getApellido();
		    data [i][2]= cliente.getDni();		        
		    data [i][3]= cliente.getTel();
		    data [i][4]= cliente.getEmail();
		    i++;
		}
	}
	
	/**
	 * @return the gUISeleccionarCliente
	 */
	public GUIGestionarOperador getGUIGestionarCliente() {
		return GUIGestionarCliente;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIGestionarCliente.getjButtonAgregarOperador() == source||GUIGestionarCliente.getAgregarMenu()==source){
			agregarCliente();
	   	}
		if (this.GUIGestionarCliente.getjButtonElminarOperador() == source||GUIGestionarCliente.getEliminarMenu()==source){
			eliminarCliente();
		}
		if (this.GUIGestionarCliente.getjButtonModificarOperador() == source||GUIGestionarCliente.getModificarMenu()==source){
			modificarCliente();
		}
		if (this.GUIGestionarCliente.getJButtonSeleccionar() == source){
			seleccionarCliente();
		}
		if (this.GUIGestionarCliente.getJButtonBuscar() == source){
	   		buscarCliente();
		}
		if (this.GUIGestionarCliente.getJButtonCancelar() == source){
			GUIGestionarCliente.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Cliente"
	 */
	public void modificarCliente(){
		if (GUIGestionarCliente.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = GUIGestionarCliente.getTablePanel().getRow(GUIGestionarCliente.getTablePanel().getSelectedRow());
			try {
				MediadorModificarCliente modificarCliente = new MediadorModificarCliente(fila);
				if (modificarCliente.seModificoCliente()) {
					GUIGestionarCliente.getTablePanel().removeRow(GUIGestionarCliente.getTablePanel().getSelectedRow());
					this.GUIGestionarCliente.getTablePanel().addRow(modificarCliente.getData());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Cliente"
	 */
	public void eliminarCliente(){
		if (GUIGestionarCliente.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta seguro de eliminar este usuario?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	        if(quitOption==JOptionPane.YES_OPTION){
	        	try{
	        		System.out.println(GUIGestionarCliente.getTablePanel().getSelectedRow());
	        	   	String [] fila = GUIGestionarCliente.getTablePanel().getRow(GUIGestionarCliente.getTablePanel().getSelectedRow());
	            	GUIGestionarCliente.getTablePanel().removeRow(GUIGestionarCliente.getTablePanel().getSelectedRow());
	            	String dni = fila[2];
	               	try {
	               		control.eliminarCliente(dni);
	               	} catch (Exception e) {
						e.printStackTrace();
	               	}
	        	}
	        	catch (Exception e) {
	        		JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
		}
		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Cliente"
	 */
	public void agregarCliente(){
		try {	
			System.out.println("Button Agregar Usuario");
			MediadorAltaCliente altaCliente = new MediadorAltaCliente("Ingresar Cliente de Laboratorio");	
		if (altaCliente.esAltaCliente()){  
			this.GUIGestionarCliente.getTablePanel().addRow(altaCliente.getData());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Cliente"
	 */
	public void seleccionarCliente(){
		if (GUIGestionarCliente.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun Cliente","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				seleccionado = GUIGestionarCliente.getTablePanel().getRow(GUIGestionarCliente.getTablePanel().getSelectedRow());//
				System.out.println("Button Seleccionar Cliente");
				GUIGestionarCliente.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un Cliente invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar Cliente"
	 */
	public void buscarCliente(){
		try {
   			System.out.println("Button Buscar Cliente");
   			new MediadorBuscar();	
   		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show(){
		GUIGestionarCliente.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			seleccionarCliente();
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	seleccionarCliente();
	}
	
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	/**
	 * @return the seleccionado
	 */
	public Object[] getSeleccionado() {
		return seleccionado;
	}

		public void itemStateChanged(ItemEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
