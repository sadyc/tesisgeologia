package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorModificarAnalisis  extends Mediador{
	private Muestra muestra;
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Analisis analisis;
	private String numeroTamiz;
	private boolean modifico = false;
	private ControlGestionarAnalisis control ;
	private Component frame;
	
	/**
	 * This is the default constructor
	 */
	public MediadorModificarAnalisis(Muestra muestra,Float pesoRetenido,String numeroTamiz) {
		super();
		this.muestra = muestra;
		control = new ControlGestionarAnalisis();
		this.numeroTamiz = numeroTamiz;
		analisis = new Analisis();
		GUIAnalisis = new GUIAltaAnalisis(muestra,pesoRetenido,numeroTamiz);
		GUIAnalisis.setTitle("Modificar el peso retenido del tamizado de la muestra: "+muestra.getNombreMuestra());
		GUIAnalisis.setModal(true);
		GUIAnalisis.getJButtonSeleccionarTamiz().setEnabled(false);
		GUIAnalisis.setListenerButtons(this);
		show();
	}
	
		
	public void show(){
		GUIAnalisis.show();
	}
	
	/**
	 * @return the data
	 */
	public String getPesoRetenido() {
		return pesoRetenido;
	}

	/**
	 * @return the altaMuestra
	 */
	public GUIAltaAnalisis getAnalisis() {
		return GUIAnalisis;
	}	
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIAnalisis.getJButtonAceptar() == source || GUIAnalisis.getjMenuItemAgregar()==source){
			aceptar();
		}
		if (this.GUIAnalisis.getJButtonCancelar() == source || GUIAnalisis.getjMenuItemCancelar()==source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUIAnalisis.dispose();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Aceptar"
	 */
	public void aceptar(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAceptar");
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
		analisis.setMuestra(muestra);
		if (pesoRetenido.equals("")){
			JOptionPane.showMessageDialog(frame,"No ingreso un peso retenido","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (Float.parseFloat(pesoRetenido)> muestra.getPeso()){
				JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso de la muestra que es: "+muestra.getPeso(),"ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					control.ModificarAnalisis(Float.parseFloat(pesoRetenido), muestra, numeroTamiz);
					control.recalcularAnalisis(analisis);
				} catch (Exception e) {
					e.printStackTrace();
				}
				GUIAnalisis.dispose();
			}
		}
	}

	public void itemStateChanged(ItemEvent arg0) {
	}


	public void mouseClicked(MouseEvent arg0) {
	}


	public void mouseEntered(MouseEvent arg0) {
	}


	public void mouseExited(MouseEvent arg0) {
	}


	public void mousePressed(MouseEvent arg0) {
	}


	public void mouseReleased(MouseEvent arg0) {
	}


	public String[] getData() {
		return null;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
