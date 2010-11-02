/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;



/**
 * Implementacion de la clase que define la muestra
 * @author TesisGeologia
 * @version 1.0 24/09/2010 
 *
 */
@PersistenceCapable
public class Muestra {
 
	private String nombreMuestra;
	private float profundidadInicial;
	private float profundidadFinal;
	private Integer peso;
	private Date fecha;
	private float coeficienteUniformidad;
	protected OperadorDeLaboratorio operador ;
	protected Usuario usuario;
	
	

	/**
	 * Default contructors
	 */
	public Muestra() {
		nombreMuestra = "";
		profundidadInicial= -1;
		profundidadFinal= -1;
		peso= -1;
		operador = new OperadorDeLaboratorio();
	}
	
	/**
	 * Constructors whit parameters
	 * @param idMuestra identificador de la muestra creada
	 * @param tipo Indica el tipo de la muestra
	 * @param profundidadInicial profundidad inicial de la muestra creada
	 * @param profundidadFinal profundidad final de la muestra creada
	 * @param peso peso de la muestra
	 */
	public Muestra(String nombreMuestra,Integer peso, float profundidadInicial,float profundidadFinal,  OperadorDeLaboratorio operador) {
		this.nombreMuestra = nombreMuestra;
		this.profundidadInicial = profundidadInicial;
		this.profundidadFinal = profundidadFinal;
		this.peso = peso;
		this.operador = operador;
	}
		
	/**
	 * Metodo que permite obtener el id Muestra
	 * @return the idMuestra
	 */
	public String getNombreMuestra() {
		return nombreMuestra;
	}
	
	/**
	 * Metodo que permite setear idMuestra de la Muestra
	 * @param idMuestra the idMuestra to set
	 */
	public void setIdMuestra(String nombreMuestra) {
		this.nombreMuestra = nombreMuestra;
	}
	
	/**
	 * Metodo que permite obtener la profundidadInicial
	 * @return the profundidadInicial
	 */
	public float getProfundidadInicial() {
		return profundidadInicial;
	}
	
	/**
	 * Metodo que permite setear profundidadInicial de la Muestra
	 * @param profundidadInicial the profundidadInicial to set
	 */
	public void setProfundidadInicial(float profundidadInicial) {
		this.profundidadInicial = profundidadInicial;
	}
	
	/**
	 * Metodo que permite obtener la profundidadFinal
	 * @return the profundidadFinal
	 */
	public float getProfundidadFinal() {
		return profundidadFinal;
	}
	
	/**
	 * Metodo que permite setear profundidadFinal de la Muestra
	 * @param profundidadFinal the profundidadFinal to set
	 */
	public void setProfundidadFinal(float profundidadFinal) {
		this.profundidadFinal = profundidadFinal;
	}
	
	/**
	 * Metodo que permite obtener el peso
	 * @return the peso
	 */
	public Integer getPeso() {
		return peso;
	}
	
	/**
	 * Metodo que permite setear peso de la Muestra
	 * @param peso the peso to set
	 */
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	/**
	 * @return the operador
	 */
	public OperadorDeLaboratorio getOperador() {
		return operador;
	}

	/**
	 * Metodo que elimina el operador cargado
	 */
	public void removeOperador() {
		operador=null;
	}
	
	/**
	 * @param operador the operador to set
	 */
	public void setOperador(OperadorDeLaboratorio operador) {
		this.operador = operador;
	}

}
