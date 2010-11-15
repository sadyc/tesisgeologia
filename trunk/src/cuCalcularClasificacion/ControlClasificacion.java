/**
 * 
 */
package cuCalcularClasificacion;

import persistencia.Persistencia;
import persistencia.domain.Muestra;

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
			persistencia.cerrarPersistencia();
		}
		return aux;
	}
	/**
	 * Metodo que segun el analisis con los tamices calcula la clasificacion de la muestra.
	 */
	public void calcularClasificacion() {
	}
	
	/**
	 * Elimina la clasificacion que almacena una muestra.
	 */
	public void eliminarClasificacion(){
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
