package cuLimiteConsistencia;


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

import persistencia.domain.Muestra;
/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un analisis de Limite de Consistencia
 */
public class GUILimiteConsistencia extends JDialog {
	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton salir;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JTextField limiteLiquido;
	private JTextField limitePlastico;
	private JLabel muestra;
	




	/**
	 * This is the default constructor
	 */
	public GUILimiteConsistencia(String title, Muestra muestra) {
		super();
		setTitle(title);
		limiteLiquido = new JTextField(15);
		limitePlastico = new JTextField(15);
		this.muestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		aceptar = new JButton("AGREGAR");
		salir = new JButton("SALIR");
		initialize();
		show();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param limLiq  arreglo que almacena los datos de una limiteLiquido. 
	 */
	public GUILimiteConsistencia(String title,String limLiq, String limPlas, Muestra muestra) {
		super();
		setTitle(title);
		limiteLiquido = new JTextField(limLiq);
		limitePlastico = new JTextField(limPlas);
		this.muestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		aceptar = new JButton("AGREGAR ANALISIS");
		salir = new JButton("SALIR");
		initialize();
		show();
	}
	
	/**
	 * @return the limiteLiquido
	 */
	public JTextField getLimiteLiquido() {
		return limiteLiquido;
	}

	/**
	 * @return the limitePlastico
	 */
	public JTextField getLimitePlastico() {
		return limitePlastico;
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
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(600 , 200);
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
			limiteLiquido.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelCentro.add(new JLabel("Limite Liquido: "));
			this.panelCentro.add(limiteLiquido);
			limitePlastico.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelCentro.add(new JLabel("Limite Plastico: "));
			this.panelCentro.add(limitePlastico);
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
	}
	
	
}

