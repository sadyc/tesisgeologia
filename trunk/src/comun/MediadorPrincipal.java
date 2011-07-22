package comun;


import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Muestra;
import persistencia.domain.Usuario;
import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuCompararMuestra.MediadorCompararMuestra;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarCliente.MediadorGestionarCliente;
import cuGestionarMuestra.MediadorGestionarMuestra;
import cuGestionarMuestra.MediadorSeleccionarMuestra;
import cuGestionarOperador.MediadorGestionarOperador;
import cuGestionarUbicacion.MediadorGestionarUbicacion;
import cuGestionarUsuario.MediadorGestionarUsuario;
import cuLimiteConsistencia.MediadorConsistencia;
import cuLogin.MediadorLogin;
/**
 * @brief Clase que se utiliza para escuchar los eventos que suceden en la ventana Principal.
 * @author TesisGeologia
 * @version 1.0
 */
public class MediadorPrincipal extends Mediador{

	private GUIPrincipal GUIPrincipal = null;
	private Usuario usuario;
	private Backup backup;
		
	/**
	 * Constructor parametrizado de la clase.
	 * @param nombreVentana, Título de la ventana.
	 * @param usuario, Usuario que inició sesión en el sistema.
	 */
	@SuppressWarnings("deprecation")
	public MediadorPrincipal(String nombreVentana, Usuario usuario) throws Exception {
		super();
		this.backup=new Backup();	    
		this.usuario = usuario;
		this.GUIPrincipal = new GUIPrincipal(nombreVentana);
		this.GUIPrincipal.setListenerButtons(this);
		if (usuario.getCategoria().compareTo("Operador") == 0){
			GUIPrincipal.getJButtonGestionarUsuario().setEnabled(false);
			GUIPrincipal.getGestionarUsuarioMenu().setEnabled(false);
			GUIPrincipal.getCrearBackupMenu().setEnabled(false);
			GUIPrincipal.getCargarBackupMenu().setEnabled(false);
		}else{
			if(usuario.getCategoria().compareTo("Restringido") == 0){
				GUIPrincipal.getJButtonGestionarMuestra().setEnabled(false);
				GUIPrincipal.getJButtonAnalisis().setEnabled(false);
				GUIPrincipal.getJButtonGestionarLimiteConsistencia().setEnabled(false);
				GUIPrincipal.getJButtonGestionarUsuario().setEnabled(false);
				GUIPrincipal.getJButtonClasificacion().setEnabled(false);
				GUIPrincipal.getjButtonGestionarOperador().setEnabled(false);
				GUIPrincipal.getjButtonGestionarCliente().setEnabled(false);
				GUIPrincipal.getGestionarAnalisisMenu().setEnabled(false);
				GUIPrincipal.getGestionarClienteMenu().setEnabled(false);
				GUIPrincipal.getGestionarLimiteConsistenciaMenu().setEnabled(false);
				GUIPrincipal.getGestionarMuestraMenu().setEnabled(false);
				GUIPrincipal.getGestionarOperadorMenu().setEnabled(false);
				GUIPrincipal.getGestionarUsuarioMenu().setEnabled(false);
				GUIPrincipal.getCalcularClasificacionMenu().setEnabled(false);
				GUIPrincipal.getCrearBackupMenu().setEnabled(false);
				GUIPrincipal.getCargarBackupMenu().setEnabled(false);
				GUIPrincipal.getjButtonGestionarUbicacion().setEnabled(false);
				GUIPrincipal.getGestionarUbicacionMenu().setEnabled(false);
			}
		}
		GUIPrincipal.show();
		
	}
	/**
	 * Método que permite visualizar la ventana.
	 */
	@SuppressWarnings("deprecation")
	public void show(){
		GUIPrincipal.show();
	}

	/**
	 * @return the gUIPrincipal
	 */
	public GUIPrincipal getGUIPrincipal() {
		return GUIPrincipal;
	}

