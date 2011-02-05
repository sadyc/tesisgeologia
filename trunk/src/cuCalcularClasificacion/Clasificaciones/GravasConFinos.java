/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GravasConFinos extends Gravas {

	/**
	 * Constructor por defecto.
	 */
	public GravasConFinos() {
		this.descripcion="(apreciable cantidad de finos)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GravasConFinos(String descripcion) {
		super(descripcion);
	}

}
