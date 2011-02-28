package comun;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
/**
* @brief Clase que se utiliza para escuchar los eventos que suceden en la ventana Version.
*
* @author TesisGeologia
* @version 1.0.
*/
public class MediadorVersion extends Mediador {

	GUIVersion GUIVersion = null;
	
	/**
	 *Constructor por defecto. 
	 */
	@SuppressWarnings("deprecation")
	public MediadorVersion () {
		super();
		this.GUIVersion = new GUIVersion();
		this.GUIVersion.setListenerButtons(this);
		this.GUIVersion.setModal(true);
		this.GUIVersion.show();
	}
	
	public void actionPerformed(ActionEvent arg0){
		Object source = arg0.getSource();
		if (GUIVersion.getjButtonCancelar() == source){
			GUIVersion.dispose();
		}
	}
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
