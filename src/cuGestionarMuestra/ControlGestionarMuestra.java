/**
 * 
 */
package cuGestionarMuestra;


import java.util.Collection;
import java.util.List;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Cliente;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

/**
 * Clase que se utiliza para gestionar los datos de una muestra 
 * con persistencia en la base de datos del sistema.
 * 
 * @author tesisGeologia
 * @version 1.0
 */
public class ControlGestionarMuestra {
	private boolean yaExiste;
	
	/**
	 * Contructor por defecto
	 */
	public ControlGestionarMuestra(){}
	
	/**
	 * Inserta una muestra con persistencia.
	 * @param mu muestra a insertar.
	 * @param ubicacion ubicacion a la que se asocia la muestra.
	 * @param operador operador a la que se asocia la muestra.
	 * @param cliente cliente a la que se asocia la muestra.
	 * @param usuario1 usuario a la que se asocia la muestra.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void insertarMuestra(Muestra mu, Ubicacion ubicacion, OperadorDeLaboratorio operador, Cliente cliente, Usuario usuario1) throws Exception{
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			Usuario usuario = usuario1;
			Class claseUbicacion = ubicacion.getClass();
			if ((Muestra)persistencia.buscarObjeto(mu.getClass(), "nombreMuestra=='"+mu.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"' && ubicacion.ciudad=='"+ubicacion.getCiudad()+"'")==null){
				mu.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "ciudad=='"+ubicacion.getCiudad()+"' && nombreUbicacion=='"+ubicacion.getNombreUbicacion()+"'"));
				Class claseOperador = operador.getClass();
				mu.setOperadorLaboratorio((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+operador.getDni()+"'"));
				Class claseUsuario = usuario.getClass();
				mu.setUsuario((Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+usuario.getDni()+"'")); 
				if (cliente != null){
					Class claseCliente = cliente.getClass();
					mu.setCliente((Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+cliente.getDni()+"'"));
				}
				
				persistencia.insertarObjeto(mu);

			}
			else{
				yaExiste=true;
			}
			persistencia.cerrarTransaccion();
		} catch (Exception e) {
			System.out.println("Fatal error en ControlGestionarMuestra insertar");
			persistencia.realizarRollback();
		}
	}
	
	/**
	 * @param nombreMuestra nombre de la muestra a eliminar
	 * @param ubicacion ubicacion de la muestra a eliminar.
	 * Elimina una muestra con persistencia. 
	 */
	public void eliminarMuestra(String nombreMuestra, String ubicacion, String ciudad) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try {
			Muestra muestra = new Muestra();
			Muestra auxMuestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"' && ubicacion.ciudad=='"+ciudad+"'");
			persistencia.eliminarObjeto(auxMuestra);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
	}
			
	/**
	 * Retorna todos los elementos de la clase pasada como persistente.
	 * @param clase clase a la que perteneceran los elementos de la coleccion.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection coleccionMuestras(Class clase) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Collection<Muestra> aux = null;
		try {
			aux = (persistencia.buscarColeccion(clase));
			persistencia.cerrarTransaccion();
			System.out.println("La coleccion ha sido cargada");
		} catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}

	/**
	 * Modifica una muestra con persistencia. 
	 * @param nombreMuestraModificar 
	 * @param ubicacionModificar
	 * @param data
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void ModificarMuestra(Muestra muestra, String[] data) throws Exception {
		yaExiste=false;
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			Class claseMuestra = aux.getClass();
			if (muestra.getNombreMuestra().equals(data[1]) && muestra.getUbicacion().getNombreUbicacion().equals(data[0]) && muestra.getUbicacion().getCiudad().equals(data[7])){
				aux =(Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
				aux.setPeso(data[2]);
				if (!muestra.getPeso().equals(data[2])){
					eliminarAnalisis(muestra,persistencia);
					aux.setAashto(null);
					aux.setSucs(null);
				}
				aux.setNombreMuestra(data[1]);
				aux.setProfundidadInicial(data[3]);
				aux.setProfundidadFinal(data[4]);
				OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
				Class claseOperador = operador.getClass();
				aux.setOperadorLaboratorio((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+data[5]+"'"));
				Cliente cliente = new Cliente();
				Class claseCliente = cliente.getClass();
				aux.setCliente((Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+data[6]+"'"));
				Ubicacion ubicacion = new Ubicacion();
				Class claseUbicacion = ubicacion.getClass();
				aux.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+data[0]+"' && ciudad=='"+data[7]+"'"));
				Usuario usuario = new Usuario();
				Class claseUsuario = usuario.getClass();
				aux.setUsuario((Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+data[8]+"'"));
				java.util.Date utilDate = new java.util.Date();
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    aux.setFecha(sqlDate);
			}
			else{
				if ((Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+data[1]+"' && ubicacion.nombreUbicacion=='"+data[0]+"' && ubicacion.ciudad=='"+data[7]+"'")==null){
					aux =(Muestra)persistencia.buscarObjeto(claseMuestra, "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && ubicacion.ciudad=='"+ muestra.getUbicacion().getCiudad()+"'");
					aux.setPeso(data[2]);
					if (!muestra.getPeso().equals(data[2])){
						eliminarAnalisis(muestra,persistencia);
						aux.setAashto(null);
						aux.setSucs(null);
					}
					aux.setNombreMuestra(data[1]);
					aux.setProfundidadInicial(data[3]);
					aux.setProfundidadFinal(data[4]);
					OperadorDeLaboratorio operador = new OperadorDeLaboratorio();
					Class claseOperador = operador.getClass();
					aux.setOperadorLaboratorio((OperadorDeLaboratorio)persistencia.buscarObjeto(claseOperador, "dni=='"+data[5]+"'"));
					Cliente cliente = new Cliente();
					Class claseCliente = cliente.getClass();
					aux.setCliente((Cliente)persistencia.buscarObjeto(claseCliente, "dni=='"+data[6]+"'"));
					Ubicacion ubicacion = new Ubicacion();
					Class claseUbicacion = ubicacion.getClass();
					aux.setUbicacion((Ubicacion)persistencia.buscarObjeto(claseUbicacion, "nombreUbicacion=='"+data[0]+"' && ciudad=='"+data[7]+"'"));
					Usuario usuario = new Usuario();
					Class claseUsuario = usuario.getClass();
					aux.setUsuario((Usuario)persistencia.buscarObjeto(claseUsuario, "dni=='"+data[8]+"'"));
					java.util.Date utilDate = new java.util.Date();
				    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				    aux.setFecha(sqlDate);
				}
				else{
					yaExiste=true;
				}
			}			
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			System.out.println("Error al modificar");
			e.printStackTrace();
			persistencia.realizarRollback();
		}		
	}
	
	
	@SuppressWarnings("rawtypes")
	private void eliminarAnalisis(Muestra muestra, Persistencia persistencia) throws Exception {
		Analisis analisis =new Analisis();
		
		List analisisLista = (List)persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
		int i = 0;
		while (analisisLista.size()>i) {
			analisis = (Analisis) analisisLista.get(i);
			persistencia.eliminarObjeto(analisis);
			i++;
		}
		
	}

	/**
	 * Retorna la muestra persistente que cumpla con el nombre y ubicacion pasado como parametro.
	 * @param nombreMuestra
	 * @return
	 */
	public Muestra obtenerMuestra (String nombreMuestra,String ubicacion, String ciudad) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			aux =(Muestra)persistencia.buscarObjeto(aux.getClass(), "nombreMuestra=='"+nombreMuestra+"' && ubicacion.nombreUbicacion=='"+ubicacion+"' && ubicacion.ciudad=='"+ciudad+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Retorna si un objeto a insertar ya existe en la base de datos.
	 * @return yaExiste
	 */
	public boolean getExiste(){
		return yaExiste;
	}
}
	
	