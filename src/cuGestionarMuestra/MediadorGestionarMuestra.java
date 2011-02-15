package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Muestra;
import persistencia.domain.Usuario;

import comun.Mediador;

import cuBuscar.MediadorBuscar;
import cuGestionarAnalisis.MediadorGestionarAnalisis;



/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de GestionarMuestra
 * @author TesisGeologia
 */
public class MediadorGestionarMuestra extends Mediador{

	private GUIABMMuestra GUIABMMuestra;
	private Object [][] data ;
	private Component frame;
	private Muestra muestra;
	private Usuario usuario;
	private ControlGestionarMuestra control = new ControlGestionarMuestra();
	private Object [] seleccionado = new Object [4];
	private boolean seleccionoMuestra = false;
		
	
	public MediadorGestionarMuestra(String nombreVentana, Usuario usuario) throws Exception {
		super();
		this.usuario=usuario;
		cargarTablaDeMuestras();
		String [] columAux = {"Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final","Operador de Laboratorio","Cliente"};
		GUIABMMuestra = new GUIABMMuestra(nombreVentana,data,columAux);
		GUIABMMuestra.setListenerButtons(this);
		GUIABMMuestra.setListenerTable(this);
		GUIABMMuestra.setMouseListener(this);
		GUIABMMuestra.setKeyListener(this);     
		GUIABMMuestra.getJButtonSeleccionar().setEnabled(true);
		GUIABMMuestra.getSeleccionarMenu().setEnabled(false);
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
		Collection<Muestra> muestras = control.coleccionMuestras(clase);
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
		    data [i][6]= muestra.getCliente().getNombre()+" "+muestra.getCliente().getApellido();
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
		if (this.GUIABMMuestra.getJButtonAgregar() == source||GUIABMMuestra.getAgregarMenu()==source){
			agregarMuestra();
	   	}
		if (this.GUIABMMuestra.getJButtonEliminar() == source||GUIABMMuestra.getEliminarMenu()==source){
			eliminarMuestra();
		}
		if (this.GUIABMMuestra.getJButtonModificar() == source||GUIABMMuestra.getModificarMenu()==source){
			modificarMuestra();
		}

		if (this.GUIABMMuestra.getBuscarMenu() == source || this.GUIABMMuestra.getJButtonBuscar() == source){
			buscarMuestra();
			
		}
		if (this.GUIABMMuestra.getJButtonSeleccionar() == source || this.GUIABMMuestra.getSeleccionarMenu() == source){
			if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ninguna muestra","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}else{
			seleccionarMuestra();
			analisis();
			}
		}
		if (this.GUIABMMuestra.getJButtonCancelar() == source || GUIABMMuestra.getCancelarMenu()==source){

			GUIABMMuestra.dispose();
		}
	}
	
	private void analisis() {
		GUIABMMuestra.dispose();
		try {
			new MediadorGestionarAnalisis("Gestionar Analisis",muestra);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Muestra"
	 */
	public void seleccionarMuestra(){
			System.out.println("Button Seleccionar Muestra");
			try {
				seleccionado = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
				seleccionoMuestra = true;
				muestra = control.obtenerMuestra((String)seleccionado[1], (String)seleccionado[0]);
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
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
   				GUIABMMuestra.getJButtonSeleccionar().setEnabled(false);
   				GUIABMMuestra.getSeleccionarMenu().setEnabled(false);
   				GUIABMMuestra.setModal(true);
   				GUIABMMuestra.show();
   			}
		} catch (Exception e) {

			e.printStackTrace();
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
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Muestra"
	 */
	public void modificarMuestra(){
		if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
			try {
				MediadorModificarMuestra modificarMuestra = new MediadorModificarMuestra(fila, usuario);
				if (modificarMuestra.seModificoMuestra()) {
					GUIABMMuestra.getTablePanel().removeRow(GUIABMMuestra.getTablePanel().getSelectedRow());
					this.GUIABMMuestra.getTablePanel().addRow(modificarMuestra.getData());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Muestra"
	 */
	public void eliminarMuestra(){
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
	            	String ubicacion = fila[0];
	            	String nombreMuestra = fila[1];
	               	try {
	               		control.eliminarMuestra(nombreMuestra,ubicacion);
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
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Muestra"
	 */
	public void agregarMuestra(){
		try {
   			System.out.println("Button Agregar Muestra");
			MediadorAltaMuestra altaMuestra = new MediadorAltaMuestra("Ingresar Muestra",usuario);	
			if (altaMuestra.esAltaMuestra()){  
				this.GUIABMMuestra.getTablePanel().addRow(altaMuestra.getData());
     		}
   		} catch (Exception e) {
			e.printStackTrace();
		}
   		
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2){
			seleccionarMuestra();
			analisis();
		}
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
		// TODO Auto-generated method stub
		
	}

}
