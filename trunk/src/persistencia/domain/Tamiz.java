/**
 * 
 */
package persistencia.domain;

import java.util.HashSet;
import java.util.Collection;

import javax.jdo.annotations.PersistenceCapable;


/**
 * @author TesisGeologia
 *
 */
@PersistenceCapable
public class Tamiz {
	private Integer numeroTamiz;
	private Double aberturaMalla;
	protected Collection<Analisis> analisis = new HashSet();
	
	/**
	 * Constructor por defecto
	 */
	public Tamiz(){
		numeroTamiz = 0;
		aberturaMalla = 0.0;
	}
	
	/**
	 * Constructor con parametros
	 */
	public Tamiz(Integer numeroTamiz, Double aberturaMalla) {
		this.numeroTamiz = numeroTamiz;
		this.aberturaMalla = aberturaMalla;
	}
	/**
	 * @return the numeroTamiz
	 */
	public Integer getNumeroTamiz() {
		return numeroTamiz;
	}
	/**
	 * @param numeroTamiz the numeroTamiz to set
	 */
	public void setNumeroTamiz(Integer numeroTamiz) {
		this.numeroTamiz = numeroTamiz;
	}
	/**
	 * @return the aberturaMalla
	 */
	public Double getAberturaMalla() {
		return aberturaMalla;
	}
	/**
	 * @param aberturaMalla the aberturaMalla to set
	 */
	public void setAberturaMalla(Double aberturaMalla) {
		this.aberturaMalla = aberturaMalla;
	}
	/**
	 * @return the muestras
	 */
	public Collection<Analisis> getMuestras() {
		return analisis;
	}
	/**
	 * @param muestras the muestras to set
	 */
	public void setAnalisisTamiz(Collection<Analisis> analisisTamiz) {
		this.analisis = analisisTamiz;
	}
	
	/** 
	 * 
	 */
	public String toString() {
		return ("Numero Tamiz= " + numeroTamiz + ", Abertura De Malla= "+ aberturaMalla );
	}
	
}
