/**
 * 
 */
package comun;

import persistencia.Persistencia;
import persistencia.domain.AASHTO;
import persistencia.domain.Cliente;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.SUCS;
import persistencia.domain.Tamiz;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;
import cuLogin.Encriptar;

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
	 * Inserta un cliente con persistencia. 
	 */ 
	public void insertarCliente(Cliente cliente) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(cliente);
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
	 * Inserta una SUCS con persistencia. 
	 */ 
	public void insertarSucs(SUCS sucs) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(sucs);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Inserta una AASHTO con persistencia. 
	 */ 
	public void insertarAashto(AASHTO aashto) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			persistencia.insertarObjeto(aashto);
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * Carga una serie de ubicaciones para facilitar el testing.
	 * @throws Exception 
	 */
	public void cargar () throws Exception{
		

		Ubicacion ubicacion1 = new Ubicacion("UBA","El Impenetrable","Chaco","0","0");
		Ubicacion ubicacion2 = new Ubicacion("UNRC","Rio Cuarto","Cordoba","0","1");
		Ubicacion ubicacion3 = new Ubicacion("Campo 1","Ushuaia","TierraDelFuego","1","0");

		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "lionel@messi.com", "4665458");
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "javier@pastore.com", "4917015");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "manuvarel@gmail.com", "3584192871");
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
		
		
		AASHTO aashto1 = new AASHTO("A1a");
		AASHTO aashto2 = new AASHTO("A1b");
		AASHTO aashto3 = new AASHTO("A3");
		AASHTO aashto4 = new AASHTO("A24");
		AASHTO aashto5 = new AASHTO("A25");
		AASHTO aashto6 = new AASHTO("A26");
		AASHTO aashto7 = new AASHTO("A27");
		AASHTO aashto8 = new AASHTO("A4");
		AASHTO aashto9 = new AASHTO("A5");
		AASHTO aashto10 = new AASHTO("A6");
		AASHTO aashto11 = new AASHTO("A7");
		
		insertarAashto(aashto1);
		insertarAashto(aashto2);
		insertarAashto(aashto3);
		insertarAashto(aashto4);
		insertarAashto(aashto5);
		insertarAashto(aashto6);
		insertarAashto(aashto7);
		insertarAashto(aashto8);
		insertarAashto(aashto9);
		insertarAashto(aashto10);
		insertarAashto(aashto11);
		
		
		SUCS sucs = new SUCS("ML");
		SUCS sucs1 = new SUCS("CL");
		SUCS sucs2 = new SUCS("OL");
		SUCS sucs3 = new SUCS("MH");
		SUCS sucs4 = new SUCS("CH");
		SUCS sucs5 = new SUCS("OH");
		SUCS sucs6 = new SUCS("PT");
		SUCS sucs7 = new SUCS("SW");
		SUCS sucs8 = new SUCS("SP");
		SUCS sucs9 = new SUCS("SC");
		SUCS sucs10 = new SUCS("SM");
		SUCS sucs11 = new SUCS("GW");
		SUCS sucs12 = new SUCS("GP");
		SUCS sucs13 = new SUCS("GM");
		SUCS sucs14 = new SUCS("GC");
		
		insertarSucs(sucs);
		insertarSucs(sucs1);
		insertarSucs(sucs2);
		insertarSucs(sucs3);
		insertarSucs(sucs4);
		insertarSucs(sucs5);
		insertarSucs(sucs6);
		insertarSucs(sucs7);
		insertarSucs(sucs8);
		insertarSucs(sucs9);
		insertarSucs(sucs10);
		insertarSucs(sucs11);
		insertarSucs(sucs12);
		insertarSucs(sucs13);
		insertarSucs(sucs14);
		
		Encriptar encriptar = new Encriptar();
		String a = encriptar.hash("ana");
		String b = encriptar.hash("pepe");
		Usuario usuario1 = new Usuario("Juan", "Perez", "555","juanPerez","administrador", "juan@perez.com", "4917015",b);
		Usuario usuario2 = new Usuario("pepe", "grillo", "111", "pepito", "administrador", "pepe@grillo", "444-222", "pepito el grosso");
		Cliente cliente1 = new Cliente("cliente 1", "no se", "dni", "email", "tel");
		Muestra muestra2 = new Muestra("M1",new Float(100),new Float(1),new Float(2),operador1,null,ubicacion1,null,null,cliente1,null);	
	//	Muestra muestra3 = new Muestra("M2",new Float(250),new Float(2),new Float(6),operador2,null,ubicacion2,null,null,cliente1,null);	
		try {
			
			System.out.println("Comienza carga muestras");
			insertarMuestra(muestra2);
	//		insertarMuestra(muestra3);
			//insertarUbicacion(ubicacion1);
			//insertarUbicacion(ubicacion2);
			insertarUbicacion(ubicacion3);
			System.out.println("Comienza carga operadores");
			//insertarOperador(operador1);
		    insertarOperador(operador3);
			//insertarOperador(operador2);
		    System.out.println("Comienza carga clientes");
			//insertarCliente(cliente1);
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
