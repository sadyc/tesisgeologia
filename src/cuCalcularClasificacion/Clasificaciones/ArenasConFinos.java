package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class ArenasConFinos extends Arenas {

	/**
	 * Constructor por defecto.
	 */
	public ArenasConFinos() {
		this.descripcion="(apreciable cantidad de finos)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public ArenasConFinos(String descripcion) {
		super(descripcion);
	}

}
