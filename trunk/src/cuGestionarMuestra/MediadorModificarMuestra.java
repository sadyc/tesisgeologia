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

import persistencia.domain.Muestra;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Modificar Muestra
 * @author TesisGeologia
 *
 */
public class MediadorModificarMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra;
	private String[] data = new String [10];
	private Component frame;
	private Muestra muestra;
	private String nombreMuestra;

	public MediadorModificarMuestra(Object[] data) throws Exception {
		super();
		this.GUIMuestra = new GUIMuestra(data);
		nombreMuestra = (String)data[1];
		GUIMuestra.setTitle("Modificar Muestra");
		GUIMuestra.setModal(true);
		this.GUIMuestra.setListenerButtons(this);
		this.GUIMuestra.show();
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
			System.out.println("Aceptar Modificar Muestra");
			
			if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("")  ){
				JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					muestra = new Muestra();
					muestra.setNombreMuestra(GUIMuestra.getNombre().getText());
					muestra.setPeso(Integer.parseInt(GUIMuestra.getPeso().getText()));
					muestra.setProfundidadInicial(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
					muestra.setProfundidadFinal(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
					data[0]= GUIMuestra.getUbicacion().getText();
					data[1]= GUIMuestra.getNombre().getText();
					data[2]= GUIMuestra.getPeso().getText();
					data[3]= GUIMuestra.getProfundidadInicial().getText();
					data[4]= GUIMuestra.getProfundidadFinal().getText();
					data[5]= "longitud";
	                data[6]= "latitud";
	                data[7]=  "clasificacion"; // muestra.getClasificacion
	                data[8]= "nombre usuario"; // usuario.getNombre
	                data[9]=  "operador ID"; // operador.getId
					System.out.println("modifique campos456");
					control.ModificarMuestra(nombreMuestra, muestra);
				} catch (Exception e1) {
					e1.printStackTrace();
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
