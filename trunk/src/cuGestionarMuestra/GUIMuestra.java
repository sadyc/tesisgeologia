package cuGestionarMuestra;

import java.awt.*;
import java.awt.event.*;
//import java.awt.HeadlessException;

import javax.swing.*;
/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para dar de alta una muestra   
 */
public class GUIMuestra extends JDialog {

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton cancelar;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JTextField muestra;
	private JTextField profundidadInicial;
	private JTextField profundidadFinal;
	private JTextField peso;

	/**
	 * This is the default constructor
	 */
	public GUIMuestra() {
	
		
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		aceptar = new JButton("Agregar Muestra");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIMuestra(String[] data) {
	
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		muestra.setText(data[0]);
		peso.setText(data[1]);
		profundidadInicial.setText(data[2]);
		profundidadFinal.setText(data[3]);
		aceptar = new JButton("Agregar Muestra");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * @return the muestra
	 */
	public JTextField getMuestra() {
		return muestra;
	}

	/**
	 * @return the profundidadInicial
	 */
	public JTextField getProfundidadInicial() {
		return profundidadInicial;
	}

	/**
	 * @return the profundidadFinal
	 */
	public JTextField getProfundidadFinal() {
		return profundidadFinal;
	}
	
	/**
	 * @return the peso
	 */
	public JTextField getPeso() {
		return peso;
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
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	// Se aaden los componentes al Frame
		// Agregamos el Panel Norte al Frame
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
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
			// Se pone el FlowLayout en el Panel Norte
			this.panelNorte.setLayout(new BoxLayout(this.panelNorte,BoxLayout.Y_AXIS));
			profundidadInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
			profundidadFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
			peso.setAlignmentX(Component.CENTER_ALIGNMENT);
			// Se aaden los componentes al panel Norte
			this.panelNorte.add(new JLabel("Nombre: "));
			this.panelNorte.add(muestra);
			this.panelNorte.add(new JLabel("Peso: "));
			this.panelNorte.add(peso); 
			this.panelNorte.add(new JLabel("Profundidad Inicial: "));
			this.panelNorte.add(profundidadInicial);
			this.panelNorte.add(new JLabel("Profundidad Final: "));
			this.panelNorte.add(profundidadFinal);
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
			// Se pone el FlowLayout en el Panel Sur
			this.panelSur.setLayout(new FlowLayout());
			// Se instancian los componentes para el Panel Sur
			// Se aaden los componentes al panel Sur
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
