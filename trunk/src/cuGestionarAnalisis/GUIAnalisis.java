/**
 * 
 */
package cuGestionarAnalisis;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.domain.Muestra;

/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un Analisis
 */
public class GUIAnalisis extends JDialog {

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton cancelar;
	private JButton seleccionarTamiz;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JTextField pesoRetenido;
	private JLabel muestra;


	/**
	 * This is the default constructor
	 */
	public GUIAnalisis() {
		super();
		pesoRetenido = new JTextField(15);
		muestra = new JLabel("muestra tanto...");
		aceptar = new JButton("Agregar Analisis");
		cancelar = new JButton("Cancelar");
		seleccionarTamiz = new JButton("Seleccionar Tamiz");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una pesoRetenido. 
	 */
	public GUIAnalisis(String data, Muestra muestra) {
		super();
		pesoRetenido = new JTextField(15);
		this.muestra = new JLabel("muestra: "+muestra.getNombreMuestra());
		this.pesoRetenido.setText(data);
		this.aceptar = new JButton("Agregar muestra");
		this.cancelar = new JButton("Cancelar");
		this.seleccionarTamiz = new JButton("Seleccionar Tamiz");
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
	 * @return the cancelar
	 */
	public JButton getJButtonCancelar() {
		return cancelar;
	}

	/**
	 * @param cancelar the cancelar to set
	 */
	public void setJButtonCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
	/**
	 * @return the seleccionarTamiz
	 */
	public JButton getSeleccionarTamiz() {
		return seleccionarTamiz;
	}

	/**
	 * @param seleccionarTamiz the seleccionarTamiz to set
	 */
	public void setSeleccionarTamiz(JButton seleccionarTamiz) {
		this.seleccionarTamiz = seleccionarTamiz;
	}


	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(500 , 200);
	
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	// Se aaden los componentes al Frame
		// Agregamos el Panel Norte al Frame
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		// Agregamos el Panel Centro al Frame
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	// Agregamos el Panel Sur al Frame
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	
	}
   
	
	/**
	 * Metodo que retorna el panelNorte.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelNorte() {
		if (this.panelNorte==null) {
			this.panelNorte= new JPanel();
			this.panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.muestra.setAlignmentY(Component.CENTER_ALIGNMENT);
			this.panelNorte.add(muestra);
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
			this.panelSur.add(cancelar);
			this.panelSur.add(seleccionarTamiz);
		}
		return this.panelSur;
	}
	
	/**
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.aceptar.addActionListener(lis);
		this.cancelar.addActionListener(lis);
		this.seleccionarTamiz.addActionListener(lis);
	}
	

	
	
}

