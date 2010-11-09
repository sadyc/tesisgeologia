package comun;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
* @author TesisGeología
*
*/
public class GUIPrincipal extends JFrame {

	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonListarMuestras;
	private JButton jButtongestionarMuestra;
	private JButton jButtonclasificacion;
	private JButton jButtonanalisis;
	private JButton jButtoncerrar;
	
	



	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			JMenuItem listarMuestras = new JMenuItem("Listar Muestras Cargadas");
			JMenuItem gestionarMuestraMenu = new JMenuItem("Gestionar Muestra");
			JMenuItem gestionarAnalisisMenu = new JMenuItem("Gestionar Analisis");
			JMenuItem calcularClasificacionMenu = new JMenuItem("Calcular Clasificacion");
			JMenuItem salir = new JMenuItem("Salir");
			herramientas.add(gestionarMuestraMenu);
			herramientas.add(gestionarAnalisisMenu);
			herramientas.add(calcularClasificacionMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(listarMuestras);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(salir);
			JMenuItem version = new JMenuItem("Version");
			ayuda.add(version);
		}
		initialize();
	}


	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private  void initialize() {
		
		this.setSize(500,500);
		this.getContentPane().setLayout(new BorderLayout());
	 	this.setJMenuBar(this.getMenu());	
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	}

	
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new JPanel();
			this.panelCentro.setLayout(new GridBagLayout());
			this.panelCentro.add(getJButtonGestionarMuestra());
			this.panelCentro.add(getJButtonAnalisis());
			this.panelCentro.add(getJButtonClasificacion());
			this.panelCentro.add(getJButtonListarMuestras());
		}
		return this.panelCentro;
	}
	

	public JPanel getPanelSur() {
		if (this.panelSur==null) {
			this.panelSur = new JPanel();
			this.panelSur.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.panelSur.add(getJButtonSalir());
		}
		return this.panelSur;
	}



	
	/**
	 * @return the menuBar
	 */
	public JMenuBar getMenu(){
		return menu;
	}


	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menu) {
		this.menu = menu;
	}

	/**
	 * @return the gestionarMuestra
	 */
	public JButton getJButtonGestionarMuestra() {
		if (jButtongestionarMuestra == null) {
			jButtongestionarMuestra = new JButton();
			jButtongestionarMuestra.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtongestionarMuestra.setText("GESTIONAR MUESTRA");
		}
		return jButtongestionarMuestra;
	}




	/**
	 * @return the clasificacion
	 */
	public JButton getJButtonClasificacion() {
		if (jButtonclasificacion == null) {
			jButtonclasificacion = new JButton();
			jButtonclasificacion.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonclasificacion.setText("CLASIFICACION");
		}
		return jButtonclasificacion;
	}





	/**
	 * @return the analisis
	 */
	public JButton getJButtonAnalisis() {
		if (jButtonanalisis == null) {
			jButtonanalisis  = new JButton();
			jButtonanalisis.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonanalisis .setText("ANALISIS");
		}
		return jButtonanalisis ;
	}
	
	/**
	 * @return the gestionarMuestra
	 */
	public JButton getJButtonListarMuestras() {
		if (jButtonListarMuestras == null) {
			jButtonListarMuestras = new JButton();
			jButtonListarMuestras.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonListarMuestras.setText("LISTAR MUESTRAS");
		}
		return jButtonListarMuestras;
	}

	/**
	 * @return the cerrar
	 */
	public JButton getJButtonSalir() {
		if (jButtoncerrar == null) {
			jButtoncerrar  = new JButton();
			jButtoncerrar.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtoncerrar .setText("SALIR");
		}
		return jButtoncerrar ;
	}
	public void setListenerButtons(ActionListener lis){
		this.jButtongestionarMuestra.addActionListener(lis);
		this.jButtonanalisis.addActionListener(lis);
		this.jButtonclasificacion.addActionListener(lis);
        this.jButtoncerrar.addActionListener(lis);
	}

}

