/**
 * 
 */
package cuGestionarAnalisis;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import comun.TablePanel;

import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;

/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un Analisis
 */
public class GUIAltaAnalisis extends JDialog {

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton salir;
	private JButton seleccionarTamiz;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JTextField pesoRetenido;
	private JLabel muestra;
	private JLabel tamiz;



	/**
	 * This is the default constructor
	 */
	public GUIAltaAnalisis( Muestra muestra) {
		super();
		pesoRetenido = new JTextField(15);
		this.muestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		tamiz = new JLabel("Tamiz: ");
		aceptar = new JButton("AGREGAR ANALISIS");
		salir = new JButton("SALIR");
		seleccionarTamiz = new JButton("SELECCIONAR TAMIZ");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una pesoRetenido. 
	 */
	public GUIAltaAnalisis(String data, Muestra muestra, Tamiz tamiz) {
		super();
		pesoRetenido = new JTextField(15);
		this.muestra = new JLabel("Muestra: "+muestra.getNombreMuestra()+"Peso: "+muestra.getPeso());
		this.tamiz = new JLabel("Tamiz: " + tamiz.getNumeroTamiz());
		this.pesoRetenido.setText(data);
		aceptar = new JButton("AGREGAR ANALISIS");
		salir = new JButton("SALIR");
		seleccionarTamiz = new JButton("SELECCIONAR TAMIZ");
		initialize();
	}
	
	/**
	 * @return the pesoRetenido
	 */
	public JTextField getPesoRetenido() {
		return pesoRetenido;
	}

	/**
	 * @return the aceptar
	 */
	public JButton getJButtonAceptar() {
		return aceptar;
	}


	/**
	 * @param aceptar the aceptar to set
	 */
	public void setJButtonAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}
	
	/**
	 * @return the salir
	 */
	public JButton getJButtonSalir() {
		return salir;
	}

	/**
	 * @param salir the salir to set
	 */
	public void setJButtonSalir(JButton salir) {
		this.salir = salir;
	}
	
	/**
	 * @return the seleccionarTamiz
	 */
	public JButton getJButtonSeleccionarTamiz() {
		return seleccionarTamiz;
	}

	/**
	 * @param seleccionarTamiz the seleccionarTamiz to set
	 */
	public void setSeleccionarTamiz(JButton seleccionarTamiz) {
		this.seleccionarTamiz = seleccionarTamiz;
	}


	/**
	 * @return the tamiz
	 */
	public JLabel getTamiz() {
		return tamiz;
	}

	/**
	 * @param tamiz the tamiz to set
	 */
	public void setTamiz(String tamiz) {
		this.tamiz.setText(tamiz);
	}

	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(500 , 200);
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	}
   
	
	/**
	 * Metodo que retorna el panelNorte.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelNorte() {
		if (this.panelNorte==null) {
			this.panelNorte= new JPanel();
			this.panelNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.panelNorte.add(muestra);
			this.panelNorte.add(tamiz);
		}
		return this.panelNorte;
	}	

	/**
	 * Metodo que retorna el panelCentro.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new JPanel();
			this.panelCentro.setLayout(new GridBagLayout());
			pesoRetenido.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelCentro.add(new JLabel("Peso Retenido: "));
			this.panelCentro.add(pesoRetenido);
			this.panelCentro.add(new JLabel("gramos"));
		}
		return this.panelCentro;
	}	

	
	/**
	 * Metodo que retorna el panelSur.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelSur() {
		if (this.panelSur==null) {
			this.panelSur = new JPanel();
			this.panelSur.setLayout(new FlowLayout());
			this.panelSur.add(aceptar);
			this.panelSur.add(seleccionarTamiz);
			this.panelSur.add(salir);
		}
		return this.panelSur;
	}
	
	/**
	 * Metodo que permite escuchar los botoner aceptar y salir.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.aceptar.addActionListener(lis);
		this.salir.addActionListener(lis);
		this.seleccionarTamiz.addActionListener(lis);
	}
	
	
}

