package cuGestionarUsuario;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.HMuestra;
import persistencia.domain.GOperadorDeLaboratorio;
import persistencia.domain.FUbicacion;
import persistencia.domain.DUsuario;

public class ControlGestionarUsuario {
	private boolean yaExiste;
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarUsuario(){}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarUsuario(DUsuario usuario) throws Exception{
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			if(persistencia.buscarObjeto(usuario.getClass(), "nombreUsuario=='"+usuario.getNombreUsuario()+"' || dni=='"+usuario.getDni()+"'")==null){
				persistencia.insertarObjeto(usuario);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
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
			DUsuario usuario = new DUsuario();
			DUsuario auxUsuario = (DUsuario)persistencia.buscarObjeto(usuario.getClass(), "dni=='"+DNI+"'");
			persistencia.eliminarObjeto(auxUsuario);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	public void modificarUsuario(String DNI,String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		DUsuario aux = new DUsuario();
		try {
			Class claseUsuario = aux.getClass();
			if(persistencia.buscarObjeto(claseUsuario, "nombreUsuario=='"+data[3]+"' || dni=='"+data[2]+"'")==null){
				aux =(DUsuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+DNI+"'");
				aux.setNombre(data[0]);
				aux.setApellido(data[1]);
				aux.setDni(data[2]);
				aux.setNombreUsuario(data[3]);
				aux.setCategoria(data[4]);
				aux.setEmail(data[5]);
				aux.setTel(data[6]);
				aux.setContraseña(data[7]);
				
			}
			else{
				yaExiste=true;
			}
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
	public DUsuario obtenerUsuario (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		DUsuario aux = new DUsuario();
		try {
			aux =(DUsuario)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
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
		Collection<DUsuario> aux = null;
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
	 * Retorna si un objeto a insertar ya existe en la base de datos.
	 * @return yaExiste
	 */
	public boolean getExiste(){
		return yaExiste;
	}
}
