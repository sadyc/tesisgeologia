package cuCompararMuestra;

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

 * Esta clase implementa la ventana que me permite seleccionar una de las muestras almacenadas.
 * @author TesisGeolog�a
 * @version 1.0.

*/
@SuppressWarnings("serial")
public class GUISeleccionarMuestra extends JDialog	{

	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonBuscarMuestra;
	private JButton jButtonSeleccionarMuestra;
	private JButton jButtonCancelar;
	private JMenuItem seleccionarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem cancelarMenu;
	private JMenuItem versionMenu;
	private JPanel panelSur;
	private TablePanel tablePanel;
	private Object [][] data;
	
	/**
	 * Constructor de la clase.
	 * @param datos, contiene la información de las muestras almacenadas en el sistema.
	 */
	public GUISeleccionarMuestra(Object [][] datos) {
		super();
		data = datos;
		if (this.menu==null) {
			tablePanel = getTablePanel();
			menu = new JMenuBar();
			herramientas = new JMenu("Herramientas");
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			buscarMenu = new JMenuItem("Buscar");
			seleccionarMenu = new JMenuItem("Seleccionar");
			cancelarMenu = new JMenuItem("Cancelar");
			herramientas.add(seleccionarMenu);
			herramientas.add(buscarMenu);
			herramientas.add(new JSeparator());
			herramientas.add(cancelarMenu);
			versionMenu = new JMenuItem("Versión");
			ayuda.add(versionMenu);
			jButtonBuscarMuestra = new JButton("BUSCAR");
			jButtonSeleccionarMuestra  = new JButton("SELECCIONAR");
			jButtonCancelar  = new JButton("CANCELAR");
		}
		initialize();
	}
	
	/**
	 * Método que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(1003, 700);
      	this.getContentPane().setLayout(new BorderLayout());
    	this.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new JPanel(), BorderLayout.EAST);
		this.getContentPane().add(new JPanel(), BorderLayout.WEST);
	 	this.setJMenuBar(this.getMenu());
	  	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	}
	/**
	 * This method retorna botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSeleccionar() {
		return jButtonSeleccionarMuestra;
	}

	/**
	 * This method retorna boton buscar
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonBuscar() {
		return jButtonBuscarMuestra;
	}

	/**
	 * This method retorna boton salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSalir() {
		return jButtonCancelar;
	}
	
	/**
	 * Método que permite escuchar los botones Seleccionar y Buscar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonSeleccionarMuestra.addActionListener(lis);
		this.jButtonBuscarMuestra.addActionListener(lis);
		this.jButtonCancelar.addActionListener(lis);
		seleccionarMenu.addActionListener(lis);
		buscarMenu.addActionListener(lis);
		versionMenu.addActionListener(lis);
	
	}
	/**
	 * Método que permite escuchar la tabla panel.
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
		String[] columnName = {"Ubicación","Nombre","Peso","Profundidad Inicial","Profundidad Final"};
		return columnName;
	}

	/**
	 * Método que retorna el panelSur.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelSur() {
		if (this.panelSur==null) {
		this.panelSur = new JPanel();
		this.panelSur.setLayout(new FlowLayout());
		this.panelSur.add(getJButtonSeleccionar());
		this.panelSur.add(getJButtonBuscar());
		this.panelSur.add(getJButtonSalir());
		}
		return this.panelSur;
	}

	/**
	 * Método que retorna la tabla panel.
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
	
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
	}

}