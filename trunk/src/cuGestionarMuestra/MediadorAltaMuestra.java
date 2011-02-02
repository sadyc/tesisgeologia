/**
 * 
 */
package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JOptionPane;

import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

import comun.Mediador;

import cuGestionarOperador.MediadorSeleccionarOperador;
import cuGestionarUbiacion.MediadorSeleccionarUbicacion;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana Muestra.
 * 
 * @author TesisGeologia
 *
 */
public class MediadorAltaMuestra extends Mediador{
	private GUIMuestraNetBeans GUIMuestra;
	private String[] data = new String [10];
	private Muestra muestra ;
	private Ubicacion ubicacion;
	private OperadorDeLaboratorio operador;
	private Component frame;
	private ControlGestionarMuestra control;
	private Usuario usuario ;
	private Date fecha ;
	private boolean altaMuestra= false;

	
	/**
	 * @param nombreVentana
	 * Constructor con pasaje de parametros.
	 */
	public MediadorAltaMuestra(String nombreVentana) {
		super();
		muestra = new Muestra();
		control = new ControlGestionarMuestra();
		fecha = new Date(11,22,1980);
		usuario = new Usuario();
		ubicacion = new Ubicacion();
		operador= new OperadorDeLaboratorio();
		GUIMuestra = new GUIMuestraNetBeans(true);
		GUIMuestra.setTitle("Ingresar Muestra");
		GUIMuestra.setModal(true);
		GUIMuestra.setListenerButtons(this);
		GUIMuestra.show();
	}
	
	/**
	 * @return the altaMuestra
	 */
	public boolean esAltaMuestra() {
		return altaMuestra;
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
		if (this.GUIMuestra.getJButtonAceptar() == source || this.GUIMuestra.getjMenuAceptar()== source) {
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
		System.out.println("Muestra.actionPerformed() jButtonAceptar");
		try{
		 	if (GUIMuestra.getNombre().getText().equals("") || GUIMuestra.getPeso().getText().equals("") || GUIMuestra.getUbicacion().getText().equals("Ubicacion(*) : ") || GUIMuestra.getOperador().getText().equals("Operador(*) :") ){
	 			JOptionPane.showMessageDialog(frame,"Los campos con (*) son obligatorios","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (Integer.parseInt(GUIMuestra.getPeso().getText()) <= 0 || Integer.parseInt(GUIMuestra.getPeso().getText()) > 5000) {
					JOptionPane.showMessageDialog(frame,"El peso de la muestra debe ser mayor a 0 y no puede superar los 5000 gramos","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (!GUIMuestra.getProfundidadInicial().getText().equals("") && !GUIMuestra.getProfundidadFinal().getText().equals("")){
						if (Integer.parseInt(GUIMuestra.getProfundidadFinal().getText()) < Integer.parseInt(GUIMuestra.getProfundidadInicial().getText())){
							JOptionPane.showMessageDialog(frame,"La Profundidad Final debe ser mayor o igual que la Profundidad Inicial","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
						}
						else{
							insertarMuestra();
						}
					}
					else{
						insertarMuestra();
					}
				}
			}
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frame,"Recuerde ingresar solo numeros en los campos correspondientes y que estos mismos no excedan la cantidad de caracteres","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Una vez verificados que los datos ingresados son correctos se procede a la carga de los mismos al sistema.
	 */
	public void insertarMuestra(){
		data[0]= ubicacion.getNombreUbicacion();
		data[1]= GUIMuestra.getNombre().getText();
		data[2]= GUIMuestra.getPeso().getText();
		data[3]= GUIMuestra.getProfundidadInicial().getText();
		data[4]= GUIMuestra.getProfundidadFinal().getText();
		muestra = new Muestra(data[1],Float.parseFloat(data[2]),Float.parseFloat(data[3]),Float.parseFloat(data[4]),operador,usuario,this.ubicacion,fecha);
		try {
			control.insertarMuestra(muestra, ubicacion, operador);
			altaMuestra = true;
		} catch (Exception e) {
			System.out.println("No inserta muestra Mediador Alta Muestra");
			e.printStackTrace();
		}
		GUIMuestra.dispose();

	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Ubicacion"
	 */
	public void seleccionarUbicacion(){
		try {
			MediadorSeleccionarUbicacion mediadorSelUbic = new MediadorSeleccionarUbicacion();
			if((String)mediadorSelUbic.getSeleccionado()[0]!= null){
				this.GUIMuestra.setUbicacion("Ubicacion : "+(String)mediadorSelUbic.getSeleccionado()[0]);
				this.ubicacion.setNombreUbicacion((String)mediadorSelUbic.getSeleccionado()[0]);
				}
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
			if ((String)seleccionarOperador.getSeleccionado()[0]!=null) {
				this.GUIMuestra.setOperador("Operador : "+(String)seleccionarOperador.getSeleccionado()[0]);
				this.operador.setDni((String)seleccionarOperador.getSeleccionado()[2]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String[] getData() {
		return data;
	}
}
