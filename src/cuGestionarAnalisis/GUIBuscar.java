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

/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un Analisis
 */
public class GUIBuscar extends JDialog {

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JButton aceptar;
	private JButton cancelar;
	private JButton buscar;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JTextField claveBusqueda;
	private JLabel claveBusquedaLabel;


	/**
	 * This is the default constructor
	 */
	public GUIBuscar() {
		super();
		claveBusqueda = new JTextField(15);
		claveBusquedaLabel = new JLabel("Ingrese el ID del analisis a buscar: ");
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		buscar = new JButton("Buscar");
		initialize();
	}
	
	
	/**
	 * @return the claveBusqueda
	 */
	public JTextField getClaveBusqueda() {
		return claveBusqueda;
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
	 * @return the buscar
	 */
	public JButton getJButtonBuscar() {
		return buscar;
	}

	/**
	 * @param buscar the buscar to set
	 */
	public void setJButtonBuscar(JButton seleccionarTamiz) {
		this.buscar = seleccionarTamiz;
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
	 //	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
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
			this.claveBusquedaLabel.setAlignmentY(Component.LEFT_ALIGNMENT);
			this.claveBusqueda.setAlignmentY(Component.CENTER_ALIGNMENT);
			this.panelNorte.add(claveBusquedaLabel);
			this.panelNorte.add(claveBusqueda);
			this.panelNorte.add(buscar);
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
			claveBusqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelCentro.add(new JLabel("Peso Retenido: "));
			this.panelCentro.add(claveBusqueda);
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
		this.buscar.addActionListener(lis);
	}
	

	
	
}

