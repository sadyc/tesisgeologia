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
	private Integer porcentajePasante;
	private Integer porcentajeRetenidoParcial;
	private Integer porcentajeRetenidoAcumulado;   //  FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	private Integer pesoRetenido;
	protected Muestra muestra;
	protected Tamiz tamiz;
	
	/**
	 * Constructor con parametros
	 */
	public Analisis(Integer pesoRetenido, Muestra muestra, Tamiz tamiz){
		this.pesoRetenido = pesoRetenido;
		this.muestra = muestra;
		this.tamiz=tamiz;
		calcularPorcentajeRetenidoParcial();
		calcularPorcentajePasante();
		
	}
	
	/**
	 * @return the porcentajePasante
	 */
	public Integer getPorcentajePasante() {
		return porcentajePasante;
	}
	
	/**
	 * @return the porcentajeRetenidoParcial
	 */
	public Integer getPorcentajeRetenidoParcial() {
		return porcentajeRetenidoParcial;
	}
	
	/**
	 * @return the porcentajeRetenidoAcumulado
	 */
	public Integer getPorcentajeRetenidoAcumulado() {
		return porcentajeRetenidoAcumulado;
	}
	
	/**
	 * @return the pesoRetenido
	 */
	public Integer getPesoRetenido() {
		return pesoRetenido;
	}
	/**
	 * @param pesoRetenido the pesoRetenido to set
	 */
	public void setPesoRetenido(Integer pesoRetenido) {
		this.pesoRetenido = pesoRetenido;
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
	 * Calcula el porcentaje retenido parcial del analisis de una muestra.
	 */
	public void calcularPorcentajeRetenidoParcial(){
		porcentajeRetenidoParcial=(pesoRetenido*100)/muestra.getPeso();
	}
	
	/**
	 * Calcula el porcentaje pasante del analisis de una muestra.
	 */
	public void calcularPorcentajePasante(){
		porcentajePasante=100-porcentajeRetenidoAcumulado;
	}
	
	/**
	 * Calcula el porcentaje retenido acumulado del analisis de una muestra. 
	 */
	public void calcularPorcentajeRetenidoAcumulado(){
		//muestra.getAnalisis();
	}
	
	/**
	 * 
	 */
	public String toString(){
		return ("%Pasante: "+porcentajePasante+", %Retenido Parcial: "+porcentajeRetenidoParcial+", %Retenido Acumulado: "+porcentajeRetenidoAcumulado+", Peso Retenido: "+pesoRetenido);
	}
}
