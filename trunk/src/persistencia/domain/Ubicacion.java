package persistencia.domain;



import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Ubicacion {
	

	private String nombreUbicacion;
	public enum Provincia {BuenosAires,Catamarca,Chaco,Chubut,CiudadAutonomadeBuenosAires,Cordoba,Corrientes,EntreRíos,Formosa,Jujuy,LaPampa,LaRioja,Mendoza,Misiones,Neuquen,RíoNegro,Salta,SanJuan,SanLuis,SantaCruz,SantaFe,SantiagoDelEstero,TierraDelFuego,Tucuman};
	private String latitud;
	private String longitud;
	private Provincia prov;
	
	private Collection muestras = new HashSet();
	
	
	public Ubicacion(){
		nombreUbicacion= "";
		prov = null;
		latitud = "";
		longitud = "";		
	}
	
	public Ubicacion(String nombreUbicacion, Provincia prov, String latitud, String longitud){
		this.nombreUbicacion= nombreUbicacion;
		this.prov = prov;
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
	public Provincia getProvincia() {
		return prov;
	}

	/**
	 * @param prov the prov to set
	 */
	public void setProvincia(Provincia prov) {
		this.prov = prov;
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
	
	
}