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
	 * @return the contraseña
	 */
	public String getContraseña() {
		return password;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.password = contraseña;
	}
	
	public String toString(){
		return("nombre: " + nombreUsuario + "contraseña: " + password);
	}
}
