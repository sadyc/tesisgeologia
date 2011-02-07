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
	private Float peso;
	private java.sql.Date fecha;
	private Float limitePlastico;
	private Float limiteLiquido;
	private Float indicePlasticidad;
	
	protected OperadorDeLaboratorio operadorLaboratorio ;
	protected Usuario usuario;
	protected Ubicacion ubicacion;
	
	protected AASHTO aashto;
	protected SUCS sucs;
	
	
	protected Collection<Analisis> analisis= new HashSet();
	/**
	 * Default contructors
	 */
	public Muestra() {
		nombreMuestra = "";
		profundidadInicial= new Float(0);
		profundidadFinal= new Float(0);
		peso= new Float(0);
		operadorLaboratorio = new OperadorDeLaboratorio();
		usuario = new Usuario();
		ubicacion = new Ubicacion();
		aashto = new AASHTO();
		sucs = new SUCS();
		
		java.util.Date f = new java.util.Date();
		fecha = new java.sql.Date(f.getTime());
	}
	
	/**
	 * Constructors whit parameters
	 * @param idMuestra identificador de la muestra creada
	 * @param tipo Indica el tipo de la muestra
	 * @param profundidadInicial profundidad inicial de la muestra creada
	 * @param profundidadFinal profundidad final de la muestra creada
	 * @param peso peso de la muestra
	 */
	public Muestra(String nombreMuestra,Float peso, Float profundidadInicial,Float profundidadFinal, OperadorDeLaboratorio operador, Usuario usuario, Ubicacion ubicacion, java.sql.Date fecha) {
		this.nombreMuestra = nombreMuestra;
		this.profundidadInicial = profundidadInicial;
		this.profundidadFinal = profundidadFinal;
		this.peso = peso;
		this.operadorLaboratorio = operador;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.aashto = new AASHTO();
		this.sucs = new SUCS();
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
	public Float getPeso() {
		return peso;
	}
	
	/**
	 * Metodo que permite setear peso de la Muestra
	 * @param peso the peso to set
	 */
	public void setPeso(Float peso) {
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
	 * @return the fecha
	 */
	public java.sql.Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
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
	
	/**
	 * Metodo que calcula el Indice de Plasticidad.
	 */
	public void calcularIndicePlasticidad(){
		indicePlasticidad = limiteLiquido - limitePlastico;
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
		this.indicePlasticidad = indicePlasticidad;
	}
	
	/**
	 * @return the aashto
	 */
	public AASHTO getAashto() {
		return aashto;
	}

	/**
	 * @param aashto the aashto to set
	 */
	public void setAashto(AASHTO aashto) {
		this.aashto = aashto;
	}

	/**
	 * @return the sucs
	 */
	public SUCS getSucs() {
		return sucs;
	}

	/**
	 * @param sucs the sucs to set
	 */
	public void setSucs(SUCS sucs) {
		this.sucs = sucs;
	}

	
	
}
