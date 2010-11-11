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
	private JButton jButtonSalir;
	private JMenuItem listarMuestrasMenu;
	private JMenuItem gestionarMuestraMenu;
	private JMenuItem gestionarAnalisisMenu;
	private JMenuItem calcularClasificacionMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	



	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			jButtongestionarMuestra = new JButton("GESTIONAR MUESTRA");
			jButtonclasificacion = new JButton("CALCULAR CLASIFICACION");
			jButtonanalisis  = new JButton("GESTIONAR ANALISIS");
			jButtonListarMuestras = new JButton("LISTAR MUESTRAS");
			jButtonSalir  = new JButton("SALIR");
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			listarMuestrasMenu = new JMenuItem("Listar Muestras Cargadas");
			gestionarMuestraMenu = new JMenuItem("Gestionar Muestra");
			gestionarAnalisisMenu = new JMenuItem("Gestionar Analisis");
			calcularClasificacionMenu = new JMenuItem("Calcular Clasificacion");
			salirMenu = new JMenuItem("Salir");
			herramientas.add(gestionarMuestraMenu);
			herramientas.add(gestionarAnalisisMenu);
			herramientas.add(calcularClasificacionMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(listarMuestrasMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(salirMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
		}
		initialize();
	}


	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private  void initialize() {
		
		this.setSize(700,500);
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
		return jButtongestionarMuestra;
	}

	/**
	 * @return the clasificacion
	 */
	public JButton getJButtonClasificacion() {
		return jButtonclasificacion;
	}

	/**
	 * @return the analisis
	 */
	public JButton getJButtonAnalisis() {
		return jButtonanalisis ;
	}
	
	/**
	 * @return the gestionarMuestra
	 */
	public JButton getJButtonListarMuestras() {
		return jButtonListarMuestras;
	}

	/**
	 * @return the cerrar
	 */
	public JButton getJButtonSalir() {
		return jButtonSalir ;
	}
	
	
	
	
	/**
	 * @return the listarMuestrasMenu
	 */
	public JMenuItem getListarMuestrasMenu() {
		return listarMuestrasMenu;
	}


	/**
	 * @return the gestionarMuestraMenu
	 */
	public JMenuItem getGestionarMuestraMenu() {
		return gestionarMuestraMenu;
	}


	/**
	 * @return the gestionarAnalisisMenu
	 */
	public JMenuItem getGestionarAnalisisMenu() {
		return gestionarAnalisisMenu;
	}


	/**
	 * @return the calcularClasificacionMenu
	 */
	public JMenuItem getCalcularClasificacionMenu() {
		return calcularClasificacionMenu;
	}


	/**
	 * @return the salirMenu
	 */
	public JMenuItem getSalirMenu() {
		return salirMenu;
	}


	/**
	 * @return the versionMenu
	 */
	public JMenuItem getVersionMenu() {
		return versionMenu;
	}


	public void setListenerButtons(ActionListener lis){
		this.jButtongestionarMuestra.addActionListener(lis);
		this.jButtonanalisis.addActionListener(lis);
		this.jButtonclasificacion.addActionListener(lis);
        this.jButtonSalir.addActionListener(lis);
        this.salirMenu.addActionListener(lis);
        this.listarMuestrasMenu.addActionListener(lis);
        this.gestionarMuestraMenu.addActionListener(lis);
        this.gestionarAnalisisMenu.addActionListener(lis);
        this.calcularClasificacionMenu.addActionListener(lis);
        this.versionMenu.addActionListener(lis);
	}

}

