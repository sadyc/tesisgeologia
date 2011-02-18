package cuGestionarOperador;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.OperadorDeLaboratorio;

public class ControlGestionarOperador {
	private boolean yaExiste;
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
	 * Elimina una muestra con persistencia. 
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
			
	public void modificarOperador(String DNI,String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		OperadorDeLaboratorio aux = new OperadorDeLaboratorio();
		try {
			Class claseOperador = aux.getClass();
			if (persistencia.buscarObjeto(claseOperador, "dni=='"+data[2]+"'")==null){
				aux =(OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+DNI+"'");
				aux.setNombre(data[0]);
				aux.setApellido(data[1]);
				aux.setDni(data[2]);
				aux.setEmail(data[3]);
				aux.setTel(data[4]);
			}
			else{
				yaExiste=true;
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
	
	/**
	 * Retorna si un objeto a insertar ya existe en la base de datos.
	 * @return yaExiste
	 */
	public boolean getExiste(){
		return yaExiste;
	}
}
