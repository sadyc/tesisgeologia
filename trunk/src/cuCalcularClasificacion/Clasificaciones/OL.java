package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class OL extends LimosYArcillasMenor50 {

	/**
	 * Constructor por defecto.
	 */
	public OL() {
		this.descripcion="Limos orgánicos y arcillas orgánicas limosas de baja plasticidad.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public OL(String descripcion) {
		super(descripcion);
	}
}
