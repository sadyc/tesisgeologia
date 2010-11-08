package cuGestionarAnalisis;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MediadorSeleccionarMuestra hola;
		try {
			Object [][] a = null;
			hola = new MediadorSeleccionarMuestra("das");
			hola.show();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hola cuate");
			e.printStackTrace();
		}
		
	}

}
