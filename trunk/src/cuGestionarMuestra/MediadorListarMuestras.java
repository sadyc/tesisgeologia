package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.Muestra;

/**
* @author TesisGeología
*
*/
public class MediadorListarMuestras implements ActionListener {
	
	private GUIListarMuestras GUIListarMuestras = null;
	private Object [][] data;
	private Component frame;
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorListarMuestras() throws Exception {
		super();
		cargarTablaDeMuestras();
		this.GUIListarMuestras = new GUIListarMuestras(data);
		GUIListarMuestras.setTitle("Muestras Cargadas");
		GUIListarMuestras.setModal(true);
		this.GUIListarMuestras.setListenerButtons(this);
		GUIListarMuestras.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = new Muestra();
		Class clase = muestra.getClass();
		Collection muestras = control.coleccionMuestras(clase);
		Iterator<Muestra> it = muestras.iterator();
		data = new Object [muestras.size()] [8];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    data [i][5]= muestra.getOperador().getNombre()+" "+muestra.getOperador().getApellido();
		    data [i][6]= muestra.getUbicacion().getLatitud();
		    data [i][7]= muestra.getUbicacion().getLongitud();
		    i++;
		}
	}
		
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIListarMuestras.getJButtonSalir() == source){
			GUIListarMuestras.dispose();
		}
	}
	
	public void show(){
		GUIListarMuestras.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	
}