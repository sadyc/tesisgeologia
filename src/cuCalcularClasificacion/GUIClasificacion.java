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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.domain.Muestra;

/**
 * @author tesisGeologia.
 * 
 */
public class GUIClasificacion {

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
	private JComboBox ubicacion;
	private JLabel usuario;

	/**
	 * This is the default constructor
	 */
	public GUIClasificacion() {
		super();
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		ubicacion = new JComboBox();
		usuario = new JLabel ("Usuario tanto...");
		
		aceptar = new JButton("Agregar Muestra");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIClasificacion(String title,Muestra muestra) {
	
		super();
		
		this.muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		this.muestra.setText(muestra.getNombreMuestra());
		peso.setText(muestra.getPeso().toString());
		
		profundidadInicial.setText("");
		profundidadFinal.setText("");
		usuario = new JLabel ("Usuario: "+muestra.getUsuario().getNombreUsuario());
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
	
	public void setListenerComboBox(ItemListener lis){
		this.ubicacion.addItemListener(lis);
       
	}
	
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getJComboBox() {
		if (ubicacion == null) {
			ubicacion = new JComboBox();
			ubicacion.setBounds(new java.awt.Rectangle(124,179,143,34));
			ubicacion.setName("Ubicacion");
		}
		return ubicacion;
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
