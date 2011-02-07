package cuGestionarTamiz;

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

import javax.swing.JOptionPane;

import persistencia.domain.Tamiz;

import comun.Mediador;

import cuGestionarMuestra.ControlGestionarMuestra;



public class MediadorSeleccionarTamiz implements ActionListener, KeyListener, MouseListener {

	private GUISeleccionarTamiz GUISeleccionarTamiz = null;
	private String seleccionado = new String();
	private Object [][] data ;
	private Component frame;
	
	
	public MediadorSeleccionarTamiz(Double abertura) throws Exception {
		super();
		cargarTablaDeTamiz(abertura);
		GUISeleccionarTamiz = new GUISeleccionarTamiz(data);
		GUISeleccionarTamiz.setTitle("Seleccionar un Tamiz");
		GUISeleccionarTamiz.setListenerButtons(this);
		GUISeleccionarTamiz.setListenerTable(this);
		GUISeleccionarTamiz.setMouseListener(this);
		GUISeleccionarTamiz.setKeyListener(this);
		GUISeleccionarTamiz.setModal(true);
		GUISeleccionarTamiz.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param abertura 
	 */
	public void cargarTablaDeTamiz(Double abertura)throws Exception{
		ControlTamiz control = new ControlTamiz();
		Tamiz tamiz = new Tamiz();
		Class clase = tamiz.getClass();
		Collection tamices = control.coleccionTamicesFiltro(abertura);
		Iterator<Tamiz> it = tamices.iterator();
		data =  new Object [tamices.size()] [2];
		int i = 0;
		while (it.hasNext()){
			tamiz = it.next();
			data [i][0]= tamiz.getNumeroTamiz();
			data [i][1]= tamiz.getAberturaMalla();
		    i++;
		}
	}
	
	/**
	 * @return the gUISeleccionarMuestra
	 */
	public GUISeleccionarTamiz getGUISeleccionarTamiz() {
		return GUISeleccionarTamiz;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarTamiz.getJButtonSeleccionar() == source || GUISeleccionarTamiz.getSeleccionarMenu()==source){
			seleccionarTamiz();
		}
		if (this.GUISeleccionarTamiz.getJButtonCancelar() == source || GUISeleccionarTamiz.getCancelarMenu()==source){
			GUISeleccionarTamiz.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Tamiz"
	 */
	public void seleccionarTamiz(){
		if (GUISeleccionarTamiz.getTablePanel().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún Tamiz","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			seleccionado = (String)GUISeleccionarTamiz.getTablePanel().getRow(GUISeleccionarTamiz.getTablePanel().getSelectedRow())[0];//
			System.out.println("Button Seleccionar Tamiz");
   			GUISeleccionarTamiz.dispose();	   		
		}
	}
	
	public void show(){
		GUISeleccionarTamiz.show();
	}
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			seleccionarTamiz();
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
	 * @return the seleccionado
	 */
	public String getSeleccionado() {
		return seleccionado;
	}

	
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	seleccionarTamiz();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
