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
 *@brief Clase que se utiliza para escuchar los eventos que suceden en la ventana "Alta Análisis".
 *@author TesisGeología
 *@version 1.0
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
	 * Constructor parametrizado de la clase. 
	 * @param muestra, muestra a la que se le van a modificar los análisis.
	 * @param pesoRetenido, peso retenido cargado anteriormente de modificar.
	 * @param numeroTamiz, numero de tamiz al que se le va a modificar el análisis.
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
		GUIAnalisis.setLocationRelativeTo(null);
		show();
	}
	
	
	/**
	 * Metodo que permite visualizar la ventana.
	 */
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
	 * Acciones a realizar cuando se selecciona la opción de "Aceptar"
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
				JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso de la muestra que es: "+muestra.getPeso()+" grs.","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					control.ModificarAnalisis(Float.parseFloat(pesoRetenido), muestra, numeroTamiz);
					control.recalcularAnalisis(analisis);
					if (control.getExiste()) {
						System.out.println("El objeto ya existe");
						JOptionPane.showMessageDialog(frame,"El análisis de la muestra correspondiente ya tiene cargado un resultado en el Tamiz Nº: "+numeroTamiz+". Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						modifico = true;
						GUIAnalisis.dispose();
					}
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
