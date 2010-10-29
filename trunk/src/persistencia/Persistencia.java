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
            if (tx.isActive()){
                tx.rollback();
            }
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
			Extent e = pmi.getExtent(Muestra.class, true);
		    Query q = pmi.newQuery(e,"cuit == "+elemento);
		    q.deletePersistentAll(elemento);
			Iterator iter=e.iterator();
			
			pmi.deletePersistent(elemento);
		}	
		catch (Exception e){
		    if (tx.isActive()){
		        tx.rollback();
		    }
		}
	    finally{
	         pmi.close();
	    }
	}
	
	/**
	 * Busca un elemento generico. Retorna lo encontrado.
	 *
	 */
	public Object buscarObjeto () throws Exception{
		Object a = new Object();
		try {
			
		} catch (Exception e) {
			
		}
		return (a);
	}
	
	public Collection buscarColeccion ()throws Exception{
		Collection a = null;
		return a;
	}
	
	public void realizarRollback()throws Exception{}

	
	public void cierraTransaccion()throws Exception{
		tx.commit();
	}
	
	//metodos particulares de busqueda.
}
