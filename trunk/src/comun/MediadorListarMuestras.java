package comun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MediadorListarMuestras implements ActionListener,MouseListener,ItemListener {

	GUIListarMuestras GUIListarMuestras;
	
	public MediadorListarMuestras(String title) throws Exception {
		super();
		//cargarTablaDeMuestras();
		Object [][] data = new Object [4] [5];
		GUIListarMuestras = new GUIListarMuestras(data);
		GUIListarMuestras.setTitle(title);
		this.GUIListarMuestras.setListenerButtons(this);
		show();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIListarMuestras.getJButtonSalir() == source){
			System.out.println("JButtonSalir() ventana Listar Muestra");
			GUIListarMuestras.dispose();
		}
	}
	
	public void show(){
		GUIListarMuestras.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent arg0) {
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
}