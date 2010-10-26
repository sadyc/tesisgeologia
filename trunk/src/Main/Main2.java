/**
 * 
 */
package Main;


import java.util.Collection;
import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import comun.Muestra;

import persistencia.Singleton;


import Domain.*;


/**
 * @author NAVE
 *
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
		public static String  retornaHTML()
	    {
			
	    
			String html="";
	        PersistenceManager pm = Singleton.getInstance();
	        Transaction tx=pm.currentTransaction();
	        tx = pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            System.out.println("Executing Query ");
	            Extent e=pm.getExtent(Muestra.class,true);
	            Query q=pm.newQuery(e, "");
	            q.setOrdering("NOMBREMUESTRA ascending");
	            Collection c=(Collection)q.execute();
	            Iterator iter=c.iterator();
	            while (iter.hasNext())
	            {
	                Object obj = iter.next();
	                html=html+"<tr> <td> "+obj+" </td> </tr>";
	            }

	            tx.commit();
	            return html;
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
	        }
	    
	    
	    }   
	
}
