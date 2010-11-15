package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GW extends GravasLimpias {
	
	/**
	 * Constructor por defecto.
	 */
	public GW() {
		this.descripcion="Gravas, bien graduadas, mezclas grava-arena, pocos finos  o sin finos.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GW(String descripcion) {
		super(descripcion);
	}
}
