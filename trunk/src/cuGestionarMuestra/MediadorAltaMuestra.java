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
public class MediadorAltaMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra;
	private String[] data = new String [9];
	private Component frame;

	public MediadorAltaMuestra(String nombreVentana) throws Exception {
		super();
		this.GUIMuestra = new GUIMuestra();
		GUIMuestra.setTitle("Ingresar Muestra");
		GUIMuestra.setModal(true);
		
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		this.GUIMuestra.setListenerButtons(this);
		GUIMuestra.show();
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
		ControlGestionarMuestra control = new ControlGestionarMuestra();
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
				data[0]= GUIMuestra.getMuestra().getText();
				data[1]= GUIMuestra.getPeso().getText();
				data[2]= GUIMuestra.getProfundidadInicial().getText();
				data[3]= GUIMuestra.getProfundidadFinal().getText();
				data[4]= "dsa";
				data[5]=  "dsa";
				data[6]=  "dsa";
				data[7]= "dsa";
				data[8]=  "dsa";
				System.out.println("llene el arreglo");
				Muestra mu = new Muestra("s",1,2,3,op,usuario,ubicacion,clasificacion);
				//Muestra mu = new Muestra();
				//Muestra mu = new Muestra((GUIMuestra.getData()[0]),Integer.parseInt(GUIMuestra.getData()[1]),Float.parseFloat(GUIMuestra.getData()[2]),Float.parseFloat(GUIMuestra.getData()[3]),op,usuario,ubicacion,clasificacion);
				try {
					//control.insertarMuestra(mu);
				} catch (Exception e) {
					System.out.println("No inserta muestra");
					e.printStackTrace();
				}
				GUIMuestra.dispose();
				
			}
     	}
		if (this.GUIMuestra.getJButtonCancelar() == source){
			GUIMuestra.dispose();
		}
	}
	public String[] getData() {
		return data;
	}
}
