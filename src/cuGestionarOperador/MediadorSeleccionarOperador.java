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


/**
* @author TesisGeología
*/
public class MediadorSeleccionarOperador implements ActionListener, KeyListener, MouseListener{

	private GUISeleccionarOperador GUISeleccionarOperador = null;
	private Object [] seleccionado = new Object [5];
	private Object [][] data;
	private Component frame;
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorSeleccionarOperador() throws Exception {
		super();
		cargarTablaDeOperador();
		GUISeleccionarOperador = new GUISeleccionarOperador(data);
		GUISeleccionarOperador.setTitle("Seleccionar un Operador");
		GUISeleccionarOperador.setListenerButtons(this);
		GUISeleccionarOperador.setListenerTable(this);
		GUISeleccionarOperador.setMouseListener(this);
		GUISeleccionarOperador.setKeyListener(this);
		GUISeleccionarOperador.setModal(true);
		GUISeleccionarOperador.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeOperador()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();   ////////////   DICE MUESTERAAAAAAAAA!!!!!
		OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
		Class clase = operador.getClass();
		Collection operadores = control.coleccionMuestras(clase);
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
	public GUISeleccionarOperador getGUISeleccionarOperador() {
		return GUISeleccionarOperador;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarOperador.getjButtonAgregarOperador() == source||GUISeleccionarOperador.getAgregarMenu()==source){
			agregarOperador();
	   	}
		if (this.GUISeleccionarOperador.getjButtonElminarOperador() == source||GUISeleccionarOperador.getEliminarMenu()==source){
			eliminarOperador();
		}
		if (this.GUISeleccionarOperador.getjButtonModificarOperador() == source||GUISeleccionarOperador.getModificarMenu()==source){
			modificarOperador();
		}
		if (this.GUISeleccionarOperador.getJButtonSeleccionar() == source){
			seleccionarOperador();
		}
		if (this.GUISeleccionarOperador.getJButtonBuscar() == source){
	   		buscarOperador();
		}
		if (this.GUISeleccionarOperador.getJButtonCancelar() == source){
			GUISeleccionarOperador.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Operador"
	 */
	public void modificarOperador(){
		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Operador"
	 */
	public void eliminarOperador(){
		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Operador"
	 */
	public void agregarOperador(){
		//new GUIOperador();
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Operador"
	 */
	public void seleccionarOperador(){
		if (GUISeleccionarOperador.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun Operador","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				seleccionado = GUISeleccionarOperador.getTablePanel().getRow(GUISeleccionarOperador.getTablePanel().getSelectedRow());//
				System.out.println("Button Seleccionar Operador");
				GUISeleccionarOperador.dispose();
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
		GUISeleccionarOperador.show();
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
