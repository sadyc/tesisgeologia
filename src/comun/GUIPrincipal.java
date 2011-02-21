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
	private JButton jButtonGestionarMuestra;
	private JButton jButtonGestionarLimiteConsistencia;
	private JButton jButtonClasificacion;
	private JButton jButtonAnalisis;
	private JButton jButtonCompararMuestras;
	private JButton jButtonSalir;
	private JButton jButtonCrearBackup;
	private JButton jButtonCargarBackup;
	private JMenuItem gestionarUsuarioMenu;
	private JMenuItem gestionarClienteMenu;
	private JMenuItem gestionarOperadorMenu;
	private JMenuItem gestionarMuestraMenu;
	private JMenuItem gestionarAnalisisMenu;
	private JMenuItem gestionarLimiteConsistenciaMenu;
	private JMenuItem calcularClasificacionMenu;
	private JMenuItem compararMuestrasMenu;
	private JMenuItem crearBackupMenu;
	private JMenuItem cargarBackupMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JFileChooser fileChooser = null;
	
	 private Image imagen;
	 
	  
	 

	/**
	 * Constructor de la clase.
	 * @param title, es el titulo que va a tener la ventana.
	 * @throws Exception
	 */
	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			jButtonGestionarMuestra = new JButton("GESTIONAR MUESTRA");
			jButtonClasificacion = new JButton("CALCULAR CLASIFICACION");
			jButtonAnalisis  = new JButton("GESTIONAR ANALISIS");
			jButtonGestionarUsuario = new JButton("GESTIONAR USUARIO");
			jButtonGestionarCliente = new JButton("GESTIONAR CLIENTE");
			jButtonGestionarOperador = new JButton("GESTIONAR OPERADOR");
			jButtonCompararMuestras = new JButton("COMPARAR MUESTRAS");
			jButtonGestionarLimiteConsistencia = new JButton("GESTIONAR LIMITE CONSISTENCIA");
			jButtonCrearBackup = new JButton("CREAR BACKUP");
			jButtonCargarBackup = new JButton("CARGAR BACKUP");
			jButtonSalir  = new JButton("SALIR");
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
			jButtonCrearBackup.setBackground( SystemColor.darkGray);
			jButtonCrearBackup.setForeground(SystemColor.white);
			jButtonCargarBackup.setBackground( SystemColor.darkGray);
			jButtonCargarBackup.setForeground(SystemColor.white);
			
			
			
			jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialog-no.png"))); // NOI18N
	        jButtonSalir.setText("Salir");
	        jButtonGestionarMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/applications-science-2.png"))); // NOI18N
	        jButtonGestionarMuestra.setText("Gestionar Muestra");
	        

	        jButtonGestionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gobby.png"))); // NOI18N
	        jButtonGestionarUsuario.setText("Gestionar Usuario");
	        
	        jButtonCargarBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/update_misc.png"))); // NOI18N
	        jButtonCargarBackup.setText("Cargar Backup");

	        jButtonGestionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/system-switch-user.png"))); // NOI18N
	        jButtonGestionarCliente.setText("Gestionar Cliente");
	        
	        jButtonGestionarOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/applications-engineering-3.png"))); // NOI18N
	        jButtonGestionarOperador.setText("Gesitonar Operador");
	        
	        jButtonGestionarLimiteConsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/applications-office-3.png"))); // NOI18N
	        jButtonGestionarLimiteConsistencia.setText("Gestionar Consistencia");
	        
	           
	        jButtonAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kexi.png"))); // NOI18N
	        jButtonAnalisis.setText("Gestionar Analisis");
	        
	        jButtonCompararMuestras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/development-python.png"))); // NOI18N
	        jButtonCompararMuestras.setText("Comparar Muestras");
	        

	        jButtonCrearBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kfloppy-2.png"))); // NOI18N
	        jButtonCrearBackup.setText("Realizar Backup");
	        
	        jButtonClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/accessories-calculator-3.png"))); // NOI18N
	        jButtonClasificacion.setText("Calcular Clasificacion");
	        
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
			crearBackupMenu = new JMenuItem("Crear BackUp");
			cargarBackupMenu = new JMenuItem("Cargar BackUp");
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
			herramientas.add(crearBackupMenu);
			herramientas.add(cargarBackupMenu);
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
			this.panelCentro= new PanelConFondo();
			GridBagLayout gridbag = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
			gbc.weighty = 0.1;
			gbc.ipady = 40;
			gbc.ipadx = 90;
			gbc.gridx = 0;
			gbc.gridy = 1;
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
			gbc.gridy = 7;
			gbc.gridx = 0;
			this.panelCentro.add(getjButtonCrearBackup(),gbc);
			gbc.gridx = 2;
			this.panelCentro.add(getjButtonCargarBackup(),gbc);
			
			
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

	public JFileChooser getFileChooser() {
        if(fileChooser == null)
                fileChooser = new JFileChooser();
        return fileChooser;
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
	 * @return the jButtonCrearBackup
	 */
	public JButton getjButtonCrearBackup() {
		return jButtonCrearBackup;
	}


	/**
	 * @return the jButtonCargarBackup
	 */
	public JButton getjButtonCargarBackup() {
		return jButtonCargarBackup;
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


	public void setListenerButtons(ActionListener lis){
		this.jButtonGestionarMuestra.addActionListener(lis);
		this.jButtonAnalisis.addActionListener(lis);
		this.jButtonClasificacion.addActionListener(lis);
        this.jButtonSalir.addActionListener(lis);
        this.jButtonGestionarUsuario.addActionListener(lis);
        this.jButtonCompararMuestras.addActionListener(lis);
        this.jButtonGestionarLimiteConsistencia.addActionListener(lis);
        this.jButtonGestionarOperador.addActionListener(lis);
        this.jButtonGestionarCliente.addActionListener(lis);
        this.jButtonCargarBackup.addActionListener(lis);
        this.jButtonCrearBackup.addActionListener(lis);
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
	}

}

