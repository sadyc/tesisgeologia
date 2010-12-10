/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;
import java.util.Iterator;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

/**
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
	public void insertarMuestra(Muestra mu, Ubicacion ubicacion, OperadorDeLaboratorio operador) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			
			Usuario usuario = new Usuario();
			Class claseUbicacion = ubicacion.getClass();
			mu.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
			Class claseOperador = operador.getClass();
			mu.setOperador((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+operador.getDni()+"'"));
			Class claseUsuario = usuario.getClass();
			mu.setUsuario((Usuario)persistencia.buscarObjeto(claseUsuario, "dni==123"));//Todavia no esta implementado el caso de uso Usuario
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
			System.out.println("Analisis eliminado con persistencia");
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionMuestras(Class clase) throws Exception {
		Collection<Muestra> aux = null; 
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	public void ModificarMuestra(String nombreMuestra,Muestra muestra, Ubicacion ubicacion, OperadorDeLaboratorio operador) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			
			Class claseMuestra = aux.getClass();
			aux =(Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestra+"'");
			aux.setPeso(muestra.getPeso());
			aux.setNombreMuestra(muestra.getNombreMuestra());
			aux.setProfundidadInicial(muestra.getProfundidadInicial());
			aux.setProfundidadFinal(muestra.getProfundidadFinal());
			Class claseOperador = operador.getClass();
			aux.setOperador((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+operador.getDni()+"'"));
			Class claseUbicacion = ubicacion.getClass();
			Ubicacion ubic = (Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'");
			aux.setUbicacion(ubic);
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
			aux =(Muestra)persistencia.buscarObjeto(aux.getClass(), "nombreMuestra=='"+nombreMuestra+"'");//+"' && Ubicacion=='"+ubicacion+"'");
			persistencia.cerrarTransaccion();
			persistencia.cerrarPersistencia();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
	
	