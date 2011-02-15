package comun;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Tamiz;
import cuGestionarMuestra.ControlGestionarMuestra;



public class MediadorSeleccionarTamiz implements ActionListener,MouseListener,ItemListener {

	private GUISeleccionarTamiz GUISeleccionarTamiz = null;
	private String seleccionado = new String();
	private Object [][] data ;
	private Component frame;
	
	
	public MediadorSeleccionarTamiz() throws Exception {
		super();
		cargarTablaDeTamiz();
		this.GUISeleccionarTamiz = new GUISeleccionarTamiz(data);
		GUISeleccionarTamiz.setTitle("Seleccionar un Tamiz");
		GUISeleccionarTamiz.setModal(true);
		this.GUISeleccionarTamiz.setListenerButtons(this);
		this.GUISeleccionarTamiz.setListenerTable(this);
		GUISeleccionarTamiz.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeTamiz()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Tamiz tamiz = new Tamiz();
		Class clase = tamiz.getClass();
		Collection tamices = control.coleccionMuestras(clase);
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
		if (this.GUISeleccionarTamiz.getJButtonSeleccionar() == source){
			if (GUISeleccionarTamiz.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun Tamiz","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				seleccionado = (String)GUISeleccionarTamiz.getTablePanel().getRow(GUISeleccionarTamiz.getTablePanel().getSelectedRow())[0];//
				System.out.println("Button Seleccionar Tamiz");
	   			GUISeleccionarTamiz.dispose();	   		
			}
		}
		if (this.GUISeleccionarTamiz.getJButtonSalir() == source){
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
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUISeleccionarTamiz.getTablePanel() == source)
			System.out.println("GestionarMediador.actionPerformed() jJTableTabla");
		
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

		public void itemStateChanged(ItemEvent e) {
	}
}
