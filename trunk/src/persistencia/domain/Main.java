package persistencia.domain;

import comun.MediadorPrincipal;

import cuLogin.Encriptar;
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
		Usuario usuario1 = new Usuario("Juan", "Perez", "555","admin","Administrador", "juan@perez.com", "4917015","admin");
		new MediadorPrincipal("Sistema Clasificador de Suelos",usuario1);
		
		
	}
}

