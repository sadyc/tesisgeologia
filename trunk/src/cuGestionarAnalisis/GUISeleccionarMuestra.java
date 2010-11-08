package cuGestionarAnalisis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import comun.TablePanel;

public class GUISeleccionarMuestra extends JDialog	{

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JMenuBar menu ;
	private JMenu archivo;
	private JMenu editar;
	private JMenu ayuda;
	 
	
	private JPanel panelSur;
	private TablePanel tablePanel;
	private JButton jButtonSeleccionar;
	private JButton jButtonBuscar;
	private Object [][] data;
	
	
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	public GUISeleccionarMuestra(Object [][] datos) {
		super();
		
		data = datos;
		menu = new JMenuBar();
		archivo = new JMenu("Archivo");
		editar = new JMenu("Editar");
		ayuda = new JMenu("Ayuda");
		menu.add(archivo);
		menu.add(editar);
		menu.add(ayuda);
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem cortar = new JMenuItem("Cortar");
		JMenuItem pegar = new JMenuItem("Pegar");
		editar.add(copiar);
		editar.add(cortar);
		editar.add(pegar);
		JMenuItem buscar = new JMenuItem("Buscar");
		JMenuItem agregar = new JMenuItem("Agregar Muestra");
		JMenuItem modificar = new JMenuItem("Modificar Muestra");
		JMenuItem salir = new JMenuItem("Salir");
		archivo.add(agregar);
		archivo.add(modificar);
		archivo.add(buscar);
		archivo.add(new JSeparator()); // Una rayita separadora.
		archivo.add(salir);
		JMenuItem version = new JMenuItem("Version");
		ayuda.add(version);		
		initialize();
	}
	
	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(803, 200);
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout());
		this.setJMenuBar(this.getMenu());
	 	// Se aaden los componentes al Frame
	 	// Agregamos la tabla  al Frame
		//this.getContentPane().add(this.getMenu(),BorderLayout.NORTH);
	 	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	// Agregamos el Panel Sur al Frame
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	}
	/**
	 * This method initializes botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSeleccionar() {
		if (jButtonSeleccionar == null) {
			jButtonSeleccionar = new JButton();
			jButtonSeleccionar.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonSeleccionar.setText("Seleccionar Muestra");
		}
		return jButtonSeleccionar;
	}

	/**
	 * This method initializes botonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new java.awt.Rectangle(277,113,89,34));
			jButtonBuscar.setText("Buscar");
		}
		return jButtonBuscar;
	}

	
	
	/**
	 * Metodo que permite escuchar los botones Seleccionar y Buscar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonSeleccionar.addActionListener(lis);
		this.jButtonBuscar.addActionListener(lis);
	
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
		// Se pone el FlowLayout en el Panel Sur
		this.panelSur.setLayout(new FlowLayout());
		// Se aaden los componentes al panel Sur
		this.panelSur.add(getJButtonSeleccionar());
		this.panelSur.add(getJButtonBuscar());
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

