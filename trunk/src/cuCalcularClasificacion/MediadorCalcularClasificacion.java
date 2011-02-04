/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;

import cuCalcularClasificacion.Clasificaciones.AASHTO;
import cuCalcularClasificacion.Clasificaciones.SUCS;
import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 *
 */
public class MediadorCalcularClasificacion extends Mediador{
	private GUIClasificacion GUIClasificacion;
	private String nombreMuestra;
	private Muestra muestra = new Muestra();
	private Object [][] data;
	
	/**
	 * Default Constructor
	 */
	public MediadorCalcularClasificacion(String titulo){
		super();
		GUIClasificacion = new GUIClasificacion();
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setModal(true);
		GUIClasificacion.setListenerButtons(this);
		GUIClasificacion.show();
	}
	
	/**
	 * 
	 * @param titulo
	 * @param muestra
	 * @throws Exception
	 */
	public MediadorCalcularClasificacion(String titulo, Muestra muestra) throws Exception {
		super();
		cargarTablaDeAnalisis(muestra.getNombreMuestra());
		ControlClasificacion control = new ControlClasificacion();
		SUCS clasificacion = new SUCS();
		control.calcularClasificacionSUCS(muestra,clasificacion);
		muestra.setClasificacion(clasificacion);
		GUIClasificacion = new GUIClasificacion(clasificacion,muestra,data);
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setModal(true);
		GUIClasificacion.setListenerButtons(this);
		
		GUIClasificacion.show();
	}
	
	/**
	 * Permite recuperar una muestra de la base de datos. 
	 */
	public void obtenerMuestra(){
		ControlClasificacion control = new ControlClasificacion();
		try {
			this.muestra = control.obtenerMuestra(muestra.getClass(), nombreMuestra);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la muestra a clasificar!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param nombreMuestra 
	 */
	public void cargarTablaDeAnalisis(String nombreMuestra)throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection muestras = control.coleccionAnalisisDeMuestra(clase, nombreMuestra);
		Iterator<Analisis> it = muestras.iterator();
		data = new Object [muestras.size()] [5];
		int i = 0;
		while (it.hasNext()){
			analisis = it.next();
			data [i][0]= analisis.getTamiz().getNumeroTamiz();
			data [i][1]= analisis.getPesoRetenido();
			data [i][2]= analisis.getPorcentajePasante();
		    data [i][3]= analisis.getPorcentajeRetenidoAcumulado();		        
		    data [i][4]= analisis.getPorcentajeRetenidoParcial();
		    i++;
		}
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
		if (this.GUIClasificacion.getJButtonImprimir() == source) {
			GUIClasificacion.dispose();
				
			}
		if (this.GUIClasificacion.getJButtonSalir() == source){
			GUIClasificacion.dispose();
		}
	}
	public Object[][] getData() {
		return data;
	}
}

