/**
 * 
 */
package cuGestionarUbicacion;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
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
		ubicacion.setNombreUbicacion(data[0]);
		ubicacion.setCiudad(data[1]);
		ubicacion.setProvincia(data[2]);
		ubicacion.setLatitud(Float.parseFloat(data[3]));
		ubicacion.setLongitud(Float.parseFloat(data[4]));
		persistencia.insertarObjeto(ubicacion);
		persistencia.cerrarTransaccion();
	}

	
	/**
	 * Modifica una ubicacion con persistencia.
	 * @param ciudad 
	 * @param nombreUbicacion 
	 * @param data
	 * @throws Exception
	 */
	public void modificarUbicacion(String nombreUbicacion, String ciudad, String[] data) throws Exception {
		Persistencia persistencia= new Persistencia();
		persistencia.abrirTransaccion();
		Ubicacion ubicacion = new Ubicacion();
		ubicacion = (Ubicacion)persistencia.buscarObjeto(ubicacion.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
		ubicacion.setNombreUbicacion(data[0]);
		ubicacion.setCiudad(data[1]);
		ubicacion.setProvincia(data[2]);
		ubicacion.setLatitud(Float.parseFloat(data[3]));
		ubicacion.setLongitud(Float.parseFloat(data[4]));
		persistencia.insertarObjeto(ubicacion);
		persistencia.cerrarTransaccion();
		
	}

	/**
	 * Metodo para eliminar una Ubicacion con presistencia.
	 * @param nombreUbicacion
	 * @param ciudad
	 * @throws Exception
	 */
	public void eliminarUbicacion(String nombreUbicacion, String ciudad) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Ubicacion ubicacion = new Ubicacion();
		ubicacion = (Ubicacion)persistencia.buscarObjeto(ubicacion.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
		persistencia.eliminarObjeto(ubicacion);
		persistencia.cerrarTransaccion();
	}

	/**
	 * Retorna la ubicacion persistente que cumpla con el nombre y la ciudad pasado como parametro.
	 * @param nombreUbicacion
	 * @param ciudad
	 * @return
	 */
	public Ubicacion obtenerUbicacion (String nombreUbicacion,String ciudad) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Ubicacion aux = new Ubicacion();
		try {
			aux =(Ubicacion)persistencia.buscarObjeto(aux.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

}
