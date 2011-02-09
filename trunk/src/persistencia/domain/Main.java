package persistencia.domain;



import comun.MediadorPrincipal;




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
		//Muestra mu = new Muestra();
		//MediadorAltaLimiteConsistencia hola = new MediadorAltaLimiteConsistencia("Limite Consistencia");

		//new MediadorLogin("Login");
		new MediadorPrincipal ("Sistema Clasificador de Suelos");
	//MediadorGestionarMuestra med = new MediadorGestionarMuestra("");
		
       
	}
}

