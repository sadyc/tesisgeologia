package comun;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistencia.domain.Muestra;
import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuCompararMuestra.MediadorCompararMuestra;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarMuestra.MediadorGestionarMuestra;
import cuGestionarMuestra.MediadorListarMuestras;
import cuGestionarMuestra.MediadorSeleccionarMuestra;
import cuLimiteConsistencia.MediadorAltaLimiteConsistencia;
import cuLimiteConsistencia.MediadorConsistencia;

public class MediadorPrincipal implements ActionListener{

	private GUIPrincipal GUIPrincipal = null;
	private Component frame;
	
	
	public MediadorPrincipal(String nombreVentana) throws Exception {
		super();
		this.GUIPrincipal = new GUIPrincipal(nombreVentana);
		this.GUIPrincipal.setListenerButtons(this);
		GUIPrincipal.show();
		
	}
	
	public void show(){
		GUIPrincipal.show();
	}

	/**
	 * @return the gUIPrincipal
	 */
	public GUIPrincipal getGUIPrincipal() {
		return GUIPrincipal;
	}

	/**
	 * @param gUIPrincipal the gUIPrincipal to set
	 */
	public void setGUIPrincipal(GUIPrincipal gUIPrincipal) {
		GUIPrincipal = gUIPrincipal;
	}
	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 * @throws Exception
	 */
	public void actionPerformed(ActionEvent arg0){
		Object source = arg0.getSource();
		if (this.GUIPrincipal.getJButtonGestionarMuestra() == source || this.GUIPrincipal.getGestionarMuestraMenu()== source){
			gestionarMuestra();
     	}
		if (this.GUIPrincipal.getJButtonAnalisis() == source || this.GUIPrincipal.getGestionarAnalisisMenu()== source){
			gestionarAnalisis();
			}
		if (this.GUIPrincipal.getJButtonClasificacion() == source || this.GUIPrincipal.getCalcularClasificacionMenu()== source){
			calcularClasificacion();
		}
		if (this.GUIPrincipal.getJButtonListarMuestras() == source || this.GUIPrincipal.getListarMuestrasMenu()== source){
			listarMuestras();
     	}
		if (this.GUIPrincipal.getJButtonCompararMuestras() == source || this.GUIPrincipal.getCompararMuestrasMenu()== source){
			compararMuestras();
     	}
		if (this.GUIPrincipal.getJButtonGestionarLimiteConsistencia() == source || this.GUIPrincipal.getGestionarLimiteConsistenciaMenu()== source){
			gestionarLimiteConsistencia();
		}
		if (this.GUIPrincipal.getJButtonSalir() == source || this.GUIPrincipal.getSalirMenu()== source){
			GUIPrincipal.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Muestra"
	 */
	public void gestionarMuestra(){
		try {
			MediadorGestionarMuestra gestionarMuestra = new MediadorGestionarMuestra("Gestionar Muestra");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarMuestra"); 
	}
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Analisis"
	 */
	public void gestionarAnalisis(){
		try {
			MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra();
			if (seleccion.seSeleccionoMuestra()){
				new MediadorGestionarAnalisis("Analisis de la muestra "+seleccion.getSeleccionado().getNombreMuestra(), seleccion.getSeleccionado());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarAnalisis");
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Calcular Clasificacion"
	 */
	public void calcularClasificacion(){
		try {
			MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
			if (seleccionarMuestra.seSeleccionoMuestra()){
				new MediadorCalcularClasificacion("Clasificacion",seleccionarMuestra.getSeleccionado());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Listar Muestras"
	 */
	private void listarMuestras() {
		try {
			new MediadorListarMuestras();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonListarMuestra"); 
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Comparar Muestras"
	 */
	public void compararMuestras(){
		try {
			MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
			if (seleccionarMuestra.seSeleccionoMuestra()){
				Muestra muestra1 = seleccionarMuestra.getSeleccionado();
				seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					Muestra muestra2 = seleccionarMuestra.getSeleccionado();
					new MediadorCompararMuestra("Comparacion de Muestras",muestra1,muestra2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonListarMuestra"); 
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Gestionar Limites Consistencia"
	 */
	public void gestionarLimiteConsistencia(){
		try {
			MediadorConsistencia consistencia = new MediadorConsistencia();
			if (consistencia.seSeleccionoMuestra()){
				new MediadorAltaLimiteConsistencia(consistencia.getSeleccionado().getNombreMuestra());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");


	}
}
