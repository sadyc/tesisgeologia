/**
 * 
 */
package comun;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Tamiz;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

/**
 * @author TesisGeologia
 *
 */
public class CargaDatos {

	
	public CargaDatos(){
		
	}
	
	/**
	 * Inserta una ubicacion con persistencia. 
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
	 * Inserta un operadorLaboratorio con persistencia. 
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
	 * Inserta un tamiz con persistencia. 
	 */ 
	public void insertarTamiz(Tamiz tamiz) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(tamiz);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Inserta un usuario con persistencia. 
	 */ 
	public void insertarUsuario(Usuario usuario) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(usuario);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Inserta un usuario con persistencia. 
	 */ 
	public void insertarAnalisis(Analisis analisis) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(analisis);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Carga una serie de ubicaciones para facilitar el testing.
	 */
	public void cargar (){
		Ubicacion ubicacion1 = new Ubicacion("El Impenetrable",Ubicacion.Provincia.Chaco,"11°11'11\"","11°11'11\"");
		Ubicacion ubicacion2 = new Ubicacion("Rio Cuarto",Ubicacion.Provincia.Cordoba,"22°22'22\"","22°22'22\"");
		Ubicacion ubicacion3 = new Ubicacion("Ushuaia",Ubicacion.Provincia.TierraDelFuego,"33°33'33\"","33°33'33\"");
		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "4665458", "lionel@messi.com");
		Muestra muestra = new Muestra();
		muestra.setNombreMuestra("nombreMuestra");
		muestra.setPeso(50);
		//operador1.addMuestra(muestra);
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "4917015", "javier@pastore.com");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "3584192871", "manuvarel@gmail.com");
		Tamiz tamiz1 = new Tamiz(1,1);
		//Collection<Analisis> analisis = new HashSet();
		//tamiz1.setAnalisisTamiz(analisis);
		Tamiz tamiz2 = new Tamiz(2,2);
		Tamiz tamiz3 = new Tamiz(3,3);
		Usuario usuario1 = new Usuario("Juan", "Perez", "34.101.099", "4917015", "juan@perez.com","juanPerez","pepe");
		Usuario usuario2 = new Usuario("Susana", "Gomez", "34.101.098", "4917015", "Sus@gomez.com","susy","ana");
		Analisis analisis1 = new Analisis(10,muestra, tamiz1);
		
		try {
			insertarUbicacion(ubicacion1);
			insertarUbicacion(ubicacion2);
			insertarUbicacion(ubicacion3);
			System.out.println("Comienza carga operadores");
			insertarOperador(operador1);
			//System.out.println("quiza Inserto a Messi");
			insertarOperador(operador3);
			//insertarOperador(operador2);
			insertarTamiz(tamiz1);
			insertarTamiz(tamiz2);
			insertarTamiz(tamiz3);
			System.out.println("Comienza carga usuarios");
			insertarUsuario(usuario1);    //  ver  "value-strategy"
			insertarUsuario(usuario2);
			//insertarAnalisis(analisis1);
		} catch (Exception e) {
			System.out.println("No se pudieron insertar");
			e.printStackTrace();
		}
		
	}
}
