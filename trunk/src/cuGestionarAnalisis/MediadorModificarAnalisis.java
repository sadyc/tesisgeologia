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
import comun.MediadorVersion;



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
	private boolean modifico;
	private ControlGestionarAnalisis control ;
	private Component frame;
	private String ultimoPeso;
	
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
		ultimoPeso = GUIAnalisis.getPesoRetenido().getText().replace(",",".");
		show();
	}
	
	
	/**
	 * Metodo que permite visualizar la ventana.
	 */
	@SuppressWarnings("deprecation")
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
	 * Método que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIAnalisis.getJButtonAceptar() == source || GUIAnalisis.getjMenuItemAgregar()==source){
			aceptar();
		}
		if (this.GUIAnalisis.getJButtonCancelar() == source || GUIAnalisis.getjMenuItemCancelar()==source){
			GUIAnalisis.dispose();
		}
		if(this.GUIAnalisis.getVersionMenu() == source){
			new MediadorVersion();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opción de "Aceptar"
	 */
	public void aceptar(){
		try{
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText().replace(",",".");
		analisis.setMuestra(muestra);
		if (pesoRetenido.equals("")){
			JOptionPane.showMessageDialog(frame,"No ingresó un peso retenido","Atencion!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (Float.parseFloat(pesoRetenido)> muestra.getPeso()){
				JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso de la muestra que es: "+muestra.getPeso()+" grs.","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Float pesoPasante = control.pesoPasante(muestra);
				if (Float.parseFloat(pesoRetenido.replace(",","."))>(muestra.getPeso()-pesoPasante+Float.parseFloat(ultimoPeso))){
					JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso pasante por el último tamiz que es: "+(muestra.getPeso()-pesoPasante+Float.parseFloat(ultimoPeso))+" grs.","Atención!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					try {
						control.ModificarAnalisis(pesoRetenido, muestra, numeroTamiz);
						control.recalcularAnalisis(analisis);
						if (control.yaExiste()) {
							System.out.println("El objeto ya existe");
							JOptionPane.showMessageDialog(frame,"El análisis de la muestra correspondiente ya tiene cargado un resultado en el Tamiz N°: "+numeroTamiz+". Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							modifico = true;
							GUIAnalisis.dispose();
						}
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(frame,"El formato de uno de los números no es correcto, sólo deben poseer un punto(.) o coma(,)","Atención", JOptionPane.WARNING_MESSAGE);
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
	}
	/**
	 * @return the modifico
	 */
	public boolean isModifico() {
		return modifico;
	}

	
}
