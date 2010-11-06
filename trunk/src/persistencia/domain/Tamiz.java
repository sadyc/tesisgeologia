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
	private Integer aberturaMalla;
	protected Collection<Analisis> analisisTamiz = new HashSet();
	
	/**
	 * Constructor con parametros
	 */
	public Tamiz(Integer numeroTamiz, Integer aberturaDeMalla, Collection<Analisis> analisisTamiz) {
		this.numeroTamiz = numeroTamiz;
		this.aberturaMalla = aberturaDeMalla;
		this.analisisTamiz = analisisTamiz;
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
	public Integer getAberturaMalla() {
		return aberturaMalla;
	}
	/**
	 * @param aberturaMalla the aberturaMalla to set
	 */
	public void setAberturaMalla(Integer aberturaMalla) {
		this.aberturaMalla = aberturaMalla;
	}
	/**
	 * @return the muestras
	 */
	public Collection<Analisis> getMuestras() {
		return analisisTamiz;
	}
	/**
	 * @param muestras the muestras to set
	 */
	public void setanalisisTamiz(Collection<Analisis> analisisTamiz) {
		this.analisisTamiz = analisisTamiz;
	}
	
	/** 
	 * 
	 */
	public String toString() {
		return ("Numero Tamiz= " + numeroTamiz + ", Abertura De Malla= "+ aberturaMalla );
	}
	
}
