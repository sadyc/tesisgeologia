/**
 * 
 */
package cuGestionarAnalisis;

import cuGestionarMuestra.Muestra;

/**
 * @author TesisGeologia
 *
 */
public class Analisis {
	private Integer porcentajePasante;
	private Integer porcentajeRetenidoParcial;
	private Integer porcentajeRetenidoAcumulado;
	private Integer pesoRetenido;
	private Muestra muestra;
	private Tamiz tamiz;
	
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
	 * 
	 */
	public String toString(){
		return ("%Pasante: "+porcentajePasante+", %Retenido Parcial: "+porcentajeRetenidoParcial+", %Retenido Acumulado: "+porcentajeRetenidoAcumulado+", Peso Retenido: "+pesoRetenido);
	}
}
