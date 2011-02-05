package cuCalcularClasificacion.Clasificaciones;
/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class SP extends ArenasLimpias {

	/**
	 * Constructor por defecto.
	 */
	public SP() {
		this.descripcion="Arenas mal graduadas, arenas con grava, pocos finos o sin finos.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public SP(String descripcion) {
		super(descripcion);
	}
}
