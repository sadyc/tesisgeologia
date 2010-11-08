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
	private JMenu archivo;
	private JMenu editar;
	private JMenu ayuda;
	 
	
	private JPanel panelSur;
	private TablePanel tablePanel;
	private JButton jButtonAgregar;
	private JButton jButtonEliminar;
	private JButton jButtonModificar;
	private JButton jButtonSalir;
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
	public JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonAgregar.setText("Agregar");
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes botonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new java.awt.Rectangle(277,113,89,34));
			jButtonEliminar.setText("Eliminar");
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes botonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new java.awt.Rectangle(149,113,89,34));
			jButtonModificar.setText("Modificar");
		}
		return jButtonModificar;
	}
	
	/**
	 * This method initializes boton Salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new java.awt.Rectangle(149,113,89,34));
			jButtonSalir.setText("Salir");
		}
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
		// Se pone el FlowLayout en el Panel Sur
		this.panelSur.setLayout(new FlowLayout());
		// Se aaden los componentes al panel Sur
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
