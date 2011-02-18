/**
 * 
 */
package comun;

import persistencia.Persistencia;
import persistencia.domain.BAASHTO;
import persistencia.domain.DCliente;
import persistencia.domain.HMuestra;
import persistencia.domain.GOperadorDeLaboratorio;
import persistencia.domain.BSUCS;
import persistencia.domain.ETamiz;
import persistencia.domain.FUbicacion;
import persistencia.domain.DUsuario;
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
	public void insertarUbicacion(FUbicacion ubicacion) throws Exception{
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
	public void insertarOperador(GOperadorDeLaboratorio operador) throws Exception{
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
	public void insertarCliente(DCliente cliente) throws Exception{
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
	public void insertarTamiz(ETamiz tamiz) throws Exception{
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
	public void insertarUsuario(DUsuario usuario) throws Exception{
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
	public void insertarMuestra(HMuestra muestra) throws Exception{
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
	 * Inserta una BSUCS con persistencia. 
	 */ 
	public void insertarSucs(BSUCS sucs) throws Exception{
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
	 * Inserta una BAASHTO con persistencia. 
	 */ 
	public void insertarAashto(BAASHTO aashto) throws Exception{
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
		

		FUbicacion ubicacion1 = new FUbicacion("UBA","El Impenetrable","Chaco","0","0");
		FUbicacion ubicacion2 = new FUbicacion("UNRC","Rio Cuarto","Cordoba","0","1");
		FUbicacion ubicacion3 = new FUbicacion("Campo 1","Ushuaia","TierraDelFuego","1","0");

		GOperadorDeLaboratorio operador1 = new GOperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "lionel@messi.com", "4665458");
		GOperadorDeLaboratorio operador2 = new GOperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "javier@pastore.com", "4917015");
		GOperadorDeLaboratorio operador3 = new GOperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "manuvarel@gmail.com", "3584192871");
		ETamiz tamiz1 = new ETamiz("4",4.75);
		ETamiz tamiz2 = new ETamiz("5",4.0);
		ETamiz tamiz3 = new ETamiz("6",3.35);
		ETamiz tamiz4 = new ETamiz("7",2.8);
		ETamiz tamiz5 = new ETamiz("8",2.36);
		ETamiz tamiz6 = new ETamiz("10",2.0);
		ETamiz tamiz7 = new ETamiz("12",1.7);
		ETamiz tamiz8 = new ETamiz("14",1.4);
		ETamiz tamiz9 = new ETamiz("16",1.18);
		ETamiz tamiz11 = new ETamiz("18",1.0);
		ETamiz tamiz12 = new ETamiz("20",0.85);
		ETamiz tamiz13 = new ETamiz("25",0.71);
		ETamiz tamiz14= new ETamiz("30",0.6);
		ETamiz tamiz15= new ETamiz("35",0.5);
		ETamiz tamiz16 = new ETamiz("40",0.425);
		ETamiz tamiz10 = new ETamiz("45",0.355);
		ETamiz tamiz17 = new ETamiz("50",0.3);
		ETamiz tamiz18 = new ETamiz("60",0.25);
		ETamiz tamiz19 = new ETamiz("70",0.212);
		ETamiz tamiz20 = new ETamiz("80",0.18);
		ETamiz tamiz21= new ETamiz("100",0.15);
		ETamiz tamiz22= new ETamiz("120",0.125);
		ETamiz tamiz23 = new ETamiz("140",0.106);
		ETamiz tamiz24 = new ETamiz("170",0.09);
		ETamiz tamiz25 = new ETamiz("200",0.075);
		ETamiz tamiz26= new ETamiz("230",0.063);
		ETamiz tamiz27= new ETamiz("270",0.053);
		ETamiz tamiz28 = new ETamiz("325",0.045);
		ETamiz tamiz29 = new ETamiz("400",0.038);
		ETamiz tamiz30 = new ETamiz("1",25.0);
		ETamiz tamiz31 = new ETamiz("1 1/2",37.50);
		ETamiz tamiz32 = new ETamiz("1 1/4",31.50);
		ETamiz tamiz33 = new ETamiz("1 3/4",45.0);
		ETamiz tamiz34 = new ETamiz("1/4",6.30);
		ETamiz tamiz35 = new ETamiz("1/8",3.17);
		ETamiz tamiz36 = new ETamiz("2",50.0);
		ETamiz tamiz37 = new ETamiz("2 1/2",63.00);
		ETamiz tamiz38 = new ETamiz("3/4",19.00);
		ETamiz tamiz39 = new ETamiz("3/8",9.50);
		ETamiz tamiz40 = new ETamiz("5/16",8.0);
		ETamiz tamiz41 = new ETamiz("5/8",16.0);
		ETamiz tamiz42 = new ETamiz("7/16",11.20);
		ETamiz tamiz43 = new ETamiz("7/8",22.40);
		
		
		BAASHTO aashto1 = new BAASHTO("A1a");
		BAASHTO aashto2 = new BAASHTO("A1b");
		BAASHTO aashto3 = new BAASHTO("A3");
		BAASHTO aashto4 = new BAASHTO("A24");
		BAASHTO aashto5 = new BAASHTO("A25");
		BAASHTO aashto6 = new BAASHTO("A26");
		BAASHTO aashto7 = new BAASHTO("A27");
		BAASHTO aashto8 = new BAASHTO("A4");
		BAASHTO aashto9 = new BAASHTO("A5");
		BAASHTO aashto10 = new BAASHTO("A6");
		BAASHTO aashto11 = new BAASHTO("A7");
		
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
		
		
		BSUCS sucs = new BSUCS("ML");
		BSUCS sucs1 = new BSUCS("CL");
		BSUCS sucs2 = new BSUCS("OL");
		BSUCS sucs3 = new BSUCS("MH");
		BSUCS sucs4 = new BSUCS("CH");
		BSUCS sucs5 = new BSUCS("OH");
		BSUCS sucs6 = new BSUCS("PT");
		BSUCS sucs7 = new BSUCS("SW");
		BSUCS sucs8 = new BSUCS("SP");
		BSUCS sucs9 = new BSUCS("SC");
		BSUCS sucs10 = new BSUCS("SM");
		BSUCS sucs11 = new BSUCS("GW");
		BSUCS sucs12 = new BSUCS("GP");
		BSUCS sucs13 = new BSUCS("GM");
		BSUCS sucs14 = new BSUCS("GC");
		
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
		DUsuario usuario1 = new DUsuario("Juan", "Perez", "555","juanPerez","administrador", "juan@perez.com", "4917015",b);
		DUsuario usuario2 = new DUsuario("pepe", "grillo", "111", "pepito", "administrador", "pepe@grillo", "444-222", "pepito el grosso");
		DCliente cliente1 = new DCliente("cliente 1", "no se", "dni", "email", "tel");
		HMuestra muestra2 = new HMuestra("M1",new Float(100),new Float(1),new Float(2),operador1,null,ubicacion1,null,null,cliente1,null);	
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
