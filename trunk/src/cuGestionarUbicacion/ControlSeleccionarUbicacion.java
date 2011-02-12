package cuGestionarUbicacion;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Ubicacion;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlSeleccionarUbicacion {

	
	/**
	 * Contructor por defecto
	 */
	public ControlSeleccionarUbicacion(){}
	
	public boolean pepe(String asd){
		return true;
	}
		
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionUbicaciones(Class clase) throws Exception {
		Collection<Object> aux = null; 
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
	
	
}
	
	