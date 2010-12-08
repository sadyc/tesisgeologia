/**
 * 
 */
package persistencia.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Implementacion de la clase que define la muestra
 * @author TesisGeologia
 * @version 1.0 24/09/2010 
 *
 */
@PersistenceCapable
public class Muestra {
 
	private String nombreMuestra;
	private Float profundidadInicial;
	private Float profundidadFinal;
	private Integer peso;
	private Date fecha;
	private Float coeficienteUniformidad;
	protected OperadorDeLaboratorio operadorLaboratorio ;
	protected Usuario usuario;
	protected Ubicacion ubicacion;
	protected Clasificacion clasificacion;
	protected Consistencia consistencia;
	
	protected Collection<Analisis> analisis= new HashSet();
	/**
	 * Default contructors
	 */
	public Muestra() {
		nombreMuestra = "";
		profundidadInicial= new Float(0);
		profundidadFinal= new Float(0);
		peso= -1;
		operadorLaboratorio = new OperadorDeLaboratorio();
		usuario = new Usuario();
		ubicacion = new Ubicacion();
		clasificacion = new Clasificacion();
		consistencia = new Consistencia();
		fecha = new Date(11,22,1980);
	}
	
	/**
	 * Constructors whit parameters
	 * @param idMuestra identificador de la muestra creada
	 * @param tipo Indica el tipo de la muestra
	 * @param profundidadInicial profundidad inicial de la muestra creada
	 * @param profundidadFinal profundidad final de la muestra creada
	 * @param peso peso de la muestra
	 */
	public Muestra(String nombreMuestra,Integer peso, float profundidadInicial,float profundidadFinal,  OperadorDeLaboratorio operador, Usuario usuario, Ubicacion ubicacion, Clasificacion clasificacion, Date fecha) {
		this.nombreMuestra = nombreMuestra;
		this.profundidadInicial = profundidadInicial;
		this.profundidadFinal = profundidadFinal;
		this.peso = peso;
		this.operadorLaboratorio = operador;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.clasificacion = clasificacion;
		this.fecha = fecha;
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
	public Float getProfundidadInicial() {
		return profundidadInicial;
	}
	
	/**
	 * Metodo que permite setear profundidadInicial de la Muestra
	 * @param profundidadInicial the profundidadInicial to set
	 */
	public void setProfundidadInicial(Float profundidadInicial) {
		this.profundidadInicial = profundidadInicial;
	}
	
	/**
	 * Metodo que permite obtener la profundidadFinal
	 * @return the profundidadFinal
	 */
	public Float getProfundidadFinal() {
		return profundidadFinal;
	}
	
	/**
	 * Metodo que permite setear profundidadFinal de la Muestra
	 * @param profundidadFinal the profundidadFinal to set
	 */
	public void setProfundidadFinal(Float profundidadFinal) {
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
	 * @return the operadorLaboratorio
	 */
	public OperadorDeLaboratorio getOperador() {
		return operadorLaboratorio;
	}

	/**
	 * Metodo que elimina el operadorLaboratorio cargado
	 */
	public void removeOperador() {
		operadorLaboratorio=null;
	}
	
	/**
	 * @param operadorLaboratorio the operadorLaboratorio to set
	 */
	public void setOperador(OperadorDeLaboratorio operador) {
		this.operadorLaboratorio = operador;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the ubicacion
	 */
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the clasificacion
	 */
	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	/**
	 * @param nombreMuestra the nombreMuestra to set
	 */
	public void setNombreMuestra(String nombreMuestra) {
		this.nombreMuestra = nombreMuestra;
	}

	/**
	 * @return the operadorLaboratorio
	 */
	public OperadorDeLaboratorio getOperadorLaboratorio() {
		return operadorLaboratorio;
	}

	/**
	 * @param operadorLaboratorio the operadorLaboratorio to set
	 */
	public void setOperadorLaboratorio(OperadorDeLaboratorio operadorLaboratorio) {
		this.operadorLaboratorio = operadorLaboratorio;
	}

	/**
	 * @return the consistencia
	 */
	public Consistencia getConsistencia() {
		return consistencia;
	}

	/**
	 * @param consistencia the consistencia to set
	 */
	public void setConsistencia(Consistencia consistencia) {
		this.consistencia = consistencia;
	}

	/**
	 * @return the analisis
	 */
	public Collection<Analisis> getAnalisis() {
		return analisis;
	}

	/**
	 * @param analisis the analisis to set
	 */
	public void setAnalisis(Collection<Analisis> analisis) {
		this.analisis = analisis;
	}

}
