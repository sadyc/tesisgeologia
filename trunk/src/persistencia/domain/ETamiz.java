/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


/**
 * @author TesisGeologia
 *
 */
@PersistenceCapable
public class ETamiz {
	
	private String numeroTamiz;
	private Double aberturaMalla;
	protected Collection<IAnalisis> analisis = new HashSet();
	
	/**
	 * Constructor por defecto
	 */
	public ETamiz(){
		numeroTamiz = new String();
		aberturaMalla = 0.0;
	}
	
	/**
	 * Constructor con parametros
	 */
	public ETamiz(String numeroTamiz, Double aberturaMalla) {
		this.numeroTamiz = numeroTamiz;
		this.aberturaMalla = aberturaMalla;
	}
	/**
	 * @return the numeroTamiz
	 */
	public String getNumeroTamiz() {
		return numeroTamiz;
	}
	/**
	 * @param numeroTamiz the numeroTamiz to set
	 */
	public void setNumeroTamiz(String numeroTamiz) {
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
	public Collection<IAnalisis> getMuestras() {
		return analisis;
	}
	/**
	 * @param muestras the muestras to set
	 */
	public void setAnalisisTamiz(Collection<IAnalisis> analisisTamiz) {
		this.analisis = analisisTamiz;
	}
	
	/** 
	 * 
	 */
	public String toString() {
		return ("Numero Tamiz= " + numeroTamiz + ", Abertura De Malla= "+ aberturaMalla );
	}
	
}
