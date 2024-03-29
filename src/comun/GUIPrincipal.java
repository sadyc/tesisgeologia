package comun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;



/**
* Esta clase implementa la ventana principal del programa, con los botones de sus principales funcionalidades.
* @author TesisGeología
* @version 1.0
*/
@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {

	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private JMenuBar menu = null;
	private JMenu muestra;
	private JMenu gestionar;
	private JMenu sistema;
	private JMenu version;
	private JButton jButtonGestionarUsuario;
	private JButton jButtonGestionarCliente;
	private JButton jButtonGestionarOperador;
	private JButton jButtonGestionarMuestra;
	private JButton jButtonGestionarLimiteConsistencia;
	private JButton jButtonClasificacion;
	private JButton jButtonAnalisis;
	private JButton jButtonCompararMuestras;
	private JButton jButtonSalir;
	private JButton jButtonGestionarUbicacion;
	private JMenuItem gestionarUsuarioMenu;
	private JMenuItem gestionarClienteMenu;
	private JMenuItem gestionarOperadorMenu;
	private JMenuItem gestionarMuestraMenu;
	private JMenuItem gestionarAnalisisMenu;
	private JMenuItem gestionarUbicacionMenu;
	private JMenuItem gestionarLimiteConsistenciaMenu;
	private JMenuItem calcularClasificacionMenu;
	private JMenuItem compararMuestrasMenu;
	private JMenuItem crearBackupMenu;
	private JMenuItem cargarBackupMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JMenuItem cerrarSesionMenu;
	
	
	 
	  
	/**
	 * Constructor de la clase.
	 * @param title, es el título que va a tener la ventana.
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			jButtonGestionarMuestra = new JButton();
			jButtonClasificacion = new JButton();
			jButtonAnalisis  = new JButton();
			jButtonGestionarUsuario = new JButton();
			jButtonGestionarCliente = new JButton();
			jButtonGestionarOperador = new JButton();
			jButtonCompararMuestras = new JButton();
			jButtonGestionarLimiteConsistencia = new JButton();
			jButtonGestionarUbicacion = new JButton();
			jButtonSalir  = new JButton();

			jButtonSalir.setBackground( SystemColor.red );
			jButtonGestionarOperador.setBackground( SystemColor.darkGray);
			jButtonGestionarOperador.setForeground(SystemColor.white);
			jButtonGestionarMuestra.setBackground( SystemColor.darkGray);
			jButtonGestionarMuestra.setForeground(SystemColor.white);
			jButtonClasificacion.setBackground( SystemColor.darkGray);
			jButtonClasificacion.setForeground(SystemColor.white);
			jButtonAnalisis.setBackground( SystemColor.darkGray);
			jButtonAnalisis.setForeground(SystemColor.white);
			jButtonGestionarUsuario.setBackground( SystemColor.darkGray);
			jButtonGestionarUsuario.setForeground(SystemColor.white);
			jButtonGestionarCliente.setBackground( SystemColor.darkGray);
			jButtonGestionarCliente.setForeground(SystemColor.white);
			jButtonGestionarOperador.setBackground( SystemColor.darkGray);
			jButtonGestionarOperador.setForeground(SystemColor.white);
			jButtonCompararMuestras.setBackground( SystemColor.darkGray);
			jButtonCompararMuestras.setForeground(SystemColor.white);
			jButtonGestionarLimiteConsistencia.setBackground( SystemColor.darkGray);
			jButtonGestionarLimiteConsistencia.setForeground(SystemColor.white);
			jButtonGestionarUbicacion.setBackground( SystemColor.darkGray);
			jButtonGestionarUbicacion.setForeground(SystemColor.white);
			
			jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
	        jButtonSalir.setText("Salir");
	        
	        jButtonGestionarMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-science-2.png"))); // NOI18N
	        jButtonGestionarMuestra.setText("Gestionar Muestras");
	        jButtonGestionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gobby.png"))); // NOI18N
	        jButtonGestionarUsuario.setText("Gestionar Usuario");
	        jButtonGestionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-switch-user.png"))); // NOI18N
	        jButtonGestionarCliente.setText("Gestionar Cliente");
	        jButtonGestionarOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-engineering-3.png"))); // NOI18N
	        jButtonGestionarOperador.setText("Gesitonar Operador");
	        jButtonGestionarLimiteConsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-office-3.png"))); // NOI18N
	        jButtonGestionarLimiteConsistencia.setText("Gestionar Consistencia");
	        jButtonAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kexi.png"))); // NOI18N
	        jButtonAnalisis.setText("Gestionar Análisis");
	        jButtonCompararMuestras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/development-python.png"))); // NOI18N
	        jButtonCompararMuestras.setText("Comparar Muestras");
	        jButtonClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accessories-calculator-3.png"))); // NOI18N
	        jButtonClasificacion.setText("Calcular Clasificación");
	        jButtonGestionarUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/internet-web-browser-3.png"))); // NOI18N
	        jButtonGestionarUbicacion.setText("Gestionar Ubicación");
	        
	        muestra = new JMenu("Muestra");
			version = new JMenu("Acerca de SCS");
			sistema = new JMenu("Sistema");
			gestionar = new JMenu("Gestionar");
				
			menu.add(muestra);
			menu.add(gestionar);
			menu.add(sistema);
			menu.add(version);
			
			gestionarUsuarioMenu = new JMenuItem("Gestionar Usuario");
			gestionarUsuarioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gobby.png"))); // NOI18N

			gestionarClienteMenu = new JMenuItem("Gestionar Cliente");
			gestionarClienteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-switch-user.png"))); // NOI18N

			gestionarOperadorMenu = new JMenuItem("Gestionar Operador");
			gestionarOperadorMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-engineering-3.png"))); // NOI18N

			gestionarMuestraMenu = new JMenuItem("Gestionar Muestra");
			gestionarMuestraMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-science-2.png"))); // NOI18N

			gestionarAnalisisMenu = new JMenuItem("Gestionar Análisis");
			gestionarAnalisisMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kexi.png"))); // NOI18N

			gestionarLimiteConsistenciaMenu = new JMenuItem("Gestionar Limite Consistencia");
			gestionarLimiteConsistenciaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-office-3.png"))); // NOI18N

			calcularClasificacionMenu = new JMenuItem("Calcular Clasificación");
			calcularClasificacionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accessories-calculator-3.png"))); // NOI18N

			compararMuestrasMenu = new JMenuItem("Comparar Muestras");
			compararMuestrasMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/development-python.png"))); // NOI18N

			crearBackupMenu = new JMenuItem("Crear BackUp");
			crearBackupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kfloppy-2.png"))); // NOI18N

			cargarBackupMenu = new JMenuItem("Cargar BackUp");
			cargarBackupMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update_misc.png"))); // NOI18N

			gestionarUbicacionMenu = new JMenuItem("Gestionar Ubicación");
			gestionarUbicacionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/internet-web-browser-3.png"))); // NOI18N

			salirMenu = new JMenuItem("Salir");
			salirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
			
			cerrarSesionMenu = new JMenuItem("Cerrar sesión");
			cerrarSesionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/task-recurring.png")));
			
			muestra.add(gestionarMuestraMenu);
			muestra.add(gestionarAnalisisMenu);
			muestra.add(gestionarLimiteConsistenciaMenu);
			muestra.add(calcularClasificacionMenu);
			muestra.add(compararMuestrasMenu);
			gestionar.add(gestionarUsuarioMenu);
			gestionar.add(gestionarClienteMenu);
			gestionar.add(gestionarOperadorMenu);
			gestionar.add(gestionarUbicacionMenu);
			sistema.add(crearBackupMenu);
			sistema.add(cargarBackupMenu);
			muestra.add(new JSeparator());
			muestra.add(cerrarSesionMenu);
			muestra.add(salirMenu);
			versionMenu = new JMenuItem("Versión");
			versionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
			version.add(versionMenu);
		
		}
		this.setExtendedState(this.MAXIMIZED_BOTH);
		initialize();
	}


	/**
	 * Metodo que inicializa la interfaz.
	 */
	private  void initialize() {
		this.setSize(1000,700);
		this.getContentPane().setLayout(new BorderLayout());
	 	this.setJMenuBar(this.getMenu());	
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	
	}

	/**
	 * Metodo que retorna el panelCentro.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new PanelConFondo();
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
			gbc.gridx = 1;
			this.panelCentro.add(getJButtonAnalisis(),gbc);
			gbc.gridx= 2;
			this.panelCentro.add(getjButtonGestionarUbicacion(),gbc);
			gbc.gridx = 3;
			this.panelCentro.add(getJButtonGestionarLimiteConsistencia(),gbc);
			gbc.gridy = 1;
			gbc.gridx = 0;
			this.panelCentro.add(getJButtonGestionarUsuario(),gbc);
			gbc.gridx = 1;
			this.panelCentro.add(getJButtonCompararMuestras(),gbc);
			gbc.gridx = 2;
			this.panelCentro.add(getJButtonClasificacion(),gbc);
			gbc.gridy = 2;
			gbc.gridx = 0;
			this.panelCentro.add(getjButtonGestionarOperador(),gbc);
			gbc.gridx = 1;
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
			panelSur.add(new PanelConFondo());
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
	 * @return the jButtonGestionarMuestra
	 */
	public JButton getJButtonGestionarMuestra() {
		return jButtonGestionarMuestra;
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
		return jButtonClasificacion;
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
	 * @return the cerrarSesionMenu
	 */
	public JMenuItem getCerrarSesionMenu() {
		return cerrarSesionMenu;
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
	
	/**
	 * @return the crearBackupMenu
	 */
	public JMenuItem getCrearBackupMenu() {
		return crearBackupMenu;
	}


	/**
	 * @return the cargarBackupMenu
	 */
	public JMenuItem getCargarBackupMenu() {
		return cargarBackupMenu;
	}
	
	/**
	 * @return the gestionarUbicacionMenu
	 */
	public JMenuItem getGestionarUbicacionMenu() {
		return gestionarUbicacionMenu;
	}
	
	/**
	 * @return the jButtonGestionarUbicacion
	 */
	public JButton getjButtonGestionarUbicacion() {
		return jButtonGestionarUbicacion;
	}

	/**
	 * Metodo que permite escuchar los botones de la ventana.
	 * @param lis
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonGestionarMuestra.addActionListener(lis);
		this.jButtonGestionarUbicacion.addActionListener(lis);
		this.jButtonAnalisis.addActionListener(lis);
		this.jButtonClasificacion.addActionListener(lis);
        this.jButtonSalir.addActionListener(lis);
        this.jButtonGestionarUsuario.addActionListener(lis);
        this.jButtonCompararMuestras.addActionListener(lis);
        this.jButtonGestionarLimiteConsistencia.addActionListener(lis);
        this.jButtonGestionarOperador.addActionListener(lis);
        this.jButtonGestionarCliente.addActionListener(lis);
        this.cerrarSesionMenu.addActionListener(lis);
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
        this.cargarBackupMenu.addActionListener(lis);
        this.crearBackupMenu.addActionListener(lis);
        this.gestionarUbicacionMenu.addActionListener(lis);
	}

}

