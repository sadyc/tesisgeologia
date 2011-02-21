package cuLogin;

import persistencia.Persistencia;
import persistencia.domain.Muestra;
import persistencia.domain.Usuario;

public class ControlLogin {

	private boolean encontrado;
	
	public ControlLogin(){
		encontrado = true;
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
				encontrado = false;
			}
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
		
			persistencia.realizarRollback();
			e.printStackTrace();
		}
		
		return aux;
		
		
	}

	/**
	 * @return the encontrado
	 */
	public boolean seEncontro() {
		return encontrado;
	}

	/**
	 * @param encontrado the encontrado to set
	 */
	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}
	
	
}
