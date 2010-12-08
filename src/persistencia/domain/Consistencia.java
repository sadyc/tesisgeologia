/**
 * 
 */
package persistencia.domain;

import javax.jdo.annotations.PersistenceCapable;

/**
 * @author manuvarel
 *
 */
@PersistenceCapable
public class Consistencia {
	private Float limitePlastico;
	private Float limiteLiquido;
	private Float indicePlasticidad;
	private Muestra muestra;
	
		
	/**
	 * Default constructor
	 */
	public Consistencia () {
		limitePlastico = null;
		limiteLiquido = null;
		indicePlasticidad=null;
	
	}
	
	/**
	 * @param limitePlastico, es el valor de limite plastico correspondiente al analisis de consistencia.
	 * @param limiteLiquido, es el valor de limite l�quido correspondiente al analisis de consistencia.
	 * @param muestra, es la muestra a la cual corresponde el analisis de consistencia.
	 */
	public Consistencia(Float limitePlastico, Float limiteLiquido, Muestra muestra) {
		this.limitePlastico = limitePlastico;
		this.limiteLiquido = limiteLiquido;
		calcularIndicePlasticidad();
		this.muestra = muestra;
	}
	
	
	/**
	 * @return the limitePlastico
	 */
	public Float getLimitePlastico() {
		return limitePlastico;
	}
	/**
	 * @param limitePlastico the limitePlastico to set
	 */
	public void setLimitePlastico(Float limitePlastico) {
		this.limitePlastico = limitePlastico;
	}
	/**
	 * @return the limiteLiquido
	 */
	public Float getLimiteLiquido() {
		return limiteLiquido;
	}
	/**
	 * @param limiteLiquido the limiteLiquido to set
	 */
	public void setLimiteLiquido(Float limiteLiquido) {
		this.limiteLiquido = limiteLiquido;
	}
	/**
	 * @return the indicePlasticidad
	 */
	public Float getIndicePlasticidad() {
		return indicePlasticidad;
	}
	/**
	 * @param indicePlasticidad the indicePlasticidad to set
	 */
	public void setIndicePlasticidad(Float indicePlasticidad) {
		this.indicePlasticidad= indicePlasticidad;
	}
	
	/**
	 * @return the muestra
	 */
	public Muestra getMuestra() {
		return muestra;
	}
	/**
	 * @param muestra the muestra to set
	 */
	public void setMuestra(Muestra muestra) {
		this.muestra = muestra;
	}
	
	/**
	 * Metodo que calcula el Indice de Plasticidad.
	 */
	public void calcularIndicePlasticidad(){
		indicePlasticidad = limitePlastico - limiteLiquido;
	}
}
