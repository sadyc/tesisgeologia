/**
 * 
 */
package comun;

import java.sql.Date;

import persistencia.Persistencia;
import persistencia.domain.AASHTO;
import persistencia.domain.Analisis;
import persistencia.domain.Cliente;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.SUCS;
import persistencia.domain.Tamiz;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;
import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarCliente.ControlGestionarCliente;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarOperador.ControlGestionarOperador;
import cuGestionarUbicacion.ControlGestionarUbicacion;
import cuGestionarUsuario.ControlGestionarUsuario;
import cuLimiteConsistencia.ControlLimiteConsistencia;
import cuLogin.Encriptar;

/**
 * @author TesisGeologia
 * Clase que permite la carga de ciertos datos para poder utilizar el 
 * Sistema Clasificador de Suelos 
 */
public class CargaDatos {
	private ControlGestionarMuestra controlMuestra;
	private ControlGestionarUbicacion controlUbicacion;
	private ControlGestionarOperador controlOperador;
	private ControlGestionarCliente controlCliente;
	private ControlGestionarUsuario controlUsuario;
	private ControlGestionarAnalisis controlAnalisis;
	private ControlLimiteConsistencia controlConsistencia;
	
	
	public CargaDatos(){
		controlMuestra = new ControlGestionarMuestra();
		controlUbicacion = new ControlGestionarUbicacion();
		controlUsuario = new ControlGestionarUsuario();
		controlOperador = new ControlGestionarOperador();
		controlCliente = new ControlGestionarCliente();
		controlAnalisis = new ControlGestionarAnalisis();
		controlConsistencia = new ControlLimiteConsistencia();
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
		SUCS sucs15 = new SUCS("GW-GM");
		SUCS sucs16 = new SUCS("GW-GC");
		SUCS sucs17 = new SUCS("GP-GM");
		SUCS sucs18 = new SUCS("GP-GC");
		SUCS sucs19 = new SUCS("SW-SM");
		SUCS sucs20 = new SUCS("SW-SC");
		SUCS sucs21 = new SUCS("SP-SM");
		SUCS sucs22 = new SUCS("SP-SC");
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    java.util.Date utilDate1 = new java.util.Date();
	    java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
		Encriptar encriptar = new Encriptar();
		String a = encriptar.hash("kulmino");
		String b = encriptar.hash("admin");
		String c = encriptar.hash("pepe");
		Usuario usuario1 = new Usuario("Juan", "Perez", "555","admin","Administrador", "juan@perez.com", "4917015",b);
		Usuario usuario2 = new Usuario("José", "Álvarez", "111", "jalvarez", "Administrador", "pepe@alvarez", "444-222", c);
		Usuario usuario3 = new Usuario("Nicolas", "Bettiol", "33.825.312", "nbettiol", "Restringido", "nicolasbettiol@gmail.com", "0358-4632587", a);
		
		Cliente cliente1 = new Cliente("Carlos", "Leoni", "12.980.320", "email@email.com", "3584192871");
		Cliente cliente2 = new Cliente("Ernesto", "Shwesteiger", "20.325.414", "ernesto@yahoo.com", "0358-4648494");
		Cliente cliente3 = new Cliente("JUMALA SA", " ", " ", "contacto@jumala.com", "0358-4404021");
		
		Muestra muestra2 = new Muestra("M1",new Float(100),new Float(1),new Float(2),null,usuario1,null,null,null,null,sqlDate);	
		Muestra muestra3 = new Muestra("M2",new Float(250),new Float(2),new Float(6),null,usuario1,null,null,null,null,sqlDate1);

		Ubicacion ubicacion1 = new Ubicacion("ZONA 5","EL IMPENETRABLE","Chaco","0","0");
		Ubicacion ubicacion2 = new Ubicacion("UNRC","RIO CUARTO","Cordoba","0","1");
		Ubicacion ubicacion3 = new Ubicacion("CAMPO 1","USHUAIA","TierraDelFuego","1","0");
		Ubicacion ubicacion4 = new Ubicacion("CAMPO 1","CANALS","Cordoba","1","1");

		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "4665458", "lionel@messi.com");
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "4917015", "javier@pastore.com");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "3584192871", "manuvarel@gmail.com");
		
		Analisis analisis0 = new Analisis((float) 0, muestra3, tamiz36);
		Analisis analisis1 = new Analisis((float) 7.2, muestra3, tamiz38);
		Analisis analisis2 = new Analisis((float) 19.3, muestra3, tamiz1);
		Analisis analisis3 = new Analisis((float) 9.8, muestra3, tamiz6);
		Analisis analisis4 = new Analisis((float) 26.0, muestra3, tamiz16);
		Analisis analisis5 = new Analisis((float) 32.9, muestra3, tamiz25);
		
		try {
			System.out.println("Comienza carga ubicaciones");
			String [] ubicacion = {ubicacion2.getNombreUbicacion(),ubicacion2.getCiudad(),ubicacion2.getProvincia(),ubicacion2.getLatitud(),ubicacion2.getLongitud()};
			controlUbicacion.insertarUbicacion(ubicacion);
			ubicacion[0] = ubicacion3.getNombreUbicacion();
			ubicacion[1] = ubicacion3.getCiudad();
			ubicacion[2] = ubicacion3.getProvincia();
			ubicacion[3] = ubicacion3.getLatitud();
			ubicacion[4] = ubicacion3.getLongitud();
			controlUbicacion.insertarUbicacion(ubicacion);
			ubicacion[0] = ubicacion1.getNombreUbicacion();
			ubicacion[1] = ubicacion1.getCiudad();
			ubicacion[2] = ubicacion1.getProvincia();
			ubicacion[3] = ubicacion1.getLatitud();
			ubicacion[4] = ubicacion1.getLongitud();
			controlUbicacion.insertarUbicacion(ubicacion);
			ubicacion[0] = ubicacion4.getNombreUbicacion();
			ubicacion[1] = ubicacion4.getCiudad();
			ubicacion[2] = ubicacion4.getProvincia();
			ubicacion[3] = ubicacion4.getLatitud();
			ubicacion[4] = ubicacion4.getLongitud();
			controlUbicacion.insertarUbicacion(ubicacion);
			
			System.out.println("Comienza carga operadores");
			controlOperador.insertarOperador(operador1);
			controlOperador.insertarOperador(operador3);
			controlOperador.insertarOperador(operador2);
			
		    System.out.println("Comienza carga clientes");
			controlCliente.insertarCliente(cliente1);
			controlCliente.insertarCliente(cliente2);
			controlCliente.insertarCliente(cliente3);
			
			System.out.println("Comienza carga usuarios");
			controlUsuario.insertarUsuario(usuario1);
			controlUsuario.insertarUsuario(usuario2);
			controlUsuario.insertarUsuario(usuario3);
			
			System.out.println("Comienza carga muestras");
			controlMuestra.insertarMuestra(muestra2, ubicacion1, operador1, cliente1, usuario1);
			controlMuestra.insertarMuestra(muestra3, ubicacion3, operador3, cliente2, usuario1);
			
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
			System.out.println("Comienza carga clasificaciones SUCS");
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
			insertarSucs(sucs15);
			insertarSucs(sucs16);
			insertarSucs(sucs17);
			insertarSucs(sucs18);
			insertarSucs(sucs19);
			insertarSucs(sucs20);
			insertarSucs(sucs21);
			insertarSucs(sucs22);
			
			System.out.println("Comienza carga clasificaciones AASHTO");
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
			
			System.out.println("Comienza carga analisis");
			controlAnalisis.insertarAnalisis(analisis0, muestra3, "2");
			controlAnalisis.insertarAnalisis(analisis1, muestra3, "3/4");
			controlAnalisis.insertarAnalisis(analisis2, muestra3, "4");
			controlAnalisis.insertarAnalisis(analisis3, muestra3, "10");
			controlAnalisis.insertarAnalisis(analisis4, muestra3, "40");
			controlAnalisis.insertarAnalisis(analisis5, muestra3, "200");
			
			System.out.println("Comienza carga limite consistencia");
			controlConsistencia.insertarConsistencia((float)29.5,(float)26.2, muestra3);
			
		} catch (Exception e) {
			System.out.println("No se pudieron insertar");
			e.printStackTrace();
		}
		
	}
}
