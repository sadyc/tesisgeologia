/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

/**
 * @author TesisGeologia
 * @version 1.0
 */
@PersistenceCapable
public class Clasificacion {
	
	protected String nombre;
	protected String descripcion;
	protected Collection<Muestra> muestras = new HashSet();

	/**
	 * @brief Constructor por defecto.
	 */
	public Clasificacion() {
		this.descripcion = new String();
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
