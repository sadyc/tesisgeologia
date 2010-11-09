package cuGestionarMuestra;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
//import java.awt.HeadlessException;


import javax.swing.*;

import comun.TablePanel;


/**
 * @author TesisGeologia
 * 
 * Clase que define la interfaz para dar de alta una muestra   
 */
public class GUIABMMuestra extends JFrame {


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
	private JButton jButtonSalir;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private Object [][] data;
	
	
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIABMMuestra(String title, Object [][] datos) {
		super(title);
		data = datos;
		menu = new JMenuBar();
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(herramientas);
		menu.add(ayuda);
		buscarMenu = new JMenuItem("Buscar");
		agregarMenu = new JMenuItem("Agregar Muestra");
		modificarMenu = new JMenuItem("Modificar Muestra");
		eliminarMenu = new JMenuItem("Eliminar Muestra");
		salirMenu = new JMenuItem("Salir");
		herramientas.add(agregarMenu);
		herramientas.add(modificarMenu);
		herramientas.add(eliminarMenu);
		herramientas.add(new JSeparator());
		herramientas.add(buscarMenu);
		herramientas.add(new JSeparator()); // Una rayita separadora.
		herramientas.add(salirMenu);
		versionMenu = new JMenuItem("Version");
		ayuda.add(versionMenu);		
		jButtonAgregar = new JButton("AGREGAR");
		jButtonModificar = new JButton("MODIFICAR");
		jButtonEliminar = new JButton("ELIMINAR");
		jButtonSalir = new JButton("SALIR");
		initialize();
	}

	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(803, 200);
		this.getContentPane().setLayout(new BorderLayout());
		this.setJMenuBar(this.getMenu());
	 	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
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
	public JButton getJButtonSalir() {
		return jButtonSalir;
	}
	
	/**
	 * Metodo que permite escuchar los botoner Agregar, Eliminar, Modificar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonAgregar.addActionListener(lis);
		this.jButtonEliminar.addActionListener(lis);
		this.jButtonModificar.addActionListener(lis);
		this.jButtonSalir.addActionListener(lis);
        
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
		String[] columnName = {"Nombre","Peso","Profundidad Inicial","Profundidad Final","Latitud","Longitud","Clasificacion","Usuario","Operador ID"};
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
		this.panelSur.add(getJButtonAgregar());
		this.panelSur.add(getJButtonModificar());
		this.panelSur.add(getJButtonEliminar());
		this.panelSur.add(getJButtonSalir());
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
	
}
