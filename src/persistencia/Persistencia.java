/**
 * 
 */
package persistencia;

import java.util.Iterator;

/**
 * @author TesisGeologia
 * @version 1.0
 */
public class Persistencia {

	public void realizarRollback(){}
	/**
	 * Default constructor.
	 *
	 */
	public Persistencia (){}
	
	/**
	 * Inserta un elemento generico.
	 *
	 */
	public void insertarObjeto () {}
	
	/**
	 * Elimina un elemento generico.
	 *
	 */
	public void eliminarObjeto () throws Exception {}
	
	/**
	 * Busca un elemento generico. Retorna lo encontrado.
	 *
	 */
	public Object buscarObjeto () {
		Object a = new Object();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (a);
	}
	
	public Colection buscarColeccion (){}

	public void cierraTransaccion(){}
	
	//metodos particulares de busqueda.
}
