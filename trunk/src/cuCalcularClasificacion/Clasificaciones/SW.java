/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class SW extends ArenasLimpias {

	/**
	 * Constructor por defecto.
	 */
	public SW() {
		this.descripcion="Arenas bien graduadas, arenas con grava, pocos finos o  sin finos.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public SW(String descripcion) {
		super(descripcion);
	}
}
