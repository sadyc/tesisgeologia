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
		
		// Create a PersistenceManagerFactory for this datastore

        //CargaDatos cargaDatos = new CargaDatos();
        //cargaDatos.cargar();
        MediadorLogin login = new MediadorLogin("Login");
		//MediadorPrincipal pantallaPrincipal = new MediadorPrincipal("Pantalla Principal");
        //MediadorGestionarMuestra gestionarMu = new MediadorGestionarMuestra("gestionar muestra");
    	//MediadorGestionarAnalisis hola = new MediadorGestionarAnalisis("probandoo", "soplala");
        

	}
}

