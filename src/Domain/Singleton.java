/**
 * 
 */
package Domain;

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
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private static PersistenceManager pmi = null;

	/**
	 * Default constructor.
	 */
	public Singleton() {
	} 
	
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
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 
	public void InsertarMuestras(Muestra muestra,Muestra muestra2, OperadorDeLaboratorio op){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
        {
            tx.begin();
            System.out.println("Persisting products");
            
            muestra.setOperador(op);
            muestra2.setOperador(op);
            pm.makePersistent(muestra);
            pm.makePersistent(muestra2);            
            tx.commit();
            System.out.println("Muestra have been persisted");
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
	
	
	public Object[][] getDatos(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Object [][] resultado =  new Object[3][5];
		int i = 0;
		try
		{
		    tx.begin();
		    Extent e = pm.getExtent(Muestra.class, true);
		    Iterator iter=e.iterator();
		    Muestra mu = new Muestra();
		    while (iter.hasNext()){
		    	mu = (Muestra)iter.next();
		    	resultado [i][0]= mu.getNombreMuestra();
		        resultado [i][1]= mu.getPeso();		        
		        resultado [i][2]= mu.getProfundidadInicial();
		        resultado [i][3]= mu.getProfundidadFinal();
		        resultado [i][4]= mu.getOperador().getDni();
		        i++;
		    }
		    tx.commit();
		}
		catch (Exception e){
		    if (tx.isActive()){
		        tx.rollback();
		    }
		}
            pm.close();
        return (resultado);
	}
	/**
	 * 
	 * 
	  
	public void eliminarMuestra (String nombreMuestra){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
		 tx.begin();
		 Extent e = pm.getExtent(Muestra.class, true);
		 Iterator iter=e.iterator();
		 Muestra mu = new Muestra(); 
		 while (iter.hasNext() && (mu.getNombreMuestra().compareTo(nombreMuestra))!=0){
		   mu = (Muestra)iter.next();
		 }
		 pm.deletePersistent(mu);
         tx.commit();
		}
		catch (Exception e)
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
		
	}
	/**
	 * 
	 * 
	 
	public void ModificarMuestras(Muestra muestra){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			 tx.begin();
			 Extent e = pm.getExtent(OperadorDeLaboratorio.class, true);
			 Iterator iter=e.iterator();
			 OperadorDeLaboratorio oL = new OperadorDeLaboratorio();
			 boolean encontrado = false;
			 while (iter.hasNext() && !(encontrado)){
				oL = (OperadorDeLaboratorio)iter.next();
			   if (oL.getDni().compareTo((muestra.getOperador().getDni()))== 0){
				  encontrado=true;
			   }
			}
			if (encontrado){
				pm.deletePersistent(oL);
			}
			tx.commit();
			}
			catch (Exception e)
			{
			    if (tx.isActive())
			    {
			        tx.rollback();
			    }
			}
			
        try
        {
            tx.begin();
            System.out.println("Persisting products");
            
            pm.makePersistent(muestra);
                        
            tx.commit();
            System.out.println("Muestra have been persisted");
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
	*/
  }
