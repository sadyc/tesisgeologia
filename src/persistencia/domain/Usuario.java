/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;



/**
 * @author TesisGeologia
 *
 */
@PersistenceCapable
public class Usuario extends Persona{
	private String nombreUsuario;
	private String password;
	protected Collection<Muestra> muestras = new HashSet();
	
	public Usuario (){
		super();
		
	}
	public Usuario (String nombre, String apellido, String dni, String tel, String email,String nombreUsuario, String password){
		super(nombre, apellido,dni,tel, email);
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		
	}
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

	/**
	 * Metodo que permite agregar una muestra al usuario.
	 * @param muestra, muestra a ser agregada al usuario.
	 */
	public void addMuestra (Muestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra al usuario.
	 * @param muestra, muestra a ser eliminada al usuario.
	 */
	public void removeMuesra (Muestra muestra){
		muestras.remove(muestra);
	}
	

	/**
	 * Metodo que me retorna las muestras tomadas por el usuario.
	 * @return muestras, coleccion de muestras tomadas por el usuario.
	 */
	public Collection getMuestras(){
		return (muestras);
	}

	/**
	 * Metodo que me retorna la cantidad de muestras tomadas por el usuario.
	 * @return la cantidad de muestras tomadas por el usuario.
	 */
	public int getCantidadMuestras(){
		return (muestras.size());
	}
	
	public String toString(){
		return("nombre: " + nombreUsuario + "contraseña: " + password);
	}
}
