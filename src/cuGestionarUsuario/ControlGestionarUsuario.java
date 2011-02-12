package cuGestionarUsuario;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

public class ControlGestionarUsuario {
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarUsuario(){}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarUsuario(Usuario usuario) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(usuario);
			persistencia.cerrarTransaccion();
			persistencia.cerrarPersistencia();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarUsuario insertar");
			e.printStackTrace();
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarUsuario(String DNI) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			Usuario usuario = new Usuario();
			Usuario auxUsuario = (Usuario)persistencia.buscarObjeto(usuario.getClass(), "dni=='"+DNI+"'");
			persistencia.eliminarObjeto(auxUsuario);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	public void modificarUsuario(String DNI,String[] data) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Usuario aux = new Usuario();
		try {
			Class claseUsuario = aux.getClass();
			aux =(Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+DNI+"'");
			aux.setNombre(data[0]);
			aux.setApellido(data[1]);
			aux.setDni(data[2]);
			aux.setNombreUsuario(data[3]);
			aux.setCategoria(data[4]);
			aux.setEmail(data[5]);
			aux.setTel(data[6]);
			aux.setContraseña(data[7]);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			e.printStackTrace();
			persistencia.realizarRollback();
		}		
	}
	
	
	/**
	 * Retorna el usuario persistente que cumpla con el DNI pasado como parametro.
	 * @param DNI
	 * @return
	 */
	public Usuario obtenerUsuario (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Usuario aux = new Usuario();
		try {
			aux =(Usuario)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionUsuarios(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<Usuario> aux = null;
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
