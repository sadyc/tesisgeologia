/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;
import java.util.Iterator;

import persistencia.Persistencia;
import persistencia.domain.Muestra;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarMuestra {

	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarMuestra(){}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarMuestra(Muestra mu) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(mu);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarMuestra(Muestra mu) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			System.out.println("Muestra eliminada con persistencia");
			Muestra muestra = new Muestra();
			Class clase = muestra.getClass();
			Collection muestras = persistencia.buscarColeccion(clase);
			Iterator<Muestra> it = muestras.iterator();
			int i = 0;
			System.out.println(mu.getNombreMuestra()+"el q busco --->el q encunetro"+muestra.getNombreMuestra());
			while (it.hasNext()&& mu.getNombreMuestra()!= muestra.getNombreMuestra()){
				System.out.println(mu.getNombreMuestra()+"el q busco --->el q encunetro"+muestra.getNombreMuestra());
				muestra = it.next();
			    i++;
			}
			persistencia.eliminarObjeto(muestra);
			

			persistencia.cerrarTransaccion();
			
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionMuestras(Class clase) throws Exception {
		Collection<Object> aux = null; 
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	public void ModificarMuestra(String nombreMuestra, Muestra muestra) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			System.out.println("Buscar Objeto");
			Class clase = muestra.getClass();
			Collection muestras = persistencia.buscarColeccion(clase);
			Iterator<Muestra> it = muestras.iterator();
			int i = 0;
			while (it.hasNext()&& nombreMuestra!= muestra.getNombreMuestra()){
				aux = it.next();
			    i++;
			}
		}
		catch (Exception e) {
			persistencia.realizarRollback();
			persistencia.cerrarPersistencia();
		}
		aux.setNombreMuestra(muestra.getNombreMuestra());
		aux.setPeso(muestra.getPeso());
		aux.setProfundidadInicial(muestra.getProfundidadInicial());
		aux.setProfundidadFinal(muestra.getProfundidadFinal());
		persistencia.cerrarTransaccion();
	}

	
	
	
}
	
	