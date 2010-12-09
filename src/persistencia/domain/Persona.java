/**
 * 
 */
package persistencia.domain;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Implementacion de la clase que define una Persona. 
 * @author TesisGeologia
 * @version 1.0  21/09/10
 */
@PersistenceCapable
public class Persona { 
	
	private String nombre;
	private String apellido;
	private String dni;
	private String tel;
	private String email;
	
	
	/**
	 * Default constructor
	 */
	public Persona (){
		this.nombre = null;
		this.apellido = null;
		this.dni = null;
		this.tel = null;
		this.email = null;
	}
	
	/**
	 * Constructor with parameters
	 * @param nombre, nombre de la persona creada.
	 * @param apellido, apellido de la persona creada.
	 * @param dni, DNI de la persona creada.
	 */
	public Persona(String nombre, String apellido, String dni, String tel, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tel = tel;
		this.email = email;
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
	public String getDni() {
		return dni;
	}


	/**
	 * Metodo que permite setear el DNI de la persona.
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo que permite obtener el telefono de la persona.
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Metodo que permite setear el telefono de la persona
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Metodo que permite obtener el e-Mail de la persona.
	 * @return the eMail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que permite setear el e-Mail de la persona
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
