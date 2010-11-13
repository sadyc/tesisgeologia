/**
 * 
 */
package cuGestionarMuestra;

import java.util.Collection;
import java.util.Iterator;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;

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
	public void insertarMuestra(Muestra mu, Ubicacion ubicacion, OperadorDeLaboratorio operador) throws Exception{
		Persistencia persistencia = new Persistencia();
		
		try {
			persistencia.abrirTransaccion();
			Class claseUbicacion = ubicacion.getClass();
			mu.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
			Class claseOperador = operador.getClass();
			mu.setOperador((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=="+operador.getDni()));
			persistencia.insertarObjeto(mu);
			persistencia.cerrarTransaccion();
			System.out.println("Fatal error en ControlGestionarMuestra insertar");

			persistencia.cerrarTransaccion(); // ACA SOLIA TENER ERROR.. POSIBLEMENTE COMENTAR!!
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarMuestra insertar");
			e.printStackTrace();
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
			Muestra muestra = new Muestra();
			Class clase = muestra.getClass();
			Collection muestras = persistencia.buscarColeccion(clase);
			Iterator<Muestra> it = muestras.iterator();
			int i = 0;
			while (it.hasNext()&& mu.getNombreMuestra()!= muestra.getNombreMuestra()){
				muestra = it.next();
			    i++;
			}
			persistencia.eliminarObjeto(muestra);
			persistencia.cerrarTransaccion();
			System.out.println("Muestra eliminada con persistencia");
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 */
	public Collection coleccionMuestras(Class clase) throws Exception {
		Collection<Muestra> aux = null; 
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			aux = (persistencia.buscarColeccion(clase));
			System.out.println("La coleccion ha sido cargada");
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	public void ModificarMuestra(String nombreMuestra,Muestra muestra, Ubicacion ubicacion, OperadorDeLaboratorio operador) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			Class claseMuestra = muestra.getClass();
			aux =(Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=="+nombreMuestra);
			Class claseUbicacion = ubicacion.getClass();
			aux.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
			Class claseOperador = operador.getClass();
			aux.setOperador((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "DNI=='"+operador.getDni()+"'"));
			aux.setNombreMuestra(muestra.getNombreMuestra());
			aux.setPeso(muestra.getPeso());
			aux.setProfundidadInicial(muestra.getProfundidadInicial());
			aux.setProfundidadFinal(muestra.getProfundidadFinal());
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
			persistencia.cerrarPersistencia();
		}		
	}

	
	
	
}
	
	