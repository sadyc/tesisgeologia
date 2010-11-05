/**
 * 
 */
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

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Muestra
 * @author TesisGeologia
 *
 */
public class MediadorMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra = null;
	private Component frame;

	public MediadorMuestra(String nombreVentana) throws Exception {
		super();
		this.GUIMuestra = new GUIMuestra();
		GUIMuestra.show();
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		this.GUIMuestra.setListenerButtons(this);
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
		if (this.GUIMuestra.getJButtonAceptar() == source) {
			System.out.println("Muestra.actionPerformed() jButtonAceptar");
			Muestra muestra= new Muestra();
			OperadorDeLaboratorio op = new OperadorDeLaboratorio("asd","asd","12","4665458","asd@gmail.com");
     		Ubicacion ubicacion = new Ubicacion();
     		Usuario usuario = new Usuario();
     		Clasificacion clasificacion = new Clasificacion();
     		if (GUIMuestra.getMuestra().getText().equals("") || GUIMuestra.getPeso().getText().equals("")  ){
				JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				Muestra mu = new Muestra();
				//Muestra mu = new Muestra((GUIMuestra.getData()[0]),Integer.parseInt(GUIMuestra.getData()[1]),Float.parseFloat(GUIMuestra.getData()[2]),Float.parseFloat(GUIMuestra.getData()[3]),op,usuario,ubicacion,clasificacion);
				//control.insertarObject(mu);
				GUIMuestra.dispose();
				
			}
     	}
		if (this.GUIMuestra.getJButtonCancelar() == source){
			GUIMuestra.dispose();
		}
	}
	
}
