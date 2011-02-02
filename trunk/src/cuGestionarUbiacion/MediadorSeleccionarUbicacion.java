package cuGestionarUbiacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Ubicacion;

import comun.Mediador;

import cuGestionarMuestra.ControlGestionarMuestra;

public class MediadorSeleccionarUbicacion extends Mediador{

	private GUISeleccionarUbicacion GUISeleccionarUbicacion = null;
	private Object [][] data;
	private Object [] seleccionado = new Object [4];
	private Component frame;
	
	
	public MediadorSeleccionarUbicacion() throws Exception {
		super();
		cargarTablaDeMuestras();
		this.GUISeleccionarUbicacion = new GUISeleccionarUbicacion(data);
		GUISeleccionarUbicacion.setTitle("Seleccionar una muestra");
		GUISeleccionarUbicacion.setModal(true);
		GUISeleccionarUbicacion.setListenerButtons(this);
		GUISeleccionarUbicacion.setListenerTable(this);
		GUISeleccionarUbicacion.show();
	}
	
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Ubicacion ubicacion = new Ubicacion();
		Class clase = ubicacion.getClass();
		Collection ubicaciones = control.coleccionMuestras(clase);
		Iterator<Ubicacion> it = ubicaciones.iterator();
		data = new Object [ubicaciones.size()] [4];
		int i = 0;
		while (it.hasNext()){
			ubicacion = it.next();
			data [i][0]= ubicacion.getNombreUbicacion();
			data [i][1]= ubicacion.getProvincia();
		    data [i][2]= ubicacion.getLatitud();		        
		    data [i][3]= ubicacion.getLongitud();
		    i++;
		}
	}
	/**
	 * @return the gUISeleccionarUbicacion
	 */
	public GUISeleccionarUbicacion getGUISeleccionarUbicacion() {
		return GUISeleccionarUbicacion;
	}

	/**
	 * @param gUISeleccionarMuestra the gUISeleccionarMuestra to set
	 */
	public void setGUISeleccionarMuestra(GUISeleccionarUbicacion gUISeleccionarUbicacion) {
		GUISeleccionarUbicacion = gUISeleccionarUbicacion;
	}

		
	/**
	 * @return the seleccionado
	 */
	public Object[] getSeleccionado() {
		return seleccionado;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarUbicacion.getJButtonSeleccionar() == source){
			seleccionarUbicacion();
		}
		if (this.GUISeleccionarUbicacion.getJButtonBuscar() == source){
	   		buscarUbicacion();
		}
		if (this.GUISeleccionarUbicacion.getJButtonSalir() == source){
			GUISeleccionarUbicacion.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Ubicacion"
	 */
	public void seleccionarUbicacion(){
		if (GUISeleccionarUbicacion.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ninguna ubicacion","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
			System.out.println("Button Seleccionar Ubicacion");
			seleccionado = GUISeleccionarUbicacion.getTablePanel().getRow(GUISeleccionarUbicacion.getTablePanel().getSelectedRow());
   			GUISeleccionarUbicacion.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado una ubicacion invalida","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar Ubicacion"
	 */
	public void buscarUbicacion(){
		try {
   			System.out.println("Button Buscar Muestra"); // TODAVIA NO HACE NADAAA!!!!!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show(){
		GUISeleccionarUbicacion.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		System.out.println(" mouse eventtt" );
		if (this.GUISeleccionarUbicacion.getTablePanel() == source)
			System.out.println("GestionarMediador.actionPerformed() jJTableTabla");
		if (arg0.getClickCount() == 2){
			seleccionarUbicacion();
        System.out.println(" double click" );
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
	 * @returns data 
	*/
	

	public void itemStateChanged(ItemEvent e) {
	}
}