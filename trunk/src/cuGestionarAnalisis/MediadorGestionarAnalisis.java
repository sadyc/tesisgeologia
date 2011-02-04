package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;

import comun.Mediador;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorGestionarAnalisis  extends Mediador{
	
	private GUIGestionarAnalisis gestionarAnalisis;
	private Muestra muestra;
	private Analisis analisis;
	private Object [][] data;
	private Component frame;
	
	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis(String titulo,Muestra muestra) throws Exception {
		super();
		this.muestra = muestra;
		cargarTablaDeAnalisis();
		gestionarAnalisis = new GUIGestionarAnalisis(titulo,data);
		gestionarAnalisis.setListenerButtons(this);
		show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param nombreMuestra 
	 */
	public void cargarTablaDeAnalisis()throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection coleccionAnalisis = control.coleccionAnalisisDeMuestra(clase,muestra);
		Iterator<Analisis> it = coleccionAnalisis.iterator();
		data = new Object [coleccionAnalisis.size()] [5];
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
		
	public void show(){
		gestionarAnalisis.show();
	}
	
	
	/**
	 * @return the gestionarAnalisis.
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
			agregarAnalisis();
		}
		if (this.gestionarAnalisis.getJButtonModificarAnalisis() == source){
			modificarAnalisis();
		}
		if (this.gestionarAnalisis.getJButtonEliminarAnalisis() == source){
			eliminarAnalisis();
		}
		if (this.gestionarAnalisis.getJButtonCerrar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			gestionarAnalisis.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Analisis"
	 */
	public void eliminarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonEliminar");
		if (gestionarAnalisis.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta Seguro de eliminar la fila?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(quitOption==JOptionPane.YES_OPTION){
            	ControlGestionarAnalisis control = new ControlGestionarAnalisis();
            	String [] fila = gestionarAnalisis.getTablePanel().getRow(gestionarAnalisis.getTablePanel().getSelectedRow());
            	Tamiz tamiz = new Tamiz();
            	tamiz.setNumeroTamiz(fila[0]);
              	analisis = new Analisis(Float.parseFloat(fila[1]),muestra,tamiz);
              	try {
					control.eliminarAnalisis(analisis);
					control.recalcularAnalisis(analisis);
					gestionarAnalisis.dispose();
					new MediadorGestionarAnalisis("Analisis de la muestra "+ muestra.getNombreMuestra(), muestra);
				} catch (Exception e1) {
					e1.printStackTrace();
				}              	    	
            }
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Analisis"
	 */
	public void modificarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonModificar");
		if (gestionarAnalisis.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = gestionarAnalisis.getTablePanel().getRow(gestionarAnalisis.getTablePanel().getSelectedRow());
			new MediadorModificarAnalisis(muestra.getNombreMuestra(),Float.parseFloat(fila[1]),(String)fila[0]);
			gestionarAnalisis.dispose();
			try {
				new MediadorGestionarAnalisis("Analisis de la muestra "+muestra.getNombreMuestra(), muestra);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Analisis"
	 */
	public void agregarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		MediadorAltaAnalisis altaAnalisis = new MediadorAltaAnalisis(muestra);
		if (altaAnalisis.isAltaAnalisis()){
			this.gestionarAnalisis.getTablePanel().addRow(altaAnalisis.getData());
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