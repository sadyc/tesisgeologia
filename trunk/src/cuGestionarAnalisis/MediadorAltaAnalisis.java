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

import cuSeleccionarTamiz.MediadorSeleccionarTamiz;



/**
 *@brief Clase que se utiliza para escuchar los eventos que suceden en la ventana "Alta Análisis".
 *@author TesisGeología
 *@version 1.0
 */

public class MediadorAltaAnalisis  extends Mediador{
	
	private GUIAltaAnalisis GUIAnalisis;
	private String pesoRetenido;
	private Muestra muestra = new Muestra();
	private Analisis analisis;
	private String[] data= new String[5];
	private String numeroTamiz;
	private ControlGestionarAnalisis control;
	private boolean altaAnalisis = false;
	private Component frame;
	
	/**
	 * This is the default constructor
	 */
	public MediadorAltaAnalisis(Muestra muestra) {
		super();
		control =   new ControlGestionarAnalisis();
		this.muestra = muestra;
		analisis = new Analisis();
		GUIAnalisis = new GUIAltaAnalisis(muestra);
		GUIAnalisis.setTitle("Análisis por Tamiz de una Muestra");
		GUIAnalisis.setModal(true);
		GUIAnalisis.setListenerButtons(this);
		GUIAnalisis.setKeyListener(this);
		GUIAnalisis.setLocationRelativeTo(null);
		show();
	}
	
		
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
	public Analisis getAnalisis() {
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
	 * Método que necesita definir al implementar la interface ActionListener 
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
	   	if (GUIAnalisis.getVersionMenu()==source){
			new MediadorVersion();
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
			analisis = new Analisis();
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
	 * Acciones a realizar cuando se selecciona la opcion de "Agregar Análisis"
	 * @throws Exception 
	 */
	public void agregarAnalisis() throws Exception{
		
		try{
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		pesoRetenido = GUIAnalisis.getPesoRetenido().getText();
		if (numeroTamiz==null){
			JOptionPane.showMessageDialog(frame,"No se seleccionó ningún Tamiz","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if (pesoRetenido.equals("")){
				JOptionPane.showMessageDialog(frame,"No ingresó un peso retenido","Atención!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if (Float.parseFloat(pesoRetenido.replace(",","."))> muestra.getPeso()){
					JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso de la muestra que es: "+muestra.getPeso()+" grs.","Atención!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Float pesoPasante = control.pesoPasante(muestra);
					if (Float.parseFloat(pesoRetenido.replace(",","."))>(muestra.getPeso()-pesoPasante)){
						JOptionPane.showMessageDialog(frame,"El peso retenido por el tamiz no puede superar al peso pasante por el último tamiz que es: "+(muestra.getPeso()-pesoPasante)+" grs.","Atención!", JOptionPane.ERROR_MESSAGE);
					}
					else{
						analisis = new Analisis();
						analisis.setPesoRetenido(pesoRetenido);
						try {
							data = control.insertarAnalisis(analisis, muestra, numeroTamiz);
							if (control.yaExiste()) {
								System.out.println("El objeto ya existe");
								JOptionPane.showMessageDialog(frame,"El análisis de la muestra correspondiente ya tiene cargado un resultado en el Tamiz N° "+data[0]+". Por favor ingrese otro.","Atención!", JOptionPane.ERROR_MESSAGE);
							}
							else {
								altaAnalisis = true;
								GUIAnalisis.dispose();
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(frame,"Asegúrese que el peso retenido tiene un formato válido como por ej, 23.34 gramos.","Atención!", JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
						GUIAnalisis.dispose();
					}
				}
				
			}	
		}
		}catch (Exception e) {
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
	public void keyTyped(KeyEvent arg0) {
		if (GUIAnalisis.getPesoRetenido().getText().length()==25){ 
			arg0.consume();
			System.out.print("\07");
		}
		
	}
}