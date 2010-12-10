package cuGestionarOperador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;
import cuGestionarAnalisis.MediadorBuscar;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.MediadorAltaMuestra;
import cuGestionarMuestra.MediadorModificarMuestra;


/**
* @author TesisGeolog�a
*/
public class MediadorSeleccionarOperador implements ActionListener,MouseListener,ItemListener {

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
		this.GUISeleccionarOperador = new GUISeleccionarOperador(data);
		GUISeleccionarOperador.setTitle("Seleccionar un Operador");
		GUISeleccionarOperador.setModal(true);
		this.GUISeleccionarOperador.setListenerButtons(this);
		this.GUISeleccionarOperador.setListenerTable(this);
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
		if (this.GUISeleccionarOperador.getJButtonSeleccionar() == source){
			seleccionarOperador();
		}
		if (this.GUISeleccionarOperador.getJButtonBuscar() == source){
	   		buscarOperador();
		}
		if (this.GUISeleccionarOperador.getJButtonSalir() == source){
			GUISeleccionarOperador.dispose();
		}
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
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarOperador.getTablePanel() == source)
			System.out.println("GestionarMediador.actionPerformed() jJTableTabla");
		
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
}