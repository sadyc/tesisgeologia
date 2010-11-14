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
	private JMenu herramientas;
	private JMenu ayuda;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JMenuItem imprimirMenu;
	private JButton imprimir;
	private JButton salir;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JPanel panelCenter=null;
	private JPanel panelSW=null;
	
	private JLabel muestra;
	private JLabel peso;
	private JLabel profundidadInicial;
	private JLabel profundidadFinal;
	private JLabel ubicacion;
	private JLabel clasificacion;
	private JLabel descripcion;
	private JLabel limiteLiquido;
	private JLabel limitePlastico;
	private JLabel indicePlasticidad;
	private JLabel D60;
	private JLabel D30;
	private JLabel D10;
	private JLabel coeficienteUniformidad;
	private JLabel gradoCurvatura;
		
	private TablePanel tablePanel;
	private Object [][] data = new Object [3][5];

	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	/**
	 * This is the default constructor
	 */
	public GUIClasificacion() {
		super();
		menu = new JMenuBar();
		herramientas = new JMenu ("Archivo");
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(herramientas);
		menu.add(herramientas);
		menu.add(ayuda);
		salirMenu = new JMenuItem("Salir");
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		versionMenu = new JMenuItem("Version");
		ayuda.add(versionMenu);	
		imprimirMenu = new JMenuItem("Imprimir");
		herramientas.add(imprimirMenu);
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		muestra = new JLabel("Muestra: ");
		peso = new JLabel("Peso: ");
		profundidadInicial = new JLabel("Profundidad Inicial: ");
		profundidadFinal = new JLabel("Profundidad Final: ");
		ubicacion = new JLabel ("Ubicación: ");
		clasificacion = new JLabel ("Clasificación: ");
		descripcion = new JLabel ("Descripción: ");
		limiteLiquido = new JLabel ("Límite Líquido (LL): ");
		limitePlastico = new JLabel ("Límite Plástico (LP): ");
		indicePlasticidad = new JLabel ("Íncide de Plasticidad (IP): ");
		D60 = new JLabel("D60(mm): ");
		D30 = new JLabel("D30(mm): ");
		D10 = new JLabel("D10(mm): ");
		coeficienteUniformidad = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura = new JLabel ("Grado de Corvatura (Cc): ");
		
		imprimir = new JButton("Imprimir");
		salir = new JButton("Salir");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIClasificacion(Muestra muestra) {
		super();
		//data =     LE TENGO QUE CARGAR LA COLECCION DE ANALISIS QUE TIENE LA MUESTRA 
		menu = new JMenuBar();
		herramientas = new JMenu ("Archivo");
		herramientas = new JMenu("Herramientas");
		ayuda = new JMenu("Ayuda");
		menu.add(herramientas);
		menu.add(herramientas);
		menu.add(ayuda);
		salirMenu = new JMenuItem("Salir");
		versionMenu = new JMenuItem("Version");
		ayuda.add(versionMenu);	
		imprimirMenu = new JMenuItem("Imprimir");
		herramientas.add(imprimirMenu);
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		this.muestra.setText(muestra.getNombreMuestra());
		this.peso.setText("Peso: "+muestra.getPeso().toString()+"grs");
		profundidadInicial.setText("Profundidad Inicial: "+muestra.getProfundidadInicial()+"mts");
		profundidadFinal.setText("Profundidad Final: "+muestra.getProfundidadFinal()+"mts");
		ubicacion = new JLabel ("Ubicacion: "+muestra.getUbicacion().getNombreUbicacion());
		clasificacion = new JLabel ("Clasificacion: "+muestra.getClasificacion());
		descripcion = new JLabel ("Descripcion: "+muestra.getClasificacion().getDescripcion());
		limiteLiquido = new JLabel ("Límite Líquido (LL): ");    //FALTAN ASIGNARLES VALOREEEEEEEEEEES
		clasificacion = new JLabel ("Límite Plástico (LP): ");	//***************************************
		descripcion = new JLabel ("Íncide de Plasticidad (IP): ");
		D60 = new JLabel("D60(mm): ");
		D30 = new JLabel("D30(mm): "); // INFORMACION QUE SACA DEL ANALISIS PERTENECIENTE A LA MUESTRA PASADA
		D10 = new JLabel("D10(mm): "); // COMO PARAMETRO.. NO SE BIEN COMO LOS SACA A ESTOS DATOS.
		coeficienteUniformidad = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura = new JLabel ("Grado de Corvatura (Cc): ");
		
		imprimir = new JButton("Imprimir");
		salir = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * @return the muestra
	 */
	public JLabel getMuestra() {
		return muestra;
	}

	/**
	 * @return the profundidadInicial
	 */
	public JLabel getProfundidadInicial() {
		return profundidadInicial;
	}

	/**
	 * @return the profundidadFinal
	 */
	public JLabel getProfundidadFinal() {
		return profundidadFinal;
	}
	
	/**
	 * @return the peso
	 */
	public JLabel getPeso() {
		return peso;
	}
	
	/**
	 * @return the imprimir
	 */
	public JButton getJButtonImprimir() {
		return imprimir;
	}


	/**
	 * @param imprimir the imprimir to set
	 */
	public void setJButtonImprimir(JButton imprimir) {
		this.imprimir = imprimir;
	}
	
	/**
	 * @return the salir
	 */
	public JButton getJButtonSalir() {
		return salir;
	}

	/**
	 * @param salir the salir to set
	 */
	public void setJButtonSalir(JButton salir) {
		this.salir = salir;
	}

	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(800 , 400);
		this.getContentPane().setLayout(new BorderLayout()); 		
	 	this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		this.setJMenuBar(this.getMenu());
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
			this.panelNorte.add(new JLabel("DATOS DE LA MUESTRA: "));
			this.panelNorte.add(ubicacion);
			this.panelNorte.add(peso);
			this.panelNorte.add(profundidadInicial);
			this.panelNorte.add(profundidadFinal);
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
			this.panelCenter.add(clasificacion);
			this.panelCenter.add(descripcion);
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
			this.panelSur.setLayout(new FlowLayout());
			this.panelSur.add(imprimir);
			this.panelSur.add(salir);
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
			this.panelSW.add(limiteLiquido);
			this.panelSW.add(limitePlastico);
			this.panelSW.add(indicePlasticidad);
			this.panelSW.add(new JLabel("------------------------------------"));
			this.panelSW.add(D60);
			this.panelSW.add(D30);
			this.panelSW.add(D10);
			this.panelSW.add(coeficienteUniformidad);
			this.panelSW.add(gradoCurvatura);
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
		this.salir.addActionListener(lis);
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
}
