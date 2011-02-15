package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.OperadorDeLaboratorio;

import comun.Mediador;

import cuBuscar.MediadorBuscar;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.MediadorAltaMuestra;
import cuGestionarMuestra.MediadorModificarMuestra;
import cuGestionarUsuario.ControlGestionarUsuario;
import cuGestionarUsuario.MediadorAltaUsuario;
import cuGestionarUsuario.MediadorModificarUsuario;
import cuGestionarUsuario.MediadorVerificarPassword;


/**
* @author TesisGeología
*/
public class MediadorGestionarOperador implements ActionListener, KeyListener, MouseListener{

	private GUIGestionarOperador GUIGestionarOperador = null;
	private Object [] seleccionado;
	private Object [][] data;
	private Component frame;
	private ControlGestionarOperador control = new ControlGestionarOperador();

	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorGestionarOperador() throws Exception {
		super();
		cargarTablaDeOperador();
		GUIGestionarOperador = new GUIGestionarOperador(data);
		GUIGestionarOperador.setTitle("Seleccionar un Operador");
		GUIGestionarOperador.setListenerButtons(this);
		GUIGestionarOperador.setListenerTable(this);
		GUIGestionarOperador.setMouseListener(this);
		GUIGestionarOperador.setKeyListener(this);
		GUIGestionarOperador.getJButtonSeleccionar().setEnabled(false);
		GUIGestionarOperador.getSeleccionarMenu().setEnabled(false);
		GUIGestionarOperador.setModal(true);
		GUIGestionarOperador.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeOperador()throws Exception{
		OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
		Class clase = operador.getClass();
		Collection operadores = control.coleccionOperadores(clase);
		Iterator<OperadorDeLaboratorio> it = operadores.iterator();
		data = new Object [operadores.size()] [5];
		int i = 0;
		while (it.hasNext()){
			operador = it.next();
			data [i][0]= operador.getNombre();
			data [i][1]= operador.getApellido();
		    data [i][2]= operador.getDni();		        
		    data [i][3]= operador.getTel();
		    data [i][4] = operador.getEmail();
		    i++;
		}
	}
	
	/**
	 * @return the gUISeleccionarOperador
	 */
	public GUIGestionarOperador getGUIGestionarOperador() {
		return GUIGestionarOperador;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIGestionarOperador.getjButtonAgregarOperador() == source||GUIGestionarOperador.getAgregarMenu()==source){
			agregarOperador();
	   	}
		if (this.GUIGestionarOperador.getjButtonElminarOperador() == source||GUIGestionarOperador.getEliminarMenu()==source){
			eliminarOperador();
		}
		if (this.GUIGestionarOperador.getjButtonModificarOperador() == source||GUIGestionarOperador.getModificarMenu()==source){
			modificarOperador();
		}
		if (this.GUIGestionarOperador.getJButtonSeleccionar() == source){
			seleccionarOperador();
		}
		if (this.GUIGestionarOperador.getJButtonBuscar() == source){
	   		buscarOperador();
		}
		if (this.GUIGestionarOperador.getJButtonCancelar() == source){
			GUIGestionarOperador.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Operador"
	 */
	public void modificarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = GUIGestionarOperador.getTablePanel().getRow(GUIGestionarOperador.getTablePanel().getSelectedRow());
			try {
				MediadorModificarOperador modificarOperador = new MediadorModificarOperador(fila);
				if (modificarOperador.seModificoOperador()) {
					GUIGestionarOperador.getTablePanel().removeRow(GUIGestionarOperador.getTablePanel().getSelectedRow());
					this.GUIGestionarOperador.getTablePanel().addRow(modificarOperador.getData());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Operador"
	 */
	public void eliminarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta seguro de eliminar este usuario?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	        if(quitOption==JOptionPane.YES_OPTION){
	        	try{
	        		System.out.println(GUIGestionarOperador.getTablePanel().getSelectedRow());
	        	   	String [] fila = GUIGestionarOperador.getTablePanel().getRow(GUIGestionarOperador.getTablePanel().getSelectedRow());
	            	GUIGestionarOperador.getTablePanel().removeRow(GUIGestionarOperador.getTablePanel().getSelectedRow());
	            	String dni = fila[2];
	               	try {
	               		control.eliminarOperador(dni);
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
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Operador"
	 */
	public void agregarOperador(){
		try {	
			System.out.println("Button Agregar Usuario");
			MediadorAltaOperador altaOperador = new MediadorAltaOperador("Ingresar Operador de Laboratorio");	
		if (altaOperador.esAltaOperador()){  
			this.GUIGestionarOperador.getTablePanel().addRow(altaOperador.getData());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Operador"
	 */
	public void seleccionarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun Operador","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				seleccionado = GUIGestionarOperador.getTablePanel().getRow(GUIGestionarOperador.getTablePanel().getSelectedRow());//
				System.out.println("Button Seleccionar Operador");
				GUIGestionarOperador.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un Operador invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar Operador"
	 */
	public void buscarOperador(){
		try {
   			System.out.println("Button Buscar Operador");
   			new MediadorBuscar();	
   		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show(){
		GUIGestionarOperador.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			modificarOperador();
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	modificarOperador();
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
