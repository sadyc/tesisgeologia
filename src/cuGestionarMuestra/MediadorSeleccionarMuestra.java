package cuGestionarMuestra;

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

import persistencia.domain.Muestra;
import cuBuscar.MediadorBuscar;
import cuCompararMuestra.GUISeleccionarMuestra;
import cuGestionarAnalisis.ControlGestionarAnalisis;


/**
* @author TesisGeolog�a
* 
*/

public class MediadorSeleccionarMuestra implements ActionListener, KeyListener, MouseListener {

	private GUIABMMuestra GUIABMMuestra = null;
	private GUISeleccionarMuestra GUISeleccionarMuestra = null;
	private Object [] seleccionado = new Object [4];
	private Object [][] data;
	private boolean seleccionoMuestra = false;
	private Component frame;
	
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorSeleccionarMuestra() throws Exception {
		super();
		cargarTablaDeMuestras();
		String [] columAux = {"Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final"};
		this.GUIABMMuestra = new GUIABMMuestra("Seleccionar una muestra",data,columAux);
		this.GUIABMMuestra.setListenerButtons(this);
		this.GUIABMMuestra.setListenerTable(this);
		this.GUIABMMuestra.setMouseListener(this);
		this.GUIABMMuestra.setKeyListener(this);     
		GUIABMMuestra.getJButtonAgregar().setEnabled(false);
		GUIABMMuestra.getAgregarMenu().setEnabled(false);
		GUIABMMuestra.getJButtonEliminar().setEnabled(false);
		GUIABMMuestra.getEliminarMenu().setEnabled(false);
		GUIABMMuestra.getJButtonModificar().setEnabled(false);
		GUIABMMuestra.getModificarMenu().setEnabled(false);
		GUIABMMuestra.setModal(true);
		GUIABMMuestra.show();
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
		data = new Object [muestras.size()] [5];
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
		if (this.GUIABMMuestra.getJButtonSeleccionar() == source || GUIABMMuestra.getSeleccionarMenu()==source){
				seleccionarMuestra();
			
		}
		if (this.GUIABMMuestra.getBuscarMenu() == source || this.GUIABMMuestra.getJButtonBuscar() == source){
			buscarMuestra();
		}
		if (this.GUIABMMuestra.getJButtonCancelar() == source || GUIABMMuestra.getCancelarMenu()==source){
			GUIABMMuestra.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Muestra"
	 */
	public void seleccionarMuestra(){
		if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ning�n elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			System.out.println("Button Seleccionar Muestra");
			try {
				seleccionado = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
				seleccionoMuestra = true;
				GUIABMMuestra.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inv�lido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
   				   		
		}
	}
	
	private void cargarTablaDeMuestras(Collection resultado) {
		data = new Object [resultado.size()] [6];
		int i = 0;
		Muestra muestra = new Muestra();
		Iterator<Muestra> it = resultado.iterator();
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
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar Muestra"
	 */
	public void buscarMuestra(){
		try {
   			System.out.println("Button Buscar Muestra");
   			MediadorBuscar buscar = new MediadorBuscar();
   			if (buscar.seEncontro()){
   				GUIABMMuestra.dispose();
   				cargarTablaDeMuestras(buscar.getResultado());
   				String [] columAux = {"Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final"};
   				GUIABMMuestra = new GUIABMMuestra("Gestionar Muestra", data, columAux);
   				GUIABMMuestra.setListenerButtons(this);
   				GUIABMMuestra.setListenerTable(this);
   				GUIABMMuestra.getJButtonAgregar().setEnabled(false);
   				GUIABMMuestra.getAgregarMenu().setEnabled(false);
   				GUIABMMuestra.getJButtonEliminar().setEnabled(false);
   				GUIABMMuestra.getEliminarMenu().setEnabled(false);
   				GUIABMMuestra.getJButtonModificar().setEnabled(false);
   				GUIABMMuestra.getModificarMenu().setEnabled(false);
   				GUIABMMuestra.getJButtonSeleccionar().setEnabled(true);
   				GUIABMMuestra.getSeleccionarMenu().setEnabled(true);
   				GUIABMMuestra.setModal(true);
   				GUIABMMuestra.show();
   			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * @return the seleccionado
	 * @throws Exception 
	 */
	public Muestra getSeleccionado() throws Exception {
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = (control.obtenerMuestra((String)seleccionado[1],(String)seleccionado[0]));
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