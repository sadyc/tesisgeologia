package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorGestionarAnalisis  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIGestionarAnalisis gestionarAnalisis;
	private String nombreMuestra;
	private Analisis analisis;
	private Object [][] data;
	private Component frame;
	
	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis(String titulo,String nombreMuestra) throws Exception {
		super();
		this.nombreMuestra = nombreMuestra;
		cargarTablaDeAnalisis(nombreMuestra);
		this.gestionarAnalisis = new GUIGestionarAnalisis(titulo,data);
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
		Collection coleccionAnalisis = control.coleccionAnalisisDeMuestra(clase, nombreMuestra);
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
            	Muestra muestra = new Muestra();
            	muestra.setNombreMuestra(nombreMuestra);
            	Tamiz tamiz = new Tamiz();
            	tamiz.setNumeroTamiz(Integer.parseInt(fila[0]));
              	analisis = new Analisis(Integer.parseInt(fila[1]),muestra,tamiz);
              	try {
					control.eliminarAnalisis(analisis);
					control.recalcularAnalisis(analisis);
					gestionarAnalisis.dispose();
					new MediadorGestionarAnalisis("Analisis de la muestra "+nombreMuestra, nombreMuestra);
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
			new MediadorModificarAnalisis(nombreMuestra,Integer.parseInt(fila[1]),(String)fila[0]);
			gestionarAnalisis.dispose();
			try {
				new MediadorGestionarAnalisis("Analisis de la muestra "+nombreMuestra, nombreMuestra);
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
		MediadorAltaAnalisis altaAnalisis = new MediadorAltaAnalisis(nombreMuestra);
		if (altaAnalisis.isAltaAnalisis()){
			analisis = altaAnalisis.getAnalisis();
			String [] fila = new String[5];
			fila[0] = analisis.getTamiz().getNumeroTamiz().toString();
			fila[1] = analisis.getPesoRetenido().toString();
			fila[2] = analisis.getPorcentajePasante().toString();
			fila[3] = analisis.getPorcentajeRetenidoAcumulado().toString();
			fila[4] = analisis.getPorcentajeRetenidoParcial().toString();
			this.gestionarAnalisis.getTablePanel().addRow(fila);
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