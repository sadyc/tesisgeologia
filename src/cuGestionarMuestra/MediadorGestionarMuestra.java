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
import comun.MediadorVersion;

import cuGestionarAnalisis.MediadorGestionarAnalisis;



/**
 * @brief Clase que se utiliza para escuchar los eventos que suceden en la ventana de GestionarMuestra
 * @author TesisGeologia
 * @version 1.0.
 */
public class MediadorGestionarMuestra extends Mediador{

	private GUIABMMuestra GUIABMMuestra;
	private Object [][] data ;
	private Component frame;
	private Muestra muestra;
	private Usuario usuario;
	private ControlGestionarMuestra control = new ControlGestionarMuestra();
	private Object [] seleccionado = new Object [10];
	
	/**
	 * Constructor parametrizado de la clase.
	 * @param nombreVentana, Título de la ventana.
	 * @param usuario, Usuario que inició sesión en el sistema.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public MediadorGestionarMuestra(String nombreVentana, Usuario usuario) throws Exception {
		super();
		this.usuario=usuario;
		cargarTablaDeMuestras();

		String [] columAux = {"Ubicación","Nombre","Peso","Profundidad Inicial","Profundidad Final","Operador de Laboratorio","Cliente","Ciudad","Usuario"};

		GUIABMMuestra = new GUIABMMuestra(nombreVentana,data,columAux);
		GUIABMMuestra.setListenerButtons(this);
		GUIABMMuestra.setListenerTable(this);
		GUIABMMuestra.setMouseListener(this);
		GUIABMMuestra.setKeyListener(this);    
		GUIABMMuestra.setLocationRelativeTo(null);
		GUIABMMuestra.getJButtonSeleccionar().setEnabled(true);
		GUIABMMuestra.setModal(true);
		GUIABMMuestra.show();
		
	}
	
	
	/**
	 * Levanta informaci�n almacenada en la base de datos y los copia sobre el atributo data de la clase mediador.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		    if (muestra.getCliente()!=null){
		    	data [i][6]= muestra.getCliente().getNombre()+" "+muestra.getCliente().getApellido();
		    }
		    data [i][7]= muestra.getUbicacion().getCiudad();
		    data [i][8]= muestra.getUsuario().getNombre() + " " + muestra.getUsuario().getApellido();
		    i++;
		}
	}

	/**
	 * M�todo que me permite visualizar la ventana.
	 */
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
	 * M�todo que se necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIABMMuestra.getJButtonAgregar() == source||GUIABMMuestra.getjMenuAgregar()==source){
			agregarMuestra();
	   	}
		if (this.GUIABMMuestra.getJButtonEliminar() == source||GUIABMMuestra.getjMenuEliminar()==source){
			eliminarMuestra();
		}
		if (this.GUIABMMuestra.getJButtonModificar() == source||GUIABMMuestra.getjMenuModificar()==source){
			modificarMuestra();
		}

		if (this.GUIABMMuestra.getJButtonSeleccionar() == source || this.GUIABMMuestra.getjMenuSeleccionar() == source){
			if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){

				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ninguna muestra","Atención!", JOptionPane.WARNING_MESSAGE);

			}else{
				seleccionarMuestra();
				analisis();
			}
		}
		if (this.GUIABMMuestra.getjButtonSalir() == source || GUIABMMuestra.getjMenuSalir()==source){
			GUIABMMuestra.dispose();
		}
		if (GUIABMMuestra.getjMenuVersion()==source){
			new MediadorVersion();
		}
	}
	
	/**
	 * Acciones a realizar cuando se ha seleccionado una Muestra"
	 */
	private void analisis() {
		GUIABMMuestra.dispose();
		try {
			new MediadorGestionarAnalisis("Gestionar Análisis",muestra);
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
				muestra = control.obtenerMuestra((String)seleccionado[1], (String)seleccionado[0], (String)seleccionado[7]);
			} catch (Exception e) {

				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","Atención!", JOptionPane.ERROR_MESSAGE);

			}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opción de "Modificar Muestra"
	 */
	public void modificarMuestra(){
		if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){

			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","Atención!", JOptionPane.ERROR_MESSAGE);

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
	 * Acciones a realizar cuando se selecciona la opci�n de "Eliminar Muestra"
	 */
	public void eliminarMuestra(){
		if (GUIABMMuestra.getTablePanel().getSelectedRow() == -1){

			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","Atención!", JOptionPane.ERROR_MESSAGE);

		}
		else{

		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está Seguro de eliminar la fila?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

            if(quitOption==JOptionPane.YES_OPTION){
            	try{
            		String [] fila = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	GUIABMMuestra.getTablePanel().removeRow(GUIABMMuestra.getTablePanel().getSelectedRow());
	            	String ubicacion = fila[0];
	            	String nombreMuestra = fila[1];
	            	String ciudad = fila[7];
	               	try {
	               		control.eliminarMuestra(nombreMuestra,ubicacion,ciudad);
	               	} catch (Exception e) {
						e.printStackTrace();
	               	}
            	}
            	catch (Exception e) {

            		JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento inválido","Atención!", JOptionPane.ERROR_MESSAGE);

            	}
            }
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opci�n de "Agregar Muestra"
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
	 * Métodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2){
			seleccionarMuestra();
			analisis();
		}
	}
	
	/** 
	 * Metodo para escuchar el atajo del teclado.
	 * @see comun.Mediador#keyPressed(java.awt.event.KeyEvent)
	 */
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER){
        	seleccionarMuestra();
    		analisis();
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


	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
