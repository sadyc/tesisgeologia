package cuGestionarCliente;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Cliente;

public class ControlGestionarCliente {
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarCliente(){}
	
	/**
	 * Inserta un cliente con persistencia. 
	 */ 
	public void insertarCliente(Cliente cliente) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(cliente);
			persistencia.cerrarTransaccion();
			persistencia.cerrarPersistencia();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarCliente insertar");
			e.printStackTrace();
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
			
	public void modificarCliente(String DNI,String[] data) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Cliente aux = new Cliente();
		try {
			Class claseCliente = aux.getClass();
			aux =(Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+DNI+"'");
			aux.setNombre(data[0]);
			aux.setApellido(data[1]);
			aux.setDni(data[2]);
			aux.setEmail(data[3]);
			aux.setTel(data[4]);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			e.printStackTrace();
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
}
