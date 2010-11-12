package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.Analisis;
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
	private String nombreMuestra;
	private MediadorSeleccionarMuestra mediadorMuestra;
	private MediadorBuscar mediadorBuscar;
	private Object [][] data = new Object [20] [4];
	
	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis(String titulo,String nombreMuestra) throws Exception {
		super();
		this.nombreMuestra = nombreMuestra;
		//cargarTablaDeAnalisis(nombreMuestra);
		this.gestionarAnalisis = new GUIGestionarAnalisis(titulo,data);
		gestionarAnalisis.setTitle(titulo);
		//gestionarAnalisis.setModal(true);
		this.gestionarAnalisis.setListenerButtons(this);
		show();
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
		int i = 0;
		while (it.hasNext()){
			analisis = it.next();
			data [i][0]= analisis.getPesoRetenido();
			data [i][1]= analisis.getPorcentajePasante();
		    data [i][2]= analisis.getPorcentajeRetenidoAcumulado();		        
		    data [i][3]= analisis.getPorcentajeRetenidoParcial();
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
			MediadorAltaAnalisis analisis = new MediadorAltaAnalisis(nombreMuestra);
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