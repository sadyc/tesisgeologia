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
public class DCliente extends CPersona{
	protected Collection<HMuestra> muestras = new HashSet();
	
	/**
	 * Default constructor.
	 */
	public DCliente() {
		super();
	}
	
	/**
	 * Constructor con parametros.
	 * @param nombre, nombre del cliente creado.
	 * @param apellido, apellido del cliente creado.
	 * @param dni, DNI del cliente creado.
	 * @param email, direccion de e-mail del cliente creado.
	 * @param tel, numero de telefono del cliente creado.
	 */
	public DCliente(String nombre, String apellido, String dni, String email, String tel) {
		super(nombre, apellido, dni, tel, email);
	}
	
	/**
	 * Metodo que permite agregar una muestra al cliente.
	 * @param muestra, muestra a ser agregada al cliente.
	 */
	public void addMuestra (HMuestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra al cliente.
	 * @param muestra, muestra a ser eliminada al cliente.
	 */
	public void removeMuesra (HMuestra muestra){
		muestras.remove(muestra);
	}
	

	/**
	 * Metodo que me retorna las muestras correspondientes a el cliente.
	 * @return muestras, coleccion de muestras correspondientes cliente.
	 */
	public Collection<HMuestra> getMuestras(){
		return (muestras);
	}

	/**
	 * Metodo que me retorna la cantidad de muestras correspondientes a el cliente.
	 * @return la cantidad de muestras correspondientes a el cliente.
	 */
	public int getCantidadMuestras(){
		return (muestras.size());
	}
	
}