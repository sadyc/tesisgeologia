/**
 * 
 */
package Domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Implementacion de la clase que define una Persona. 
 * @author TesisGeologia
 * @version 1.0  21/09/10
 */
@PersistenceCapable
public class Persona { 
	
	private String nombre;
	private String apellido;
	private Integer dni;
	
	/**
	 * Default constructor
	 */
	public Persona (){
		this.nombre = null;
		this.apellido = null;
		this.dni = -1;
	}
	
	/**
	 * Constructor with parameters
	 * @param nombre, nombre de la persona creada.
	 * @param apellido, apellido de la persona creada.
	 * @param dni, DNI de la persona creada.
	 */
	public Persona(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	

	/**
	 * Metodo que permite obtener el nombre de la persona.
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Metodo que permite setear el nombre de la persona.
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Metodo que permite obtener el Apellido de la persona.
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * Metodo que permite setear el apellido de la persona.
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * Metodo que permite obtener el DNI de la persona.
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}


	/**
	 * Metodo que permite setear el DNI de la persona.
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}

}
