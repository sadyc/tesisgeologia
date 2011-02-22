package cuLimiteConsistencia;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import comun.MediadorVersion;

import persistencia.domain.Muestra;
import cuCompararMuestra.GUISeleccionarMuestra;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.GUIABMMuestra;


/**
* @author TesisGeología
* 
*/

public class MediadorConsistencia implements ActionListener, KeyListener, MouseListener {

	private GUIABMMuestra GUIABMMuestra = null;
	private GUISeleccionarMuestra GUISeleccionarMuestra = null;
	private Object [] seleccionado = new Object [10];
	private Object [][] data;
	private boolean seleccionoMuestra = false;
	private Component frame;
	
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorConsistencia() throws Exception {
		super();
		cargarTablaDeMuestras();
		String [] columAux = {"Ubicacion","Nombre","Peso","Ciudad","Profundidad Inicial","Profundidad Final","Límite Líquido","Límite Plástico","Índice de Plasticidad"};
		this.GUIABMMuestra = new GUIABMMuestra("Seleccionar una muestra",data,columAux);
		this.GUIABMMuestra.setListenerButtons(this);
		this.GUIABMMuestra.setListenerTable(this);
		this.GUIABMMuestra.setMouseListener(this);
		this.GUIABMMuestra.setKeyListener(this);     
		GUIABMMuestra.getJButtonAgregar().setEnabled(false);
		GUIABMMuestra.getjMenuAgregar().setEnabled(false);
		GUIABMMuestra.getJButtonEliminar().setEnabled(false);
		GUIABMMuestra.getjMenuEliminar().setEnabled(false);
		GUIABMMuestra.getJButtonModificar().setEnabled(false);
		GUIABMMuestra.getjMenuModificar().setEnabled(false);
		GUIABMMuestra.getJButtonSeleccionar().setEnabled(true);
		GUIABMMuestra.getjMenuSeleccionar().setEnabled(true);
		GUIABMMuestra.setModal(true);
		GUIABMMuestra.setLocationRelativeTo(null);
		GUIABMMuestra.show();
	}
	
	/**
	 * Metodo que contruye la ventana seleccionar Muestra con las muestras
	 * ya cargadas en una coleccion.
	 * @param coleccion
	 */
	public MediadorConsistencia(Collection coleccion) {
		super();
		Iterator<Muestra> it = coleccion.iterator();
		data = new Object [coleccion.size()] [10];
		int i = 0;
		while (it.hasNext()){
			Muestra muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
			data [i][3]= muestra.getUbicacion().getCiudad();
		    data [i][4]= muestra.getProfundidadInicial();
		    data [i][5]= muestra.getProfundidadFinal();
		    data [i][6]= muestra.getLimiteLiquido();
		    data [i][7]= muestra.getLimitePlastico();
		    data [i][8]= muestra.getIndicePlasticidad();
		    i++;
		}

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
		data = new Object [muestras.size()] [10];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
			data [i][3]= muestra.getUbicacion().getCiudad();
		    data [i][4]= muestra.getProfundidadInicial();
		    data [i][5]= muestra.getProfundidadFinal();
		    if (muestra.getLimiteLiquido()==null ||muestra.getLimitePlastico()==null||muestra.getIndicePlasticidad()==null ){
		    	data [i][8]= 0;
			    data [i][6]= 0;
			    data [i][7]= 0;
			    
		    }
		    else {
		    data [i][6]= muestra.getLimiteLiquido();
		    data [i][7]= muestra.getLimitePlastico();
		    data [i][8]= muestra.getIndicePlasticidad();
		    }
		    i++;
		}
	}
	
	/**
	 * @return the gUISeleccionarMuestra
	 */
	public GUIABMMuestra getGUISeleccionarMuestra() {
		return GUIABMMuestra;
	}

	/**
	 * @param gUISeleccionarMuestra the gUISeleccionarMuestra to set
	 */
	public void setGUISeleccionarMuestra(GUIABMMuestra gUISeleccionarMuestra) {
		GUIABMMuestra = gUISeleccionarMuestra;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIABMMuestra.getJButtonSeleccionar() == source || GUIABMMuestra.getjMenuSeleccionar()==source){
			seleccionarMuestra();
		}
		if (this.GUIABMMuestra.getjButtonSalir() == source || GUIABMMuestra.getjMenuSalir()==source){
			GUIABMMuestra.dispose();
		}
		if (GUIABMMuestra.getjMenuVersion()==source){
			MediadorVersion version = new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Muestra"
	 */
	public void seleccionarMuestra(){
		if (GUIABMMuestra.InicializarTabla().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			System.out.println("Button Seleccionar Muestra");
			try {
				seleccionado = GUIABMMuestra.InicializarTabla().getRow(GUIABMMuestra.InicializarTabla().getSelectedRow());
				seleccionoMuestra = true;
				GUIABMMuestra.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","Atención!", JOptionPane.ERROR_MESSAGE);
			}
   				   		
		}
	}
	/**
	 * @return the seleccionado
	 * @throws Exception 
	 */
	public Muestra getSeleccionado() throws Exception {
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = (control.obtenerMuestra((String)seleccionado[1],(String)seleccionado[0],(String)seleccionado[3]));
		return muestra;
	}
	
	/**
	 * @return the seleccionoMuestra
	 */
	public boolean seSeleccionoMuestra() {
		return seleccionoMuestra;
	}

	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
		
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			seleccionarMuestra();
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	seleccionarMuestra();
	}
	
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void itemStateChanged(ItemEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}