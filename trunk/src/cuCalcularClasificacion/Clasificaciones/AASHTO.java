/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

import persistencia.domain.Clasificacion;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class AASHTO extends Clasificacion{

	/**
	 * @brief Constructor por defecto.
	 */
	public AASHTO() {
		descripcion = "arena de metales";
	}
	
	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public AASHTO(String descripcion) {
		super(descripcion);
	}

}
