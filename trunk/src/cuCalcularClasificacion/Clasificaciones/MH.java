/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class MH extends LimosYArcillasMayor50 {

	/**
	 * Constructor por defecto.
	 */
	public MH() {
		this.descripcion="Limos inorgánicos, suelos arenosos finos o limosos con mica o diatomeas, limos elásticos.";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public MH(String descripcion) {
		super(descripcion);
	}

}
