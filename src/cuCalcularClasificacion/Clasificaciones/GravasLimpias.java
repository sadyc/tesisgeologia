/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GravasLimpias extends Gravas {

	/**
	 * Constructor por defecto.
	 */
	public GravasLimpias() {
		this.descripcion="(sin o con pocos finos)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GravasLimpias(String descripcion) {
		super(descripcion);
	}

}
