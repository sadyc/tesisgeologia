package persistencia.domain;



import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Esta clase define la ubicacion de una muestra con persistencia.
 * 
 * @author tesisGeologia
 *
 * @version 1.0.
 */
@PersistenceCapable 
public class Ubicacion {
	
	private String latitud;
	
	private String longitud;
	private String nombreUbicacion;
	public String ciudad;
	private String provincia;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Collection<Muestra> muestras = new HashSet();
	
	/**
	 *Contructor por defecto.
	 */
	public Ubicacion(){
		nombreUbicacion= "";
		provincia = null;
		latitud = "";
		longitud = "";
	}
	
	/**
	 *Contructor con pasaje de parametros.
	 */
	public Ubicacion(String nombreUbicacion,String ciudad, String prov, String latitud, String longitud){
		this.nombreUbicacion= nombreUbicacion;
		this.ciudad = ciudad;
		this.provincia = prov;
		this.latitud = latitud;
		this.longitud = longitud;
	}




		/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the prov
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param prov the prov to set
	 */
	public void setProvincia(String prov) {
		this.provincia = prov;
	}

	/**
	 * @return the nombreUbicacion
	 */
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	/**
	 * @param nombreUbicacion the nombreUbicacion to set
	 */
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	
	/**
	 * Metodo que permite agregar una muestra a la ubicacion
	 * @param muestra, muestra a ser agregada a la ubicacion.
	 */
	public void addMuestra (Muestra muestra){
		this.muestras.add(muestra);
	}
	
	/**
	 * Metodo que permite quitar una muestra a la ubicacion.
	 * @param muestra, muestra a ser eliminada a la ubicacion.
	 */
	public void removeMuesra (Muestra muestra){
		muestras.remove(muestra);
	}
	

	/**
	 * Metodo que me retorna las muestras tomadas en una ubicacion.
	 * @return muestras, coleccion de muestras tomadas en una ubicacion.
	 */
	public Collection<Muestra> getMuestras(){
		return (muestras);
	}

	/**
	 * Metodo que me retorna la cantidad de muestras tomadas en una ubicacion.
	 * @return la cantidad de muestras tomadas en una ubicacion.
	 */
	public int getCantidadMuestras(){
		return (muestras.size());
	}
	
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String toString(){
		return nombreUbicacion;
	}
	
	public boolean equals(Ubicacion ubicacion){
		return (this.latitud.equals(ubicacion.getLatitud()) && this.longitud.equals(ubicacion.getLongitud())); 
	}
	
}