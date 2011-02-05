/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class ArenasLimpias extends Arenas {

	/**
	 * Constructor por defecto.
	 */
	public ArenasLimpias() {
		this.descripcion="(pocos o sin finos)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public ArenasLimpias(String descripcion) {
		super(descripcion);
	}

}
