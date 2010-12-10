package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import comun.*;
import persistencia.domain.Muestra;
import cuCompararMuestra.GUISeleccionarMuestra;
import cuGestionarAnalisis.MediadorBuscar;

/**
* @author TesisGeología
* 
*/

public class MediadorSeleccionarMuestra extends Mediador{

	private GUISeleccionarMuestra GUISeleccionarMuestra = null;
	private Object [] seleccionado = new Object [4];
	private Object [][] data;
	private boolean seleccionoMuestra = false;
	private Component frame;
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorSeleccionarMuestra() throws Exception {
		super();
		cargarTablaDeMuestras();
		this.GUISeleccionarMuestra = new GUISeleccionarMuestra(data);
		GUISeleccionarMuestra.setTitle("Seleccionar una muestra");
		GUISeleccionarMuestra.setModal(true);
		this.GUISeleccionarMuestra.setListenerButtons(this);
		this.GUISeleccionarMuestra.setListenerTable(this);
		GUISeleccionarMuestra.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = new Muestra();
		Class clase = muestra.getClass();
		Collection muestras = control.coleccionMuestras(clase);
		Iterator<Muestra> it = muestras.iterator();
		data = new Object [muestras.size()] [5];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    i++;
		}
	}
	
	/**
	 * @return the gUISeleccionarMuestra
	 */
	public GUISeleccionarMuestra getGUISeleccionarMuestra() {
		return GUISeleccionarMuestra;
	}

	/**
	 * @param gUISeleccionarMuestra the gUISeleccionarMuestra to set
	 */
	public void setGUISeleccionarMuestra(GUISeleccionarMuestra gUISeleccionarMuestra) {
		GUISeleccionarMuestra = gUISeleccionarMuestra;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarMuestra.getJButtonSeleccionar() == source){
			seleccionarMuestra();
		}
		if (this.GUISeleccionarMuestra.getJButtonBuscar() == source){
	   		buscarMuestra();
		}
		if (this.GUISeleccionarMuestra.getJButtonSalir() == source){
			GUISeleccionarMuestra.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Muestra"
	 */
	public void seleccionarMuestra(){
		if (GUISeleccionarMuestra.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			System.out.println("Button Seleccionar Muestra");
			try {
				seleccionado = GUISeleccionarMuestra.getTablePanel().getRow(GUISeleccionarMuestra.getTablePanel().getSelectedRow());
				seleccionoMuestra = true;
				GUISeleccionarMuestra.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
   				   		
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar Muestra"
	 */
	public void buscarMuestra(){
		try {
   			System.out.println("Button Buscar Muestra");
   			new MediadorBuscar();	// HACE LA BUSQUEDA!
			
   		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the seleccionado
	 */
	public Object[] getSeleccionado() {
		return seleccionado;
	}
	
	/**
	 * @return the seleccionoMuestra
	 */
	public boolean seSeleccionoMuestra() {
		return seleccionoMuestra;
	}

	public void show(){
		GUISeleccionarMuestra.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarMuestra.getTablePanel() == source)
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

	public void itemStateChanged(ItemEvent e) {
	}
}