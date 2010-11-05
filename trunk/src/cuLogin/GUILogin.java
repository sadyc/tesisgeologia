/**
 * 
 */
package cuLogin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author TesisGeologia
 *
 */
public class GUILogin extends JFrame{
	
	private JButton aceptar;
	private JButton cancelar;
	private JPanel panelNorte;
	private JPanel panelSur;
	private JTextField nombre;
	private JTextField password;
	private JLabel nombreLabel;
	private JLabel passwordLabel;
	
	
	
	/**
	 * @param aceptar
	 * @param cancelar
	 * @param panelNorte
	 * @param panelSur
	 * @param nombre
	 * @param password
	 * @param nombreLabel
	 * @param passwordLabel
	 */
	public GUILogin(String title) {
		super(title);
		aceptar = new JButton ("Aceptar");
		cancelar = new JButton ("Cancelar");
		panelNorte = null;
		panelSur = null;
		nombre = new JTextField(15);
		password = new JTextField(15);
		nombreLabel = new JLabel ("Nombre Usuario: ");
		passwordLabel = new JLabel ("Password: ");
		initialize();
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
	 * @return the panelNorte
	 */
	public JPanel getPanelNorte() {
		if (this.panelNorte==null) {
			this.panelNorte= new JPanel();
			this.panelNorte.setLayout(new BoxLayout(this.panelNorte,BoxLayout.Y_AXIS));
			nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
			passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			password.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelNorte.add(nombreLabel);
			this.panelNorte.add(nombre);
			this.panelNorte.add(passwordLabel); 
			this.panelNorte.add(password);
		}
		return this.panelNorte;
	}

	/**
	 * @return the panelSur
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
	 * @return the nombre
	 */
	public JTextField getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the password
	 */
	public JTextField getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(JTextField password) {
		this.password = password;
	}
	
	/**
	 * @param nombreLabel the nombreLabel to set
	 */
	public void setNombreLabel(JLabel nombreLabel) {
		this.nombreLabel = nombreLabel;
	}
	
	/**
	 * @param passwordLabel the passwordLabel to set
	 */
	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
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
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.aceptar.addActionListener(lis);
		this.cancelar.addActionListener(lis);
	}
}
