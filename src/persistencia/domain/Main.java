package persistencia.domain;


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
		//CargaDatosMain cargaDatos = new CargaDatosMain();
        //cargaDatos.cargar();
        MediadorLogin login = new MediadorLogin("Login");
		//MediadorGestionarMuestra med = new MediadorGestionarMuestra("");
		
       
	}
}

