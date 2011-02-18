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
public class DUsuario extends CPersona{
	private String nombreUsuario;
	private String password;
	private String categoria;
	protected Collection<HMuestra> muestras = new HashSet();
	
	public DUsuario (){
		super();
		
	}
	public DUsuario (String nombre, String apellido, String dni, String nombreUsuario, String categoria,String email, String tel, String password){
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
	public void addMuestra (HMuestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra al usuario.
	 * @param muestra, muestra a ser eliminada al usuario.
	 */
	public void removeMuesra (HMuestra muestra){
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
