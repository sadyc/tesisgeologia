package cuGestionarAnalisis;

import java.util.Collection;
import java.util.List;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;

import comun.Control;

/**
 * @brief Clase que se utiliza para gestionar los datos con persistencia en la base de datos del sistema.
 * @author tesisGeologia
 * @version 1.0
 */

public class ControlGestionarAnalisis extends Control {

	/**
	 * Contructor por defecto
	 */
	public ControlGestionarAnalisis(){}


	/**
	 * Inserta un analisis con persistencia.
	 * @param analisis, análisis que haremos persistente.
	 * @param muestra, muestra a la que corresponde el análisis.
	 * @param numeroTamiz, tamiz que corresponde al análisis.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
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
			if (listaAnalisis.isEmpty()){
				System.out.println(analisis.getPesoRetenido()*100);
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
		} catch (Exception e) {
			System.out.println("Error al insertar Analisis con persistencia");
			persistencia.realizarRollback();
		}
		return data;
	}

	/**
	 * Elimina un análisis persistente.
	 * @param análisis, es el análisis a eliminar.  
	 */
	public void eliminarAnalisis(Analisis analisis) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			Analisis aux = (Analisis) persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+analisis.getMuestra().getNombreMuestra()+"' && tamiz.numeroTamiz=='"+analisis.getTamiz().getNumeroTamiz()+"'");
			persistencia.eliminarObjeto(aux);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al eliminar Analisis con persistencia");
			persistencia.realizarRollback();
		}

	}
	/**
	 * Recalcula los analisis después de eliminar o modificar.
	 * @param analisis, analisis a recalcular. 
	 */
	@SuppressWarnings("rawtypes")
	public void recalcularAnalisis(Analisis analisis) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra muestra = new Muestra();
		try {
			muestra = analisis.getMuestra();
			List listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
			int i=0;
			analisis = new Analisis();
			while (listaAnalisis.size()>i){
				if (i==0){
					analisis = (Analisis)listaAnalisis.get(i);
					analisis.setPorcentajeRetenidoAcumulado(truncaNum(analisis.getPesoRetenido()*100)/muestra.getPeso());
					analisis.setPorcentajePasante(truncaNum(100-analisis.getPorcentajeRetenidoParcial()));
					persistencia.insertarObjeto(analisis);
				}else{
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
		}
		catch (Exception e) {
			System.out.println("Error al recalcular Analisis con persistencia");
			persistencia.realizarRollback();
		}

	}

	/**
	 * Retorna todos los elementos persistentes de la clase pasada como parámetro.
	 * @param muestra, muestra de la que se desean obtener los an�lisis.
	 * @return coleccion de analisis de una muestra.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection coleccionAnalisisDeMuestra(Class clase,Muestra muestra) throws Exception {
		Collection<Object> aux = null; 
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'";
			aux = (persistencia.buscarColeccionFiltro(clase, filtro));
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			System.out.println("Error al obtener coleccion Analisis con persistencia");
			persistencia.realizarRollback();
		}
		return aux;
	}


	/**
	 * Método que me permite modificar un analisis con los datos pasados como par�metros.
	 * @param pesoRetenido, nuevo peso a ser modificado del an�lisis.
	 * @param muestra, muestra a la que corresponde el an�lisis a ser modificado.
	 * @param numeroTamiz, tamiz al que se le va a modificar el an�lisis.
	 * @throws Exception
	 */
	public void ModificarAnalisis(String pesoRetenido,Muestra muestra, String numeroTamiz) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Analisis analisis = new Analisis();
		try {
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"' && tamiz.numeroTamiz=='"+numeroTamiz+"'");
			analisis.setPesoRetenido(pesoRetenido);
			analisis.setPorcentajeRetenidoParcial(truncaNum(analisis.getPesoRetenido()*100)/muestra.getPeso());
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar Analisis con persistencia");
			persistencia.realizarRollback();
		}               
	}

	/**
	 * Trunca el número a solo una decimal.
	 * @param num, número a ser truncado.
	 * @return valor, el valor pasado como parametro, pero truncado a un solo decimal.
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
	 * Retorna el último analisis cargado para la muestra pasada como paramentro.
	 * @param muestra, muestra de la que se desea obtener el último analisis calculado.
	 * @return el último análisis calculado a la muestra pasada como parámetro.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
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
			System.out.println("Error al obtener último Analisis con persistencia");
			persistencia.realizarRollback();
		}
		return aux;
	}

	/**
	 * @param muestra.
	 * @return resultado.
	 * @throws Exception.
	 */
	@SuppressWarnings("rawtypes")
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
}

