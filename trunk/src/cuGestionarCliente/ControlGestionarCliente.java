package cuGestionarCliente;

import java.util.Collection;
import javax.jdo.JDOException;
import persistencia.Persistencia;
import persistencia.domain.Cliente;
import persistencia.domain.OperadorDeLaboratorio;

public class ControlGestionarCliente {
	private boolean yaExiste;
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarCliente(){
		
	}
	
	/**
	 * Inserta un cliente con persistencia. 
	 */ 
	public void insertarCliente(Cliente cliente) throws Exception{
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			if (persistencia.buscarObjeto(cliente.getClass(),"dni=='"+cliente.getDni()+"'")==null){
				persistencia.insertarObjeto(cliente);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarCliente insertar");
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarCliente(String DNI) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			Cliente cliente = new Cliente();
			Cliente auxcliente = (Cliente)persistencia.buscarObjeto(cliente.getClass(), "dni=='"+DNI+"'");
			persistencia.eliminarObjeto(auxcliente);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al eliminar");
			persistencia.realizarRollback();
		}
	}
			
	public void modificarCliente(String DNI,Cliente data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Cliente aux = new Cliente();
		try {
			Class claseCliente = aux.getClass();
			if (!DNI.equals(data.getDni())){
				if (persistencia.buscarObjeto(claseCliente, "dni=='"+data.getDni()+"'")==null){
					aux =(Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+DNI+"'");
					aux.setNombre(data.getNombre());
					aux.setApellido(data.getApellido());
					aux.setDni(data.getDni());
					aux.setEmail(data.getEmail());
					aux.setTel(data.getTel());
				}else{
					yaExiste=true;
				}
			}
			else{
				aux =(Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+DNI+"'");
				aux.setNombre(data.getNombre());
				aux.setApellido(data.getApellido());
				aux.setDni(data.getDni());
				aux.setEmail(data.getEmail());
				aux.setTel(data.getTel());
			}
			persistencia.cerrarTransaccion();
		}
		catch (JDOException e) {
			System.out.println("Error al modificar porque ya existe esa clave");
			persistencia.realizarRollback();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			persistencia.realizarRollback();
		}		
	}
	
	
	/**
	 * Retorna el cliente persistente que cumpla con el DNI pasado como parametro.
	 * @param DNI
	 * @return
	 */
	public Cliente obtenerCliente (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Cliente aux = new Cliente();
		try {
			aux =(Cliente)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
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
	public Collection coleccionClientes(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<Cliente> aux = null;
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
