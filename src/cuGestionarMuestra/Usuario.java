/**
 * 
 */
package cuGestionarMuestra;


/**
 * @author TesisGeologia
 *
 */
public class Usuario extends Persona{
	private String nombreUsuario;
	private String contrase�a;
	
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
		return contrase�a;
	}
	/**
	 * @param contrase�a the contrase�a to set
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public String toString(){
		return("nombre: " + nombreUsuario + "contrase�a: " + contrase�a);
	}
}
