/**
 * 
 */
package persistencia.domain;

import javax.jdo.annotations.PersistenceCapable;


/**
 * @author TesisGeologia
 *
 */
@PersistenceCapable
public class Analisis {
	private Float pesoRetenido;
	private Float porcentajePasante;
	private Float porcentajeRetenidoParcial;
	private Float porcentajeRetenidoAcumulado;   //  FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	protected Muestra muestra;
	protected Tamiz tamiz;
	
	
	/**
	 * Constructor por defecto
	 */
	public Analisis(){
		pesoRetenido= null;
		porcentajePasante= null;
		porcentajeRetenidoParcial=null;
		porcentajeRetenidoAcumulado=null;
		muestra = new Muestra();
		tamiz = new Tamiz();
	}
	
	
	/**
	 * Constructor con parametros
	 */
	public Analisis(Float pesoRetenido, Muestra muestra, Tamiz tamiz){
		this.pesoRetenido = pesoRetenido;
		this.muestra = muestra;
		this.tamiz=tamiz;
	}
	
	/**
	 * @return the porcentajePasante
	 */
	public Float getPorcentajePasante() {
		return porcentajePasante;
	}
	
	/**
	 * @return the porcentajeRetenidoParcial
	 */
	public Float getPorcentajeRetenidoParcial() {
		return porcentajeRetenidoParcial;
	}
	
	/**
	 * @return the porcentajeRetenidoAcumulado
	 */
	public Float getPorcentajeRetenidoAcumulado() {
		return porcentajeRetenidoAcumulado;
	}
	
	/**
	 * @return the pesoRetenido
	 */
	public Float getPesoRetenido() {
		return pesoRetenido;
	}
	/**
	 * @param f the pesoRetenido to set
	 */
	public void setPesoRetenido(Float f) {
		this.pesoRetenido = f;
		//calcularPorcentajeRetenidoParcial();
		//calcularPorcentajePasante();
		
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
	 * @return the tamiz
	 */
	public Tamiz getTamiz() {
		return tamiz;
	}
	/**
	 * @param tamiz the tamiz to set
	 */
	public void setTamiz(Tamiz tamiz) {
		this.tamiz = tamiz;
	}
		
	/**
	 * 
	 */
	public String toString(){
		return ("%Pasante: "+porcentajePasante+", %Retenido Parcial: "+porcentajeRetenidoParcial+", %Retenido Acumulado: "+porcentajeRetenidoAcumulado+", Peso Retenido: "+pesoRetenido);
	}
	
	/**
	 * @param porcentajeRetenidoAcumulado the porcentajeRetenidoAcumulado to set
	 */
	public void setPorcentajeRetenidoAcumulado(Float porcentajeRetenidoAcumulado) {
		this.porcentajeRetenidoAcumulado = porcentajeRetenidoAcumulado;
	}
	
	/**
	 * @param f the porcentajeRetenidoParcial to set
	 */
	public void setPorcentajeRetenidoParcial(Float f) {
		this.porcentajeRetenidoParcial = f;
	}
	
	/**
	 * @param porcentajePasante the porcentajePasante to set
	 */
	public void setPorcentajePasante(Float porcentajePasante) {
		this.porcentajePasante = porcentajePasante;
	}
}
