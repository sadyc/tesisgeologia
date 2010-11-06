/**
 * 
 */
package persistencia.domain;

import javax.jdo.annotations.PersistenceCapable;



/**
 * @author TesisGeologia
 *
 */
@PersistenceCapable
public class Usuario extends Persona{
	private String nombreUsuario;
	private String password;
	
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the contrase�a
	 */
	public String getContrase�a() {
		return password;
	}
	/**
	 * @param contrase�a the contrase�a to set
	 */
	public void setContrase�a(String contrase�a) {
		this.password = contrase�a;
	}
	
	public String toString(){
		return("nombre: " + nombreUsuario + "contrase�a: " + password);
	}
}
