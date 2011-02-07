/**
 * 
 */
package cuGestionarUbiacion;

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
* Esta clase implementa la ventana que me permite seleccionar una ubicacion de las almacenados.
*/
public class GUISeleccionarUbicacion extends JDialog	{

	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonBuscarUbicacion;
	private JButton jButtonSeleccionarUbicacion;
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
	 * @param datos, contiene la informacion de las ubicaciones almacenadas.
	 */
	public GUISeleccionarUbicacion(Object [][] datos) {
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
			cancelarMenu = new JMenuItem("Salir");
			herramientas.add(seleccionarMenu);
			herramientas.add(buscarMenu);
			herramientas.add(new JSeparator()); // Una rayita separadora.
			herramientas.add(cancelarMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
			jButtonBuscarUbicacion = new JButton("BUSCAR");
			jButtonSeleccionarUbicacion  = new JButton("SELECCIONAR");
			jButtonCancelar  = new JButton("SALIR");
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
		return jButtonSeleccionarUbicacion;
	}

	/**
	 * This method retorna boton buscar
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonBuscar() {
		return jButtonBuscarUbicacion;
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
	 * @return the seleccionarMenu
	 */
	public JMenuItem getSeleccionarMenu() {
		return seleccionarMenu;
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
	 * @return the versionMenu
	 */
	public JMenuItem getVersionMenu() {
		return versionMenu;
	}

	/**
	 * Metodo que permite escuchar los botones Seleccionar, Buscar y Salir.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonSeleccionarUbicacion.addActionListener(lis);
		this.jButtonBuscarUbicacion.addActionListener(lis);
		this.jButtonCancelar.addActionListener(lis);
		seleccionarMenu.addActionListener(lis);
		buscarMenu.addActionListener(lis);
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
    */
	public static String[] getColumName(){
		String[] columnName = {"Nombre","Provincia","Latitud","Longitud"};
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
	
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
	}
	
	
}

