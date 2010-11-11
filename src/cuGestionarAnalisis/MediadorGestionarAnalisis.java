package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.Muestra;

import comun.MediadorSeleccionarMuestra;
import cuGestionarMuestra.ControlGestionarMuestra;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorGestionarAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIGestionarAnalisis gestionarAnalisis;
	private MediadorSeleccionarMuestra mediadorSeleccionar;
	private MediadorBuscar mediadorBuscar;
	private Object [][] data = new Object [4] [6];
	
	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis(String titulo) throws Exception {
		super();
		cargarTablaDeAnalisis();
		this.gestionarAnalisis = new GUIGestionarAnalisis();
		gestionarAnalisis.setTitle(titulo);
		//gestionarAnalisis.setModal(true);
		this.gestionarAnalisis.setListenerButtons(this);
		show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeAnalisis()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = new Muestra();
		Class clase = muestra.getClass();
		Collection muestras = control.coleccionMuestras(clase);
		Iterator<Muestra> it = muestras.iterator();
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
		    data [i][2]= muestra.getPeso();		        
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    data [i][5]= muestra.getOperador().getDni();
		    i++;
		}
	}
		
	public void show(){
		gestionarAnalisis.show();
	}
	
	
	/**
	 * @return the 
	 */
	public GUIGestionarAnalisis getGestionarAnalisis() {
		return gestionarAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.gestionarAnalisis.getJButtonAgregarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
			MediadorAltaAnalisis analisis = new MediadorAltaAnalisis();
		}
		if (this.gestionarAnalisis.getJButtonModificarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonModificar");
			
			
		}
		if (this.gestionarAnalisis.getJButtonEliminarAnalisis() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonEliminar");
			
		}
		if (this.gestionarAnalisis.getJButtonCerrar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			gestionarAnalisis.dispose();
		}
	}



	public void itemStateChanged(ItemEvent arg0) {
	}


	public void mouseClicked(MouseEvent arg0) {
	}


	public void mouseEntered(MouseEvent arg0) {
	}


	public void mouseExited(MouseEvent arg0) {
	}


	public void mousePressed(MouseEvent arg0) {
	}


	public void mouseReleased(MouseEvent arg0) {
	}
}