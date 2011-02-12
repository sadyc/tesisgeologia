/**
 * 
 */
package cuGestionarUbicacion;

import persistencia.Persistencia;
import persistencia.domain.Ubicacion;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * @author TesisGeologia.
 *
 */
public class ControlGestionarUbicacion {

	/**
	 * Contructor por defecto.
	 */
	public ControlGestionarUbicacion() {
	}
	
	/**
	 * Metodo para insertar una ubicacion.
	 * @param data
	 * @throws Exception
	 */
	public void insertarUbicacion (String[] data) throws Exception{
		Persistencia persistencia= new Persistencia();
		persistencia.abrirTransaccion();
		Ubicacion ubicacion = new Ubicacion();
		ubicacion.setProvincia(data[1]);
		ubicacion.setCiudad(data[2]);
		ubicacion.setNombreUbicacion(data[3]);
		ubicacion.setLatitud(Float.parseFloat(data[4]));
		ubicacion.setLongitud(Float.parseFloat(data[5]));
		persistencia.insertarObjeto(ubicacion);
		persistencia.cerrarTransaccion();
	}	

}
