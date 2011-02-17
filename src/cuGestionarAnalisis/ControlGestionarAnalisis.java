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

	private boolean yaExiste;
        
        /**
         * Contructor por defecto
         */
        public ControlGestionarAnalisis(){}
        
        
        /**
         * Inserta un analisis con persistencia. 
         */ 
        public String[] insertarAnalisis(Analisis analisis,Muestra muestra, String numeroTamiz) throws Exception{
        		yaExiste=false;
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
                	 	System.out.println("Error al insertar Analisis con persistencia");
                		yaExiste=persistencia.getExiste();
                	    persistencia.realizarRollback();
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
    			System.out.println("Error al eliminar Analisis con persistencia");
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
    					analisis.setPorcentajeRetenidoAcumulado(truncaNum(analisis.getPesoRetenido()*100)/muestra.getPeso());
                    	analisis.setPorcentajePasante(truncaNum(100-analisis.getPorcentajeRetenidoParcial()));
                    	persistencia.insertarObjeto(analisis);
    				}else{
    					System.out.println("i > 0");
    					Analisis auxAnalisis = new Analisis();
    					auxAnalisis = (Analisis)listaAnalisis.get(i-1);
    					analisis = (Analisis)listaAnalisis.get(i);
    					analisis.setPorcentajePasante(truncaNum(auxAnalisis.getPorcentajePasante()- analisis.getPorcentajeRetenidoParcial()));
    					analisis.setPorcentajeRetenidoAcumulado(truncaNum(auxAnalisis.getPorcentajeRetenidoAcumulado()+ analisis.getPorcentajeRetenidoParcial()));
    					persistencia.insertarObjeto(analisis);
    				}
    				i++;
    			}   			
    			persistencia.cerrarTransaccion();
    			System.out.println("Todo recalculado sin rollback");
    		}
    		catch (Exception e) {
    			System.out.println("Error al recalcular Analisis con persistencia");
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
                		System.out.println("Error al obtener coleccion Analisis con persistencia");
                        persistencia.realizarRollback();
                }
                return aux;
        }
        
        public void ModificarAnalisis(Float pesoRetenido,Muestra muestra, String numeroTamiz) throws Exception {
        		yaExiste=false;
                Persistencia persistencia = new Persistencia();
                persistencia.abrirTransaccion();
                Analisis analisis = new Analisis();
                try {
                	System.out.println(numeroTamiz);
                	analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && tamiz.numeroTamiz=='"+numeroTamiz+"'");
        			analisis.setPesoRetenido(pesoRetenido);
        			analisis.setPorcentajeRetenidoParcial(truncaNum(analisis.getPesoRetenido()*100)/muestra.getPeso());
        			persistencia.cerrarTransaccion();
        			System.out.println("Muestra modificada con persistencia");
                }
                catch (Exception e) {
                		System.out.println("Error al modificar Analisis con persistencia");
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
    		try {
    			List listaAnalisis = persistencia.buscarListaFiltro(aux.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
    			int i = 0;
    			if (!listaAnalisis.isEmpty()){
    				while(i<listaAnalisis.size()){
	    				aux = (Analisis)listaAnalisis.get(i);
	    				i++;
	    			}
    			}
    			persistencia.cerrarTransaccion();
    		}
    		catch (Exception e) {
    			System.out.println("Error al obtener ultimo Analisis con persistencia");
    			persistencia.realizarRollback();
    		}
    		return aux;
        }
        
        public Float pesoPasante(Muestra muestra) throws Exception{
        	Persistencia persistencia = new Persistencia();
    		persistencia.abrirTransaccion();
    		Analisis aux = new Analisis();
    		Float resultado = new Float(0);
    		try {
    			List listaAnalisis =persistencia.buscarListaFiltro(aux.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
    			int i = 0;
    			if (!listaAnalisis.isEmpty()){
    				while(i<listaAnalisis.size()){
    	    				aux = (Analisis)listaAnalisis.get(i);
    	    				resultado = resultado + aux.getPesoRetenido();
    	    				i++;
    	    			}
    			}
    			persistencia.cerrarTransaccion();
    			}
    		catch (Exception e) {
    			System.out.println("Error al obtener peso pasante Analisis con persistencia");
    			persistencia.realizarRollback();
    		}
    		return resultado;
        }
        
        /**
    	 * Retorna si un objeto a insertar ya existe en la base de datos.
    	 * @return yaExiste
    	 */
    	public boolean getExiste(){
    		return yaExiste;
    	}
}

