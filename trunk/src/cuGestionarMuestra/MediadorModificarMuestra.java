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
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;

import cuGestionarOperador.MediadorSeleccionarOperador;
import cuGestionarUbiacion.MediadorSeleccionarUbicacion;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana Modificar Muestra
 * @author TesisGeologia
 *
 */
public class MediadorModificarMuestra implements ActionListener,MouseListener,ItemListener{
	private GUIMuestra GUIMuestra;
	private String[] data = new String [5];
	private Component frame;
	private Ubicacion ubicacion;
	private OperadorDeLaboratorio operador;
	private Muestra muestra;
	private ControlGestionarMuestra control = new ControlGestionarMuestra();
	

	public MediadorModificarMuestra(Muestra muestra) throws Exception {
		super();
		this.muestra = muestra;
		operador = muestra.getOperador();
		ubicacion = muestra.getUbicacion();
		this.GUIMuestra = new GUIMuestra(muestra);
		GUIMuestra.setTitle("Modificar Muestra");
		GUIMuestra.setModal(true);
		this.GUIMuestra.setListenerButtons(this);
		this.GUIMuestra.show();
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
		if (this.GUIMuestra.getJButtonSeleccionarOperador()== source) {
			seleccionarOperador();
		}
		if (this.GUIMuestra.getJButtonSeleccionarUbicacion()== source) {
			seleccionarUbicacion();
		}
		if (this.GUIMuestra.getJButtonAceptar() == source) {
			aceptar();
		}
		if (this.GUIMuestra.getJButtonCancelar() == source){
			GUIMuestra.dispose();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("Aceptar Modificar Muestra");
		if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("")  ){
			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			try {
				String nombreMuestraModificar = muestra.getNombreMuestra();
				muestra.setNombreMuestra(GUIMuestra.getNombre().getText());
				muestra.setPeso(Float.parseFloat(GUIMuestra.getPeso().getText()));
				muestra.setProfundidadInicial(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
				muestra.setProfundidadFinal(Float.parseFloat(GUIMuestra.getProfundidadInicial().getText()));
				data[0]= GUIMuestra.getUbicacion().getText().substring(15);
				data[1]= GUIMuestra.getNombre().getText();
				data[2]= GUIMuestra.getPeso().getText();
				data[3]= GUIMuestra.getProfundidadInicial().getText();
				data[4]= GUIMuestra.getProfundidadFinal().getText();
				control.ModificarMuestra(nombreMuestraModificar, muestra,ubicacion,operador);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			GUIMuestra.dispose();
		}

	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Ubicacion"
	 */
	public void seleccionarUbicacion(){
		try {
			MediadorSeleccionarUbicacion mediadorSelUbic = new MediadorSeleccionarUbicacion();
			this.GUIMuestra.setUbicacion("Ubicacion : "+(String)mediadorSelUbic.getSeleccionado()[0]);
			this.ubicacion.setNombreUbicacion((String)mediadorSelUbic.getSeleccionado()[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Operador"
	 */
	public void seleccionarOperador(){
		try {
			MediadorSeleccionarOperador seleccionarOperador = new MediadorSeleccionarOperador();
			this.GUIMuestra.setOperador("Operador : "+(String)seleccionarOperador.getSeleccionado()[0]);
			this.operador.setDni((String)seleccionarOperador.getSeleccionado()[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getData() {
		return data;
	}
}
