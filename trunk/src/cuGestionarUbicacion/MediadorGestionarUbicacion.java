package cuGestionarUbicacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Ubicacion;

import comun.Mediador;
import comun.MediadorVersion;

import cuGestionarMuestra.ControlGestionarMuestra;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana GestionarUbicacion.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class MediadorGestionarUbicacion extends Mediador{

	private GUIGestionarUbicacion GUIGestionarUbicacion = null;
	private Object [][] data;
	private String [] seleccionado = new String[4];
	private boolean selecciono=false;
	private boolean seleccionar;
	private Component frame;
	
	
	/**
	 * Constructor con pasaje de parametros.
	 * @throws Exception
	 */
	public MediadorGestionarUbicacion(boolean seleccionar,boolean eliminar) throws Exception {
		super();
		cargarTablaDeMuestras();
		this.seleccionar=seleccionar;
		GUIGestionarUbicacion = new GUIGestionarUbicacion(data);
		GUIGestionarUbicacion.setTitle("Gestionar Ubicacion");
		GUIGestionarUbicacion.setModal(true);
		GUIGestionarUbicacion.getjButtonSeleccionar().setEnabled(seleccionar);
		GUIGestionarUbicacion.getjMenuSeleccionar().setEnabled(seleccionar);
		GUIGestionarUbicacion.getjMenuEliminar().setEnabled(eliminar);
		GUIGestionarUbicacion.getjButtonEliminar().setEnabled(eliminar);
		GUIGestionarUbicacion.setListenerButtons(this);
		GUIGestionarUbicacion.setListenerTable(this);
		GUIGestionarUbicacion.setLocationRelativeTo(null);
		GUIGestionarUbicacion.setMouseListener(this);
		GUIGestionarUbicacion.setKeyListener(this);
		GUIGestionarUbicacion.show();
	}
	
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Ubicacion ubicacion = new Ubicacion();
		Class clase = ubicacion.getClass();
		Collection ubicaciones = control.coleccionMuestras(clase);
		Iterator<Ubicacion> it = ubicaciones.iterator();
		int i = 0;
		data = new Object [ubicaciones.size()] [5];
		while (it.hasNext()){
			ubicacion = it.next();
			data [i][0]= ubicacion.getNombreUbicacion();
			data [i][1]= ubicacion.getCiudad();
			data [i][2]= ubicacion.getProvincia();
		    data [i][3]= ubicacion.getLatitud();		        
		    data [i][4]= ubicacion.getLongitud();
		    i++;
		}
	}
	/**
	 * @return the gUISeleccionarUbicacion
	 */
	public GUIGestionarUbicacion getGUISeleccionarUbicacion() {
		return GUIGestionarUbicacion;
	}
	
	/**
	 * @param gUISeleccionarMuestra the gUISeleccionarMuestra to set
	 */
	public void setGUIGestionarMuestra(GUIGestionarUbicacion gUISeleccionarUbicacion) {
		GUIGestionarUbicacion = gUISeleccionarUbicacion;
	}

		
	/**
	 * retorna la ubicacion seleccionada.
	 * @return ubicacion
	 */
	public Ubicacion getSeleccionado() {
		Ubicacion ubicacion= new Ubicacion(seleccionado[0],seleccionado[1],seleccionado[2],seleccionado[3],seleccionado[4]);
		return ubicacion;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (GUIGestionarUbicacion.getjButtonEliminar() == source || GUIGestionarUbicacion.getjMenuEliminar() == source ){
			eliminar();
		}
		if (GUIGestionarUbicacion.getjButtonSeleccionar() == source || GUIGestionarUbicacion.getjMenuSeleccionar() == source){
			seleccionar();
		}
		if (GUIGestionarUbicacion.getjButtonModificar() == source || GUIGestionarUbicacion.getjMenuModificar() == source){
			modificar();
		}
		
		if (GUIGestionarUbicacion.getjButtonAgregar() == source || GUIGestionarUbicacion.getjMenuAgregar() == source){
			MediadorAltaUbicacion altaUbicacion = new MediadorAltaUbicacion();
			if (altaUbicacion.esAltaUbicacion()){  
				this.GUIGestionarUbicacion.getTablePanel().addRow(altaUbicacion.getData());
     		}
			
		}
		if (GUIGestionarUbicacion.getJButtonSalir() == source || GUIGestionarUbicacion.getjMenuSalir() == source){
			GUIGestionarUbicacion.dispose();
		}
		if (GUIGestionarUbicacion.getjMenuVersion()==source){
			new MediadorVersion();
		}
	}
	
	public void show(){
		GUIGestionarUbicacion.show();
	}
	
	public void modificar(){
		if (GUIGestionarUbicacion.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ninguna ubicación.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				System.out.println("Button Modificar Ubicacion");
				MediadorModificarUbicacion modificarUbicacion = new MediadorModificarUbicacion(GUIGestionarUbicacion.getTablePanel().getRow(GUIGestionarUbicacion.getTablePanel().getSelectedRow()));
				if (modificarUbicacion.seModificoUbicacion()) {
					GUIGestionarUbicacion.getTablePanel().removeRow(GUIGestionarUbicacion.getTablePanel().getSelectedRow());
					GUIGestionarUbicacion.getTablePanel().addRow(modificarUbicacion.getData());
				}
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado una ubicación inválida","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public void seleccionar(){
		if (GUIGestionarUbicacion.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ninguna ubicación.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			try{
				System.out.println("Button Seleccionar Ubicacion");
				seleccionado = GUIGestionarUbicacion.getTablePanel().getRow(GUIGestionarUbicacion.getTablePanel().getSelectedRow());
				selecciono = true;
				GUIGestionarUbicacion.dispose();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado una ubicación inválida","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Muestra"
	 */
	public void eliminar(){
		if (GUIGestionarUbicacion.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro de eliminar la Ubicación? Recuerde que se borrarán todas las muestras asociadas.","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		    ControlGestionarUbicacion control = new ControlGestionarUbicacion(); 
            if(quitOption==JOptionPane.YES_OPTION){
            	try{
            		String [] fila = GUIGestionarUbicacion.getTablePanel().getRow(GUIGestionarUbicacion.getTablePanel().getSelectedRow());
	            	GUIGestionarUbicacion.getTablePanel().removeRow(GUIGestionarUbicacion.getTablePanel().getSelectedRow());
	            	String nombreUbicacion = fila[0];
	            	String ciudad = fila[1];
	               	try {
	               		control.eliminarUbicacion(nombreUbicacion,ciudad);
	               	} catch (Exception e) {
						e.printStackTrace();
	               	}
            	}
            	catch (Exception e) {
            		JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
            	}
            }
		}
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2){
			if (seleccionar) {
				seleccionar();
			}
			else{
				modificar();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER){
        	if (seleccionar) {
				seleccionar();
			}
			else{
				modificar();
			}
        }
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


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		if (GUIGestionarUbicacion.getjTextFieldBuscar().getText().length()==25){ 
			arg0.consume(); 
		}
	}
	
	/**
	 * @return the selecciono
	 */
	public boolean seSelecciono() {
		return selecciono;
	}
}