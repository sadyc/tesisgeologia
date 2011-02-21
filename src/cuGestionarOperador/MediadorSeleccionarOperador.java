package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comun.Mediador;
import comun.MediadorVersion;

import persistencia.domain.OperadorDeLaboratorio;


/**
* @brief Clase que se utiliza para escuchar los eventos que suceden en la ventana "Seleccionar Operador".
* @author TesisGeología
* @version 1.0
*/
public class MediadorSeleccionarOperador extends Mediador{

	private GUIGestionarOperador GUIGestionarOperador = null;
	private Object [] seleccionado;
	private Object [][] data;
	private Component frame; 
	private boolean seleccionoOperador = false;
	private ControlGestionarOperador control = new ControlGestionarOperador();

	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorSeleccionarOperador() throws Exception {
		super();
		cargarTablaDeOperador();
		GUIGestionarOperador = new GUIGestionarOperador(data);
		GUIGestionarOperador.setTitle("Seleccionar un Operador");
		GUIGestionarOperador.setListenerButtons(this);
		GUIGestionarOperador.setListenerTable(this);
		GUIGestionarOperador.setMouseListener(this);
		GUIGestionarOperador.setKeyListener(this);
		GUIGestionarOperador.setModal(true);
		GUIGestionarOperador.setLocationRelativeTo(null);
		GUIGestionarOperador.show();
	}
	
	/**
	 * Levanta informacion almacenada en la base de datos y las copia 
	 * al atributo data de la clase mediador.
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
	
	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
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
		if (GUIGestionarOperador.getjMenuVersion()==source){
			MediadorVersion version = new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opción de "Modificar Operador"
	 */
	public void modificarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","Atención!", JOptionPane.ERROR_MESSAGE);
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
	 * Acciones a realizar cuando se selecciona la opción de "Eliminar Operador"
	 */
	public void eliminarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","Atención!", JOptionPane.ERROR_MESSAGE);
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
	        		JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","Atención!", JOptionPane.ERROR_MESSAGE);
	        	}
	        }
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opción de "Agregar Operador"
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
	 * Acciones a realizar cuando se selecciona la opción de "Seleccionar Operador"
	 */
	public void seleccionarOperador(){
		if (GUIGestionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún Operador","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				seleccionado = GUIGestionarOperador.getTablePanel().getRow(GUIGestionarOperador.getTablePanel().getSelectedRow());
				seleccionoOperador = true;
				System.out.println("Button Seleccionar Operador");
				GUIGestionarOperador.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un Operador inválido","Atención!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Método que me permite visualizar la ventana.
	 */
	public void show(){
		GUIGestionarOperador.show();
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			seleccionarOperador();
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	seleccionarOperador();
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
				
		}

		@Override
		public void keyTyped(KeyEvent e) {
				
		}

		/**
		 * @return the seleccionoOperador
		 */
		public boolean isSeleccionoOperador() {
			return seleccionoOperador;
		}
			
}
