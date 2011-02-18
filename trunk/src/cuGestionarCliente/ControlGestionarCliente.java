package cuGestionarCliente;

import java.util.Collection;

import javax.jdo.JDOException;

import persistencia.Persistencia;
import persistencia.domain.DCliente;

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
	public void insertarCliente(DCliente cliente) throws Exception{
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
			DCliente cliente = new DCliente();
			DCliente auxcliente = (DCliente)persistencia.buscarObjeto(cliente.getClass(), "dni=='"+DNI+"'");
			persistencia.eliminarObjeto(auxcliente);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al eliminar");
			persistencia.realizarRollback();
		}
	}
			
	public void modificarCliente(String DNI,String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		DCliente aux = new DCliente();
		try {
			Class claseCliente = aux.getClass();
			if (persistencia.buscarObjeto(claseCliente,"dni=='"+data[2]+"'")==null){
				aux =(DCliente)persistencia.buscarObjeto(claseCliente, "dni=='"+DNI+"'");
				aux.setNombre(data[0]);
				aux.setApellido(data[1]);
				aux.setDni(data[2]);
				aux.setEmail(data[3]);
				aux.setTel(data[4]);
			}
			else{
				yaExiste=true;
			}
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
	public DCliente obtenerCliente (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		DCliente aux = new DCliente();
		try {
			aux =(DCliente)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
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
		Collection<DCliente> aux = null;
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
