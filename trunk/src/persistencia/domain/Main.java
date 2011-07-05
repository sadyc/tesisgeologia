package persistencia.domain;

import comun.MediadorPrincipal;

 /**
 * Clase que contiene Main para ejecutar el programa. 
 * @author TesisGeologia
 * @version 1.0.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//new MediadorLogin("Login");
			Usuario jose= new Usuario("","","","","Administrador","","","");
			new MediadorPrincipal("hola",jose);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
}

