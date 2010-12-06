/**
 * 
 */
package persistencia;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;


/**
 * Implementacion de la clase que define la conexion de nuestro programa con
 * la base de datos persistente llamada Domain
 * @author TesisGeologia
 *
 */
/**
 * @author Administrador
 *
 */
public final class Singleton {
	private static PersistenceManagerFactory pmf;
	/**
	 * Default constructor.
	 */
	public Singleton() {} 
	
	/**
	* Retorna la conexion a la base de datos obtenida
	* por la PersistenceManagerFactory.
	* 
	* @return static PersistenceManager
	*/
	public static PersistenceManagerFactory getInstance(){
		if(pmf==null){
			  pmf = JDOHelper.getPersistenceManagerFactory("database.properties");
			}
			return pmf;
	}
	
	
  }