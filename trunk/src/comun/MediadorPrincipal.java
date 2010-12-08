package comun;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuCompararMuestra.MediadorCompararMuestra;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarMuestra.MediadorGestionarMuestra;
import cuLimiteConsistencia.MediadorAltaLimiteConsistencia;

public class MediadorPrincipal implements ActionListener{

	private GUIPrincipal GUIPrincipal = null;
	private Component frame;
	
	
	public MediadorPrincipal(String nombreVentana) throws Exception {
		super();
		this.GUIPrincipal = new GUIPrincipal(nombreVentana);
		GUIPrincipal.show();
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		this.GUIPrincipal.setListenerButtons(this);
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
			try {
				MediadorGestionarMuestra gestionarMuestra = new MediadorGestionarMuestra("Listado de Muestras");
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarMuestra"); 
     	}
		if (this.GUIPrincipal.getJButtonAnalisis() == source || this.GUIPrincipal.getCalcularClasificacionMenu()== source){
			try {
				MediadorSeleccionarMuestra seleccion = new MediadorSeleccionarMuestra();
				if (seleccion.seSeleccionoMuestra()){
					new MediadorGestionarAnalisis("Analisis de la muestra "+(String)seleccion.getSeleccionado()[1], (String)seleccion.getSeleccionado()[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarAnalisis");
		}
		if (this.GUIPrincipal.getJButtonClasificacion() == source || this.GUIPrincipal.getCalcularClasificacionMenu()== source){
			try {
				MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					new MediadorCalcularClasificacion("Clasificacion",(String)seleccionarMuestra.getSeleccionado()[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
		}
		if (this.GUIPrincipal.getJButtonListarMuestras() == source || this.GUIPrincipal.getListarMuestrasMenu()== source){
			try {
				new MediadorListarMuestras();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonListarMuestra"); 
     	}
		if (this.GUIPrincipal.getJButtonCompararMuestras() == source || this.GUIPrincipal.getCompararMuestrasMenu()== source){
			try {
				MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					String muestra1 = (String)seleccionarMuestra.getSeleccionado()[1];
					seleccionarMuestra = new MediadorSeleccionarMuestra();
					if (seleccionarMuestra.seSeleccionoMuestra()){
						String muestra2 = (String)seleccionarMuestra.getSeleccionado()[1];
						new MediadorCompararMuestra("Comparacion de Muestras",muestra1,muestra2);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonListarMuestra"); 
     	}
		if (this.GUIPrincipal.getJButtonGestionarLimiteConsistencia() == source || this.GUIPrincipal.getGestionarLimiteConsistenciaMenu()== source){
			//JOptionPane.showMessageDialog(frame,"Funcionalidad Temporalmente Inhabilitada","Error :(", JOptionPane.INFORMATION_MESSAGE);
			try {
				MediadorSeleccionarMuestra seleccionarMuestra = new MediadorSeleccionarMuestra();
				if (seleccionarMuestra.seSeleccionoMuestra()){
					new MediadorAltaLimiteConsistencia((String)seleccionarMuestra.getSeleccionado()[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
	
		}
		if (this.GUIPrincipal.getJButtonSalir() == source || this.GUIPrincipal.getSalirMenu()== source){
			GUIPrincipal.dispose();
		}
	}
	
}
