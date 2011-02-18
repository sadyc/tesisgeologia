package comun;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import persistencia.domain.DUsuario;
import persistencia.domain.HMuestra;
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
	private DUsuario usuario;
	private java.sql.Date calendario;
	private int BUFFER = 10485760;  
    private JFileChooser directorio= null;
    //para guardar en memmoria
    private StringBuffer temp = null;
    //para guardar el archivo SQL
    private FileWriter  fichero = null;
    private PrintWriter pw = null;
	
/**	private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {
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
*/	
	public MediadorPrincipal(String nombreVentana, DUsuario usuario) throws Exception {
		super();
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date calendario = new java.sql.Date(utilDate.getTime());
		this.usuario = usuario;
		this.GUIPrincipal = new GUIPrincipal(nombreVentana);
		this.GUIPrincipal.setListenerButtons(this);
		if (usuario.getCategoria().compareTo("Operador") == 0){
			GUIPrincipal.getJButtonGestionarUsuario().setEnabled(false);
			GUIPrincipal.getGestionarUsuarioMenu().setEnabled(false);
			GUIPrincipal.getjButtonCrearBackup().setEnabled(false);
			GUIPrincipal.getCrearBackupMenu().setEnabled(false);
			GUIPrincipal.getCargarBackupMenu().setEnabled(false);
			GUIPrincipal.getjButtonCargarBackup().setEnabled(false);
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
				GUIPrincipal.getjButtonCrearBackup().setEnabled(false);
				GUIPrincipal.getCrearBackupMenu().setEnabled(false);
				GUIPrincipal.getCargarBackupMenu().setEnabled(false);
				GUIPrincipal.getjButtonCargarBackup().setEnabled(false);
			}
		}
		System.out.println(usuario.getCategoria());
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
			GUIPrincipal.dispose();
		}
		if (this.GUIPrincipal.getjButtonCrearBackup()==source || this.GUIPrincipal.getCrearBackupMenu()==source){
			crearBackup();
		}
		if (this.GUIPrincipal.getjButtonCargarBackup()==source || this.GUIPrincipal.getCargarBackupMenu()==source){
			cargarBackup();
		}
	}
	
	
	 public void cargarBackup() {
		 JOptionPane.showMessageDialog(null, "Por favor elija la ubicación", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		 JFileChooser directorio = new JFileChooser();
         directorio = GUIPrincipal.getFileChooser();
         directorio.setFileSelectionMode(JFileChooser.FILES_ONLY);
         int seleccion = directorio.showOpenDialog(new JPanel());
         directorio.setDialogType(directorio.DIRECTORIES_ONLY);
         if (seleccion == JFileChooser.APPROVE_OPTION){
         	File f = directorio.getSelectedFile();
	            String filePath = f.getPath();
	            try {
		            // Ejecucion del cliente mysql
		            Process p = Runtime.getRuntime().exec("mysql -u root -proot tesis");

		            // Lectura de la salida de error y se muestra por pantalla.
		            InputStream es = p.getErrorStream();
		            muestraSalidaDeError(es);

		            // Lectura del fichero de backup y redireccion a la entrada estandar
		            // de mysql.
		            OutputStream os = p.getOutputStream(); 
		            FileInputStream fis = new FileInputStream(filePath);

		            byte buffer[] = new byte[1024];
		            int leido = fis.read(buffer);
		            while (leido > 0) {
		                System.out.println(leido);
		                os.write(buffer, 0, leido);
		                leido = fis.read(buffer);
		            }
		            os.close();
		            fis.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	            
	        }          
		 	    }

	 private void muestraSalidaDeError(final InputStream es) {
	        Thread hiloError = new Thread() {
	            public void run() {
	                try {
	                    byte[] buffer = new byte[1024];
	                    int leido = es.read(buffer);
	                    while (leido > 0) {
	                        System.out.println(new String(buffer, 0, leido));
	                        leido = es.read(buffer);
	                    }
	                    es.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        hiloError.start();
	    }
	
	// METODO PARA REALIZAR EL BACKP
	 public void crearBackup(){
		 JOptionPane.showMessageDialog(null, "Por favor elija la ubicación", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		 JFileChooser directorio = new JFileChooser();
         directorio = GUIPrincipal.getFileChooser();
         int seleccion = directorio.showSaveDialog(new JPanel());
         directorio.setDialogType(directorio.DIRECTORIES_ONLY);
         if (seleccion == JFileChooser.APPROVE_OPTION){
         	File f = directorio.getSelectedFile();
	            String filePath = f.getPath();
	            if(!filePath.toLowerCase().endsWith(".sql"))
	            {
	                f = new File(filePath + ".sql");
	                filePath = f.getPath();  
	            }

	            try{       
	                //sentencia para crear el BackUp
	                 Process run = Runtime.getRuntime().exec("mysqldump --host=localhost --port=3306 --user=root --password=root --compact --complete-insert --extended-insert --skip-quote-names"
	                		 +" --skip-comments --skip-triggers tesis");
	                 
	                //se guarda en memoria el backup
	                InputStream in = run.getInputStream();
	                BufferedReader br = new BufferedReader(new InputStreamReader(in));
	                File backupFile = new File(filePath);
	                fichero = new FileWriter(backupFile);
	                temp = new StringBuffer();
	                int count;
	                char[] cbuf = new char[BUFFER];
	                while ((count = br.read(cbuf, 0, BUFFER)) != -1)
	                    temp.append(cbuf, 0, count);
	                String line;
	    			while( (line=br.readLine()) != null ) {
	    			fichero.write(line + "\n");
	    			}
	    			br.close();
	                in.close();        

	                String fecha = String.valueOf(new Date().toGMTString());
	                /* se crea y escribe el archivo SQL */
	                
	                fichero = new FileWriter(backupFile);
	                pw = new PrintWriter(fichero);                                         
	                pw.println(temp.toString());  

	           }
	            catch (Exception ex){
	            	System.out.println("Falló el backup");
	            	ex.printStackTrace();
	            } finally {
	            	try {           
	            	   if (null != fichero)
	                	 fichero.close();
	               } catch (Exception e2) {
	                   e2.printStackTrace();
	               }
	            }   
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
	 * Acciones a realizar cuando se selecciona la opcion de "Calcular AClasificacion"
	 */
	public void calcularClasificacion(){
		try {
			MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
			if (seleccionarMuestra.seSeleccionoMuestra()){
				new MediadorCalcularClasificacion("AClasificacion",seleccionarMuestra.getSeleccionado());
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
				HMuestra muestra1 = seleccionarMuestra.getSeleccionado();
				seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					HMuestra muestra2 = seleccionarMuestra.getSeleccionado();
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
	public DUsuario getUsuario() {
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
