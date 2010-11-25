/**
 * 
 */
package cuCalcularClasificacion;



import java.util.List;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import cuCalcularClasificacion.Clasificaciones.GranoFino;
import cuCalcularClasificacion.Clasificaciones.GranoGrueso;

/**
 * @author TesisGeologia
 * @version 1.0
 */
public class ControlClasificacion {

	/**
	 * Constructor por defecto de la clase.
	 */
	public ControlClasificacion(){}
	
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
	
	/**
	 * Realiza los calculos correspondientes para determinar la clasificacion de una muestra.
	 * @param muestra 
	 */
	public void calcularClasificacionSUCS(Muestra muestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try{
			Analisis analisis = new Analisis();
			ControlClasificacion control = new ControlClasificacion();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"'"; 
			List listaAnalisis = (List)persistencia.buscarListaFiltro(analisis.getClass(), filtro);
			int i = listaAnalisis.size()/2;
			analisis = (Analisis)listaAnalisis.get(i);
			if (analisis.getPorcentajePasante()>50) {
				GranoFino fino = new GranoFino();	
			}
			else{
				GranoGrueso grueso = new GranoGrueso();
			}
			
		}
		catch (Exception e){
			persistencia.realizarRollback();
		}
				
	}
	
	/**
	 * Emite grafico de la clasificacion
	 */
	public void emitirGrafico(){
	}
	
	
	/**
	 * Imprime la clasificacion y el grafico.
	 */
	public void imprimirClasificacion(){
	}
	
	/**
	 * Compara las clasificaciones de dos muetras. 
	 */
	public void compararMuetras(){
	}
}
