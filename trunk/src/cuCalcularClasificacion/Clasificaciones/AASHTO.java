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
	 * @param descripcion
	 */
	public AASHTO(String descripcion) {
		super(descripcion);
		// TODO Auto-generated constructor stub
	}

}
