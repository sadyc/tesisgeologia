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
public final class Singleton {
        private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        private static PersistenceManager pmi = null;

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
        public static PersistenceManager getInstance(){
                if(pmi==null || pmi.isClosed()){
                  pmi = pmf.getPersistenceManager();
                }
                return pmi;
        }


  }
	