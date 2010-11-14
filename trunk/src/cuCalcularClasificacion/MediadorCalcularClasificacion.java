/**
 * 
 */
package cuCalcularClasificacion;

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
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.GUIMuestra;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 *
 */
public class MediadorCalcularClasificacion implements ActionListener,MouseListener,ItemListener{
	private GUIClasificacion GUIClasificacion;
	private String[] data = new String [9];
	
	public MediadorCalcularClasificacion() throws Exception {
		super();
		this.GUIClasificacion = new GUIClasificacion();
		GUIClasificacion.setTitle("Clasificacion de la Muestra");
		GUIClasificacion.setModal(true);
		this.GUIClasificacion.setListenerButtons(this);
		GUIClasificacion.show();
	}
	

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		//ControlGestionarMuestra control = new ControlGestionarMuestra();
		if (this.GUIClasificacion.getJButtonImprimir() == source) {
			GUIClasificacion.dispose();
				
			}
		if (this.GUIClasificacion.getJButtonSalir() == source){
			GUIClasificacion.dispose();
		}
	}
	public String[] getData() {
		return data;
	}
}

