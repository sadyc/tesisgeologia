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
 * 
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener. 
 */										  	
public class ModificarMuestraMediador  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIMuestra modificarMuestra = null;
	private String [] data = new String [5];
	
	/**
	 * This is the constructor whit parameters
	 */
	public ModificarMuestraMediador(String [] data) {
		super();
		this.modificarMuestra = new GUIMuestra(data);
		modificarMuestra.setTitle("Modificar Muestra");
		modificarMuestra.setModal(true);
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		this.modificarMuestra.setListenerButtons(this);
	}
			
	public void show()
	{
		modificarMuestra.show();
	}
	
	/**
	 * @return the data
	 */
	public String[] getData() {
		return data;
	}

	/**
	 * @return the modificarMuestra
	 */
	public GUIMuestra getModificarMuestra() {
		return modificarMuestra;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
     	if (this.modificarMuestra.getJButtonAceptar() == source){
			System.out.println("GestionarMediador.actionPerformed() jButtonAceptar");
			data [0] = modificarMuestra.getMuestra().getText();
			data [1] = modificarMuestra.getPeso().getText();
			data [2] = modificarMuestra.getProfundidadInicial().getText();
			data [3] = modificarMuestra.getProfundidadFinal().getText();
			modificarMuestra.dispose();
     	}
		if (this.modificarMuestra.getJButtonCancelar() == source){
			//cerrar ventana
			System.out.println("GestionarMediador.actionPerformed() jButtonCancelar");
			modificarMuestra.dispose();
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
