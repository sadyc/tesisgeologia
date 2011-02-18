/**
 * 
 */
package cuGestionarUbicacion;

import persistencia.Persistencia;
import persistencia.domain.HMuestra;
import persistencia.domain.FUbicacion;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * @author TesisGeologia.
 *
 */
public class ControlGestionarUbicacion {
	private boolean yaExiste;
	
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
		yaExiste=false;
		Persistencia persistencia= new Persistencia();
		persistencia.abrirTransaccion();
		try{
			FUbicacion ubicacion = new FUbicacion();
			if (persistencia.buscarObjeto(ubicacion.getClass(), "ciudad=='"+data[1]+"' && 'nombreUbicacion=='"+data[0]+"'")==null){
				ubicacion.setNombreUbicacion(data[0]);
				ubicacion.setCiudad(data[1]);
				ubicacion.setProvincia(data[2]);
				ubicacion.setLatitud(data[3]);
				ubicacion.setLongitud(data[4]);
				persistencia.insertarObjeto(ubicacion);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarUbicacion insertar");
			persistencia.realizarRollback();
		}
		
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
		try{
			FUbicacion ubicacion = new FUbicacion();
			if (persistencia.buscarObjeto(ubicacion.getClass(), "ciudad=='"+data[1]+"' && 'nombreUbicacion=='"+data[0]+"'")==null){
				ubicacion = (FUbicacion)persistencia.buscarObjeto(ubicacion.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
				ubicacion.setNombreUbicacion(data[0]);
				ubicacion.setCiudad(data[1]);
				ubicacion.setProvincia(data[2]);
				ubicacion.setLatitud(data[3]);
				ubicacion.setLongitud(data[4]);
				persistencia.insertarObjeto(ubicacion);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarUbicacion modificar");
			persistencia.realizarRollback();
		}
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
		FUbicacion ubicacion = new FUbicacion();
		ubicacion = (FUbicacion)persistencia.buscarObjeto(ubicacion.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
		persistencia.eliminarObjeto(ubicacion);
		persistencia.cerrarTransaccion();
	}

	/**
	 * Retorna la ubicacion persistente que cumpla con el nombre y la ciudad pasado como parametro.
	 * @param nombreUbicacion
	 * @param ciudad
	 * @return
	 */
	public FUbicacion obtenerUbicacion (String nombreUbicacion,String ciudad) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		FUbicacion aux = new FUbicacion();
		try {
			aux =(FUbicacion)persistencia.buscarObjeto(aux.getClass(), "nombreUbicacion=='"+nombreUbicacion+"' && ciudad=='"+ciudad+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	/**
	 * Retorna si un objeto a insertar ya existe en la base de datos.
	 * @return yaExiste
	 */
	public boolean getExiste(){
		return yaExiste;
	}
	
}