/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import comun.TablePanel;

import persistencia.domain.Muestra;

/**
 * @author tesisGeologia.
 * 
 */
public class GUIClasificacion extends JDialog{

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	private JMenuBar menu ;
	private JMenu archivo;
	private JMenu herramientas;
	private JMenu ayuda;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem buscarMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JMenuItem imprimirMenu;
	private JMenuItem guardarMenu;
	private JButton imprimir;
	private JButton cancelar;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JPanel panelCenter=null;
	private JPanel panelSW=null;
	private JTextField muestra;
	private JTextField profundidadInicial;
	private JTextField profundidadFinal;
	private JTextField peso;
	private TablePanel tablePanel;
	private Object [][] data = new Object [3][5];

	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	/**
	 * This is the default constructor
	 */
	public GUIClasificacion() {
		super();
		menu = new JMenuBar();
		archivo = new JMenu ("Archivo");
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(archivo);
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
		imprimirMenu = new JMenuItem("Imprimir");
		guardarMenu = new JMenuItem("Guardar");
		archivo.add(imprimirMenu);
		archivo.add(guardarMenu);
		archivo.add(new JSeparator());
		archivo.add(salirMenu);
		muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		imprimir = new JButton("Imprimir");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIClasificacion(Muestra muestra) {
		super();
		menu = new JMenuBar();
		archivo = new JMenu ("Archivo");
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(archivo);
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
		imprimirMenu = new JMenuItem("Imprimir");
		guardarMenu = new JMenuItem("Guardar");
		archivo.add(imprimirMenu);
		archivo.add(guardarMenu);
		archivo.add(new JSeparator());
		archivo.add(salirMenu);
		this.muestra = new JTextField(15);
		profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
		this.muestra.setText(muestra.getNombreMuestra());
		peso.setText(muestra.getPeso().toString());
		profundidadInicial.setText("");
		profundidadFinal.setText("");
		imprimir = new JButton("Imprimir");
		cancelar = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * @return the muestra
	 */
	public JTextField getMuestra() {
		return muestra;
	}

	/**
	 * @return the profundidadInicial
	 */
	public JTextField getProfundidadInicial() {
		return profundidadInicial;
	}

	/**
	 * @return the profundidadFinal
	 */
	public JTextField getProfundidadFinal() {
		return profundidadFinal;
	}
	
	/**
	 * @return the peso
	 */
	public JTextField getPeso() {
		return peso;
	}
	
	/**
	 * @return the aceptar
	 */
	public JButton getJButtonAceptar() {
		return imprimir;
	}


	/**
	 * @param aceptar the aceptar to set
	 */
	public void setJButtonImprimir(JButton imprimir) {
		this.imprimir = imprimir;
	}
	
	/**
	 * @return the cancelar
	 */
	public JButton getJButtonCancelar() {
		return cancelar;
	}

	/**
	 * @param cancelar the cancelar to set
	 */
	public void setJButtonCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(800 , 400);
		// Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	// Se aaden los componentes al Frame
		// Agregamos el Panel Norte al Frame
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		this.setJMenuBar(this.getMenu());
	 	// Agregamos el Panel Sur al Frame
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	 	this.getContentPane().add(this.getPanelSW(),BorderLayout.WEST);
	 	this.getContentPane().add(this.getPanelCenter(),BorderLayout.EAST);
	 	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	}
   
	
	/**
	 * Metodo que retorna el panelNorte.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelNorte() {
		if (this.panelNorte==null) {
			this.panelNorte= new JPanel();
			this.panelNorte.setLayout(new BoxLayout(this.panelNorte,BoxLayout.Y_AXIS));
			profundidadInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
			profundidadFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
			peso.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.panelNorte.add(new JLabel("DATOS DE LA MUESTRA: "));
			this.panelNorte.add(new JLabel("Ubicacion : Rio Cuarto"));
			this.panelNorte.add(new JLabel("Peso : 3253 gr"));
			this.panelNorte.add(new JLabel("Profundidad Inicial: 2 mts"));
			this.panelNorte.add(new JLabel("Profundidad Final: 3 mts"));
			this.panelNorte.add(new JLabel("Humedad: 40%"));
			this.panelNorte.add(new JLabel("------------------------------------"));
		}
		return this.panelNorte;
	}	

	/**
	 * Metodo que retorna el panelCenter.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelCenter() {
		if (this.panelCenter==null) {
			this.panelCenter = new JPanel();
			this.panelCenter.setLayout(new BoxLayout(this.panelCenter,BoxLayout.Y_AXIS));
			this.panelCenter.add(new JLabel("DATOS DE LA CLASIFICACION: "));
			this.panelCenter.add(new JLabel("Clasificación: SUCS"));
			this.panelCenter.add(new JLabel("Descripción: Arena gravosa mal graduada"));
			}
			return this.panelCenter;
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
			// Se instancian los componentes para el Panel Sur
			// Se aaden los componentes al panel Sur
			this.panelSur.add(imprimir);
			this.panelSur.add(cancelar);
			}
			return this.panelSur;
	}
	
	/**
	 * Metodo que retorna el panelSW.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelSW() {
		if (this.panelSW==null) {
			this.panelSW = new JPanel();
			this.panelSW.setLayout(new BoxLayout(this.panelSW,BoxLayout.Y_AXIS));
			this.panelSW.add(new JLabel("PLASTICIDAD: "));
			this.panelSW.add(new JLabel("Límite Líquido (LL): "));
			this.panelSW.add(new JLabel("Límite Plástico (LP): "));
			this.panelSW.add(new JLabel("Indice de Plasticidad (IP): "));
			this.panelSW.add(new JLabel("------------------------------------"));
			this.panelSW.add(new JLabel("D30(mm): 0,28"));
			this.panelSW.add(new JLabel("D10(mm): 0,10"));
			this.panelSW.add(new JLabel("D10(mm): 0,10"));
			this.panelSW.add(new JLabel("Coef. Uniformidad (Cu): 16,2"));
			this.panelSW.add(new JLabel("Grado de Corvatura (Cc): 0,5"));
			
			
			}
			return this.panelSW;
	}
	/**
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.imprimir.addActionListener(lis);
		this.cancelar.addActionListener(lis);
	}
	
	

	public String[] getData() {
		String[] data = new String[4];
		data[0]= muestra.getText();
		data[1]= peso.getText();
		data[2]= profundidadInicial.getText();
		data[3]= profundidadFinal.getText();
		return data;
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
     *@return data  
     * */
	public static String[] getColumName(){
		String[] columnName = {"Nro Tamiz","Abertura (mm)","% Pasante","% Retenido Acumulado","% Retenido Parcial"};
		return columnName;
	}
	
	/**
	 * @return the menu
	 */
	public JMenuBar getMenu() {
		return menu;
	}
	
	/**
	 * Metodo que permite escuchar la tabla panel.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerTable(MouseListener lis){
		this.tablePanel.addMouseListener(lis);
	}
}
