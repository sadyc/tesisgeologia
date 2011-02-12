package cuGestionarUsuario;

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

public class GUIGestionarUsuario extends JDialog{


	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JMenuBar menu ;
	private JMenu herramientas;
	private JMenu ayuda;
	private JPanel panelSur;
	private TablePanel tablePanel;
	private JButton jButtonAgregar;
	private JButton jButtonEliminar;
	private JButton jButtonModificar;
	private JButton jButtonCancelar;
	private JButton jButtonBuscar;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem cancelarMenu;
	private JMenuItem versionMenu;
	private String [] columName;
	private Object [][] data;
	
	
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIGestionarUsuario(String title, Object [][] datos, String [] colum) {
		super();
		columName = colum;
		setTitle(title);
		data = datos.clone();
		menu = new JMenuBar();
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(herramientas);
		menu.add(ayuda);
		buscarMenu = new JMenuItem("Buscar");
		agregarMenu = new JMenuItem("Agregar Usuario");
		modificarMenu = new JMenuItem("Modificar Usuario");
		eliminarMenu = new JMenuItem("Eliminar Usuario");
		cancelarMenu = new JMenuItem("Cancelar");
		herramientas.add(agregarMenu);
		herramientas.add(modificarMenu);
		herramientas.add(eliminarMenu);
		herramientas.add(new JSeparator());
		herramientas.add(buscarMenu);
		herramientas.add(new JSeparator()); 
		herramientas.add(cancelarMenu);
		versionMenu = new JMenuItem("Versión");
		ayuda.add(versionMenu);		
		jButtonAgregar = new JButton("AGREGAR");
		jButtonModificar = new JButton("MODIFICAR");
		jButtonEliminar = new JButton("ELIMINAR");
		jButtonCancelar = new JButton("CANCELAR");
		jButtonBuscar = new JButton("BUSCAR");
	

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
	 * This method retorna botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * This method retorna boton eliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonEliminar() {
		return jButtonEliminar;
	}

	
	/**
	 * This method retorna botonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonModificar() {
		return jButtonModificar;
	}
	
	/**
	 * This method initializes boton Salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonCancelar() {
		return jButtonCancelar;
	}
	
	/**
	 * @return the ayuda
	 */
	public JMenu getAyuda() {
		return ayuda;
	}

	/**
	 * @return the agregarMenu
	 */
	public JMenuItem getAgregarMenu() {
		return agregarMenu;
	}

	/**
	 * @return the modificarMenu
	 */
	public JMenuItem getModificarMenu() {
		return modificarMenu;
	}

	/**
	 * @return the eliminarMenu
	 */
	public JMenuItem getEliminarMenu() {
		return eliminarMenu;
	}

	/**
	 * @return the buscarMenu
	 */
	public JMenuItem getBuscarMenu() {
		return buscarMenu;
	}

	/**
	 * @return the cancelarMenu
	 */
	public JMenuItem getCancelarMenu() {
		return cancelarMenu;
	}

	/**
	 * Metodo que permite escuchar los botoner Agregar, Eliminar, Modificar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jButtonAgregar.addActionListener(lis);
		jButtonEliminar.addActionListener(lis);
		jButtonModificar.addActionListener(lis);
		jButtonBuscar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
		buscarMenu.addActionListener(lis);
		agregarMenu.addActionListener(lis);
		eliminarMenu.addActionListener(lis);
		modificarMenu.addActionListener(lis);
		cancelarMenu.addActionListener(lis);
		versionMenu.addActionListener(lis);
		
        
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
	public String[] getColumName(){
		
		return columName;
	}

	public void setColumName(String [] columName){
		this.columName = columName.clone();
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
		this.panelSur.add(getJButtonAgregar());
		this.panelSur.add(getJButtonModificar());
		this.panelSur.add(getJButtonEliminar());
		this.panelSur.add(getJButtonBuscar());
		this.panelSur.add(getJButtonCancelar());
		
		}
		return this.panelSur;
	}

	public JButton getJButtonBuscar() {
		return jButtonBuscar;
	}

	/**
	 * Metodo que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel() {
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, columName);			
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
	
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
	}


}
