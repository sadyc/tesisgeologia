package cuGestionarOperador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import comun.TablePanel;

/**
* @author TesisGeología
* Esta clase implementa la ventana que me permite seleccionar un operador de laboratorio de los almacenados.
*/
public class GUISeleccionarOperador extends JDialog	{

	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonAgregarOperador;
	private JButton jButtonModificarOperador;
	private JButton jButtonEliminarOperador;
	private JButton jButtonBuscarOperador;
	private JButton jButtonSeleccionarOperador;
	private JButton jButtonCancelar;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem seleccionarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem cancelarMenu;
	private JMenuItem versionMenu;
	private JPanel panelSur;
	private TablePanel tablePanel;
	private Object [][] data;
	
	/**
	 * Constructor de la clase.
	 * @param datos, contiene la informacion de las muestras almacenadas en el sistema.
	 */
	public GUISeleccionarOperador(Object [][] datos) {
		super();
		data = datos;
		if (this.menu==null) {
			tablePanel = getTablePanel();
			menu = new JMenuBar();
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			agregarMenu= new JMenuItem("Agregar");
			modificarMenu= new JMenuItem("Modificar");
			eliminarMenu= new JMenuItem("Eliminar");
			buscarMenu = new JMenuItem("Buscar");
			seleccionarMenu = new JMenuItem("Seleccionar");
			cancelarMenu = new JMenuItem("Salir");
			herramientas.add(agregarMenu);
			herramientas.add(modificarMenu);
			herramientas.add(eliminarMenu);
			herramientas.add(new JSeparator());
			herramientas.add(seleccionarMenu);
			herramientas.add(buscarMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(cancelarMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
			jButtonAgregarOperador = new JButton("AGREGAR");
			jButtonModificarOperador = new JButton("MODIFICAR");
			jButtonEliminarOperador = new JButton("ELIMINAR");
			jButtonBuscarOperador = new JButton("BUSCAR");
			jButtonSeleccionarOperador  = new JButton("SELECCIONAR");
			jButtonCancelar  = new JButton("CANCELAR");
		}
		initialize();
	}
	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(1003, 700);
      	this.getContentPane().setLayout(new BorderLayout());
		this.setJMenuBar(this.getMenu());
		this.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new JPanel(), BorderLayout.EAST);
		this.getContentPane().add(new JPanel(), BorderLayout.WEST);
	   	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	}
	
	/**
	 * @return the jButtonAgregarOperador
	 */
	public JButton getjButtonAgregarOperador() {
		return jButtonAgregarOperador;
	}
	/**
	 * @return the jButtonModificarOperador
	 */
	public JButton getjButtonModificarOperador() {
		return jButtonModificarOperador;
	}
	/**
	 * @return the jButtonEliminarOperador
	 */
	public JButton getjButtonElminarOperador() {
		return jButtonEliminarOperador;
	}
	/**
	 * This method retorna botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSeleccionar() {
		return jButtonSeleccionarOperador;
	}

	/**
	 * This method retorna boton buscar
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonBuscar() {
		return jButtonBuscarOperador;
	}

	/**
	 * This method retorna boton salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonCancelar() {
		return jButtonCancelar;
	}
	
	/**
	 * Metodo que permite escuchar los botones Seleccionar y Buscar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		agregarMenu.addActionListener(lis);
		eliminarMenu.addActionListener(lis);
		modificarMenu.addActionListener(lis);
		seleccionarMenu.addActionListener(lis);
		cancelarMenu.addActionListener(lis);
		buscarMenu.addActionListener(lis);
		jButtonAgregarOperador.addActionListener(lis);
		jButtonEliminarOperador.addActionListener(lis);
		jButtonModificarOperador.addActionListener(lis);
		jButtonSeleccionarOperador.addActionListener(lis);
		jButtonBuscarOperador.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
	
	}
	/**
	 * Metodo que permite escuchar la tabla panel.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerTable(MouseListener lis){
		this.tablePanel.addMouseListener(lis);
	}
	

	/** 
     *@return data  
     * */
	public static String[] getColumName(){
		String[] columnName = {"Nombre","Apellido","DNI","Telefono","Email"};
		return columnName;
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
		this.panelSur.add(jButtonAgregarOperador);
		this.panelSur.add(jButtonModificarOperador);
		this.panelSur.add(jButtonEliminarOperador);
		this.panelSur.add(getJButtonSeleccionar());
		this.panelSur.add(getJButtonBuscar());
		this.panelSur.add(getJButtonCancelar());
		}
		return this.panelSur;
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
	 * @return the menu
	 */
	public JMenuBar getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}
	
	/**
	 * @return the jButtonSeleccionarOperador
	 */
	public JButton getjButtonSeleccionarOperador() {
		return jButtonSeleccionarOperador;
	}
	
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
	}
	
	
}
