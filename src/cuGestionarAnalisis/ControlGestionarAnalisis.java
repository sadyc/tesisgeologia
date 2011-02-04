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
        public String[] insertarAnalisis(Analisis analisis,Muestra muestra, String numeroTamiz) throws Exception{
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                Tamiz tamiz= new Tamiz();
                String[] data = new String [5];
                List listaAnalisis = null;
                try {
                        Class claseMuestra= muestra.getClass();
                        Muestra muestraAux = (Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
                        analisis.setMuestra(muestraAux);
                        Class claseTamiz = tamiz.getClass();
                        analisis.setTamiz((Tamiz)persistencia.buscarObjeto(claseTamiz, "numeroTamiz=='"+numeroTamiz+"'"));
                                               
                        analisis.setPorcentajeRetenidoParcial(truncaNum((analisis.getPesoRetenido()*100)/muestra.getPeso()));
                        listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
                        Integer porcentajeRetenidoAcumulado= 0;
                        if (listaAnalisis.isEmpty()){
                        	analisis.setPorcentajeRetenidoAcumulado(truncaNum((analisis.getPesoRetenido()*100)/muestra.getPeso()));
                        	analisis.setPorcentajePasante(truncaNum(100-analisis.getPorcentajeRetenidoParcial()));
                        }else{
                        	int i = listaAnalisis.size();
                        	Analisis auxAnalisis = new Analisis();
                        	auxAnalisis = (Analisis)listaAnalisis.get(i-1);
                        	analisis.setPorcentajePasante(truncaNum(auxAnalisis.getPorcentajePasante()- analisis.getPorcentajeRetenidoParcial()));
                        	analisis.setPorcentajeRetenidoAcumulado(truncaNum(auxAnalisis.getPorcentajeRetenidoAcumulado()+ analisis.getPorcentajeRetenidoParcial()));
                        }
                        data[0]=analisis.getTamiz().getNumeroTamiz();
                        data[1]=analisis.getPesoRetenido().toString();
                        data[2] = analisis.getPorcentajePasante().toString();
                        data[3] = analisis.getPorcentajeRetenidoAcumulado().toString();
                        data[4] = analisis.getPorcentajeRetenidoParcial().toString();
                        persistencia.insertarObjeto(analisis);                                      
                        persistencia.cerrarTransaccion();
                        System.out.println("Analisis insertado con persistencia");
                } catch (Exception e) {
                		e.printStackTrace();
                        persistencia.realizarRollback();
                }
                finally{
        			persistencia.cerrarPersistencia();
        		}
                return data;
        }
        
        /**
         * Elimina un analisis persistente. 
         */
        public void eliminarAnalisis(Analisis analisis) throws Exception {
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		try {
    			Analisis aux = (Analisis) persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+analisis.getMuestra().getNombreMuestra()+"' && tamiz.numeroTamiz=='"+analisis.getTamiz().getNumeroTamiz()+"'");
    			persistencia.eliminarObjeto(aux);
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
        public Collection coleccionAnalisisDeMuestra(Class clase,Muestra muestra) throws Exception {
                Collection<Object> aux = null; 
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                try {
                		String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'";
                		aux = (persistencia.buscarColeccionFiltro(clase, filtro));
                        persistencia.cerrarTransaccion();
                        System.out.println("analisis coleccionados");
                } catch (Exception e) {
                        persistencia.realizarRollback();
                }
                return aux;
        }
        
        public void ModificarAnalisis(Float pesoRetenido,String nombreMuestra, String numeroTamiz) throws Exception {
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
         * Trunca el numero a solo una decimal.
         * @param num
         * @return valor
         * @throws Exception
         */
        public static Float truncaNum(Float num) throws Exception{
	        float valor = 0;
	        valor = num;
	        valor = valor*10;
	        valor = java.lang.Math.round(valor);
	        valor = valor/10;
	        return valor;
        }
        
        /**
         * Retorna el ultimo analisis cargado para la muestra
         * pasada como paramentro.
         * @param muestra
         * @return
         * @throws Exception
         */
        public Analisis ultimoAnalisis(Muestra muestra) throws Exception{
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		Analisis aux = new Analisis();
    		List listaAnalisis = null;
    		try {
    			listaAnalisis =persistencia.buscarListaFiltro(aux.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
    			int i = listaAnalisis.size();
    			aux = (Analisis)listaAnalisis.get(i-1);
    			persistencia.cerrarTransaccion();
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			persistencia.realizarRollback();
    		}
    		return aux;
        }
        
        public Float pesoPasante(Muestra muestra) throws Exception{
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		Analisis aux = new Analisis();
    		List listaAnalisis = null;
    		Float resultado = new Float(0);
    		try {
    			listaAnalisis =persistencia.buscarListaFiltro(aux.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
    			int i = 0;
    			while(i<listaAnalisis.size()){
    				aux = (Analisis)listaAnalisis.get(i);
    				resultado = resultado + aux.getPesoRetenido();
    				i++;
    			}
    			persistencia.cerrarTransaccion();
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			persistencia.realizarRollback();
    		}
    		return resultado;
        }
}

