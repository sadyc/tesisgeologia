/**
 * 
 */
package cuCalcularClasificacion.Clasificaciones;

/**
 * @author TesisGeologia.
 * @version 1.0.
 */
public class GranoGrueso extends SUCS {

	/**
	 * Constructor por defecto.
	 */
	public GranoGrueso() {
		this.descripcion="Más de la mitad del material retenido en el tamiz número 200";
	}

	/**
	 * Constructor con parametros de la clase.
	 * @param descripcion, es la descripcion de la clasificacion a crear.
	 */
	public GranoGrueso(String descripcion) {
		super(descripcion);
	}

}
