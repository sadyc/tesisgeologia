/**
 * 
 */
package cuGestionarAnalisis;

import java.util.HashSet;
import java.util.Collection;


/**
 * @author TesisGeologia
 *
 */
public class Tamiz {
	private Integer numeroTamiz;
	private Integer aberturaDeMalla;
	protected Collection<Analisis> analisisTamiz = new HashSet();
	
	/**
	 * Constructor con parametros
	 */
	public Tamiz(Integer numeroTamiz, Integer aberturaDeMalla, Collection<Analisis> analisisTamiz) {
		this.numeroTamiz = numeroTamiz;
		this.aberturaDeMalla = aberturaDeMalla;
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
	 * @return the aberturaDeMalla
	 */
	public Integer getAberturaDeMalla() {
		return aberturaDeMalla;
	}
	/**
	 * @param aberturaDeMalla the aberturaDeMalla to set
	 */
	public void setAberturaDeMalla(Integer aberturaDeMalla) {
		this.aberturaDeMalla = aberturaDeMalla;
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
		return ("numeroTamiz= " + numeroTamiz + ", aberturaDeMalla= "+ aberturaDeMalla );
	}
	
}
