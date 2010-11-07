package cuGestionarMuestra;

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

	private GUIABMMuestra GUIABMMuestra = null;
	private Object [][] data = new Object [4] [5];
	private Component frame;
	
	
	public MediadorGestionarMuestra(String nombreVentana) throws Exception {
		super();
		//cargarTablaDeMuestras();
		this.GUIABMMuestra = new GUIABMMuestra(nombreVentana,data);
		GUIABMMuestra.show();
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
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
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getNombreMuestra();
		    data [i][1]= muestra.getPeso();		        
		    data [i][2]= muestra.getProfundidadInicial();
		    data [i][3]= muestra.getProfundidadFinal();
		    data [i][4]= muestra.getOperador().getDni();
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
		Muestra muestra= new Muestra();
		OperadorDeLaboratorio op = new OperadorDeLaboratorio("asd","asd","12","4665458","asd@gmail.com");
 		Ubicacion ubicacion = new Ubicacion();
 		Usuario usuario = new Usuario();
 		Clasificacion clasificacion = new Clasificacion();
		ControlGestionarMuestra control = new ControlGestionarMuestra();
	   	if (this.GUIABMMuestra.getJButtonAgregar() == source){
	   		try {
	   			System.out.println("Button Agregar Muestra");
				MediadorAltaMuestra altaMuestra = new MediadorAltaMuestra("Ingresar Muestra");	
				if (altaMuestra.getData()[0] != null){  
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
	            	String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	GUIABMMuestra.getTablePanel().removeRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	Muestra mu = new Muestra ();
	            	try {
						//control.eliminarMuestra(mu);
					} catch (Exception e) {
						System.out.println("Error al eliminar");
					}
	            }
			}
		}
		if (this.GUIABMMuestra.getJButtonModificar() == source){
			if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());//
				//Muestra mu = new Muestra((fila[0]),Integer.parseInt(fila[1]),Float.parseFloat(fila[2]),Float.parseFloat(fila[3]),op,usuario,ubicacion,clasificacion);
				//muestra = new Muestra (fila[0],Integer.parseInt()[0],fila[0],fila[0],fila[0],fila[0],fila[0],fila[0],fila[0]);
				
				try {
					MediadorModificarMuestra modificarMuestra = new MediadorModificarMuestra(fila);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//GUIMuestra guiMuestra = new GUIMuestra("nombre de ventana",muestra2);

				
				//if (guiMuestra.getData()[0] != null){  
					
					//ModificarMuestraBD(modificarMuestra);				

				//}	
			}
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
