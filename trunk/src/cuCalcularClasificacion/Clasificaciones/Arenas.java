/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class Arenas extends GranoGrueso {

	/**
	 * Constructor por defecto.
	 */
	public Arenas() {
		this.descripcion = "Más de la mitad de la fracción gruesa pasa por el tamiz número 4 (4,76 mm)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public Arenas(String descripcion) {
		super(descripcion);
	}

}
