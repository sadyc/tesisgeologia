package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;



/**
 * @author TesisGeologia
 *
 */
public class MediadorGestionarMuestra implements ActionListener,MouseListener,ItemListener{

	private GUIABMMuestra GUIABMMuestra;
	private Object [][] data ;
	private Component frame;
	
	
	public MediadorGestionarMuestra(String nombreVentana) throws Exception {
		super();
		cargarTablaDeMuestras();
		this.GUIABMMuestra = new GUIABMMuestra(nombreVentana,data);
		GUIABMMuestra.show();
		this.GUIABMMuestra.setListenerButtons(this);
		this.GUIABMMuestra.setListenerTable(this);
		
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
		data = new Object [muestras.size()] [6];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    i++;
		}
	}
			
	public void show()	{
		 GUIABMMuestra.show();
	}
	
	public GUIABMMuestra getGestionarMuestra() {
		return GUIABMMuestra;
	}
	
	public void setGestionarMuestra(GUIABMMuestra gestionarMuestra) {
		this.GUIABMMuestra = gestionarMuestra;
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		OperadorDeLaboratorio op = new OperadorDeLaboratorio();
 		Ubicacion ubicacion = new Ubicacion();
 		Usuario usuario = new Usuario();
 		Date fecha = new Date(12,12,1222);
 		Clasificacion clasificacion = new Clasificacion();
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		if (this.GUIABMMuestra.getJButtonAgregar() == source){
	   		try {
	   			System.out.println("Button Agregar Muestra");
				MediadorAltaMuestra altaMuestra = new MediadorAltaMuestra("Ingresar Muestra");	
				if (altaMuestra.esAltaMuestra()){  
					this.GUIABMMuestra.getTablePanel().addRow(altaMuestra.getData());
	     		}
	   		} catch (Exception e) {
				e.printStackTrace();
			}
	   		
	   	}
		if (this.GUIABMMuestra.getJButtonEliminar() == source){
			if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
			    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta Seguro de eliminar la fila?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	            if(quitOption==JOptionPane.YES_OPTION){
	            	try{
	            		System.out.println(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	
	            	String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	GUIABMMuestra.getTablePanel().removeRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	Muestra mu = new Muestra((fila[1]),Integer.parseInt(fila[2]),Float.parseFloat(fila[3]),Float.parseFloat(fila[4]),op,usuario,ubicacion,clasificacion,fecha);
	               	try {
	               		control.eliminarMuestra(mu);
	               	} catch (Exception e) {
						e.printStackTrace();
	               	}
	            	}
	            	catch (Exception e) {
	            		JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
	            	}
	            }
			}
		}
		if (this.GUIABMMuestra.getJButtonModificar() == source){
			if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
					String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
					GUIABMMuestra.getTablePanel().removeRow(GUIABMMuestra.getTablePanel().getSelectedRow());
					try {
						MediadorModificarMuestra modificarMuestra = new MediadorModificarMuestra(fila);
						System.out.println("antees de meter en panel");
						this.GUIABMMuestra.getTablePanel().addRow(modificarMuestra.getData());
						System.out.println("dfespues de meter en panel");
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(frame,"Se ha seleccionado una muestra invalida","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
					}
					}
				}
			if (this.GUIABMMuestra.getJButtonSalir() == source){
				System.out.println("presionado boton salir");
				GUIABMMuestra.dispose();
			}
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIABMMuestra.getTablePanel() == source)
			System.out.println("GestionarMediador.actionPerformed() jJTableTabla");
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	/**
	 * @returns data 
	*/
	

	public void itemStateChanged(ItemEvent e) {
	}

}
