package persistencia.domain;



import comun.MediadorPrincipal;

import cuLogin.MediadorLogin;






 /**
 * @author TesisGeologia
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
		//new MediadorLogin("Login");
		Usuario usuario = new Usuario("pepe", "grillo", "111", "pepito", "administrador", "pepe@grillo", "444-222", "pepito el grosso");
		new MediadorPrincipal("SISTEMA DE CLASIFICACION DE SUELOS",usuario);
	}
}

