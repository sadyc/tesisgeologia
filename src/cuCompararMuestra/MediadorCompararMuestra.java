package cuCompararMuestra;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;

import cuCalcularClasificacion.ControlClasificacion;
import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de comparacion.
 * @author TesisGeologia
 *
 */
public class MediadorCompararMuestra extends Mediador{
	private GUIComparacion GUIComparacion;
	private String nombreMuestra1;
	private Muestra muestra1 = new Muestra();
	private Object [] [] data1;
	private String nombreMuestra2;
	private Muestra muestra2 = new Muestra();
	private Object [] [] data2;
	
	/**
	 * Default Constructor
	 */
	public MediadorCompararMuestra(String titulo){
		super();
		this.GUIComparacion = new GUIComparacion();
		GUIComparacion.setTitle(titulo);
		GUIComparacion.setModal(true);
		this.GUIComparacion.setListenerButtons(this);
		GUIComparacion.show();
	}
	
	/**
	 * 
	 * @param titulo
	 * @param nombreMuestra1
	 * @throws Exception
	 */
	public MediadorCompararMuestra(String titulo, String nombreMuestra1, String nombreMuestra2) throws Exception {
		super();
		this.nombreMuestra1=nombreMuestra1;
		this.nombreMuestra2=nombreMuestra2;
		muestra1 = obtenerMuestra(nombreMuestra1);
		muestra2 = obtenerMuestra(nombreMuestra2);
		data1 = cargarTablaDeAnalisis(nombreMuestra1);
		data2 = cargarTablaDeAnalisis(nombreMuestra2);
		this.GUIComparacion = new GUIComparacion(muestra1,data1,muestra2,data2);
		GUIComparacion.setTitle(titulo);
		GUIComparacion.setModal(true);
		this.GUIComparacion.setListenerButtons(this);
		GUIComparacion.show();
	}
	
	/**
	 * Permite recuperar una muestra1 de la base de datos. 
	 * @param nombreMuestra, es el nombre de la muestra a buscar en la base de datos.
	 * @return muestra, es la muestra con el nombre pasado como parametro.
	 */
	public Muestra obtenerMuestra(String nombreMuestra){
		ControlClasificacion control = new ControlClasificacion();
		Muestra muestra = new Muestra();
		try {
			muestra = control.obtenerMuestra(muestra.getClass(), nombreMuestra);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la muestra1 a clasificar!!");
			e.printStackTrace();
		}
		return muestra;
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data1 de la clase mediador.
	 * @param nombreMuestra, es el nombre de la muestra de la cual se desean obtener los analisis.
	 * @return data, es la tabla con los datos de los analisis correspondientes a la muestra.
	 */
	public Object [] [] cargarTablaDeAnalisis(String nombreMuestra)throws Exception{
		Object [] [] data = new Object [20] [5];
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
		return data;
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
		if (this.GUIComparacion.getJButtonImprimir() == source) {
			System.out.println("Se presiono imprimir!!");
			GUIComparacion.dispose();
				
			}
		if (this.GUIComparacion.getJButtonSalir() == source){
			System.out.println("Se presiono salir!!");
			GUIComparacion.dispose();
		}
	}
	public Object[][] getData1() {
		return data1;
	}
	
	public Object[][] getData2() {
		return data2;
	}
}

