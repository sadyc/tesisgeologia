package cuGestionarUsuario;

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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Usuario;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana para gestionar un Usuario.
 * 
 * @author TesisGeologia
 * @version 1.0
 *
 */
public class MediadorGestionarUsuario implements ActionListener, KeyListener, MouseListener{
		
	private GUIGestionarUsuario GUIGestionarUsuario;
	private Object [][] data ;
	private Component frame;
	private ControlGestionarUsuario control = new ControlGestionarUsuario();

		
	
	/**
	 * Constructor con pasaje de parametros.
	 * @param nombreVentana
	 * @throws Exception
	 */
	public MediadorGestionarUsuario(String nombreVentana) throws Exception {
		super();
		cargarTablaDeMuestras();
		GUIGestionarUsuario = new GUIGestionarUsuario(data);
		GUIGestionarUsuario.setTitle("Gestionar Usuario");
		GUIGestionarUsuario.setListenerButtons(this);
		GUIGestionarUsuario.setListenerTable(this);
		GUIGestionarUsuario.setMouseListener(this);
		GUIGestionarUsuario.setKeyListener(this);     
		GUIGestionarUsuario.setModal(true);
		GUIGestionarUsuario.setLocationRelativeTo(null);
		GUIGestionarUsuario.show();
	}
	
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarUsuario control = new ControlGestionarUsuario();
		Usuario usuario = new Usuario();
		Class clase = usuario.getClass();
		Collection<Usuario> usuarios = control.coleccionUsuarios(clase);
		Iterator<Usuario> it = usuarios.iterator();
		data = new Object [usuarios.size()] [7];
		int i = 0;
		while (it.hasNext()){
			usuario = it.next();
			data [i][0]= usuario.getNombre();
			data [i][1]= usuario.getApellido();
			data [i][2]= usuario.getDni();
		    data [i][3]= usuario.getNombreUsuario();
		    data [i][4]= usuario.getCategoria();
		    data [i][5]= usuario.getEmail();
		    data [i][6]= usuario.getTel();
		    i++;
		}
	}
				
	public void show()	{
		 GUIGestionarUsuario.show();
	}
	

	public GUIGestionarUsuario getGestionarUsuario() {
		return GUIGestionarUsuario;
	}
	
	public void setGestionarMuestra(GUIGestionarUsuario gestionarUsuario) {
		this.GUIGestionarUsuario = gestionarUsuario;
	}
	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIGestionarUsuario.getjButtonAgregar() == source||GUIGestionarUsuario.getjMenuAgregar()==source){
			agregarUsuario();
	   	}
		if (this.GUIGestionarUsuario.getjButtonEliminar() == source||GUIGestionarUsuario.getjMenuEliminar()==source){
			eliminarUsuario();
		}
		if (this.GUIGestionarUsuario.getjButtonModificar() == source||GUIGestionarUsuario.getjMenuModificar()==source){
			modificarUsuario();
		}
		if (this.GUIGestionarUsuario.getjButtonSalir() == source || GUIGestionarUsuario.getjMenuSalir()==source){
			GUIGestionarUsuario.dispose();
		}
	}
	
		
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Modificar Usuario"
	 */
	public void modificarUsuario(){
		if (GUIGestionarUsuario.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = GUIGestionarUsuario.getTablePanel().getRow(GUIGestionarUsuario.getTablePanel().getSelectedRow());
			MediadorVerificarPassword verif = new MediadorVerificarPassword(fila[2],fila[3]);
			if (verif.getCorrecto()){
				try {
					MediadorModificarUsuario modificarUsuario = new MediadorModificarUsuario(fila);
				if (modificarUsuario.seModificoUsuario()) {
					GUIGestionarUsuario.getTablePanel().removeRow(GUIGestionarUsuario.getTablePanel().getSelectedRow());
					this.GUIGestionarUsuario.getTablePanel().addRow(modificarUsuario.getData());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Eliminar Usuario"
	 */
	public void eliminarUsuario(){
		if (GUIGestionarUsuario.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta seguro de eliminar este usuario?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	        if(quitOption==JOptionPane.YES_OPTION){
	        	try{
	        		String [] fila = GUIGestionarUsuario.getTablePanel().getRow(GUIGestionarUsuario.getTablePanel().getSelectedRow());
	            	GUIGestionarUsuario.getTablePanel().removeRow(GUIGestionarUsuario.getTablePanel().getSelectedRow());
	            	String dni = fila[2];
	               	try {
	               		control.eliminarUsuario(dni);
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
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Usuario"
	 */
	public void agregarUsuario(){
		try {
				System.out.println("Button Agregar Usuario");
			MediadorAltaUsuario altaUsuario = new MediadorAltaUsuario("Ingresar Usuario");	
			if (altaUsuario.esAltaUsuario()){  
				this.GUIGestionarUsuario.getTablePanel().addRow(altaUsuario.getData());
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
			modificarUsuario();
		}
	}
	
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == e.VK_ENTER)
	    	modificarUsuario();
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
