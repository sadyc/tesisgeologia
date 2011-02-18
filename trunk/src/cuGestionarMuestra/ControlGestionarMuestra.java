/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.DCliente;
import persistencia.domain.HMuestra;
import persistencia.domain.GOperadorDeLaboratorio;
import persistencia.domain.FUbicacion;
import persistencia.domain.DUsuario;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * 
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarMuestra {
	private boolean yaExiste;
	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarMuestra(){}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarMuestra(HMuestra mu, FUbicacion ubicacion, GOperadorDeLaboratorio operador, DCliente cliente, DUsuario usuario1) throws Exception{
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			DUsuario usuario = usuario1;
			Class claseUbicacion = ubicacion.getClass();
			if ((HMuestra)persistencia.buscarObjeto(mu.getClass(), "nombreMuestra=='"+mu.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'")==null){
				mu.setUbicacion((FUbicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
				Class claseOperador = operador.getClass();
				mu.setOperadorLaboratorio((GOperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+operador.getDni()+"'"));
				Class claseUsuario = usuario.getClass();
				mu.setUsuario((DUsuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+usuario.getDni()+"'")); 
				if (cliente != null){
					Class claseCliente = cliente.getClass();
					mu.setCliente((DCliente)persistencia.buscarObjeto(claseCliente, "dni=='"+cliente.getDni()+"'"));
				}
				
				persistencia.insertarObjeto(mu);

			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarMuestra insertar");
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarMuestra(String nombreMuestra, String ubicacion) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			HMuestra muestra = new HMuestra();
			HMuestra auxMuestra = (HMuestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"'");
			persistencia.eliminarObjeto(auxMuestra);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionMuestras(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<HMuestra> aux = null;
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	/**
	 * Modifica una muestra con persistencia. 
	 * @param nombreMuestraModificar 
	 * @param ubicacionModificar
	 * @param data
	 * @throws Exception
	 */
	public void ModificarMuestra(String nombreMuestraModificar,String ubicacionModificar,String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		HMuestra aux = new HMuestra();
		try {
			Class claseMuestra = aux.getClass();
			if ((HMuestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+data[1]+"' && ubicacion.nombreUbicacion=='"+data[0]+"'")==null){
				aux =(HMuestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestraModificar+"' && ubicacion.nombreUbicacion=='"+ubicacionModificar+"'");
				aux.setPeso(Float.parseFloat(data[2]));
				aux.setNombreMuestra(data[1]);
				aux.setProfundidadInicial(Float.parseFloat(data[3]));
				aux.setProfundidadFinal(Float.parseFloat(data[4]));
				GOperadorDeLaboratorio operador = new GOperadorDeLaboratorio();
				Class claseOperador = operador.getClass();
				aux.setOperadorLaboratorio((GOperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+data[5]+"'"));
				DCliente cliente = new DCliente();
				Class claseCliente = cliente.getClass();
				aux.setCliente((DCliente)persistencia.buscarObjeto(claseCliente, "dni=='"+data[6]+"'"));
				FUbicacion ubicacion = new FUbicacion();
				Class claseUbicacion = ubicacion.getClass();
				aux.setUbicacion((FUbicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+data[0]+"'"));
				DUsuario usuario = new DUsuario();
				Class claseUsuario = usuario.getClass();
				aux.setUsuario((DUsuario)persistencia.buscarObjeto(claseUsuario, "nombreUsuario=='"+data[7]+"'"));
				java.util.Date utilDate = new java.util.Date();
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    aux.setFecha(sqlDate);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			persistencia.realizarRollback();
		}		
	}
	
	/**
	 * Retorna la muestra persistente que cumpla con el nombre y ubicacion pasado como parametro.
	 * @param nombreMuestra
	 * @return
	 */
	public HMuestra obtenerMuestra (String nombreMuestra,String ubicacion) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		HMuestra aux = new HMuestra();
		try {
			aux =(HMuestra)persistencia.buscarObjeto(aux.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"'");
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
	
	