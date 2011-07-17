package persistencia.domain;

import cuLogin.MediadorLogin;

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
			new MediadorLogin("Login");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
}

