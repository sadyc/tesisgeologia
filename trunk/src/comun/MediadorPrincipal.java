package comun;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistencia.domain.Muestra;
import persistencia.domain.Usuario;
import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuCompararMuestra.MediadorCompararMuestra;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarCliente.MediadorGestionarCliente;
import cuGestionarMuestra.MediadorGestionarMuestra;
import cuGestionarMuestra.MediadorSeleccionarMuestra;
import cuGestionarOperador.MediadorGestionarOperador;
import cuGestionarUsuario.MediadorGestionarUsuario;
import cuLimiteConsistencia.MediadorAltaLimiteConsistencia;
import cuLimiteConsistencia.MediadorConsistencia;

public class MediadorPrincipal extends Mediador{

	private GUIPrincipal GUIPrincipal = null;
	private Component frame;
	private Usuario usuario;
	private java.sql.Date calendario;
	
	private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser FileChooser = new JFileChooser();
		JTextField txtContenedor = new JTextField("C:");
		SimpleDateFormat dateformat = new SimpleDateFormat("ddMMyy");
		if(txtContenedor.getText().equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "Por favor elija la ubicación", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		}else{
		try{
			Runtime runtime = Runtime.getRuntime();
			File backupFile = new File(String.valueOf(FileChooser.getCurrentDirectory()) + "\\nombreArchivo" + dateformat.format(calendario.getTime()) + ".sql");
			
	
			FileWriter fw = new FileWriter(backupFile); 
			
	
			Process child = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqldump --opt --password= --user=root <tesis>");
			
			InputStreamReader irs = new InputStreamReader(child.getInputStream());
			BufferedReader br = new BufferedReader(irs);
			
			String line;
			while( (line=br.readLine()) != null ) {
			fw.write(line + "\n");
			}
			fw.close();
			irs.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo: " + e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Archivo generado", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public MediadorPrincipal(String nombreVentana, Usuario usuario) throws Exception {
		super();
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date calendario = new java.sql.Date(utilDate.getTime());
		this.usuario = usuario;
		this.GUIPrincipal = new GUIPrincipal(nombreVentana);
		this.GUIPrincipal.setListenerButtons(this);
		GUIPrincipal.show();
		
	}
	
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
	 * Para tratar los eventos de acciones de los componentes 
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
			btnGenerarActionPerformed(arg0);
			GUIPrincipal.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Cliente"
	 */
	public void gestionarCliente(){
		try {
			new MediadorGestionarCliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Operador"
	 */
	public void gestionarOperador(){
		try {
			new MediadorGestionarOperador();
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
				new MediadorGestionarAnalisis("Analisis de la muestra "+seleccion.getSeleccionado().getNombreMuestra(), seleccion.getSeleccionado());
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
				new MediadorCalcularClasificacion("Clasificacion",seleccionarMuestra.getSeleccionado());
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
	    System.out.println("GestionarMediador.actionPerformed() jButtonListarMuestra"); 
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Limites Consistencia"
	 */
	public void gestionarLimiteConsistencia(){
		try {
			MediadorConsistencia consistencia = new MediadorConsistencia();
			if (consistencia.seSeleccionoMuestra()){
				new MediadorAltaLimiteConsistencia(consistencia.getSeleccionado());
			}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
