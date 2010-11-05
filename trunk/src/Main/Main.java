package Main;

import cuGestionarMuestra.GUIABMMuestra;
import cuGestionarMuestra.GUIMuestra;
import cuGestionarMuestra.Muestra;

 /**
 * @author TesisGeologia
 *
 * Este ejemplo contiene un Frame que permite realizar la gestion sin persistencia
 * de los datos de una muestra con Border Layout y en cada uno de sus paneles
 * ajustamos el layout conveniente para cada caso.
 * 
 */
 

public class Main {

	/**
	 * This is the default constructor
	 */
	public Main() { 
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Muestra s= new Muestra();
      	GUIMuestra gestionarDi = new GUIMuestra();
		gestionarDi.show();
	}
}

