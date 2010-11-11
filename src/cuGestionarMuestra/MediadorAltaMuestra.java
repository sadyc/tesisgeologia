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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

import comun.MediadorSeleccionarOperador;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Muestra
 * @author TesisGeologia
 *
 */
public class MediadorAltaMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra;
	private String[] data = new String [10];
	private Muestra muestra ;
	private Ubicacion ubicacion;
	private Component frame;

	public MediadorAltaMuestra(String nombreVentana) throws Exception {
		super();
		muestra = new Muestra();
		this.ubicacion = new Ubicacion();
		this.GUIMuestra = new GUIMuestra();
		GUIMuestra.setTitle("Ingresar Muestra");
		GUIMuestra.setModal(true);
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
		System.out.println("Boton Seleccionar Operador");
		if (this.GUIMuestra.getJButtonSeleccionarOperador()== source) {
			try {
				System.out.println("Boton Seleccionar Operador");
				MediadorSeleccionarOperador seleccionarOperador = new MediadorSeleccionarOperador();
				this.GUIMuestra.setOperador((String)seleccionarOperador.getSeleccionado()[0]);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if (this.GUIMuestra.getJButtonSeleccionarUbicacion()== source) {
			try {
				MediadorSeleccionarUbicacion mediadorSelUbic = new MediadorSeleccionarUbicacion();
				this.GUIMuestra.setUbicacion((String)mediadorSelUbic.getSeleccionado()[0]);
				this.ubicacion = new Ubicacion((String)mediadorSelUbic.getSeleccionado()[0],Ubicacion.Provincia.valueOf((String)mediadorSelUbic.getSeleccionado()[1]),(String)mediadorSelUbic.getSeleccionado()[2],(String)mediadorSelUbic.getSeleccionado()[3]);
				//muestra.setUbicacion(ubicacion);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if (this.GUIMuestra.getJButtonAceptar() == source) {
			System.out.println("Muestra.actionPerformed() jButtonAceptar");
			OperadorDeLaboratorio op = new OperadorDeLaboratorio("nombre","apellido","dni","4665458","asd@gmail.com");
       		Usuario usuario = new Usuario();
     		Clasificacion clasificacion = new Clasificacion();
     		Date fecha = new Date(11,22,1980);
     		if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("")  ){
				JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {

				data[0]= GUIMuestra.getUbicacion().getText();
				data[1]= GUIMuestra.getNombre().getText();
				data[2]= GUIMuestra.getPeso().getText();
				data[3]= GUIMuestra.getProfundidadInicial().getText();
				data[4]= GUIMuestra.getProfundidadFinal().getText();
				data[5]= this.ubicacion.getLatitud();
                data[6]= this.ubicacion.getLongitud();
                data[7]=  "clasificacion"; // muestra.getClasificacion
                data[8]= "nombre usuario"; // usuario.getNombre
                data[9]=  "operador ID"; // operador.getId
                muestra = new Muestra(data[1],Integer.parseInt(data[2]),Float.parseFloat(data[3]),Float.parseFloat(data[4]),op,usuario,this.ubicacion,clasificacion,fecha);
                
				try {
					control.insertarMuestra(muestra);
				} catch (Exception e) {
					System.out.println("No inserta muestra Mediador Alta Muestra");
					e.printStackTrace();
				}
				GUIMuestra.dispose();
			}
     	}
		if (!this.GUIMuestra.getUbicacion().equals("")){
			System.out.println("habilito el boton aceptar");
			JButton aceptar = (this.GUIMuestra.getJButtonAceptar());
			aceptar.enable();
			this.GUIMuestra.setJButtonAceptar(aceptar);
		}
		if (this.GUIMuestra.getJButtonCancelar() == source){
			GUIMuestra.dispose();
		}
	}
	public String[] getData() {
		return data;
	}
}
