/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Cliente;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * 
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarMuestra {

	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarMuestra(){}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarMuestra(Muestra mu, Ubicacion ubicacion, OperadorDeLaboratorio operador, Cliente cliente) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			
			Usuario usuario = new Usuario();
			Class claseUbicacion = ubicacion.getClass();
			mu.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
			Class claseOperador = operador.getClass();
			mu.setOperadorLaboratorio((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+operador.getDni()+"'"));
			Class claseUsuario = usuario.getClass();
			mu.setUsuario((Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+"555"+"'")); //(Usuario)persistencia.buscarObjeto(claseUsuario, "dni==123"));//Todavia no esta implementado el caso de uso Usuario
			Class claseCliente = cliente.getClass();
			mu.setCliente((Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+cliente.getDni()+"'"));
			persistencia.insertarObjeto(mu);
			persistencia.cerrarTransaccion();
			persistencia.cerrarPersistencia();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarMuestra insertar");
			e.printStackTrace();
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
			Muestra muestra = new Muestra();
			Muestra auxMuestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"'");
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
		Collection<Muestra> aux = null;
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
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			Class claseMuestra = aux.getClass();
			aux =(Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestraModificar+"' && ubicacion.nombreUbicacion=='"+ubicacionModificar+"'");
			aux.setPeso(Float.parseFloat(data[2]));
			aux.setNombreMuestra(data[1]);
			aux.setProfundidadInicial(Float.parseFloat(data[3]));
			aux.setProfundidadFinal(Float.parseFloat(data[4]));
			OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
			Class claseOperador = operador.getClass();
			aux.setOperadorLaboratorio((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+data[5]+"'"));
			Cliente cliente = new Cliente();
			Class claseCliente = cliente.getClass();
			aux.setCliente((Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+data[6]+"'"));
			Ubicacion ubicacion = new Ubicacion();
			Class claseUbicacion = ubicacion.getClass();
			aux.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+data[0]+"'"));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    aux.setFecha(sqlDate);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			e.printStackTrace();
			persistencia.realizarRollback();
		}		
	}
	
	/**
	 * Retorna la muestra persistente que cumpla con el nombre y ubicacion pasado como parametro.
	 * @param nombreMuestra
	 * @return
	 */
	public Muestra obtenerMuestra (String nombreMuestra,String ubicacion) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			aux =(Muestra)persistencia.buscarObjeto(aux.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
	
	