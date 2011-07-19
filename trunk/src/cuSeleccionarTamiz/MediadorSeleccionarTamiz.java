package cuSeleccionarTamiz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Tamiz;

import comun.Mediador;
import comun.MediadorVersion;


/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana SeleccionarTamiz.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class MediadorSeleccionarTamiz extends Mediador{

	private GUISeleccionarTamiz GUISeleccionarTamiz = null;
	private boolean seleccionoTamiz = false;
	private String seleccionado = new String();
	private Object [][] data ;
	private Component frame;
	
	
	/**
	 * Constructor con pasaje de parametros.
	 * @param abertura
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
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
		GUISeleccionarTamiz.setLocationRelativeTo(null);
		GUISeleccionarTamiz.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param abertura 
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void cargarTablaDeTamiz(Double abertura)throws Exception{
		ControlTamiz control = new ControlTamiz();
		Tamiz tamiz = new Tamiz();
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
	
	/**
	 * @return the seleccionoTamiz
	 */
	public boolean seSeleccionoTamiz() {
		return seleccionoTamiz;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarTamiz.getJButtonSeleccionar() == source || GUISeleccionarTamiz.getSeleccionarMenu()==source){
			seleccionarTamiz();
		}
		if (GUISeleccionarTamiz.getVersionMenu()==source){
			new MediadorVersion();
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
			seleccionoTamiz = true;
			GUISeleccionarTamiz.dispose();	   		
		}
	}
	
	@SuppressWarnings("deprecation")
	public void show(){
		GUISeleccionarTamiz.show();
	}
	/**
	 * Métodos que necesita definir al implementar la interface MouseListener 
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

	
	
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER){
        	seleccionarTamiz();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
