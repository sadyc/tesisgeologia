/**
 * 
 */
package comun;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.Ubicacion;

/**
 * @author TesisGeologia
 *
 */
public class InsertarUbicaciones {

	
	public InsertarUbicaciones(){
		
	}
	
	/**
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarUbicacion(Ubicacion ubicacion) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(ubicacion);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	/**
	 * Carga una serie de ubicaciones para facilitar el testing.
	 */
	public void cargarUbicaciones (){
		Ubicacion ubicacion1 = new Ubicacion("El Impenetrable",Ubicacion.Provincia.Chaco,"11°11'11\"","11°11'11\"");
		Ubicacion ubicacion2 = new Ubicacion("Rio Cuarto",Ubicacion.Provincia.Cordoba,"22°22'22\"","22°22'22\"");
		Ubicacion ubicacion3 = new Ubicacion("Ushuaia",Ubicacion.Provincia.TierraDelFuego,"33°33'33\"","33°33'33\"");
		try {
			insertarUbicacion(ubicacion1);
			insertarUbicacion(ubicacion2);
			insertarUbicacion(ubicacion3);
			insertarUbicacion(ubicacion3);
		} catch (Exception e) {
			System.out.println("No se pudieron insertar las ubicaciones de muestra");
			e.printStackTrace();
		}
		
	}
}
