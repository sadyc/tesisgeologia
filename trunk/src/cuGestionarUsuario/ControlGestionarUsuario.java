package cuGestionarUsuario;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Usuario;

/**
 * Clase que se utiliza para gestionar los datos de un usuario 
 * con persistencia en la base de datos del sistema.
 * @author TesisGeologia.
 * @version 1.0
 *
 */
public class ControlGestionarUsuario {
	private boolean yaExiste;
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarUsuario(){}
	
	/**
	 * Inserta una muestra con persistencia.
	 * @param usuario 
	 */ 
	public void insertarUsuario(Usuario usuario) throws Exception{
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
			
	/**
	 * Permite modificar un usuario con los los parametros.
	 * @param DNI
	 * @param data
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void modificarUsuario(String DNI,String nombreUsuario,String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Usuario aux = new Usuario();
		try {
			Class claseUsuario = aux.getClass();
			if (!DNI.equals(data[2]) && nombreUsuario.equals(data[3])){
				if(persistencia.buscarObjeto(claseUsuario, "dni=='"+data[2]+"'")==null){
					aux =(Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+DNI+"'");
					aux.setNombre(data[0]);
					aux.setApellido(data[1]);
					aux.setDni(data[2]);
					aux.setNombreUsuario(data[3]);
					aux.setCategoria(data[4]);
					aux.setEmail(data[5]);
					aux.setTel(data[6]);
					aux.setPassword(data[7]);
				}
				else{
					yaExiste=true;
				}
			}else{
				if (DNI.equals(data[2]) && !nombreUsuario.equals(data[3])){
					if(persistencia.buscarObjeto(claseUsuario, "nombreUsuario=='"+data[3]+"'")==null){
						aux =(Usuario)persistencia.buscarObjeto(claseUsuario, "nombreUsuario=='"+nombreUsuario+"'");
						aux.setNombre(data[0]);
						aux.setApellido(data[1]);
						aux.setDni(data[2]);
						aux.setNombreUsuario(data[3]);
						aux.setCategoria(data[4]);
						aux.setEmail(data[5]);
						aux.setTel(data[6]);
						aux.setPassword(data[7]);
					}
					else{
						yaExiste =true;
					}
				}
				else{
					aux =(Usuario)persistencia.buscarObjeto(claseUsuario, "nombreUsuario=='"+nombreUsuario+"' && dni=='"+DNI+"'");
					aux.setNombre(data[0]);
					aux.setApellido(data[1]);
					aux.setDni(data[2]);
					aux.setNombreUsuario(data[3]);
					aux.setCategoria(data[4]);
					aux.setEmail(data[5]);
					aux.setTel(data[6]);
					aux.setPassword(data[7]);
				}
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection coleccionUsuarios(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<Usuario> aux = null;
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
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
