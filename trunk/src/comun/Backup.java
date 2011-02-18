package comun;

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

/**
* @author TesisGeología
* Esta clase implementa los métodos que permiten realizar y recuperar back-up de la base de datos.
*/
public class Backup {
	private int BUFFER = 10485760;  
    //para guardar en memmoria
    private StringBuffer temp = null;
    //para guardar el archivo SQL
    private FileWriter  fichero = null;
    private PrintWriter pw = null;
	
    public Backup(){}
    
	public void cargarBackup() {
		 JOptionPane.showMessageDialog(null, "Por favor elija la ubicación", "Verificar",JOptionPane.INFORMATION_MESSAGE);
		 JFileChooser directorio = new JFileChooser();
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
		            JOptionPane.showMessageDialog(null, "Se ha cargado el Back-Up con éxito", "Exito!",JOptionPane.PLAIN_MESSAGE);
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
	                 Process run = Runtime.getRuntime().exec("C:/Program Files (x86)/MySQL/MySQL Server 5.1/bin/mysqldump --host=localhost --port=3306 --user=root --password=root --compact --complete-insert --extended-insert --skip-quote-names"
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
	           
	                /* se crea y escribe el archivo SQL */
	                
	                fichero = new FileWriter(backupFile);
	                pw = new PrintWriter(fichero);                                         
	                pw.println(temp.toString());  
	                JOptionPane.showMessageDialog(null, "Se ha creado el Back-Up con éxito", "Exito!",JOptionPane.PLAIN_MESSAGE);

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
	
}
