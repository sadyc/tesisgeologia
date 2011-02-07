/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Implementacion de la clase que define la clasificacion 
 * de manera persistente.
 * @author TesisGeologia
 * @version 1.0
 */
@PersistenceCapable
public class Clasificacion {
	
	protected String clasificacion;
	protected String nombre;
	protected String descripcion;
	
	
	/**
	 * Contructor con pasaje de parametros.
	 * @param nombre
	 * @param descripcion
	 */
	public Clasificacion(String clasificacion,String nombre, String descripcion) {
		this.clasificacion = clasificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	/**
	 * @brief Constructor por defecto.
	 */
	public Clasificacion() {
		clasificacion = new String();
		nombre = new String();
		descripcion = new String();
	}
	
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
