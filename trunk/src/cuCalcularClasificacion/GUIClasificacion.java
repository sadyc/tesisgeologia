/**
 * 
 */
package cuCalcularClasificacion;

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

import persistencia.domain.Muestra;

/**
 * @author tesisGeologia.
 * 
 */
public class GUIClasificacion extends JDialog{

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton imprimir;
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
	public GUIClasificacion() {
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		imprimir = new JButton("Imprimir");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIClasificacion(Muestra muestra) {
	
		super();
		
		this.muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		this.muestra.setText(muestra.getNombreMuestra());
		peso.setText(muestra.getPeso().toString());
		profundidadInicial.setText("");
		profundidadFinal.setText("");
		imprimir = new JButton("Imprimir");
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
		return imprimir;
	}


	/**
	 * @param aceptar the aceptar to set
	 */
	public void setJButtonImprimir(JButton imprimir) {
		this.imprimir = imprimir;
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
			this.panelNorte.add(new JLabel("Ubicacion : Rio Cuarto"));
			this.panelNorte.add(new JLabel("Peso : 3253 gr"));
			this.panelNorte.add(new JLabel("Profundidad Inicial: 2 mts"));
			this.panelNorte.add(new JLabel("Profundidad Final: 3 mts"));
			this.panelNorte.add(new JLabel("Humedad: 40%"));
			
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
			this.panelSur.add(imprimir);
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
		this.imprimir.addActionListener(lis);
		this.cancelar.addActionListener(lis);
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
