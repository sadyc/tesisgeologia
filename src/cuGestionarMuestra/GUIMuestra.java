package cuGestionarMuestra;

import java.awt.*;
import java.awt.event.*;
//import java.awt.HeadlessException;

import javax.swing.*;

import persistencia.domain.Muestra;
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
	private JButton seleccionarUbicacion;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JTextField muestra;
	private JTextField profundidadInicial;
	private JTextField profundidadFinal;
	private JTextField peso;
	private JLabel ubicacion;
	private JLabel usuario;

	/**
	 * This is the default constructor
	 */
	public GUIMuestra() {
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		ubicacion = new JLabel("ubicate!!");
		usuario = new JLabel ("Usuario tanto...");		
		aceptar = new JButton("AGREGAR");
		cancelar = new JButton("CANCELAR");
		seleccionarUbicacion = new JButton("SELECCIONAR UBICACION");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIMuestra(Object[] data) {
	
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		muestra.setText(data[0].toString());
		peso.setText(data[1].toString());
		profundidadInicial.setText(data[2].toString());
		profundidadFinal.setText(data[3].toString());
		ubicacion = new JLabel("ubicate!!");
		usuario = new JLabel ("Usuario tanto...");		
		aceptar = new JButton("AGREGAR");
		cancelar = new JButton("CANCELAR");
		seleccionarUbicacion = new JButton("SELECCIONAR UBICACION");
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
	 * @return the selecionar ubicacion
	 */
	public JButton getJButtonSeleccionarUbicacion() {
		return seleccionarUbicacion;
	}

	/**
	 * @param cancelar the seleccionar ubicacion to set
	 */
	public void setJButtonSeleccionarUbicacion(JButton seleccionarUbicacion) {
		this.seleccionarUbicacion = seleccionarUbicacion;
	}

	/**
	 * @return the ubicacion
	 */
	public JLabel getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion.setText(ubicacion);
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
			this.panelNorte.add(new JLabel("Nombre (*): "));
			this.panelNorte.add(muestra);
			this.panelNorte.add(new JLabel("Peso (*): "));
			this.panelNorte.add(peso); 
			this.panelNorte.add(new JLabel("Profundidad Inicial: "));
			this.panelNorte.add(profundidadInicial);
			this.panelNorte.add(new JLabel("Profundidad Final: "));
			this.panelNorte.add(profundidadFinal);
			this.panelNorte.add(seleccionarUbicacion);
			this.panelNorte.add(ubicacion);
			this.panelNorte.add(usuario);
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
		this.seleccionarUbicacion.addActionListener(lis);
	}
	
	
	public String[] getData() {
		String[] data = new String[4];
		data[0]= muestra.getText();
		data[1]= peso.getText();
		data[2]= profundidadInicial.getText();
		data[3]= profundidadFinal.getText();
		return data;
	}
	
}

