package cuLogin;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.Usuario;

public class ControlLogin {

	public ControlLogin(){}
	
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
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		System.out.println(aux.getNombreUsuario());
		return aux;
		
		
	}
	
}
