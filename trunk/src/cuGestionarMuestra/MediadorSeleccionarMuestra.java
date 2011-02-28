package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Muestra;

import comun.Mediador;
import comun.MediadorVersion;


/**
 * Clase que se utiliza para escuchar los eventos al seleccionar una muesta.

* @author TesisGeología

* @version 1.0.
*/

public class MediadorSeleccionarMuestra extends Mediador{

	private GUIABMMuestra GUIABMMuestra;
	private Object [] seleccionado;
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
		String [] columAux = {"Ubicación","Nombre","Peso","Profundidad Inicial","Profundidad Final","Operador de Laboratorio","Cliente","Ciudad"};
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
		GUIABMMuestra.setLocationRelativeTo(null);
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
		data = new Object [muestras.size()] [10];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    data [i][5]= muestra.getOperadorLaboratorio().getNombre()+" "+muestra.getOperadorLaboratorio().getApellido();
		    if (muestra.getCliente()!=null){
		    	data [i][6]= muestra.getCliente().getNombre()+" "+muestra.getCliente().getApellido();
		    }
		    data [i][7]= muestra.getUbicacion().getCiudad();
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
		Muestra muestra = (control.obtenerMuestra((String)seleccionado[1],(String)seleccionado[0],(String)seleccionado[7]));
		return muestra;
	}
	
	/**
	 * @return the seleccionoMuestra
	 */
	public boolean seSeleccionoMuestra() {
		return seleccionoMuestra;
	}

	/**
	 * Métodos que necesita definir al implementar la interface MouseListener 
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