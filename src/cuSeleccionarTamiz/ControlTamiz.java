/**
 * 
 */
package cuSeleccionarTamiz;

import java.util.Collection;

import comun.Control;

import persistencia.Persistencia;
import persistencia.domain.Tamiz;

/**
 * Clase que se utiliza para gestionar los datos de tamiz 
 * con persistencia en la base de datos del sistema.
 * 
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlTamiz extends Control{

	/**
	 * Contructor por defecto
	 */
	public ControlTamiz(){}
	
	/**
	 * Retorna todos los elementos de la clase pasada como parametro.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection coleccionTamicesFiltro(Double abertura) throws Exception {
		Tamiz tamiz = new Tamiz();
		Collection<Tamiz> aux = null;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccionFiltro(tamiz.getClass(),"aberturaMalla<"+abertura));
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
