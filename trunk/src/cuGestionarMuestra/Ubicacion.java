package cuGestionarMuestra;

public class Ubicacion {

	private enum Provincia {BuenosAires,Catamarca,Chaco,Chubut,CiudadAutónomadeBuenosAires,
	Córdoba,Corrientes,EntreRíos,Formosa,Jujuy,LaPampa,LaRioja,Mendoza,Misiones,Neuquén,RíoNegro,
	Salta,SanJuan,SanLuis,SantaCruz,SantaFe,SantiagoDelEstero,TierraDelFuego,Tucumán};
	private String Latitud;
	private String Longitud;
	private Provincia prov;
	private String nombreUbicacion;
	
	public Ubicacion(){
		Provincia prov = null;
		Latitud = "";
		Longitud = "";		
	}
	
	public Ubicacion(Provincia prov,String Latitud, String Longitud){
		this.prov = prov;
		this.Latitud = Latitud;
		this.Longitud = Longitud;
	}




	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return Latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return Longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		Longitud = longitud;
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