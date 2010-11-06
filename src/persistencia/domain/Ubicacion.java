package persistencia.domain;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Ubicacion {

	private enum Provincia {BuenosAires,Catamarca,Chaco,Chubut,CiudadAutónomadeBuenosAires,
	Córdoba,Corrientes,EntreRíos,Formosa,Jujuy,LaPampa,LaRioja,Mendoza,Misiones,Neuquén,RíoNegro,
	Salta,SanJuan,SanLuis,SantaCruz,SantaFe,SantiagoDelEstero,TierraDelFuego,Tucumán};
	private String latitud;
	private String longitud;
	private Provincia prov;
	private String nombreUbicacion;
	
	public Ubicacion(){
		Provincia prov = null;
		latitud = "";
		longitud = "";		
	}
	
	public Ubicacion(Provincia prov,String latitud, String longitud){
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
	public Provincia getProv() {
		return prov;
	}

	/**
	 * @param prov the prov to set
	 */
	public void setProv(Provincia prov) {
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