package cuLogin;

import comun.Control;

import persistencia.Persistencia;
import persistencia.domain.Usuario;

public class ControlLogin extends Control{

	
	
	public ControlLogin(){
		yaExiste = true;
	}
	
	/**
	 * Retorna la muestra persistente que cumpla con el nombre y ubicacion pasado como parametro.
	 * @param nombreMuestra
	 * @return
	 */
	public Usuario obtenerUsuario (String nombreUsuario,String password) throws Exception{
		
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Usuario aux = new Usuario();
		try {
			aux =(Usuario)persistencia.buscarObjeto(aux.getClass(), "nombreUsuario=='"+nombreUsuario+"'");
			if (aux==null){
				yaExiste = false;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
		
			persistencia.realizarRollback();
			e.printStackTrace();
		}
		
		return aux;
	}
}
