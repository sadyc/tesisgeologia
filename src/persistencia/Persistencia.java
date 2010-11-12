/**
 * 
 */
package persistencia;

import java.util.Collection;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;



/**
 * @author TesisGeologia
 * @version 1.0
 */
public class Persistencia {

	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private static PersistenceManager pmi = null;
	private Transaction tx = null;
	
	/**
	 * Default constructor.
	 */
	public Persistencia (){}
	
	public void abrirTransaccion()throws Exception{
		pmi = Singleton.getInstance();
		tx = pmi.currentTransaction();
		
		try{
			tx.begin();
		}
		catch (Exception e) {
			realizarRollback();
		}
	}
	
	/**
	 * Inserta un elemento generico.
	 */
	public void insertarObjeto (Object elemento) throws Exception{
		try{
            pmi.makePersistent(elemento);   
        }
		catch (Exception e){
		    System.out.println("Exception insertar Objeto en Persistencia Generico");
		    e.printStackTrace();
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
			System.out.println("Objeto eliminado con persistencia");
			
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
	public Object buscarObjeto (Class clase, String filtro) throws Exception{
		Object aux = new Object();
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,filtro);
			q.setUnique (true);
			aux = q.execute();
			System.out.println("Objeto encontrado");
		} catch (Exception e) {
			System.out.println("Error en buscar objeto");
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Busca un elemento generico. Retorna lo encontrado.
	 *
	 */
	public Collection buscarColeccionFiltro(Class clase, String filtro) throws Exception{
		Collection<Object> aux = null;
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,filtro);
			aux = (Collection)q.execute();
			System.out.println("Coleccion encontrada y cargada");
		} catch (Exception e) {
			System.out.println("Error en buscar objeto");
			e.printStackTrace();
			realizarRollback();
		}
		return aux;
	}
	
	public Collection buscarColeccion (Class clase)throws Exception{
		Collection<Object> aux = null; 
		try {
			Extent e=pmi.getExtent(clase,true);
			Query q = pmi.newQuery(e,"");
			aux = (Collection) q.execute();
			System.out.println("Coleccion cargada");
			
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
	
	public void cerrarPersistencia() throws Exception{
		pmi.close();
	}
	
	//metodos particulares de busqueda.
}
