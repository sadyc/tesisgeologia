/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class Gravas extends GranoGrueso {

	/**
	 * Constructor por defecto.
	 */
	public Gravas() {
		this.descripcion="M�s de la mitad de la fracci�n gruesa es retenida por el tamiz n�mero 4 (4,76 mm)";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public Gravas(String descripcion) {
		super(descripcion);
	}

}
