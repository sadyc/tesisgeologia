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

import org.apache.tools.ant.taskdefs.Sleep;

import comun.MediadorVersion;

import persistencia.domain.OperadorDeLaboratorio;


/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GestionarOperador.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class MediadorGestionarOperador implements ActionListener, KeyListener, MouseListener{

	private GUIGestionarOperador GUIGestionarOperador = null;
	private Object [] seleccionado;
	private boolean selecciono= false;
	private boolean seleccionar;
	private Object [][] data;
	private Component frame;
	private ControlGestionarOperador control; 

	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorGestionarOperador(boolean seleccionar,boolean eliminar) throws Exception {
		super();
		this.seleccionar=seleccionar;
		cargarTablaDeOperador();
		GUIGestionarOperador = new GUIGestionarOperador(data);
		GUIGestionarOperador.setTitle("Seleccionar un Operador");
		GUIGestionarOperador.setListenerButtons(this);
		GUIGestionarOperador.setListenerTable(this);
		GUIGestionarOperador.setMouseListener(this);
		GUIGestionarOperador.setKeyListener(this);
		GUIGestionarOperador.setModal(true);
		GUIGestionarOperador.setLocationRelativeTo(null);
		GUIGestionarOperador.getjButtonSeleccionar().setEnabled(seleccionar);
		GUIGestionarOperador.getjMenuSeleccionar().setEnabled(seleccionar);
		GUIGestionarOperador.getjMenuEliminar().setEnabled(eliminar);
		GUIGestionarOperador.getjButtonEliminar().setEnabled(eliminar);
		GUIGestionarOperador.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeOperador()throws Exception{
		OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
		Class clase = operador.getClass();
		control = new ControlGestionarOperador();
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
		if (this.GUIGestionarOperador.getjButtonAgregar() == source||GUIGestionarOperador.getjMenuAgregar()==source){
			agregarOperador();
	   	}
		if (this.GUIGestionarOperador.getjButtonEliminar() == source||GUIGestionarOperador.getjMenuEliminar()==source){
			eliminarOperador();
		}
		if (this.GUIGestionarOperador.getjButtonModificar() == source||GUIGestionarOperador.getjMenuModificar()==source){
			modificarOperador();
		}
		if (this.GUIGestionarOperador.getjButtonSeleccionar() == source){
			seleccionarOperador();
		}
		if (this.GUIGestionarOperador.getjButtonSalir() == source || this.GUIGestionarOperador.getjMenuSalir()==source){
			GUIGestionarOperador.dispose();
		}

		if(this.GUIGestionarOperador.getjMenuVersion() == source){
			new MediadorVersion();
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
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro de eliminar este Operador? Recuerde que se borrarán todas las muestras asociadas.","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	        if(quitOption==JOptionPane.YES_OPTION){
	        	try{
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
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún Operador","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				seleccionado = GUIGestionarOperador.getTablePanel().getRow(GUIGestionarOperador.getTablePanel().getSelectedRow());//
				selecciono = true;
				System.out.println("Button Seleccionar Operador");
				GUIGestionarOperador.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un Operador inválido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * @return the selecciono
	 */
	public boolean isSelecciono() {
		return selecciono;
	}

	/**
	 * Métodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2){
			if (seleccionar) {
				seleccionarOperador();
			}
			else{
				modificarOperador();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER){
        	if (seleccionar) {
				seleccionarOperador();
			}
			else{
				modificarOperador();
			}
        }
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
