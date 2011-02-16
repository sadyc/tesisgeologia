package comun;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RealizarBackup extends ActionEvent {
	
	public RealizarBackup(Object source, int id, String command) {
		super(source, id, command);
	
	}

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
	
	public void generarBackup(){
		btnGenerarActionPerformed(this);
	}
	
}
