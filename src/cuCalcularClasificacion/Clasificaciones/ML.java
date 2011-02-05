/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class ML extends LimosYArcillasMenor50 {

	/**
	 * Constructor por defecto.
	 */
	public ML() {
		this.descripcion="Limos inorg�nicos y arenas muy finas, limos l�mpios, arenas finas, limosas o arcillosa, o limos arcillosos con ligera pl�sticidad.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public ML(String descripcion) {
		super(descripcion);
	}
}
