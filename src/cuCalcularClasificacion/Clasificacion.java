/**
 * 
 */
package cuCalcularClasificacion;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

import comun.Muestra;

/**
 * @author TesisGeologia
 * @version 1.0
 */
@PersistenceCapable
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
	
	/**
	 * Metodo que permite agregar una muestra a la clasificacion.
	 * @param muestra, muestra a ser agregada a la clasificacion.
	 */
	public void addMuestra (Muestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra a la clasificacion.
	 * @param muestra, muestra a ser eliminada a la clasificacion.
	 */
	public void removeMuesra (Muestra muestra){
		muestras.remove(muestra);
	}

}
