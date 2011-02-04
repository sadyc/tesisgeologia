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
 * Clase que permite la carga de ciertos datos para poder utilizar el 
 * Sistema Clasificador de Suelos 
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
	public void insertarMuestra(Muestra muestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(muestra);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Carga una serie de ubicaciones para facilitar el testing.
	 */
	public void cargar (){
		
		Ubicacion ubicacion1 = new Ubicacion("El Impenetrable",Ubicacion.Provincia.Chaco,"SUR 11�11'11\"","OESTE 11�11'11\"");
		Ubicacion ubicacion2 = new Ubicacion("Rio Cuarto",Ubicacion.Provincia.Cordoba,"SUR 22�22'22\""," OESTE 22�22'22\"");
		Ubicacion ubicacion3 = new Ubicacion("Ushuaia",Ubicacion.Provincia.TierraDelFuego,"NORTE 33�33'33\"","ESTE 33�33'33\"");
		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "4665458", "lionel@messi.com");
		Muestra muestra = new Muestra();
		muestra.setNombreMuestra("nombreMuestra");
		muestra.setPeso(new Float(50));
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "4917015", "javier@pastore.com");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "3584192871", "manuvarel@gmail.com");
		Tamiz tamiz1 = new Tamiz("4",4.75);
		Tamiz tamiz2 = new Tamiz("5",4.0);
		Tamiz tamiz3 = new Tamiz("6",3.35);
		Tamiz tamiz4 = new Tamiz("7",2.8);
		Tamiz tamiz5 = new Tamiz("8",2.36);
		Tamiz tamiz6 = new Tamiz("10",2.0);
		Tamiz tamiz7 = new Tamiz("12",1.7);
		Tamiz tamiz8 = new Tamiz("14",1.4);
		Tamiz tamiz9 = new Tamiz("16",1.18);
		Tamiz tamiz11 = new Tamiz("18",1.0);
		Tamiz tamiz12 = new Tamiz("20",0.85);
		Tamiz tamiz13 = new Tamiz("25",0.71);
		Tamiz tamiz14= new Tamiz("30",0.6);
		Tamiz tamiz15= new Tamiz("35",0.5);
		Tamiz tamiz16 = new Tamiz("40",0.425);
		Tamiz tamiz10 = new Tamiz("45",0.355);
		Tamiz tamiz17 = new Tamiz("50",0.3);
		Tamiz tamiz18 = new Tamiz("60",0.25);
		Tamiz tamiz19 = new Tamiz("70",0.212);
		Tamiz tamiz20 = new Tamiz("80",0.18);
		Tamiz tamiz21= new Tamiz("100",0.15);
		Tamiz tamiz22= new Tamiz("120",0.125);
		Tamiz tamiz23 = new Tamiz("140",0.106);
		Tamiz tamiz24 = new Tamiz("170",0.09);
		Tamiz tamiz25 = new Tamiz("200",0.075);
		Tamiz tamiz26= new Tamiz("230",0.063);
		Tamiz tamiz27= new Tamiz("270",0.053);
		Tamiz tamiz28 = new Tamiz("325",0.045);
		Tamiz tamiz29 = new Tamiz("400",0.038);
		Tamiz tamiz30 = new Tamiz("1",25.0);
		Tamiz tamiz31 = new Tamiz("1 1/2",37.50);
		Tamiz tamiz32 = new Tamiz("1 1/4",31.50);
		Tamiz tamiz33 = new Tamiz("1 3/4",45.0);
		Tamiz tamiz34 = new Tamiz("1/4",6.30);
		Tamiz tamiz35 = new Tamiz("1/8",3.17);
		Tamiz tamiz36 = new Tamiz("2",50.0);
		Tamiz tamiz37 = new Tamiz("2 1/2",63.00);
		Tamiz tamiz38 = new Tamiz("3/4",19.00);
		Tamiz tamiz39 = new Tamiz("3/8",9.50);
		Tamiz tamiz40 = new Tamiz("5/16",8.0);
		Tamiz tamiz41 = new Tamiz("5/8",16.0);
		Tamiz tamiz42 = new Tamiz("7/16",11.20);
		Tamiz tamiz43 = new Tamiz("7/8",22.40);
		Usuario usuario1 = new Usuario("Juan", "Perez", "34.771.488", "4917015", "juan@perez.com","juanPerez","pepe");
		Usuario usuario2 = new Usuario("Susana", "Gomez", "34.101.098", "4917015", "Sus@gomez.com","susy","ana");
		Muestra muestra2 = new Muestra("M1",new Float(100),new Float(1),new Float(2),operador1,null,ubicacion1,null);	
		Muestra muestra3 = new Muestra("M2",new Float(250),new Float(2),new Float(6),operador2,null,ubicacion2,null);	
		try {
			insertarMuestra(muestra2);
			insertarMuestra(muestra3);
			//insertarUbicacion(ubicacion1);
			//insertarUbicacion(ubicacion2);
			insertarUbicacion(ubicacion3);
			System.out.println("Comienza carga operadores");
			//insertarOperador(operador1);
		    insertarOperador(operador3);
			//insertarOperador(operador2);
			System.out.println("Comienza carga tamices");
			
			insertarTamiz(tamiz1);
			insertarTamiz(tamiz2);
			insertarTamiz(tamiz3);
			insertarTamiz(tamiz4);
			insertarTamiz(tamiz5);
			insertarTamiz(tamiz6);
			insertarTamiz(tamiz7);
			insertarTamiz(tamiz8);
			insertarTamiz(tamiz9);
			insertarTamiz(tamiz11);
			insertarTamiz(tamiz12);
			insertarTamiz(tamiz13);
			insertarTamiz(tamiz14);
			insertarTamiz(tamiz15);
			insertarTamiz(tamiz16);
			insertarTamiz(tamiz10);
			insertarTamiz(tamiz17);
			insertarTamiz(tamiz18);
			insertarTamiz(tamiz19);
			insertarTamiz(tamiz20);
			insertarTamiz(tamiz21);
			insertarTamiz(tamiz22);
			insertarTamiz(tamiz23);
			insertarTamiz(tamiz24);
			insertarTamiz(tamiz25);
			insertarTamiz(tamiz26);
			insertarTamiz(tamiz27);
			insertarTamiz(tamiz28);
			insertarTamiz(tamiz29);
			insertarTamiz(tamiz30);
			insertarTamiz(tamiz31);
			insertarTamiz(tamiz32);
			insertarTamiz(tamiz33);
			insertarTamiz(tamiz34);
			insertarTamiz(tamiz35);
			insertarTamiz(tamiz36);
			insertarTamiz(tamiz37);
			insertarTamiz(tamiz38);
			insertarTamiz(tamiz39);
			insertarTamiz(tamiz40);
			insertarTamiz(tamiz41);
			insertarTamiz(tamiz42);
			insertarTamiz(tamiz43);
			System.out.println("Comienza carga usuarios");
			insertarUsuario(usuario1); 
			insertarUsuario(usuario2);
		} catch (Exception e) {
			System.out.println("No se pudieron insertar");
			e.printStackTrace();
		}
		
	}
}