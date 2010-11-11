package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import persistencia.domain.Analisis;

/**
* @author TesisGeologia
* Implementa las interfaces de acuerdo a los eventos que necesita tratar
* en este caso: ActionListener,MouseListener,ItemListener.
*/

public class MediadorBuscar  implements ActionListener,MouseListener,ItemListener  {
	
	private GUIBuscar guiBuscar;
	private MediadorAltaAnalisis mediadorAnalisis;
	private String data;
	
	/**
	 * This is the default constructor
	 */
	public MediadorBuscar() {
		super();
		this.guiBuscar = new GUIBuscar();
		guiBuscar.setTitle("Modificar Analisis");
		guiBuscar.setModal(true);
		this.guiBuscar.setListenerButtons(this);
		show();
	}
		
	public void show(){
		guiBuscar.show();
	}
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the altaMuestra
	 */
	public GUIBuscar getGuiBuscar() {
		return guiBuscar;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
    	if (this.guiBuscar.getJButtonBuscar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonBuscar");
			data = guiBuscar.getClaveBusqueda().getText();
			
			guiBuscar.dispose();
		}
    	if (this.guiBuscar.getJButtonAceptar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonAceptar");
			guiBuscar.dispose();
			mediadorAnalisis = new MediadorAltaAnalisis(); // ACA CREO LA VENTANA CON LOS DATOS CARGADOS PARA MODIFICAR
		}
    	
		if (this.guiBuscar.getJButtonCancelar() == source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			guiBuscar.dispose();
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