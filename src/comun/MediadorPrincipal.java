package comun;

import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarMuestra.ControlGestionarMuestra;
import cuGestionarMuestra.GUIABMMuestra;
import cuGestionarMuestra.GUIMuestra;
import cuGestionarMuestra.MediadorGestionarMuestra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import persistencia.domain.OperadorDeLaboratorio;
import persistencia.domain.Ubicacion;
import persistencia.domain.Usuario;

public class MediadorPrincipal implements ActionListener{

	private GUIPrincipal GUIPrincipal = null;
	
	
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
		if (this.GUIPrincipal.getJButtonGestionarMuestra() == source){
			try {
				MediadorGestionarMuestra gestionarMuestra = new MediadorGestionarMuestra("Listado de Muestras");
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarMuestra"); 
     	}
		if (this.GUIPrincipal.getJButtonAnalisis() == source){
			try {
				MediadorGestionarAnalisis gestionarAnalisis = new MediadorGestionarAnalisis();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonGestionarAnalisis");
		}
		if (this.GUIPrincipal.getJButtonClasificacion() == source){
			try {
				MediadorCalcularClasificacion gestionarClasificacion = new MediadorCalcularClasificacion();
				//gestionarClasificacion.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    System.out.println("GestionarMediador.actionPerformed() jButtonCalcularClasificacion");
		}
		if (this.GUIPrincipal.getJButtonCerrar() == source){
			GUIPrincipal.dispose();
		}
	}
	
}
