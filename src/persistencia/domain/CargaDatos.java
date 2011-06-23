package persistencia.domain;

import java.sql.DriverManager;
import persistencia.Persistencia;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarCliente.ControlGestionarCliente;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarOperador.ControlGestionarOperador;
import cuGestionarUbicacion.ControlGestionarUbicacion;
import cuGestionarUsuario.ControlGestionarUsuario;
import cuLogin.Encriptar;

/**
 * @author TesisGeologia
 * Clase que permite la carga de ciertos datos para poder utilizar el 
 * Sistema Clasificador de Suelos 
 *  
 * @Version 1.0.
 */
public class CargaDatos {
	private ControlGestionarMuestra controlMuestra;
	private ControlGestionarUbicacion controlUbicacion;
	private ControlGestionarOperador controlOperador;
	private ControlGestionarCliente controlCliente;
	private ControlGestionarUsuario controlUsuario;
	private ControlGestionarAnalisis controlAnalisis;
	
	
	/**
	 * Constructor por defecto.
	 */
	public CargaDatos(){
		controlMuestra = new ControlGestionarMuestra();
		controlUbicacion = new ControlGestionarUbicacion();
		controlUsuario = new ControlGestionarUsuario();
		controlOperador = new ControlGestionarOperador();
		controlCliente = new ControlGestionarCliente();
		controlAnalisis = new ControlGestionarAnalisis();
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
     * Método que permite eliminar la base de datos existente para evitar el surgimiento de conflictos.     
     * @throws Exception
     */
    public void eliminarDB() throws Exception {
    	Statement stmt;
    	Class.forName("com.mysql.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/mysql";
    	Connection con = (Connection) DriverManager.getConnection(url,"root", "root");
    	stmt = (Statement) con.createStatement();
    	stmt.executeUpdate("DROP DATABASE SistemaClasificadorDeSuelos");
    	con.close();
    }	
    
    /**
     * Método que permite crear la base de datos para montar el back-up.
     * @throws Exception
     */
    public void crearDB() throws Exception {
    	Statement stmt;
    	Class.forName("com.mysql.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/mysql";
    	Connection con = (Connection) DriverManager.getConnection(url,"root", "root");
    	stmt = (Statement) con.createStatement();
    	stmt.executeUpdate("CREATE DATABASE SistemaClasificadorDeSuelos");
    	con.close();
    }	
    
	
	
	/**
	 * Carga una serie de datos para facilitar el uso del sistema.
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
		
	    java.util.Date utilDate1 = new java.util.Date();
	    java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
		Encriptar encriptar = new Encriptar();
		String nico = encriptar.hash("kulmino");
		String jperez = encriptar.hash("raton");
		String jalvarez = encriptar.hash("pepe");
		String leo = encriptar.hash("bicicleta");
		String admin = encriptar.hash("admin");
		
		Usuario usuario0 = new Usuario("SCS", "Soft", "00.000.000","admin","Administrador", "tesisgeologia@gmail.com", "0358-4665458",admin);
		Usuario usuario1 = new Usuario("Juan", "Perez", "05.255.333","jperez","Operador", "juan@perez.com", "4917015",jperez);
		Usuario usuario2 = new Usuario("José", "Álvarez", "11.121.321", "jalvarez", "Administrador", "pepe@alvarez", "444-222", jalvarez);
		Usuario usuario3 = new Usuario("Nicolas", "Bettiol", "33.825.312", "nbettiol", "Restringido", "nicolasbettiol@gmail.com", "0358-4632587", nico);
		Usuario usuario4 = new Usuario("Leonardo", "Mármol", "34.414.426", "lmarmol", "Operador", "macyerba@hotmail.com", "0358-4642667", leo);
		
		Cliente cliente1 = new Cliente("Carlos", "Leoni", "12.980.320", "email@email.com", "3584192871");
		Cliente cliente2 = new Cliente("Ernesto", "Shwesteiger", "20.325.414", "ernesto@yahoo.com", "0358-4648494");
		Cliente cliente4 = new Cliente("Francisca", "Arighini", "25.338.977", "fran_ari@hotmail.com", "0358-4917014");
		Cliente cliente3 = new Cliente("JUMALA SA", " ","00.001.183", "contacto@jumala.com", "0358-4404021");
		
		Muestra muestra2 = new Muestra("M1",new Float(100),new Float(1),new Float(2),null,usuario1,null,null,null,null,sqlDate1);	
		Muestra muestra3 = new Muestra("M2",new Float(250),new Float(2),new Float(6),null,usuario0,null,null,null,null,sqlDate1);
		muestra3.setLimiteLiquido("29.5");
		muestra3.setLimitePlastico("26.2");
		muestra3.calcularIndicePlasticidad();
		Muestra muestra1 = new Muestra("RP45",new Float(1250),new Float(2.3),new Float(10.8),null,usuario0,null,null,null,null,sqlDate1);
		muestra1.setLimiteLiquido("35");
		muestra1.setLimitePlastico("5");
		muestra1.calcularIndicePlasticidad();
		

		Ubicacion ubicacion1 = new Ubicacion("ZONA 5","RESISTENCIA","Chaco","-27.4683210","-58.919685");
		Ubicacion ubicacion2 = new Ubicacion("UNRC","RÍO CUARTO","Córdoba","-33.113188","-64.299924");
		Ubicacion ubicacion3 = new Ubicacion("CAMPO 1","USHUAIA","TierraDelFuego","-54.759158","-68.275968");
		Ubicacion ubicacion4 = new Ubicacion("CAMPO 1","CANALS","Córdoba","-33.555915","-62.878930");
		Ubicacion ubicacion5 = new Ubicacion("ALBERDI 8","RÍO CUARTO","Córdoba","-34.335110","-64.336640");
		Ubicacion ubicacion6 = new Ubicacion("CAMPO 1","SANTA ROSA","La Pampa","-36.6122522","-64.302319");

		OperadorDeLaboratorio operador1 = new OperadorDeLaboratorio("Lionel", "Messi", "10.054.605", "4665458", "lionel@messi.com");
		OperadorDeLaboratorio operador2 = new OperadorDeLaboratorio("Javier", "Pastore", "34.101.099", "4917015", "javier@pastore.com");
		OperadorDeLaboratorio operador3 = new OperadorDeLaboratorio("Manuel", "Varela", "34.254.973", "3584192871", "manuvarel@gmail.com");
		OperadorDeLaboratorio operador4 = new OperadorDeLaboratorio("Analía", "Lopez del Corral", "24.277.345", "3586010488", "analia@hotmail.com");
		
		Analisis analisis0 = new Analisis((float) 0, muestra3, tamiz36);
		Analisis analisis1 = new Analisis((float) 7.2, muestra3, tamiz38);
		Analisis analisis2 = new Analisis((float) 19.3, muestra3, tamiz1);
		Analisis analisis3 = new Analisis((float) 9.8, muestra3, tamiz6);
		Analisis analisis4 = new Analisis((float) 26.0, muestra3, tamiz16);
		Analisis analisis5 = new Analisis((float) 32.9, muestra3, tamiz25);

		Analisis analisis6 = new Analisis((float) 0, muestra1, tamiz36);
		Analisis analisis7 = new Analisis((float) 17, muestra1, tamiz38);
		Analisis analisis8 = new Analisis((float) 159.8, muestra1, tamiz1);
		Analisis analisis9 = new Analisis((float) 149.8, muestra1, tamiz6);
		Analisis analisis10 = new Analisis((float) 326.0, muestra1, tamiz16);
		Analisis analisis11 = new Analisis((float) 232.9, muestra1, tamiz25);
		
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
			ubicacion[0] = ubicacion5.getNombreUbicacion();
			ubicacion[1] = ubicacion5.getCiudad();
			ubicacion[2] = ubicacion5.getProvincia();
			ubicacion[3] = ubicacion5.getLatitud();
			ubicacion[4] = ubicacion5.getLongitud();
			controlUbicacion.insertarUbicacion(ubicacion);
			ubicacion[0] = ubicacion6.getNombreUbicacion();
			ubicacion[1] = ubicacion6.getCiudad();
			ubicacion[2] = ubicacion6.getProvincia();
			ubicacion[3] = ubicacion6.getLatitud();
			ubicacion[4] = ubicacion6.getLongitud();
			controlUbicacion.insertarUbicacion(ubicacion);
			
			System.out.println("Comienza carga operadores");
			controlOperador.insertarOperador(operador1);
			controlOperador.insertarOperador(operador3);
			controlOperador.insertarOperador(operador2);
			controlOperador.insertarOperador(operador4);
			
		    System.out.println("Comienza carga clientes");
			controlCliente.insertarCliente(cliente1);
			controlCliente.insertarCliente(cliente2);
			controlCliente.insertarCliente(cliente3);
			controlCliente.insertarCliente(cliente4);
			
			System.out.println("Comienza carga usuarios");
			controlUsuario.insertarUsuario(usuario1);
			controlUsuario.insertarUsuario(usuario2);
			controlUsuario.insertarUsuario(usuario3);
			controlUsuario.insertarUsuario(usuario4);
			controlUsuario.insertarUsuario(usuario0);
			
			System.out.println("Comienza carga muestras");
			controlMuestra.insertarMuestra(muestra2, ubicacion1, operador1, cliente1, usuario1);
			controlMuestra.insertarMuestra(muestra3, ubicacion3, operador3, cliente3, usuario0);
			controlMuestra.insertarMuestra(muestra1, ubicacion4, operador4, cliente4, usuario0);
			
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
			controlAnalisis.insertarAnalisis(analisis6, muestra1, "2");
			controlAnalisis.insertarAnalisis(analisis7, muestra1, "3/4");
			controlAnalisis.insertarAnalisis(analisis8, muestra1, "4");
			controlAnalisis.insertarAnalisis(analisis9, muestra1, "10");
			controlAnalisis.insertarAnalisis(analisis10, muestra1, "40");
			controlAnalisis.insertarAnalisis(analisis11, muestra1, "200");
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("No se pudieron insertar");
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception {
		CargaDatos cargaDatos = new CargaDatos();
		System.out.println("Se elimina la Base de Datos: 'SistemaClasificadorDeSuelos'");
		try {
			cargaDatos.eliminarDB();
		}
		catch(Exception e){
			System.out.println("La base de datos no existia. Se procede a crearla con el nombre de 'SistemaClasificadorDeSuelos'.");
		}
		System.out.println("Se crea la Base de Datos: 'SistemaClasificadorDeSuelos'");
		cargaDatos.crearDB();
		System.out.println("Comienza carga de datos");
		cargaDatos.cargar();
		
		
	}
}
