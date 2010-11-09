package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
				//seleccionado = GUISeleccionarMuestra.getTablePanel().getRow(GUISeleccionarMuestra.getTablePanel().getSelectedRow());//
				//Muestra mu = new Muestra((fila[0]),Integer.parseInt(fila[1]),Float.parseFloat(fila[2]),Float.parseFloat(fila[3]),op,usuario,ubicacion,clasificacion);
				//muestra = new Muestra (fila[0],Integer.parseInt()[0],fila[0],fila[0],fila[0],fila[0],fila[0],fila[0],fila[0]);
				System.out.println("Button Seleccionar Ubicacion");
	   			GUISeleccionarUbicacion.dispose();	   		
			}
		}
		if (this.GUISeleccionarUbicacion.getJButtonBuscar() == source){
	   		try {
	   			System.out.println("Button Buscar Muestra");
				MediadorBuscar analisis = new MediadorBuscar();	
				
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