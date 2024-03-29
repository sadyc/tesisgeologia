/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;



/**
 * Esta clase define un usuario con persistencia.
 * 
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
@PersistenceCapable
public class Usuario extends Persona{
	private String nombreUsuario;
	private String password;
	private String categoria;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Collection<Muestra> muestras = new HashSet();
	
	public Usuario (){
		super();
		
	}
	public Usuario (String nombre, String apellido, String dni, String nombreUsuario, String categoria,String email, String tel, String password){
		super(nombre, apellido,dni,tel, email);
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.categoria = categoria;
		
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
	public String getPassword() {
		return password;
	}
	/**
	 * @param contrase�a the contraseña to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	@SuppressWarnings("rawtypes")
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
		return("nombre: " + nombreUsuario + "contrase�a: " + password);
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
