/**
 * 
 */
package persistencia;

import java.util.Collection;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

/**
 * Clase que implementa el intermediario entre el singleton y los controles 
 * para el manejo de la informacion que se va a almacenar en la base de datos.
 * @author TesisGeologia
 * @version 1.0
 */
public class Persistencia {

	private static PersistenceManagerFactory pmf ;
	private static PersistenceManager pmi = null;
	private Transaction tx = null;
	
	/**
	 * Default constructor.
	 * @throws Exception 
	 */
	public Persistencia () {
	}
	
	public void abrirTransaccion() throws Exception{
		pmf = Singleton.getInstance();
		pmi = pmf.getPersistenceManager();
        tx = pmi.currentTransaction();
        tx.begin();
	}
	
	/**
	 * Inserta un elemento generico.
	 */
	public void insertarObjeto (Object elemento) throws Exception{
		try{
            pmi.makePersistent(elemento);   
        }
		catch (JDOException e) {
			System.out.println("Error insertar Objeto con clave ya existente en Persistencia Generico");
		    realizarRollback();
		}
		catch (Exception e){
		    System.out.println("Exception insertar Objeto en Persistencia Generico");
		    realizarRollback();

		}
        
    }
	
	
	/**
	 * Elimina un elemento generico.
	 *
	 */
	public void eliminarObjeto (Object objeto) throws Exception {
		try{
			pmi.deletePersistent(objeto);
		}	
		catch (Exception e){
			System.out.println("No se elimino con persistencia");
		    realizarRollback();
		}
	}
	
	/**
	 * Busca un elemento generico. Retorna lo encontrado.
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object buscarObjeto (Class clase, String filtro) throws Exception{
		Object aux = new Object();
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,filtro);
			q.setUnique (true);
			aux = (Object)q.execute();
		} catch (Exception e) {
			System.out.println("Error en buscar objeto");
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Busca un elemento generico. Retorna coleccion encontrada.
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection buscarColeccionFiltro(Class clase, String filtro) throws Exception{
		Collection<Object> aux = null;
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,filtro);
			aux = (Collection)q.execute();
		} catch (Exception e) {
			System.out.println("Error al cargar la collection");
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Retorna la lista de analisis ordenadas por porcentaje retenido acumulado.
	 *
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List buscarListaFiltro(Class clase, String filtro) throws Exception{
		List aux = null;
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,filtro);
			q.setOrdering("porcentajeRetenidoAcumulado ascending");
			aux = (List)q.execute();
		} catch (Exception e) {
			System.out.println("Error en cargar la lista");
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection buscarColeccion (Class clase)throws Exception{
		Collection<Object> aux = null; 
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,"");
			aux = (Collection) q.execute();
		} catch (Exception e) {
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	public void realizarRollback()throws Exception{
		if (tx.isActive()){
			System.out.println("Realizo rollback");
	        tx.rollback();
	    }
	}

	
	public void cerrarTransaccion()throws Exception{
		tx.commit();
	}
	
	public void cerrarPersistencia()throws Exception{
		if (!pmi.isClosed())
		pmi.close();
	}

	
}
