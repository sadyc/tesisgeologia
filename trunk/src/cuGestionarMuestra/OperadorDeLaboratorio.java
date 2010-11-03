/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

  
/**
 * Implementacion de la clase que define un operador de laboratorio
 * @author TesisGeologia
 * @version 1.0  24/09/2010
 */
@PersistenceCapable
public class OperadorDeLaboratorio extends Persona {

	protected Collection<Muestra> muestras = new HashSet();
	
	/**
	 * Default constructor.
	 */
	public OperadorDeLaboratorio() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 * @param nombre, nombre del operador de laboratorio creado.
	 * @param apellido, apellido del operador de laboratorio creado.
	 * @param dni, DNI del operador de laboratorio creado.
	 */
	public OperadorDeLaboratorio(String nombre, String apellido, String dni, String tel, String email) {
		super(nombre, apellido, dni, tel, email);
	}
	
	/**
	 * Metodo que permite agregar una muestra al operador de laboratorio
	 * @param muestra, muestra a ser agregada al operador de laboratorio.
	 */
	public void addMuestra (Muestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra al operador de laboratorio
	 * @param muestra, muestra a ser eliminada al operador de laboratorio.
	 */
	public void removeMuesra (Muestra muestra){
		muestras.remove(muestra);
	}
	

	/**
	 * Metodo que me retorna las muestras tomadas por el operador de laboratorio.
	 * @return muestras, coleccion de muestras tomadas por el operador de laboratorio.
	 */
	public Collection getMuestras(){
		return (muestras);
	}

	/**
	 * Metodo que me retorna la cantidad de muestras tomadas por el operador de laboratorio.
	 * @return la cantidad de muestras tomadas por el operador de laboratorio.
	 */
	public int getCantidadMuestras(){
		return (muestras.size());
	}
	
}
