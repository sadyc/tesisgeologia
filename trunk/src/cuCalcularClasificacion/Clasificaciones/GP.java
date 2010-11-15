package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GP extends GravasLimpias {
	
	/**
	 * Constructor por defecto.
	 */
	public GP() {
		this.descripcion="Gravas mal graduadas, mezclas grava-arena, pocos finos o sin finos.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GP(String descripcion) {
		super(descripcion);
	}
}
