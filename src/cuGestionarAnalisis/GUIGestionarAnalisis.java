package cuGestionarAnalisis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.TablePanel;

/**
* @author TesisGeología
*
*/
public class GUIGestionarAnalisis extends JFrame {

	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonAgregarAnalisis;
	private JButton jButtonEliminarAnalisis;
	private JButton jButtonModificarAnalisis;
	private JButton jButtonSalir;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private TablePanel tablePanel;
	private Object [][] data= new Object [10] [4];
	
	
	public GUIGestionarAnalisis() throws Exception {
		super();
		if (this.menu==null) {
			menu = new JMenuBar();
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			buscarMenu = new JMenuItem("Buscar");
			agregarMenu = new JMenuItem("Agregar Analisis");
			modificarMenu = new JMenuItem("Modificar Analisis");
			eliminarMenu = new JMenuItem("Eliminar Analisis");
			salirMenu = new JMenuItem("Salir");
			herramientas.add(agregarMenu);
			herramientas.add(modificarMenu);
			herramientas.add(eliminarMenu);
			herramientas.add(buscarMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(salirMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
			jButtonAgregarAnalisis = new JButton("AGREGAR ANALISIS");
			jButtonEliminarAnalisis = new JButton("ELIMINAR ANALISIS");
			jButtonModificarAnalisis  = new JButton("MODIFICAR ANALISIS");
			jButtonSalir  = new JButton("SALIR");
		}
		initialize();
	}
	
	public GUIGestionarAnalisis(String title, Object [][] datos) throws Exception {
		super(title);
		data = datos.clone();
		if (this.menu==null) {
			menu = new JMenuBar();
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			buscarMenu = new JMenuItem("Buscar");
			agregarMenu = new JMenuItem("Agregar Analisis");
			modificarMenu = new JMenuItem("Modificar Analisis");
			eliminarMenu = new JMenuItem("Eliminar Analisis");
			salirMenu = new JMenuItem("Salir");
			herramientas.add(agregarMenu);
			herramientas.add(modificarMenu);
			herramientas.add(eliminarMenu);
			herramientas.add(buscarMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(salirMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
			jButtonAgregarAnalisis = new JButton("AGREGAR ANALISIS");
			jButtonEliminarAnalisis = new JButton("ELIMINAR ANALISIS");
			jButtonModificarAnalisis  = new JButton("MODIFICAR ANALISIS");
			jButtonSalir  = new JButton("SALIR");
		}
		initialize();
	}


	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private  void initialize() {
		
		this.setSize(1000,700);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new JPanel(), BorderLayout.EAST);
		this.getContentPane().add(new JPanel(), BorderLayout.WEST);
	  	this.setJMenuBar(this.getMenu());
	 	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	}

	
	public JPanel getPanelSur() {
		if (this.panelSur==null) {
			this.panelSur = new JPanel();
			this.panelSur.setLayout(new FlowLayout());
			this.panelSur.add(getJButtonAgregarAnalisis());
			this.panelSur.add(getJButtonModificarAnalisis());
			this.panelSur.add(getJButtonEliminarAnalisis());;
			this.panelSur.add(getJButtonCerrar());
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
	 * @return the 
	 */
	public JButton getJButtonAgregarAnalisis() {
		return jButtonAgregarAnalisis;
	}

	/**
	 * @return the 
	 */
	public JButton getJButtonEliminarAnalisis() {
		return jButtonEliminarAnalisis;
	}

	/**
	 * @return the 
	 */
	public JButton getJButtonModificarAnalisis() {
		return jButtonModificarAnalisis ;
	}


	/**
	 * @return the cerrar
	 */
	public JButton getJButtonCerrar() {
		return jButtonSalir ;
	}
	public void setListenerButtons(ActionListener lis){
		this.jButtonAgregarAnalisis.addActionListener(lis);
		this.jButtonModificarAnalisis.addActionListener(lis);
		this.jButtonEliminarAnalisis.addActionListener(lis);
        this.jButtonSalir.addActionListener(lis);
	}
	/** 
     *@return data  
     * */
	public static String[] getColumName(){
		String[] columnName = {"Tamiz N°","Peso Retenido(gr)","% Porcentaje Pasante","% Porcentaje Acumulado","% Porcentaje Retenido"};
		return columnName;
	}
	
	/**
	 * Metodo que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel() {
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, getColumName());			
		}
		return this.tablePanel;
	}
	/**
	 * Metodo que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public void setTablePanel(Object [][] datos) {
		data = datos.clone();
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, getColumName());			
		}
	}

}
