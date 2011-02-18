package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import persistencia.domain.IAnalisis;
import persistencia.domain.HMuestra;

import comun.Mediador;

import cuGestionarTamiz.MediadorSeleccionarTamiz;



/**
 * @author TesisGeologia
 * Implementa las interfaces de acuerdo a los eventos que necesita tratar
 * en este caso: ActionListener,MouseListener,ItemListener.
 */

public class MediadorAltaAnalisis  extends Mediador{
	
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private HMuestra muestra = new HMuestra();
	private IAnalisis analisis;
	private String[] data= new String[5];
	private String numeroTamiz;
	private ControlGestionarAnalisis control;
	private boolean altaAnalisis = false;
	private Component frame;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis(HMuestra muestra) {
		super();
		control =   new ControlGestionarAnalisis();
		this.muestra = muestra;
		analisis = new IAnalisis();
		GUIAnalisis = new GUIAltaAnalisis(muestra);
		GUIAnalisis.setTitle("Analisis por Tamiz de una Muestra");
		GUIAnalisis.setModal(true);
		GUIAnalisis.setListenerButtons(this);
		GUIAnalisis.setKeyListener(this);
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
	public IAnalisis getAnalisis() {
		return analisis;
	}
	/**
	 * @return data
	 */
	public String[] getData() {
		return data;
	}


	/**
	 * @return the altaAnalisis
	 */
	public boolean isAltaAnalisis() {
		return altaAnalisis;
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
	   	if (this.GUIAnalisis.getJButtonAceptar() == source || GUIAnalisis.getjMenuItemAgregar()==source){
			try {
				agregarAnalisis();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   	if (this.GUIAnalisis.getJButtonSeleccionarTamiz() == source || GUIAnalisis.getjMenuItemTamiz()==source){
			seleccionarTamiz();
		}
		if (this.GUIAnalisis.getJButtonCancelar() == source || GUIAnalisis.getjMenuItemCancelar()==source){
			System.out.println("GestionarAnalisis.actionPerformed() jButtonCancelar");
			GUIAnalisis.dispose();
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Tamiz"
	 */
	private void seleccionarTamiz() {
		System.out.println("GestionarAnalisis.actionPerformed() jButtonSeleccionarTamiz");
		try {
			analisis = new IAnalisis();
			analisis = control.ultimoAnalisis(muestra);
			System.out.println(analisis.getTamiz().getAberturaMalla());
			if (analisis.getTamiz().getAberturaMalla()==0){
				Double aux = new Double(65);
				MediadorSeleccionarTamiz seleccionarTamiz = new MediadorSeleccionarTamiz(aux);
				GUIAnalisis.setTamiz(seleccionarTamiz.getSeleccionado());
				numeroTamiz = seleccionarTamiz.getSeleccionado();
			}
			else{
				MediadorSeleccionarTamiz seleccionarTamiz = new MediadorSeleccionarTamiz(analisis.getTamiz().getAberturaMalla());
				GUIAnalisis.setTamiz(seleccionarTamiz.getSeleccionado());
				numeroTamiz = seleccionarTamiz.getSeleccionado();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Analisis"
	 * @throws Exception 
	 */
	public void agregarAnalisis() throws Exception{
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
		if (numeroTamiz==null){
			JOptionPane.showMessageDialog(frame,"No se seleccionó ningún Tamiz","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (pesoRetenido.equals("")){
				JOptionPane.showMessageDialog(frame,"No ingresó un peso retenido","ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if (Float.parseFloat(pesoRetenido)> muestra.getPeso()){
					JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso de la muestra que es: "+muestra.getPeso(),"ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Float pesoPasante = control.pesoPasante(muestra);
					if (Float.parseFloat(pesoRetenido)>(muestra.getPeso()-pesoPasante)){
						JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso pasante por el último tamiz que es: "+(muestra.getPeso()-pesoPasante),"ERROR!!!!!!!", JOptionPane.ERROR_MESSAGE);
					}
					else{
						analisis = new IAnalisis();
						analisis.setPesoRetenido(Float.parseFloat(pesoRetenido));//PARA CREAR EL OBJETO A INSERTAR DEBEMOS PASARLE LA MUESTRA Y EL TAMIZ TAMBIEN
						try {
							data = control.insertarAnalisis(analisis, muestra, numeroTamiz);
							if (control.getExiste()) {
								System.out.println("El objeto ya existe");
								JOptionPane.showMessageDialog(frame,"El análisis de la muestra correspondiente ya tiene cargado un resultado en el Tamiz Nº: "+data[0]+". Por favor ingrese otro.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
							}
							else {
								altaAnalisis = true;
								GUIAnalisis.dispose();
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(frame,"Asegurese que el peso retenido tiene un formato valido como por ej, 23.34 gramos.","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
						GUIAnalisis.dispose();
					}
				}
				
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
	public void keyTyped(KeyEvent arg0) {
		if (GUIAnalisis.getPesoRetenido().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		
	}
}