	/**
	 * @param gUIPrincipal the gUIPrincipal to set
	 */
	public void setGUIPrincipal(GUIPrincipal gUIPrincipal) {
		GUIPrincipal = gUIPrincipal;
	}
	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * para tratar los eventos de acciones de los componentes. 
	 * @throws Exception
	 */
	public void actionPerformed(ActionEvent arg0){
		Object source = arg0.getSource();
		if (this.GUIPrincipal.getJButtonGestionarMuestra() == source || this.GUIPrincipal.getGestionarMuestraMenu()== source){
			gestionarMuestra();
		}
		if (this.GUIPrincipal.getJButtonAnalisis() == source || this.GUIPrincipal.getGestionarAnalisisMenu()== source){
			gestionarAnalisis();
			}
		if (this.GUIPrincipal.getJButtonClasificacion() == source || this.GUIPrincipal.getCalcularClasificacionMenu()== source){
			calcularClasificacion();
		}
		if (this.GUIPrincipal.getJButtonGestionarUsuario() == source || this.GUIPrincipal.getGestionarUsuarioMenu()== source){
			gestionarUsuario();
     	}
		if (this.GUIPrincipal.getjButtonGestionarOperador() == source || this.GUIPrincipal.getGestionarOperadorMenu()== source){
			gestionarOperador();
     	}
		if (this.GUIPrincipal.getjButtonGestionarCliente() == source || this.GUIPrincipal.getGestionarClienteMenu()== source){
			gestionarCliente();
     	}
		if (this.GUIPrincipal.getJButtonCompararMuestras() == source || this.GUIPrincipal.getCompararMuestrasMenu()== source){
			compararMuestras();
     	}
		if (this.GUIPrincipal.getJButtonGestionarLimiteConsistencia() == source || this.GUIPrincipal.getGestionarLimiteConsistenciaMenu()== source){
			gestionarLimiteConsistencia();
		}
		if (this.GUIPrincipal.getJButtonSalir() == source || this.GUIPrincipal.getSalirMenu()== source){
			 int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro que desea salir?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		        if(quitOption==JOptionPane.YES_OPTION){
		        	GUIPrincipal.dispose();
		          	System.exit(0);
		        }
		}
		if (this.GUIPrincipal.getCerrarSesionMenu()==source){
			 int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro que desea cerrar la sesión de '"+ usuario.getNombreUsuario()+"'?","Cerrar sesión",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		        if(quitOption==JOptionPane.YES_OPTION){
		        	GUIPrincipal.dispose();
		        	new MediadorLogin();
		        }
		}
		if (this.GUIPrincipal.getCrearBackupMenu()==source){
			backup.elegirDirectorio();
		}
		if (this.GUIPrincipal.getCargarBackupMenu()==source){
			backup.cargarBackup();
		}
		if (this.GUIPrincipal.getjButtonGestionarUbicacion()==source || this.GUIPrincipal.getGestionarUbicacionMenu()==source){
			gestionarUbicacion();
		}

		if(this.GUIPrincipal.getVersionMenu() == source){
			new MediadorVersion();
		}

	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Ubicacion"
	 */
	private void gestionarUbicacion() {
		try {
			new MediadorGestionarUbicacion(false,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Cliente"
	 */
	public void gestionarCliente(){
		try {
			new MediadorGestionarCliente(false,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Operador"
	 */
	public void gestionarOperador(){
		try {
			new MediadorGestionarOperador(false,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Muestra"
	 */
	public void gestionarMuestra(){
		try {
			new MediadorGestionarMuestra("Gestionar Muestra",usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarMuestra"); 
	}
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Analisis"
	 */
	public void gestionarAnalisis(){
		try {
			MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra();
			if (seleccion.seSeleccionoMuestra()){
				new MediadorGestionarAnalisis("Analisis de la muestra "+seleccion.getSeleccionado().getNombreMuestra(), seleccion.getSeleccionado(),true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarAnalisis");
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Calcular Clasificacion"
	 */
	public void calcularClasificacion(){
		try {
			MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
			if (seleccionarMuestra.seSeleccionoMuestra()){
				new MediadorCalcularClasificacion("Clasificacion de la muestra "+seleccionarMuestra.getSeleccionado().getNombreMuestra(),seleccionarMuestra.getSeleccionado());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Listar Muestras"
	 */
	private void gestionarUsuario() {
		try {
			new MediadorGestionarUsuario("Ingresar Usuario");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarUsuario"); 
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Comparar Muestras"
	 */
	public void compararMuestras(){
		try {
			MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
			if (seleccionarMuestra.seSeleccionoMuestra()){
				Muestra muestra1 = seleccionarMuestra.getSeleccionado();
				seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					Muestra muestra2 = seleccionarMuestra.getSeleccionado();
					new MediadorCompararMuestra("Comparacion de Muestras",muestra1,muestra2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonCompararMuestra"); 
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Limites Consistencia"
	 */
	public void gestionarLimiteConsistencia(){
		try {
			new MediadorConsistencia();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
	}

	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
	
}
