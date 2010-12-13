package cuGestionarAnalisis;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import comun.Mediador;

/**
* @author TesisGeologia
* Implementa las interfaces de acuerdo a los eventos que necesita tratar
* en este caso: ActionListener,MouseListener,ItemListener.
*/

public class MediadorBuscar  extends Mediador{
	
	private GUIBuscar guiBuscar;
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
			buscar();
		}
    	if (this.guiBuscar.getJButtonAceptar() == source){
			aceptar();
		}
    	
		if (this.guiBuscar.getJButtonCancelar() == source){
			cancelar();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Cancelar"
	 */
	public void cancelar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
		guiBuscar.dispose();
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAceptar");
		guiBuscar.dispose();
		new MediadorAltaAnalisis("nombreMuestra"); // ACA CREO LA VENTANA CON LOS DATOS CARGADOS PARA MODIFICAR
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Buscar"
	 */
	public void buscar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonBuscar");
		data = guiBuscar.getClaveBusqueda().getText();
		guiBuscar.dispose();
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