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
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;
import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.GUIMuestra;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 *
 */
public class MediadorCalcularClasificacion implements ActionListener,MouseListener,ItemListener{
	private GUIClasificacion GUIClasificacion;
	private String nombreMuestra;
	private Muestra muestra = new Muestra();
	private Object [] [] data;
	
	public MediadorCalcularClasificacion(String titulo, String nombreMuestra) throws Exception {
		super();
		this.nombreMuestra=nombreMuestra;
		obtenerMuestra();
		cargarTablaDeAnalisis(nombreMuestra);
		this.GUIClasificacion = new GUIClasificacion(this.muestra,data);
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setModal(true);
		this.GUIClasificacion.setListenerButtons(this);
		ControlClasificacion control = new ControlClasificacion();
		control.calcularClasificacionSUCS(muestra);
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
		data = new Object [20] [5];
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection muestras = control.coleccionAnalisisDeMuestra(clase, nombreMuestra);
		Iterator<Analisis> it = muestras.iterator();
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

