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
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Modificar Muestra
 * @author TesisGeologia
 *
 */
public class MediadorModificarMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra;
	private String[] data = new String [9];
	private Component frame;
	private Muestra muestra;

	public MediadorModificarMuestra(Object[] data) throws Exception {
		super();
		this.GUIMuestra = new GUIMuestra(data);
		this.GUIMuestra.setListenerButtons(this);
		GUIMuestra.show();
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		
		
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
			
			if (GUIMuestra.getMuestra().getText().equals("") || GUIMuestra.getPeso().getText().equals("")  ){
				JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				muestra.setNombreMuestra(GUIMuestra.getMuestra().getText());
				muestra.setPeso(Integer.parseInt(GUIMuestra.getPeso().getText()));
				muestra.setProfundidadInicial(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
				muestra.setProfundidadFinal(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
				
				
				//Muestra mu = new Muestra();
				
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
