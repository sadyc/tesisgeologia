package cuGestionarMuestra;

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
	private JButton seleccionarOperador;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JTextField nombre;
	private JTextField profundidadInicial;
	private JTextField profundidadFinal;
	private JTextField peso;
	private JLabel operador;
	private JLabel ubicacion;
	

	/**
	 * This is the default constructor
	 */
	public GUIMuestra() {
		super();
		nombre = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		ubicacion = new JLabel("Ubicacion(*) : ");
		operador = new JLabel ("Operador(*) :");
		aceptar = new JButton("AGREGAR");
		cancelar = new JButton("CANCELAR");
		seleccionarUbicacion = new JButton("SELECCIONAR UBICACION");
		seleccionarOperador = new JButton("SELECCIONAR OPERADOR");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIMuestra(String[] fila, String nombreOperador) {
	
		super();
		nombre = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		nombre.setText(fila[1]);
		peso.setText(fila[2]);
		profundidadInicial.setText(fila[3]);
		profundidadFinal.setText(fila[4]);
		ubicacion = new JLabel("Ubicacion(*) : "+ fila[0]);
		operador = new JLabel ("Operador(*) : "+ nombreOperador);
		aceptar = new JButton("AGREGAR");
		cancelar = new JButton("CANCELAR");
		seleccionarUbicacion = new JButton("SELECCIONAR UBICACION");
		seleccionarOperador = new JButton("SELECCIONAR OPERADOR");
		initialize();
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the muestra
	 */
	public JTextField getNombre() {
		return nombre;
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
		this.setSize(600 , 700);
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	// Se aaden los componentes al Frame
		// Agregamos el Panel Norte al Frame
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
	 	// Agregamos el Panel Sur al Frame
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
			// Se pone el FlowLayout en el Panel Norte
			this.panelNorte.setLayout(new BoxLayout(this.panelNorte,BoxLayout.Y_AXIS));
			profundidadInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
			profundidadFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
			peso.setAlignmentX(Component.CENTER_ALIGNMENT);
			// Se anaden los componentes al panel Norte
			this.panelNorte.add(new JLabel("Nombre (*): "));
			this.panelNorte.add(nombre);
			this.panelNorte.add(new JLabel("Peso (*): "));
			this.panelNorte.add(peso); 
			this.panelNorte.add(new JLabel("Profundidad Inicial(*): "));
			this.panelNorte.add(profundidadInicial);
			this.panelNorte.add(new JLabel("Profundidad Final(*): "));
			this.panelNorte.add(profundidadFinal);
			this.panelNorte.add(seleccionarUbicacion);
			this.panelNorte.add(ubicacion);
			this.panelNorte.add(seleccionarOperador);
			this.panelNorte.add(operador);
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
		this.seleccionarOperador.addActionListener(lis);
		this.seleccionarUbicacion.addActionListener(lis);
	}
	
	
	public String[] getData() {
		String[] data = new String[4];
		data[0]= nombre.getText();
		data[1]= peso.getText();
		data[2]= profundidadInicial.getText();
		data[3]= profundidadFinal.getText();
		return data;
	}

	public Object getJButtonSeleccionarOperador() {
		return seleccionarOperador;
	}
	/**
	 * @return the operadorLaboratorio
	 */
	public JLabel getOperador() {
		return operador;
	}

	/**
	 * @param operadorLaboratorio the operadorLaboratorio to set
	 */
	public void setOperador(String operador) {
		this.operador.setText(operador);
	}	

}

