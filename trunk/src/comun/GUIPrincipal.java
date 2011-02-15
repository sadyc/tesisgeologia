package comun;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import comun.FondoJPG;



/**
* @author TesisGeología
* Esta clase implementa la ventana principal del programa, con los botones de sus principales funcionalidades.
*/
public class GUIPrincipal extends JFrame {

	//private final FondoJPG fondo = null;
	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonGestionarUsuario;
	private JButton jButtonGestionarCliente;
	private JButton jButtonGestionarOperador;
	private JButton jButtongestionarMuestra;
	private JButton jButtonGestionarLimiteConsistencia;
	private JButton jButtonclasificacion;
	private JButton jButtonAnalisis;
	private JButton jButtonCompararMuestras;
	private JButton jButtonSalir;
	private JMenuItem gestionarUsuarioMenu;
	private JMenuItem gestionarClienteMenu;
	private JMenuItem gestionarOperadorMenu;
	private JMenuItem gestionarMuestraMenu;
	private JMenuItem gestionarAnalisisMenu;
	private JMenuItem gestionarLimiteConsistenciaMenu;
	private JMenuItem calcularClasificacionMenu;
	private JMenuItem compararMuestrasMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	


	/**
	 * Constructor de la clase.
	 * @param title, es el titulo que va a tener la ventana.
	 * @throws Exception
	 */
	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			jButtongestionarMuestra = new JButton("GESTIONAR MUESTRA");
			jButtonclasificacion = new JButton("CALCULAR CLASIFICACION");
			jButtonAnalisis  = new JButton("GESTIONAR ANALISIS");
			jButtonGestionarUsuario = new JButton("GESTIONAR USUARIO");
			jButtonGestionarCliente = new JButton("GESTIONAR CLIENTE");
			jButtonGestionarOperador = new JButton("GESTIONAR OPERADOR");
			jButtonCompararMuestras = new JButton("COMPARAR MUESTRAS");
			jButtonGestionarLimiteConsistencia = new JButton("GESTIONAR LIMITE CONSISTENCIA");
			jButtonSalir  = new JButton("SALIR");
			jButtonSalir.setBackground( SystemColor.red );
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			gestionarUsuarioMenu = new JMenuItem("Gestionar Usuario");
			gestionarClienteMenu = new JMenuItem("Gestionar Cliente");
			gestionarOperadorMenu = new JMenuItem("Gestionar Operador");
			gestionarMuestraMenu = new JMenuItem("Gestionar Muestra");
			gestionarAnalisisMenu = new JMenuItem("Gestionar Analisis");
			gestionarLimiteConsistenciaMenu = new JMenuItem("Gestionar Limite Consistencia");
			calcularClasificacionMenu = new JMenuItem("Calcular Clasificacion");
			compararMuestrasMenu = new JMenuItem("Comparar Muestras");
			salirMenu = new JMenuItem("Salir");
			herramientas.add(gestionarMuestraMenu);
			herramientas.add(gestionarAnalisisMenu);
			herramientas.add(gestionarLimiteConsistenciaMenu);
			herramientas.add(calcularClasificacionMenu);
			herramientas.add(compararMuestrasMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(gestionarUsuarioMenu);
			herramientas.add(gestionarClienteMenu);
			herramientas.add(gestionarOperadorMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(salirMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
		
		}
		this.setExtendedState(this.MAXIMIZED_BOTH);
		initialize();
	}


	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		
		this.setSize(1000,700);
		this.getContentPane().setLayout(new BorderLayout());
	 	this.setJMenuBar(this.getMenu());	
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	//setIconImage(new ImageIcon(getClass().getResource("/src/cuReporte/report/image/LogoSCS.jpg")).getImage());
	 	this.setLocationRelativeTo(null);
	
	}

