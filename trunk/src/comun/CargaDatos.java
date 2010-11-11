/**
 * 
 */
package comun;

import persistencia.Persistencia;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;

/**
 * @author TesisGeologia
 *
 */
public class CargaDatos {

	
	public CargaDatos(){
		
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
	 * Inserta una muestra con persistencia. 
	 */ 
	public void insertarOperador(OperadorDeLaboratorio operador) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(operador);
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
		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "30.777.888", "4665458", "lionel@messi.com");
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "4917015", "javier@pastore.com");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "3584192871", "manuvarel@gmail.com");
		try {
			insertarUbicacion(ubicacion1);
			insertarUbicacion(ubicacion2);
			insertarUbicacion(ubicacion3);
			insertarOperador(operador1);
			insertarOperador(operador2);
			insertarOperador(operador3);
		} catch (Exception e) {
			System.out.println("No se pudieron insertar las ubicaciones de muestra");
			e.printStackTrace();
		}
		
	}
}
