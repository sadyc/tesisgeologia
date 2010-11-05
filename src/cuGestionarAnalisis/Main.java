package cuGestionarAnalisis;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MediadorGestionarAnalisis probando = new MediadorGestionarAnalisis();
		probando.show();
		GUIGestionarAnalisis hola;
		try {
			hola = new GUIGestionarAnalisis("hola chicos");
			hola.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