	/**
	 * Metodo que retorna el panelCentro.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new JPanel();
			GridBagLayout gridbag = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
			gbc.weighty = 0.1;
			gbc.ipady = 40;
			gbc.ipadx = 90;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.panelCentro.setLayout(gridbag);
			this.panelCentro.add(getJButtonGestionarMuestra(),gbc);
			gbc.gridx = 2;
			this.panelCentro.add(getJButtonAnalisis(),gbc);
			gbc.gridx = 4;
			this.panelCentro.add(getJButtonGestionarLimiteConsistencia(),gbc);
			gbc.gridy = 3;
			gbc.gridx = 0;
			this.panelCentro.add(getJButtonGestionarUsuario(),gbc);
			gbc.gridx = 2;
			this.panelCentro.add(getJButtonCompararMuestras(),gbc);
			gbc.gridx = 4;
			this.panelCentro.add(getJButtonClasificacion(),gbc);
			gbc.gridy = 5;
			gbc.gridx = 0;
			this.panelCentro.add(getjButtonGestionarOperador(),gbc);
			gbc.gridx = 2;
			this.panelCentro.add(getjButtonGestionarCliente(),gbc);
			
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
	 * @return the gestionarMuestra
	 */
	public JButton getJButtonGestionarMuestra() {
		return jButtongestionarMuestra;
	}

	/**
	 * @return the GestionarLimiteConsistencia
	 */
	public JButton getJButtonGestionarLimiteConsistencia() {
		return jButtonGestionarLimiteConsistencia;
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
		return jButtonAnalisis ;
	}
	
	/**
	 * @return the gestionar usuario.
	 */
	public JButton getJButtonGestionarUsuario() {
		return jButtonGestionarUsuario;
	}

	/**
	 * @return the jButtonGestionarOperador
	 */
	public JButton getjButtonGestionarOperador() {
		return jButtonGestionarOperador;
	}


	/**
	 * @return the jButtonGestionarCliente
	 */
	public JButton getjButtonGestionarCliente() {
		return jButtonGestionarCliente;
	}


	/**
	 * @return the gestionarOperadorMenu
	 */
	public JMenuItem getGestionarOperadorMenu() {
		return gestionarOperadorMenu;
	}


	/**
	 * @return the comparar muestras.
	 */
	public JButton getJButtonCompararMuestras() {
		return jButtonCompararMuestras;
	}
	
	/**
	 * @return the salir
	 */
	public JButton getJButtonSalir() {
		return jButtonSalir ;
	}
	
	/**
	 * @return the gestionarUsuarioMenu
	 */
	public JMenuItem getGestionarUsuarioMenu() {
		return gestionarUsuarioMenu;
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
	 * @return the gestionarLimiteConsistenciaMenu
	 */
	public JMenuItem getGestionarLimiteConsistenciaMenu() {
		return gestionarLimiteConsistenciaMenu;
	}
	
	/**
	 * @return the calcularClasificacionMenu
	 */
	public JMenuItem getCalcularClasificacionMenu() {
		return calcularClasificacionMenu;
	}

	/**
	 * @return the compararMenu
	 */
	public JMenuItem getCompararMuestrasMenu() {
		return compararMuestrasMenu;
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

	/**
	 * @return the gestionarClienteMenu
	 */
	public JMenuItem getGestionarClienteMenu() {
		return gestionarClienteMenu;
	}


	public void setListenerButtons(ActionListener lis){
		this.jButtongestionarMuestra.addActionListener(lis);
		this.jButtonAnalisis.addActionListener(lis);
		this.jButtonclasificacion.addActionListener(lis);
        this.jButtonSalir.addActionListener(lis);
        this.jButtonGestionarUsuario.addActionListener(lis);
        this.jButtonCompararMuestras.addActionListener(lis);
        this.jButtonGestionarLimiteConsistencia.addActionListener(lis);
        this.jButtonGestionarOperador.addActionListener(lis);
        this.jButtonGestionarCliente.addActionListener(lis);
        this.salirMenu.addActionListener(lis);
        this.gestionarUsuarioMenu.addActionListener(lis);
        this.gestionarClienteMenu.addActionListener(lis);
        this.gestionarMuestraMenu.addActionListener(lis);
        this.gestionarAnalisisMenu.addActionListener(lis);
        this.calcularClasificacionMenu.addActionListener(lis);
        this.versionMenu.addActionListener(lis);
        this.compararMuestrasMenu.addActionListener(lis);
        this.gestionarLimiteConsistenciaMenu.addActionListener(lis);
        this.gestionarOperadorMenu.addActionListener(lis);
	}

}

