package Main;

import persistencia.domain.Muestra;
import cuGestionarMuestra.MediadorGestionarMuestra;


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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		MediadorGestionarMuestra gestionarMuestra = new MediadorGestionarMuestra("Listado de Muestras");
	}
}

