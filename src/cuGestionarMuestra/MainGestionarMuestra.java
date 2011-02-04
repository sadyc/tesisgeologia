/**
 * 
 */
package cuGestionarMuestra;

/**
 * @author NAVE
 *
 */
public class MainGestionarMuestra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MediadorGestionarMuestra chino = new MediadorGestionarMuestra("probando gestionar muestra");
		} catch (Exception e) {
			System.out.println("No se pudo probar!");
			e.printStackTrace();
		}

	}

}
