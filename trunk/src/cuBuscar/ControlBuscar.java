/**
 * 
 */
package cuBuscar;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.HMuestra;

/**
 * Clase que se utiliza para gestionar los datos con persistencia en la base
 * de datos del sistema.
 * 
 * @author TesisGeologia
 */
public class ControlBuscar{

	/**
	 * Constructor por defecto.
	 */
	public ControlBuscar() {
	}

	public Collection buscarNombreMuestra(String nombre) throws Exception {
		Collection<Object> aux = null; 
        Persistencia persistencia = new Persistencia();
        persistencia.abrirTransaccion();
        try {
        	String filtro = "nombreMuestra=='"+nombre+"'";
        	HMuestra muestra = new HMuestra();
        	aux = (persistencia.buscarColeccionFiltro(muestra.getClass(), filtro));
            persistencia.cerrarTransaccion();
            System.out.println("muestras coleccionados");
        } catch (Exception e) {
                persistencia.realizarRollback();
        }
        return aux;
	}

	public Collection buscarUbicacionMuestra(String ubicacion) throws Exception {
		Collection<Object> aux = null; 
        Persistencia persistencia = new Persistencia();
        persistencia.abrirTransaccion();
        try {
        	String filtro = "ubicacion.nombreUbicacion=='"+ubicacion+"'";
        	HMuestra muestra = new HMuestra();
        	aux = (persistencia.buscarColeccionFiltro(muestra.getClass(), filtro));
            persistencia.cerrarTransaccion();
            System.out.println("muestras coleccionados");
        } catch (Exception e) {
                persistencia.realizarRollback();
        }
        return aux;
	}

	public Collection buscarOperadorDeMuestra(String operador) throws Exception {
		Collection<Object> aux = null; 
        Persistencia persistencia = new Persistencia();
        persistencia.abrirTransaccion();
        try {
        	String filtro = "operadorLaboratorio.nombre=='"+operador+"'";
        	HMuestra muestra = new HMuestra();
        	aux = (persistencia.buscarColeccionFiltro(muestra.getClass(), filtro));
            persistencia.cerrarTransaccion();
            System.out.println("muestras coleccionados");
        } catch (Exception e) {
                persistencia.realizarRollback();
        }
        return aux;
	}
				

	
}
