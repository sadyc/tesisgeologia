/**
 * 
 */
package cuGestionarMuestra;

import persistencia.Persistencia;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarMuestra {

	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarMuestra(Muestra mu) throws Exception{
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.insertarObjeto(mu);
			persistencia.cierraTransaccion();
			System.out.println("Muestra insertada con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarMuestra(Muestra mu) throws Exception {
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.eliminarObjeto(mu);
			persistencia.cierraTransaccion();
			System.out.println("Muestra eliminada con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void modificarMuestra(Muestra mu) throws Exception {
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.eliminarObjeto(mu);
			persistencia.cierraTransaccion();
			System.out.println("Muestra modificada con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	
}
	
	