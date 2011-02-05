/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GranoFino extends SUCS {

	/**
	 * Constructor por defecto
	 */
	public GranoFino() {
		this.descripcion = "Más de la mitad del material pasa por el tamiz número 200";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GranoFino(String descripcion) {
		super(descripcion);
	}

}
