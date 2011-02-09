package cuLimiteConsistencia;

import persistencia.Persistencia;
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
        public void insertarConsistencia(Float limiteLiquido ,Float limitePlastico,Muestra muestra) throws Exception{
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                try {
                        muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
                        muestra.setLimiteLiquido(limiteLiquido);
                        muestra.setLimitePlastico(limitePlastico);
                        muestra.calcularIndicePlasticidad();
                        persistencia.cerrarTransaccion();
                        System.out.println("Consistencia insertado con persistencia");
                } catch (Exception e) {
                		e.printStackTrace();
                        persistencia.realizarRollback();
                }
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
                	Muestra muestra = new Muestra();
        			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"'");
        			muestra.setLimitePlastico(limitePlastico);
        			muestra.setLimiteLiquido(limiteLiquido);
        			muestra.calcularIndicePlasticidad();
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
