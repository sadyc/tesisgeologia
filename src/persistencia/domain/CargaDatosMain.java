/**
 * 
 */
package persistencia.domain;

import comun.CargaDatos;



/**
 * @author NAVE
 *
 */
public class CargaDatosMain {
	
	public CargaDatosMain (){
		
	}
	
	public static void main(String[] args) throws Exception {
		CargaDatos cargaDatos = new CargaDatos();
        cargaDatos.cargar();
	}
}
