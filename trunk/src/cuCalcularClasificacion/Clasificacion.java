/**
 * 
 */
package cuCalcularClasificacion;

import java.util.Collection;
import java.util.HashSet;

import comun.Muestra;

/**
 * @author TesisGeologia
 * @version 1.0
 */
public class Clasificacion {
	
	protected String descripcion;
	protected Collection<Muestra> muestras = new HashSet();

	/**
	 * @brief Constructor por defecto.
	 */
	public Clasificacion() {
		this.descripcion = new String();
	}
	
	
	/**
	 * @param descripcion
	 * @param muestras
	 */
	public Clasificacion(String descripcion) {
		this.descripcion = descripcion;
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

}
