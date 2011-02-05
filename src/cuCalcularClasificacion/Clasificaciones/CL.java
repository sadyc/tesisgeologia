package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class CL extends LimosYArcillasMenor50 {

	/**
	 * Constructor por defecto.
	 */
	public CL() {
		this.descripcion="Arcillas inorgánicas de plasticidad baja a media, arcillas con grava, arcillas arenosas, arcillas limosas.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public CL(String descripcion) {
		super(descripcion);
	}
}
