package cuGestionarAnalisis;

import java.util.Collection;
import persistencia.Persistencia;
import persistencia.domain.Analisis;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarAnalisis {

	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarAnalisis(){}
	
	/**
	 * Inserta un analisis con persistencia. 
	 */ 
	public void insertarAnalisis(Analisis analisis) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(analisis);
			persistencia.cerrarTransaccion();
			System.out.println("Analisis insertado con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		persistencia.cerrarTransaccion();
	}
	
	/**
	 * Elimina un analisis persistente. 
	 */
	public void eliminarAnalisis(Analisis analisis) throws Exception {
		Persistencia persistencia = new Persistencia();
		try {
		//	persistencia.eliminarObjeto(analisis);
			persistencia.cerrarTransaccion();
			System.out.println("Analisis eliminado con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos persistentes de la clase pasada como parametro.
	 */
	public Collection coleccionAnalisis(Class clase) throws Exception {
		Collection<Object> aux = null; 
		Persistencia persistencia = new Persistencia();
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("analisis coleccionados");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
	
	
}
	