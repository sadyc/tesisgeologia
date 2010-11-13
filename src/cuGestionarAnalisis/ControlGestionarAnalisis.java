package cuGestionarAnalisis;

import java.util.Collection;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Tamiz;
import persistencia.domain.Ubicacion;

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
		try {
			Class claseMuestra= muestra.getClass();
			analisis.setMuestra((Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+nombreMuestra+"'"));
			Class claseTamiz = tamiz.getClass();
			analisis.setTamiz((Tamiz)persistencia.buscarObjeto(claseTamiz, "numeroTamiz=="+numeroTamiz));
			//analisis.setPesoRetenido(pesoRetenido);
			persistencia.insertarObjeto(analisis);
			persistencia.cerrarTransaccion();
			System.out.println("Analisis insertado con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		persistencia.cerrarTransaccion();
	}
	
	/**
	 * Elimina un analisis persistente. 
	 */
	public void eliminarAnalisis(Analisis analisis) throws Exception {
		Persistencia persistencia = new Persistencia();
		try {
		//	persistencia.eliminarObjeto(analisis);
			persistencia.cerrarTransaccion();
			System.out.println("Analisis eliminado con persistencia");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos persistentes de la clase pasada como parametro.
	 */
	public Collection coleccionAnalisisDeMuestra(Class clase,String nombreMuestra) throws Exception {
		Collection<Object> aux = null; 
		Persistencia persistencia = new Persistencia();
		try {
			String filtro = "nombreMuestra=="+nombreMuestra;
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
	