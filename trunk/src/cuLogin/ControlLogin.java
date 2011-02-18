package cuLogin;

import persistencia.Persistencia;
import persistencia.domain.HMuestra;
import persistencia.domain.DUsuario;

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
	public DUsuario obtenerUsuario (String nombreUsuario,String password) throws Exception{
		
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		DUsuario aux = new DUsuario();
		try {
			aux =(DUsuario)persistencia.buscarObjeto(aux.getClass(), "nombreUsuario=='"+nombreUsuario+"'");
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
