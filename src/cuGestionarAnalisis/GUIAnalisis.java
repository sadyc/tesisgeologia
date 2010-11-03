/**
 * 
 */
package cuGestionarAnalisis;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cuGestionarMuestra.Muestra;
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
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JPanel panelEste;
	private JTextField pesoRetenido;
	private JLabel muestra;
	private JComboBox jComboBox;


	/**
	 * This is the default constructor
	 */
	public GUIAnalisis() {
		super();
		pesoRetenido = new JTextField(15);
		muestra = new JLabel("muestra tanto...");
		aceptar = new JButton("Agregar Analisis");
		cancelar = new JButton("Cancelar");
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
		pesoRetenido.setText(data);
		aceptar = new JButton("Agregar muestra");
		cancelar = new JButton("Cancelar");
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
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(300 , 140);
	
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	// Se aaden los componentes al Frame
		// Agregamos el Panel Norte al Frame
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		// Agregamos el Panel Centro al Frame
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	// Agregamos el Panel Sur al Frame
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 // Agregamos el Panel Este al Frame
	 //	this.getContentPane().add(this.getPanelSur(),BorderLayout.EAST);   es para ponerle el sufijo "Gramos" al peso retenido.


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
			muestra.setAlignmentY(Component.CENTER_ALIGNMENT);
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
			// Se pone el FlowLayout en el Panel Centro
			this.panelCentro.setLayout(new BoxLayout(this.panelCentro,BoxLayout.Y_AXIS));
			pesoRetenido.setAlignmentX(Component.CENTER_ALIGNMENT);
			// Se aaden los componentes al panel Centro
			this.panelCentro.add(new JLabel("Peso Retenido: "));
			this.panelCentro.add(pesoRetenido);
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
			// Se pone el FlowLayout en el Panel Sur
			this.panelSur.setLayout(new FlowLayout());
			// Se instancian los componentes para el Panel Sur
			// Se aaden los componentes al panel Sur
			this.panelSur.add(aceptar);
			this.panelSur.add(cancelar);
			this.panelSur.add(getJComboBox(), null);
			}
			return this.panelSur;
	}
	
	/**
	 * Metodo que retorna el panelEste.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelEste() {
		if (this.panelEste==null) {
			this.panelEste= new JPanel();
			// Se pone el FlowLayout en el Panel Norte
			this.panelEste.setLayout(new FlowLayout());
			// Se aaden los componentes al panel Norte
			this.panelCentro.add(new JLabel("Gramos: "));
		}
		return this.panelCentro;
	}	

	
	/**
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.aceptar.addActionListener(lis);
		this.cancelar.addActionListener(lis);
	}
	

	public void setListenerComboBox(ItemListener lis){
		this.jComboBox.addItemListener(lis);
       
	}

	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new java.awt.Rectangle(124,179,143,34));
			jComboBox.setName("jComboBox");
		}
		return jComboBox;
	}
	
}

