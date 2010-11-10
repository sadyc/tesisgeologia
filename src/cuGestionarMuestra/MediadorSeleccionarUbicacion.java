package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

import comun.GUISeleccionarMuestra;

import cuGestionarAnalisis.MediadorBuscar;

public class MediadorSeleccionarUbicacion implements ActionListener,MouseListener,ItemListener {

	private GUISeleccionarUbicacion GUISeleccionarUbicacion = null;
	private Object [][] data = new Object [4] [4];
	private Object [] seleccionado = new Object [4];
	private Component frame;
	
	
	public MediadorSeleccionarUbicacion() throws Exception {
		super();
		//cargarTablaDeMuestras();
		Object [][] data = new Object [4] [5];
		this.GUISeleccionarUbicacion = new GUISeleccionarUbicacion(data);
		GUISeleccionarUbicacion.setTitle("Seleccionar una muestra");
		GUISeleccionarUbicacion.setModal(true);
		this.GUISeleccionarUbicacion.setListenerButtons(this);
		this.GUISeleccionarUbicacion.setListenerTable(this);
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

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarUbicacion.getJButtonSeleccionar() == source){
			if (GUISeleccionarUbicacion.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Button Seleccionar Ubicacion");
	   			GUISeleccionarUbicacion.dispose();	   		
			}
		}
		if (this.GUISeleccionarUbicacion.getJButtonBuscar() == source){
	   		try {
	   			System.out.println("Button Buscar Muestra");
				
				
	   		} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.GUISeleccionarUbicacion.getJButtonSalir() == source){
			GUISeleccionarUbicacion.dispose();
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
		if (this.GUISeleccionarUbicacion.getTablePanel() == source)
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
	 * @returns data 
	*/
	

	public void itemStateChanged(ItemEvent e) {
	}
}