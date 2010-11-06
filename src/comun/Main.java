package comun;

import javax.swing.WindowConstants;

import cuGestionarMuestra.MediadorGestionarMuestra;


public class Main {
	public static void main(String[] args) throws Exception{ 
		try {
			MediadorPrincipal gestionarMuestra = new MediadorPrincipal("Listado de Muestras");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


