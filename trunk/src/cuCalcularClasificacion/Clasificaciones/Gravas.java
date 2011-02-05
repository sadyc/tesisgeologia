/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class Gravas extends GranoGrueso {

	/**
	 * Constructor por defecto.
	 */
	public Gravas() {
		this.descripcion="Más de la mitad de la fracción gruesa es retenida por el tamiz número 4 (4,76 mm)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public Gravas(String descripcion) {
		super(descripcion);
	}

}
