/**
 * 
 */
package persistencia;

import java.util.Collection;
import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import comun.Muestra;

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
			// FAAAAAAAAAALTAAAAAAAAAAAAAAAAAAAAAAAA!!!!!!!!!
		}
	}
	
	/**
	 * Inserta un elemento generico.
	 *
	 */
	public void insertarObjeto (Object elemento) throws Exception{
		try{
            System.out.println("Persisting products");
            pmi.makePersistent(elemento);
        }
		catch (Exception e){
		    realizarRollback();
		}
        finally{
         pmi.close();
        }
    }
	
	
	/**
	 * Elimina un elemento generico.
	 *
	 */
	public void eliminarObjeto (Object elemento) throws Exception {
		try{
			
		    //Query q = pmi.newQuery(elemento);
		    //q.deletePersistentAll(elemento);
			pmi.deletePersistent(elemento);
		}	
		catch (Exception e){
		    realizarRollback();
		}
	    finally{
	         pmi.close();
	    }
	}
	
	/**
	 * Busca un elemento generico. Retorna lo encontrado.
	 *
	 */
	public Object buscarObjeto (int id) throws Exception{
		Object aux = new Object();
		try {
			Query q = pmi.newQuery("id=="+id);
			aux = q.execute();
		} catch (Exception e) {
			realizarRollback();
		}
		return aux;
	}
	
	public Collection buscarColeccion ()throws Exception{
		Collection<Object> aux = null; 
		try {
			Query q = pmi.newQuery("");
			aux = (Collection) q.execute();
		} catch (Exception e) {
			realizarRollback();
		}
		return aux;
	}
	
	public void realizarRollback()throws Exception{
		if (tx.isActive()){
	        tx.rollback();
	    }
	}

	
	public void cierraTransaccion()throws Exception{
		tx.commit();
		pmi.close();
	}
	
	//metodos particulares de busqueda.
}
