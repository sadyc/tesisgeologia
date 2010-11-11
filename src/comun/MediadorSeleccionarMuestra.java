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



public class MediadorSeleccionarMuestra implements ActionListener,MouseListener,ItemListener {

	private GUISeleccionarMuestra GUISeleccionarMuestra = null;
	private Object [] seleccionado = new Object [4];
	private Component frame;
	
	
	public MediadorSeleccionarMuestra() throws Exception {
		super();
		//cargarTablaDeMuestras();
		Object [][] data = new Object [4] [5];
		this.GUISeleccionarMuestra = new GUISeleccionarMuestra(data);
		GUISeleccionarMuestra.setTitle("Seleccionar una muestra");
		GUISeleccionarMuestra.setModal(true);
		this.GUISeleccionarMuestra.setListenerButtons(this);
		this.GUISeleccionarMuestra.setListenerTable(this);
		GUISeleccionarMuestra.show();
		
		
		
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
	   			GUISeleccionarMuestra.dispose();	   		
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
	
	/**
	 * @returns data 
	*/
	

	public void itemStateChanged(ItemEvent e) {
	}
}