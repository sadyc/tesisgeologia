/**
 * 
 */
package cuGestionarTamiz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.domain.Tamiz;

/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un Analisis
 */
public class GUITamiz extends JDialog {

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton cancelar;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JTextField numeroTamiz;
	private JTextField aberturaMalla;
	private JLabel numeroTamizLabel;
	private JLabel aberturaMallaLabel;

	/**
	 * This is the default constructor
	 */
	public GUITamiz() {
		super();
		numeroTamiz = new JTextField(15);
		aberturaMalla = new JTextField(15);
		numeroTamizLabel = new JLabel ("Numero de Tamiz: ");
		aberturaMallaLabel = new JLabel ("Abertura de Malla: ");
		aceptar = new JButton("Agregar");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param
	 */
	public GUITamiz(Tamiz tamiz) {
		super();
		numeroTamiz = new JTextField(15);
		aberturaMalla = new JTextField(15);
		numeroTamiz.setText(tamiz.getNumeroTamiz().toString());
		aberturaMalla.setText(tamiz.getAberturaMalla().toString());
		numeroTamizLabel = new JLabel ("Numero de Tamiz: ");
		aberturaMallaLabel = new JLabel ("Abertura de Malla: ");
		aceptar = new JButton("Modificar Tamiz");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * @return the numero tamiz.
	 */
	public JTextField getNumeroTamiz() {
		return numeroTamiz;
	}

	/**
	 * @return the abertura de malla.
	 */
	public JTextField getAberturaMalla() {
		return aberturaMalla;
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
		this.setSize(300 , 300);
       	this.getContentPane().setLayout(new BorderLayout()); 		
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
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
			this.panelNorte.setLayout(new BoxLayout(this.panelNorte,BoxLayout.Y_AXIS));
			numeroTamiz.setAlignmentX(Component.CENTER_ALIGNMENT);
			aberturaMalla.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelNorte.add(numeroTamizLabel);
			this.panelNorte.add(numeroTamiz);
			this.panelNorte.add(aberturaMallaLabel);
			this.panelNorte.add(aberturaMalla);
		}
		return this.panelNorte;
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
	}
}