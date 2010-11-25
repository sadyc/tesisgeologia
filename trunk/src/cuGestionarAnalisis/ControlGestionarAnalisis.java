package cuGestionarAnalisis;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;

/**
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarAnalisis {

        
        /**
         * Contructor por defecto
         */
        public ControlGestionarAnalisis(){}
        
        /**
         * Inserta un analisis con persistencia. 
         */ 
        public Analisis insertarAnalisis(Analisis analisis,String nombreMuestra, String numeroTamiz) throws Exception{
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                Tamiz tamiz= new Tamiz();
                Muestra muestra = new Muestra();
                List listaAnalisis = null;
                try {
                        Class claseMuestra= muestra.getClass();
                        muestra = (Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestra+"'");
                        System.out.println("peso de la muestra"+muestra.getPeso()+"peso retenidodel analisis"+analisis.getPesoRetenido());
                        System.out.println((analisis.getPesoRetenido()*100)/muestra.getPeso());
                        
                        analisis.setMuestra(muestra);
                               
                        Class claseTamiz = tamiz.getClass();
                        analisis.setTamiz((Tamiz)persistencia.buscarObjeto(claseTamiz, "numeroTamiz=="+numeroTamiz));
                        //analisis.setPesoRetenido(pesoRetenido);
                       
                        analisis.setPorcentajeRetenidoParcial((analisis.getPesoRetenido()*100)/muestra.getPeso());
                        listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+nombreMuestra+"'");
                        Integer porcentajeRetenidoAcumulado= 0;
                        if (listaAnalisis.isEmpty()){
                        	analisis.setPorcentajeRetenidoAcumulado((analisis.getPesoRetenido()*100)/muestra.getPeso());
                        	analisis.setPorcentajePasante(100-analisis.getPorcentajeRetenidoParcial());
                        }else{
                        	int i = listaAnalisis.size();
                        	Analisis auxAnalisis = new Analisis();
                        	auxAnalisis = (Analisis)listaAnalisis.get(i-1);
                        	analisis.setPorcentajePasante(auxAnalisis.getPorcentajePasante()- analisis.getPorcentajeRetenidoParcial());
                        	analisis.setPorcentajeRetenidoAcumulado(auxAnalisis.getPorcentajeRetenidoAcumulado()+ analisis.getPorcentajeRetenidoParcial());
                        }                        	
                        persistencia.insertarObjeto(analisis);                                      
                        persistencia.cerrarTransaccion();
                        System.out.println("Analisis insertado con persistencia");
                } catch (Exception e) {
                		e.printStackTrace();
                        persistencia.realizarRollback();
                }
                return analisis;
        }
        
        /**
         * Elimina un analisis persistente. 
         */
        public void eliminarAnalisis(Analisis analisis) throws Exception {
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		try {
    			Analisis auxAnalisis = new Analisis();
    			Class clase = auxAnalisis.getClass();
    			Collection coleccionAnalisis = persistencia.buscarColeccion(clase);
    			Iterator<Analisis> it = coleccionAnalisis.iterator();
    			int i = 0;
    			while (it.hasNext()&& analisis.getMuestra().getNombreMuestra()!= auxAnalisis.getMuestra().getNombreMuestra() && analisis.getTamiz().getNumeroTamiz()!=auxAnalisis.getTamiz().getNumeroTamiz()){
    				auxAnalisis = it.next();
    			    i++;
    			}
    			persistencia.eliminarObjeto(auxAnalisis);
    			persistencia.cerrarTransaccion();
    			System.out.println("Muestra eliminada con persistencia");
    		}
    		catch (Exception e) {
    			persistencia.realizarRollback();
    		}
    		
    	}
        /**
         * Recalcula el analisis despues de eliminar o modificar. 
         */
        public void recalcularAnalisis(Analisis analisis) throws Exception {
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		Muestra muestra = new Muestra();
    		try {
    			String nombreMuestra = analisis.getMuestra().getNombreMuestra();
    			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"'");
    			List listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+nombreMuestra+"'");
    			int i=0;
    			analisis = new Analisis();
    			while (listaAnalisis.size()>i){
    				if (i==0){
    					System.out.println("i = 0");
    					analisis = (Analisis)listaAnalisis.get(i);
    					analisis.setPorcentajeRetenidoAcumulado((analisis.getPesoRetenido()*100)/muestra.getPeso());
                    	analisis.setPorcentajePasante(100-analisis.getPorcentajeRetenidoParcial());
                    	persistencia.insertarObjeto(analisis);
    				}else{
    					System.out.println("i > 0");
    					Analisis auxAnalisis = new Analisis();
    					auxAnalisis = (Analisis)listaAnalisis.get(i-1);
    					analisis = (Analisis)listaAnalisis.get(i);
    					analisis.setPorcentajePasante(auxAnalisis.getPorcentajePasante()- analisis.getPorcentajeRetenidoParcial());
    					analisis.setPorcentajeRetenidoAcumulado(auxAnalisis.getPorcentajeRetenidoAcumulado()+ analisis.getPorcentajeRetenidoParcial());
    					persistencia.insertarObjeto(analisis);
    				}
    				i++;
    			}   			
    			persistencia.cerrarTransaccion();
    			System.out.println("Todo recalculado sin rollback");
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			persistencia.realizarRollback();
    		}
    		
    	}
                        
        /**
         * Retorna todos los elementos persistentes de la clase pasada como parametro.
         */
        public Collection coleccionAnalisisDeMuestra(Class clase,String nombreMuestra) throws Exception {
                Collection<Object> aux = null; 
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                
                try {
                		String filtro = "muestra.nombreMuestra=='"+nombreMuestra+"'";
                		System.out.println(filtro+"la nombre de la muestar");
                        aux = (persistencia.buscarColeccionFiltro(clase, filtro));
                        persistencia.cerrarTransaccion();
                        System.out.println("analisis coleccionados");
                } catch (Exception e) {
                        persistencia.realizarRollback();
                }
                return aux;
        }
        
        public void ModificarAnalisis(Integer pesoRetenido,String nombreMuestra, String numeroTamiz) throws Exception {
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                Analisis analisis = new Analisis();
                try {
                	Analisis auxAnalisis = new Analisis();
        			Class clase = auxAnalisis.getClass();
        			Collection coleccionAnalisis = persistencia.buscarColeccionFiltro(clase, "muestra.nombreMuestra=='"+nombreMuestra+"'");
        			Iterator<Analisis> it = coleccionAnalisis.iterator();
        			int i = 0;
        			while (it.hasNext()&& numeroTamiz!=auxAnalisis.getTamiz().getNumeroTamiz().toString()){
        				auxAnalisis = it.next();
        			    i++;
        			}
        			Muestra muestra = new Muestra();
        			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"'");
        			auxAnalisis.setPesoRetenido(pesoRetenido);
        			auxAnalisis.setPorcentajeRetenidoParcial((auxAnalisis.getPesoRetenido()*100)/muestra.getPeso());
        			persistencia.cerrarTransaccion();
        			System.out.println("Muestra eliminada con persistencia");
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

