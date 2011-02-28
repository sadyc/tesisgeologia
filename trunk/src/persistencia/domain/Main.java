package persistencia.domain;

import cuLogin.MediadorLogin;

 /**
 * Clase que contiene Main para ejecutar el programa. 
 * @author TesisGeologia
 * @version 1.0.
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

		new MediadorLogin("Login");
		//new MediadorPrincipal("Sistema Clasificador de Suelos",usuario1);
		
		
	}
}

