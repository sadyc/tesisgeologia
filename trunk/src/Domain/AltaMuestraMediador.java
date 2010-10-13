package Domain;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUIs.GUIMuestra;

/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class AltaMuestraMediador  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIMuestra altaMuestra = null;
	private String [] data = new String [5];
	
	/**
	 * This is the default constructor
	 */
	public AltaMuestraMediador() {
		super();
		this.altaMuestra = new GUIMuestra();
		altaMuestra.setTitle("Ingresar Muestra");
		altaMuestra.setModal(true);
		this.altaMuestra.setListenerButtons(this);
	}
		
	public void show(){
		altaMuestra.show();
	}
	
	/**
	 * @return the data
	 */
	public String[] getData() {
		return data;
	}

	/**
	 * @return the altaMuestra
	 */
	public GUIMuestra getAltaMuestra() {
		return altaMuestra;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.altaMuestra.getJButtonAceptar() == source){
			System.out.println("GestionarMediador.actionPerformed() jButtonAgregarMuestra");
			data [0] = altaMuestra.getMuestra().getText();
			data [1] = altaMuestra.getPeso().getText();
			data [2] = altaMuestra.getProfundidadInicial().getText();
			data [3] = altaMuestra.getProfundidadFinal().getText();
			
		
			//cierra la ventana
			altaMuestra.dispose();
		}
		if (this.altaMuestra.getJButtonCancelar() == source){
			//cerrar ventana
			System.out.println("GestionarMediador.actionPerformed() jButtonCancelar");
			altaMuestra.dispose();
		}
	}



	public void itemStateChanged(ItemEvent arg0) {
	}


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
}
