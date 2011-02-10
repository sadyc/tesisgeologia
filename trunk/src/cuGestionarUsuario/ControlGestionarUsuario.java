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
			Usuario auxUsuario = (Usuario)persistencia.buscarObjeto(usuario.getClass(), "DNI=='"+DNI+"'");
			persistencia.eliminarObjeto(auxUsuario);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	public void ModificarUsuario(String DNI,String[] data) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Usuario aux = new Usuario();
		try {
			Class claseUsuario = aux.getClass();
			aux =(Usuario)persistencia.buscarObjeto(claseUsuario, "DNI=='"+DNI+"'");
			aux.setNombre(data[0]);
			aux.setApellido(data[1]);
			aux.setDni(data[2]);
			aux.setEmail(data[3]);
			aux.setTel(data[4]);
			aux.setNombreUsuario(data[5]);
			aux.setContraseña(data[6]);
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
			aux =(Usuario)persistencia.buscarObjeto(aux.getClass(), "DNI=='"+DNI+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
}
