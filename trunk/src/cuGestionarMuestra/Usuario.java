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
	private String contraseña;
	
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
		return contraseña;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String toString(){
		return("nombre: " + nombreUsuario + "contraseña: " + contraseña);
	}
}
