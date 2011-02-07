package comun;

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

import persistencia.domain.Muestra;
import cuBuscar.MediadorBuscar;
import cuGestionarMuestra.ControlGestionarMuestra;

/**
* @author TesisGeología
* 
*/

public class MediadorSeleccionarMuestra implements ActionListener,MouseListener,ItemListener {

	private GUISeleccionarMuestra GUISeleccionarMuestra = null;
	private Object [] seleccionado = new Object [4];
	private Object [][] data = new Object [20] [5];
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
			if (GUISeleccionarMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Button Seleccionar Muestra");
				try {
					seleccionado = GUISeleccionarMuestra.getTablePanel().getRow(GUISeleccionarMuestra.getTablePanel().getSelectedRow());//MediadorCalcularClasificacion gestionarClasificacion = new MediadorCalcularClasificacion();
					seleccionoMuestra = true;
					GUISeleccionarMuestra.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
	   				   		
			}
		}
		if (this.GUISeleccionarMuestra.getJButtonBuscar() == source){
	   		try {
	   			System.out.println("Button Buscar Muestra");
				MediadorBuscar analisis = new MediadorBuscar();	// HACE LA BUSQUEDA!
				
	   		} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.GUISeleccionarMuestra.getJButtonSalir() == source){
			GUISeleccionarMuestra.dispose();
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