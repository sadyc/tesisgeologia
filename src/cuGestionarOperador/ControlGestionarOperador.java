package cuGestionarOperador;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.OperadorDeLaboratorio;

import comun.Control;


/**
 * Clase que se utiliza para gestionar los datos de un operador
 * con persistencia en la base de datos del sistema.
 * 
 * @author TesisGeologia.
 *
 */
public class ControlGestionarOperador extends Control{
	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarOperador(){}
	
	/**
	 * Inserta un operador con persistencia. 
	 */ 
	public void insertarOperador(OperadorDeLaboratorio operador) throws Exception{
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			if (persistencia.buscarObjeto(operador.getClass(), "dni=='"+operador.getDni()+"'")==null){
				persistencia.insertarObjeto(operador);
			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarOperador insertar");
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina un operador con persistencia. 
	 */
	public void eliminarOperador(String DNI) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
			OperadorDeLaboratorio auxOperador = (OperadorDeLaboratorio)persistencia.buscarObjeto(operador.getClass(), "dni=='"+DNI+"'");
			persistencia.eliminarObjeto(auxOperador);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al eliminar");
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Modifica un operador.
	 * @param DNI se utiliza para buscar el operador a eliminar.
	 * @param data los datos a modificar.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void modificarOperador(String DNI,OperadorDeLaboratorio data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		OperadorDeLaboratorio aux = new OperadorDeLaboratorio();
		try {
			Class claseOperador = aux.getClass();
			if (!DNI.equals(data.getDni())){
				if (persistencia.buscarObjeto(claseOperador, "dni=='"+data.getDni()+"'")==null){
					aux =(OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+DNI+"'");
					aux.setNombre(data.getNombre());
					aux.setApellido(data.getApellido());
					aux.setDni(data.getDni());
					aux.setEmail(data.getEmail());
					aux.setTel(data.getTel());
				}else{
					yaExiste=true;
				}
			}else{
				aux =(OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+DNI+"'");
				aux.setNombre(data.getNombre());
				aux.setApellido(data.getApellido());
				aux.setDni(data.getDni());
				aux.setEmail(data.getEmail());
				aux.setTel(data.getTel());
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			persistencia.realizarRollback();
		}		
	}
	
	
	/**
	 * Retorna el operador persistente que cumpla con el DNI pasado como parametro.
	 * @param DNI
	 * @return
	 */
	public OperadorDeLaboratorio obtenerOperador (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		OperadorDeLaboratorio aux = new OperadorDeLaboratorio();
		try {
			aux =(OperadorDeLaboratorio)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
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
	public Collection coleccionOperadores(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<OperadorDeLaboratorio> aux = null;
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
