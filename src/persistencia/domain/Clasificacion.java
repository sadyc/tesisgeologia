/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

/**
 * @author TesisGeologia
 * @version 1.0
 */
@PersistenceCapable
public class Clasificacion {
	
	protected String nombre;
	protected String descripcion;
	private Float D60;
	private Float D30;
	private Float D10;
	private Float gradoCurvatura;
	private Float coeficienteUniformidad;
	protected Collection<Muestra> muestras = new HashSet();

	/**
	 * @brief Constructor por defecto.
	 */
	public Clasificacion() {
		nombre = new String();
		descripcion = new String();
		D60 = new Float(0);
		D30 = new Float(0);
		D10 = new Float(0);
		gradoCurvatura = new Float(0);
		coeficienteUniformidad = new Float(0);
	}
	
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Metodo que permite agregar una muestra a la clasificacion.
	 * @param muestra, muestra a ser agregada a la clasificacion.
	 */
	public void addMuestra (Muestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra a la clasificacion.
	 * @param muestra, muestra a ser eliminada a la clasificacion.
	 */
	public void removeMuesra (Muestra muestra){
		muestras.remove(muestra);
	}


	/**
	 * @return the d60
	 */
	public Float getD60() {
		return D60;
	}


	/**
	 * @param d60 the d60 to set
	 */
	public void setD60(Float d60) {
		D60 = d60;
	}


	/**
	 * @return the d30
	 */
	public Float getD30() {
		return D30;
	}


	/**
	 * @param d30 the d30 to set
	 */
	public void setD30(Float d30) {
		D30 = d30;
	}


	/**
	 * @return the d10
	 */
	public Float getD10() {
		return D10;
	}


	/**
	 * @param d10 the d10 to set
	 */
	public void setD10(Float d10) {
		D10 = d10;
	}


	/**
	 * @return the gradoCurvatura
	 */
	public Float getGradoCurvatura() {
		return gradoCurvatura;
	}


	/**
	 * @param gradoCurvatura the gradoCurvatura to set
	 */
	public void setGradoCurvatura(Float gradoCurvatura) {
		this.gradoCurvatura = gradoCurvatura;
	}
	
	/**
	 * @return the coeficienteUniformidad
	 */
	public Float getCoeficienteUniformidad() {
		return coeficienteUniformidad;
	}


	/**
	 * @param coeficienteUniformidad the coeficienteUniformidad to set
	 */
	public void setCoeficienteUniformidad(Float coeficienteUniformidad) {
		this.coeficienteUniformidad = coeficienteUniformidad;
	}

}
