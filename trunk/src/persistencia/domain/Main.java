package persistencia.domain;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import comun.CargaDatos;

import cuGestionarAnalisis.MediadorGestionarAnalisis;



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
		
		// Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        CargaDatos cargaDatos = new CargaDatos();
        cargaDatos.cargar();
        //MediadorLogin login = new MediadorLogin("Login");
		//login.show();
        //MediadorPrincipal pantallaPrincipal = new MediadorPrincipal("Pantalla Principal");
        //MediadorGestionarMuestra gestionarMu = new MediadorGestionarMuestra("gestionar muestra");
    	//MediadorGestionarAnalisis hola = new MediadorGestionarAnalisis("probandoo", "soplala");
        

	}
}

