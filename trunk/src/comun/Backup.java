package comun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
* Esta clase implementa los métodos que permiten realizar y recuperar back-up de la base de datos.
* @author TesisGeología
* @version 1.0
*/
public class Backup {
	private int BUFFER = 10485760;  
    private StringBuffer temp = null;
    private FileWriter  fichero = null;
    private PrintWriter pw = null;
    private String filePath =  null;
	
    /**
     * Constructor por defecto de la clase.
     */
    public Backup(){
    
    }
    /**
     * Método que me permite elegir el directorio donde se va a guardar el Back-Up.
     */
    public void elegirDirectorio(){
    	JOptionPane.showMessageDialog(null, "Por favor elija la ubicación donde guardará el Back-Up", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		 JFileChooser directorio = new JFileChooser();
        int seleccion = directorio.showSaveDialog(new JPanel());
        directorio.setDialogType(directorio.DIRECTORIES_ONLY);
        if (seleccion == JFileChooser.APPROVE_OPTION){
        	File f = directorio.getSelectedFile();
	            filePath = f.getPath();
	            if(!filePath.toLowerCase().endsWith(".sql"))
	            {
	                f = new File(filePath + ".sql");
	                filePath = f.getPath();  
	            }
	            crearBackUpWindowsX86(); 
        }
    }
    
    /**
     * Método que permite cargar el Back-Up tomando el directorio de MySQL 5.1 en el sitema operativo Windows de 32 bits. 
     */
    public void cargarBackUpWindowsX86(){
    	cargarBackup("C:/Program Files/MySQL/MySQL Server 5.1/bin/","Falló el backup de windows de 32 bits");
    }
    
    /**
     * Método que permite cargar el Back-Up tomando el directorio de MySQL 5.1 en el sitema operativo Windows de 64 bits.
     */
    public void cargarBackUpWindowsX64(){
    	cargarBackup("C:/Program Files (x86)/MySQL/MySQL Server 5.1/bin/","Falló el backup de windows de 64 bits");
    }
    
    /**
     * Método que permite crear el Back-Up tomando el directorio de MySQL 5.1 en el sitema operativo Windows de 32 bits. 
     */
    public void crearBackUpWindowsX86(){
    	crearBackup("C:/Program Files/MySQL/MySQL Server 5.1/bin/","Falló el backup de windows de 32 bits");
    }
    
    /**
     * Método que permite crear el Back-Up tomando el directorio de MySQL 5.1 en el sitema operativo Windows de 64 bits.
     */
    public void crearBackUpWindowsX64(){
    	crearBackup("C:/Program Files (x86)/MySQL/MySQL Server 5.1/bin/","Falló el backup de windows de 64 bits");
    }
    

    /**
     * Método que ejecuta todas las instrucciones que permiten cargar un Back-Up previamente realizado.
     */
	public void cargarBackup(String dirMySQL, String error) {
		 JOptionPane.showMessageDialog(null, "Por favor seleccione el archivo.", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		 JFileChooser directorio = new JFileChooser();
	     directorio.setFileSelectionMode(JFileChooser.FILES_ONLY);
	     int seleccion = directorio.showOpenDialog(new JPanel());
	     directorio.setDialogType(directorio.DIRECTORIES_ONLY);
	     if (seleccion == JFileChooser.APPROVE_OPTION){
	    	 int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"Recuerde que al Cargar Back-Up, perderá aquella información \nalmacenada posteriormente al último Back-Up realizado. \n¿Está Seguro de cargar Back-Up?","Cargar Back-Up",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	    	 if(quitOption==JOptionPane.YES_OPTION)	{
	    		 try {
	    			 eliminarDB();
	    		 }
	    		 catch (Exception e){
	    			 System.out.println("No se encontró la base de datos!!");
	    		 }	
	    		 finally{
	    			 File f = directorio.getSelectedFile();
	    			 filePath = f.getPath();
	    			 try {
	    				 crearDB();
	    				 // Ejecucion del cliente mysql
	    				 Process p = Runtime.getRuntime().exec(dirMySQL+"mysql -u root -proot tesis");
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
	    					 os.write(buffer, 0, leido);
	    					 leido = fis.read(buffer);
	    				 }
	    				 os.close();
	    				 fis.close();
	    				 JOptionPane.showMessageDialog(null, "Se ha cargado el Back-Up con éxito", "Exito!",JOptionPane.INFORMATION_MESSAGE);
	    			 } catch (Exception e) {	
	    				 System.out.println(error);
	    				 if(error.compareTo("Falló el backup de windows de 64 bits")!=0){
	    					 cargarBackUpWindowsX64();
	    				 }
	    				 else{
	    					 JOptionPane.showMessageDialog(null, "No se ha cargado el Back-Up", "Error!",JOptionPane.INFORMATION_MESSAGE);
	    				 }
	    			 }
	    		 }    
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
	
	/**
	 * Método que ejecuta todas las instrucciones que permiten crear el Back-Up de la base de datos.
	 * @param dirMySQL, directorio en donde se encuentra instalado MySQL Server 5.1.
	 * @param error, contenido del mensaje en caso de error.
	 */
	 public void crearBackup(String dirMySQL, String error){
		 try{       
			 Process run = Runtime.getRuntime().exec(dirMySQL+"mysqldump --host=localhost --port=3306 --user=root --password=root tesis");
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
			// se crea y escribe el archivo SQL 
			 fichero = new FileWriter(backupFile);
			 pw = new PrintWriter(fichero);                                         
			 pw.println(temp.toString());  
			 JOptionPane.showMessageDialog(null, "Se ha creado el Back-Up con éxito", "Exito!",JOptionPane.INFORMATION_MESSAGE);
		 }
		 catch (Exception ex){
			 System.out.println(error);
			 if(error.compareTo("Falló el backup de windows de 64 bits")!=0){
				 crearBackUpWindowsX64();
			 }
		 } finally {
			 try {           
				 if (null != fichero)
					 fichero.close();
			 } catch (Exception e2) {
				 e2.printStackTrace();
			 }
		 }   
	 }  
	
	 /**
	  * Método que permite eliminar la base de datos existente para evitar el surgimiento de conflictos.	 
	  * @throws Exception
	  */
	 public void eliminarDB() throws Exception {
			Statement stmt;
			        Class.forName("com.mysql.jdbc.Driver");
			        String url = "jdbc:mysql://localhost:3306/mysql";
			        Connection con = (Connection) DriverManager.getConnection(url,"root", "root");
			        stmt = (Statement) con.createStatement();
			        stmt.executeUpdate("DROP DATABASE tesis");
			        con.close();
	 }
	 
	 /**
	  * Método que permite crear la base de datos para montar el back-up.
	  * @throws Exception
	  */
	 public void crearDB() throws Exception {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			Connection con = (Connection) DriverManager.getConnection(url,"root", "root");
			stmt = (Statement) con.createStatement();
			stmt.executeUpdate("CREATE DATABASE tesis");
			con.close();
	 }
}
