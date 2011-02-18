/**
 * 
 */
package cuGestionarTamiz;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.ETamiz;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * 
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlTamiz {

	/**
	 * Contructor por defecto
	 */
	public ControlTamiz(){}
	
	/**
	 * Retorna todos los elementos de la clase pasada como parametro.
	 */
	public Collection coleccionTamicesFiltro(Double abertura) throws Exception {
		ETamiz tamiz = new ETamiz();
		Collection<ETamiz> aux = null;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccionFiltro(tamiz.getClass(),"aberturaMalla<"+abertura));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
