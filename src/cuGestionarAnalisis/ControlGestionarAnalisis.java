package cuGestionarAnalisis;

import java.util.Collection;
import java.util.Iterator;
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
        public void insertarAnalisis(Analisis analisis,String nombreMuestra, String numeroTamiz) throws Exception{
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
                        analisis.setPorcentajeRetenidoAcumulado((analisis.getPesoRetenido()*100)/muestra.getPeso());
                        analisis.setMuestra(muestra);
                        analisis.setPorcentajeRetenidoParcial((analisis.getPesoRetenido()*100)/muestra.getPeso());
                        analisis.setPorcentajePasante(100-analisis.getPorcentajeRetenidoParcial());
                        Class claseTamiz = tamiz.getClass();
                        analisis.setTamiz((Tamiz)persistencia.buscarObjeto(claseTamiz, "numeroTamiz=="+numeroTamiz));
                        //analisis.setPesoRetenido(pesoRetenido);
                        persistencia.insertarObjeto(analisis);
                        listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "Muestra=='"+nombreMuestra+"'");
                        Integer porcentajeRetenidoAcumulado= 0;
                        if (listaAnalisis.isEmpty()){
                        	analisis.setPorcentajeRetenidoAcumulado(analisis.getPorcentajeRetenidoParcial());
                        }else{
                        	int i = 1;
                        	while (listaAnalisis.size()>i){
                        		analisis = (Analisis)listaAnalisis.get(i);
                        		porcentajeRetenidoAcumulado = porcentajeRetenidoAcumulado+analisis.getPorcentajeRetenidoParcial();
                        		analisis.setPorcentajeRetenidoAcumulado(porcentajeRetenidoAcumulado);
                        		i++;
                        	}                        	
                        }
                        
                        //persistencia.insertarObjeto(analisis);
                        persistencia.cerrarTransaccion();
                        System.out.println("Analisis insertado con persistencia");
                } catch (Exception e) {
                        persistencia.realizarRollback();
                }
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
    			while (it.hasNext()&& analisis.getMuestra().getNombreMuestra()!= auxAnalisis.getMuestra().getNombreMuestra()){
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
         * Retorna todos los elementos persistentes de la clase pasada como parametro.
         */
        public Collection coleccionAnalisisDeMuestra(Class clase,String nombreMuestra) throws Exception {
                Collection<Object> aux = null; 
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                try {
                		String filtro = "";//"Muestra=='"+nombreMuestra+"'";//"pesoRetenido==8";
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
                        Class claseAnalisis = analisis.getClass();
                        analisis =(Analisis)persistencia.buscarObjeto(claseAnalisis, "nombreMuestra=="+nombreMuestra+" and "+"numeroTamiz=="+numeroTamiz);
                        analisis.setPesoRetenido(pesoRetenido);
                        persistencia.cerrarTransaccion();
                }
                catch (Exception e) {
                        persistencia.realizarRollback();
                        persistencia.cerrarPersistencia();
                }               
        }
        
        
        
        
}

