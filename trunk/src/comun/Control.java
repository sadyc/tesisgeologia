/**
 * 
 */
package comun;

/**
 * Clase que se utiliza para que cada control extienda a esta clase.
 * @author tesisGeologia
 *
 */
public abstract class Control {
	
	protected boolean yaExiste;
	
	/**
	 * Retorna si un objeto a insertar ya existe en la base de datos.
	 * @return yaExiste
	 */
	public boolean yaExiste(){
		return yaExiste;
	}
}
