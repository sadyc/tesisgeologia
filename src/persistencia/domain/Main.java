package persistencia.domain;


import comun.CargaDatos;
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
		//CargaDatos cargaDatos = new CargaDatos();
        //cargaDatos.cargar();
        MediadorLogin login = new MediadorLogin("Login");
		
       
	}
}

