package cuGestionarOperador;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.GOperadorDeLaboratorio;

public class ControlGestionarOperador {
	private boolean yaExiste;
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarOperador(){}
	
	/**
	 * Inserta un operador con persistencia. 
	 */ 
	public void insertarOperador(GOperadorDeLaboratorio operador) throws Exception{
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
			GOperadorDeLaboratorio operador = new GOperadorDeLaboratorio();
			GOperadorDeLaboratorio auxOperador = (GOperadorDeLaboratorio)persistencia.buscarObjeto(operador.getClass(), "dni=='"+DNI+"'");
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
		GOperadorDeLaboratorio aux = new GOperadorDeLaboratorio();
		try {
			Class claseOperador = aux.getClass();
			if (persistencia.buscarObjeto(claseOperador, "dni=='"+data[2]+"'")==null){
				aux =(GOperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+DNI+"'");
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
	public GOperadorDeLaboratorio obtenerOperador (String DNI) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		GOperadorDeLaboratorio aux = new GOperadorDeLaboratorio();
		try {
			aux =(GOperadorDeLaboratorio)persistencia.buscarObjeto(aux.getClass(), "dni=='"+DNI+"'");
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
		Collection<GOperadorDeLaboratorio> aux = null;
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
