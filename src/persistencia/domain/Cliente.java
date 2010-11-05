/**
 * 
 */
package persistencia.domain;

/**
 * @author TesisGeologia
 *
 */
public class Cliente {
	private String nombre;
	private String apellido;
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return ("nombre: " + nombre + " apellido: "+apellido);
	}
}