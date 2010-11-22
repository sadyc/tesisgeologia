package comun;

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
/**
* @author TesisGeología
* Esta clase implementa una ventana la cual lista todas las muestras almacenadas.
*/
public class GUIListarMuestras extends JDialog	{

	private JMenuBar menu = null;
	private JMenu herramientas;
	private JMenu ayuda;
	private JButton jButtonSalir;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JPanel panelSur;
	private TablePanel tablePanel;
	private Object [][] data;
		
	
	
	/**
	 * Constructor con parametros de la clase.
	 * @param datos, contiene una tabla con la informacion de las muestras almacenadas de manera persistente.
	 */
	public GUIListarMuestras(Object [][] datos) {
		super();
		data = datos;
		if (this.menu==null) {
			tablePanel = getTablePanel();
			herramientas = new JMenu("Herramientas");
			menu = new JMenuBar();
			ayuda = new JMenu("Ayuda");
			menu.add(herramientas);
			menu.add(ayuda);
			salirMenu = new JMenuItem("Salir");
			herramientas.add(salirMenu);
			versionMenu = new JMenuItem("Version");
			ayuda.add(versionMenu);
			jButtonSalir  = new JButton("SALIR");
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
	  	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.setLocationRelativeTo(null);
	}
	
	/**
	 * This method retorna boton salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSalir() {
		return jButtonSalir;
	}
	
	/**
	 * Metodo que permite escuchar los botones Salir y salirMenu.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonSalir.addActionListener(lis);
		this.salirMenu.addActionListener(lis);
	
	}
	
	/** 
	 * Determina el nombre de cada columna de la tabla de la ventana.
     *@return columName, son los datos mas importantes de una muestra.  
     */
	public static String[] getColumName(){
		String[] columnName = {"Nombre Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final","Operador","Latitud","Longitud"};
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
			this.panelSur.setLayout(new FlowLayout(FlowLayout.RIGHT));
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

}

