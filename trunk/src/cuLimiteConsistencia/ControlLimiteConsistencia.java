package cuLimiteConsistencia;

import java.util.Collection;
import java.util.Iterator;

import persistencia.Persistencia;
import persistencia.domain.Consistencia;
import persistencia.domain.Muestra;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlLimiteConsistencia {

        
        /**
         * Contructor por defecto
         */
        public ControlLimiteConsistencia(){}
        
        /**
         * Inserta un analisis de consistencia con persistencia. 
         */ 
        public Consistencia insertarConsistencia(Consistencia consistencia,String nombreMuestra) throws Exception{
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                Muestra muestra = new Muestra();
                try {
                        Class claseMuestra= muestra.getClass();
                        muestra = (Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestra+"'");
                        consistencia.setMuestra(muestra);
                        consistencia.calcularIndicePlasticidad();
                        persistencia.insertarObjeto(consistencia);
                        persistencia.cerrarTransaccion();
                        System.out.println("Consistencia insertado con persistencia");
                } catch (Exception e) {
                		e.printStackTrace();
                        persistencia.realizarRollback();
                }
                return consistencia;
        }
        
               
       /**
        * Permite modificar un analisis de consistencia persistente.                 
        * @param limitePlastico
        * @param nombreMuestra
        * @param numeroTamiz
        * @throws Exception
        */
              
        public void ModificarConsistencia(Float limitePlastico,Float limiteLiquido,String nombreMuestra) throws Exception {
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                try {
                	Consistencia auxConsistencia = new Consistencia();
        			Class clase = auxConsistencia.getClass();
        			auxConsistencia = (Consistencia)persistencia.buscarObjeto(clase, "muestra.nombreMuestra=='"+nombreMuestra+"'");
        			Muestra muestra = new Muestra();
        			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"'");
        			auxConsistencia.setLimitePlastico(limitePlastico);
        			auxConsistencia.setLimiteLiquido(limiteLiquido);
        			auxConsistencia.calcularIndicePlasticidad();
        			persistencia.cerrarTransaccion();
        			System.out.println("Consistencia modificada con persistencia");
                }
                catch (Exception e) {
                        e.printStackTrace();
                		persistencia.realizarRollback();
                }               
        }
        
        
        /**
    	 * Retorna la muestra persistente que cumpla con el nombre pasado como parametro.
    	 * @param nombreMuestra
    	 * @return
    	 */
    	public Muestra obtenerMuestra (Class clase, String nombreMuestra) throws Exception{
    		Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		Muestra aux = new Muestra();
    		try {
    			aux =(Muestra)persistencia.buscarObjeto(clase, "nombreMuestra=='"+nombreMuestra+"'");
    		}
    		catch (Exception e) {
    			persistencia.realizarRollback();
    		}
    		return aux;
    	}
               
}