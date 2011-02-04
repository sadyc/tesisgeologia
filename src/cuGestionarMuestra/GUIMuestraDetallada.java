package cuGestionarMuestra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import persistencia.domain.Muestra;

import comun.TablePanel;

/**
 * @author tesisGeologia.
 * 
 */

 
public class GUIMuestraDetallada extends JDialog{

	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	
	private JMenuBar menu ;
	private JMenu herramientas;
	private JMenu ayuda;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
	private JMenuItem imprimirMenu;
	private JButton imprimir;
	

	private JButton salir;
	private JPanel panelNorte=null;
	private JPanel panelSur=null;
	private JPanel panelCenter=null;
	

	private JLabel muestra1;
	private JLabel peso1;
	private JLabel profundidadInicial1;
	private JLabel profundidadFinal1;
	private JLabel ubicacion1;
	private JLabel clasificacion1;
	private JLabel descripcion1;
	private JLabel limiteLiquido1;
	private JLabel limitePlastico1;
	private JLabel indicePlasticidad1;
	private JLabel D60_1;
	private JLabel D30_1;
	private JLabel D10_1;
	private JLabel coeficienteUniformidad1;
	private JLabel gradoCurvatura1;
	private TablePanel tablePanel1;
	private Object [][] data1 = new Object [3][5];
	private JButton jButtonAgregarAnalisis;
	private JButton jButtonEliminarAnalisis;
	private JButton jButtonModificarAnalisis;
	
	/**
	 * This is the default constructor
	 */
	public GUIMuestraDetallada() {
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
		
		agregarMenu = new JMenuItem("Agregar Análisis");
		herramientas.add(agregarMenu);
		modificarMenu = new JMenuItem("Modificar Análisis");
		herramientas.add(modificarMenu);
		eliminarMenu = new JMenuItem("Eliminar Análisis");
		herramientas.add(eliminarMenu);
		herramientas.add(new JSeparator());
		
		imprimirMenu = new JMenuItem("Imprimir");
		herramientas.add(imprimirMenu);
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		muestra1 = new JLabel("Muestra: ");
		peso1 = new JLabel("Peso: ");
		profundidadInicial1 = new JLabel("Profundidad Inicial: ");
		profundidadFinal1 = new JLabel("Profundidad Final: ");
		ubicacion1 = new JLabel ("Ubicación: ");
		clasificacion1 = new JLabel ("Clasificación: ");
		descripcion1 = new JLabel ("Descripción: ");
		limiteLiquido1 = new JLabel ("Límite Líquido (LL): ");
		limitePlastico1 = new JLabel ("Límite Plástico (LP): ");
		indicePlasticidad1 = new JLabel ("Íncide de Plasticidad (IP): ");
		D60_1 = new JLabel("D60(mm): ");
		D30_1 = new JLabel("D30(mm): ");
		D10_1 = new JLabel("D10(mm): ");
		coeficienteUniformidad1 = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura1 = new JLabel ("Grado de Curvatura (Cc): ");
		jButtonAgregarAnalisis = new JButton("AGREGAR ANALISIS");
		jButtonEliminarAnalisis = new JButton("ELIMINAR ANALISIS");
		jButtonModificarAnalisis  = new JButton("MODIFICAR ANALISIS");
		imprimir = new JButton("IMPRIMIR");
		salir = new JButton("CANCELAR");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data1  arreglo que almacena los datos de una muestra1. 
	 */
	public GUIMuestraDetallada (Muestra muestra1, Object [] [] data1) {
		super();
		this.data1 = data1;
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
		agregarMenu = new JMenuItem("Agregar Análisis");
		herramientas.add(agregarMenu);
		modificarMenu = new JMenuItem("Modificar Análisis");
		herramientas.add(modificarMenu);
		eliminarMenu = new JMenuItem("Eliminar Análisis");
		herramientas.add(eliminarMenu);
		herramientas.add(new JSeparator());
		imprimirMenu = new JMenuItem("Imprimir");
		herramientas.add(imprimirMenu);
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		this.muestra1 = new JLabel(muestra1.getNombreMuestra());
		this.peso1 = new JLabel("Peso: "+muestra1.getPeso().toString()+"grs");
		this.profundidadInicial1= new JLabel("Profundidad Inicial: "+muestra1.getProfundidadInicial()+"mts");
		this.profundidadFinal1 = new JLabel("Profundidad Final: "+muestra1.getProfundidadFinal()+"mts");
		ubicacion1 = new JLabel ("Ubicacion: "+muestra1.getUbicacion().getNombreUbicacion());
		clasificacion1 = new JLabel ("Clasificacion: ");
		descripcion1 = new JLabel ("Descripcion: "+muestra1.getClasificacion().getDescripcion());
		limiteLiquido1 = new JLabel ("Límite Líquido (LL): ");    //FALTAN ASIGNARLES VALOREEEEEEEEEEES
		limitePlastico1 = new JLabel ("Límite Plástico (LP): ");	//***************************************
		indicePlasticidad1 = new JLabel ("Íncide de Plasticidad (IP): ");
		D60_1 = new JLabel("D60(mm): ");
		D30_1 = new JLabel("D30(mm): "); // INFORMACION QUE SACA DEL ANALISIS PERTENECIENTE A LA MUESTRA PASADA
		D10_1 = new JLabel("D10(mm): "); // COMO PARAMETRO.. NO SE BIEN COMO LOS SACA A ESTOS DATOS.
		coeficienteUniformidad1 = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura1 = new JLabel ("Grado de Curvatura (Cc): ");
		jButtonAgregarAnalisis = new JButton("AGREGAR ANALISIS");
		jButtonEliminarAnalisis = new JButton("ELIMINAR ANALISIS");
		jButtonModificarAnalisis  = new JButton("MODIFICAR ANALISIS");
		imprimir = new JButton("IMPRIMIR");
		salir = new JButton("CANCELAR");
		initialize();
	}
	
	/**
	 * @return the muestra1
	 */
	public JLabel getMuestra1() {
		return muestra1;
	}
	
	/**
	 * @return the profundidadInicial1
	 */
	public JLabel getProfundidadInicial1() {
		return profundidadInicial1;
	}
	
	/**
	 * @return the profundidadFinal1
	 */
	public JLabel getProfundidadFinal1() {
		return profundidadFinal1;
	}

	/**
	 * @return the peso1
	 */
	public JLabel getPeso1() {
		return peso1;
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
		this.setSize(1300 , 700);
		this.getContentPane().setLayout(new BorderLayout()); 		
		this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		this.setJMenuBar(this.getMenu());
	  	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	  	this.getContentPane().add(this.getPanelCenter(),BorderLayout.CENTER);
	 	this.setLocationRelativeTo(null);
	}
   
	
	/**
	 * Metodo que retorna el panelNorte.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelNorte() { //PA JUGAAAAAAAAA!!!
		if (this.panelNorte==null) {
			this.panelNorte= new JPanel();
			GridBagLayout gridbag = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.50;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.fill=GridBagConstraints.HORIZONTAL;
			this.panelNorte.setLayout(gridbag);
			gbc.ipady = 15;
			this.panelNorte.add(new JLabel("DATOS DE LA MUESTRA 1: "),gbc);
			gbc.ipady = 0;
			gbc.gridy = 1;
			this.panelNorte.add(ubicacion1,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(peso1,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(profundidadInicial1,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(profundidadFinal1,gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panelNorte.add(new JLabel("PLASTICIDAD: "),gbc);
			gbc.gridy = 1;
			this.panelNorte.add(limiteLiquido1,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(limitePlastico1,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(indicePlasticidad1,gbc);
			gbc.gridx = 2;
			gbc.gridy = 1;
			this.panelNorte.add(D60_1,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(D30_1,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(D10_1,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(new JLabel("----------------------------------"),gbc);
			gbc.gridy = 5;
			this.panelNorte.add(coeficienteUniformidad1,gbc);
			gbc.gridy = 6;
			gbc.ipady = 10;
			this.panelNorte.add(gradoCurvatura1,gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 0;
			gbc.ipady = 15;
		
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
			this.panelCenter.setLayout(new BoxLayout(this.panelCenter,BoxLayout.X_AXIS));
			JPanel muestra1 = new JPanel();
			muestra1.setLayout(new BoxLayout(muestra1,BoxLayout.Y_AXIS));
			muestra1.add(this.getTablePanel1());
			muestra1.add(new JLabel("DATOS DE LA CLASIFICACION MUESTRA 1: "));
			muestra1.add(clasificacion1);
			muestra1.add(descripcion1);
								
			this.panelCenter.add(muestra1);
		
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
			this.panelSur.add(getjButtonAgregarAnalisis());
			this.panelSur.add(getjButtonModificarAnalisis());
			this.panelSur.add(getjButtonEliminarAnalisis());
			this.panelSur.add(imprimir);
			this.panelSur.add(salir);
			
			}
			return this.panelSur;
	}
	
	/**
	 * Metodo que permite escuchar los botoner imprimir y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.imprimir.addActionListener(lis);
		this.salir.addActionListener(lis);
		this.jButtonAgregarAnalisis.addActionListener(lis);
		this.jButtonModificarAnalisis.addActionListener(lis);
		this.jButtonEliminarAnalisis.addActionListener(lis);
	}
	
	/**
	 * Metodo que retorna la tabla panel de la muestra 1.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel1() {
		if (this.tablePanel1==null) {
			this.tablePanel1 = new TablePanel();
	 		this.tablePanel1.setData(data1, getColumName());			
		}
		return this.tablePanel1;
	}

	/** 
     *@return columName  
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
	 * @param clasificacion1 the clasificacion1 to set
	 */
	public void setClasificacion1(String clasificacion) {
		this.clasificacion1.setText(clasificacion);
	}

	/**
	 * @param descripcion1 the descripcion1 to set
	 */
	public void setDescripcion1(String descripcion) {
		this.descripcion1.setText(descripcion);
	}

	/**
	 * @param limiteLiquido1 the limiteLiquido1 to set
	 */
	public void setLimiteLiquido1(String limiteLiquido) {
		this.limiteLiquido1.setText(limiteLiquido);
	}

	/**
	 * @param limitePlastico1 the limitePlastico1 to set
	 */
	public void setLimitePlastico1(String limitePlastico) {
		this.limitePlastico1.setText(limitePlastico);
	}

	/**
	 * @param indicePlasticidad1 the indicePlasticidad1 to set
	 */
	public void setIndicePlasticidad1(String indicePlasticidad) {
		this.indicePlasticidad1.setText(indicePlasticidad);
	}

	/**
	 * @param d60 the d60 to set
	 */
	public void setD60_1(String d60) {
		D60_1.setText(d60);
	}

	/**
	 * @param d30 the d30 to set
	 */
	public void setD30_1(String d30) {
		D30_1.setText(d30);
	}

	/**
	 * @param d10 the d10 to set
	 */
	public void setD10_1(String d10) {
		D10_1.setText(d10);
	}

	/**
	 * @param coeficienteUniformidad1 the coeficienteUniformidad1 to set
	 */
	public void setCoeficienteUniformidad1(String coeficienteUniformidad) {
		this.coeficienteUniformidad1.setText(coeficienteUniformidad);
	}

	/**
	 * @param gradoCurvatura1 the gradoCurvatura1 to set
	 */
	public void setGradoCurvatura1(String gradoCurvatura) {
		this.gradoCurvatura1.setText(gradoCurvatura);
	}

	/**
	 * @return the jButtonAgregarAnalisis
	 */
	public JButton getjButtonAgregarAnalisis() {
		return jButtonAgregarAnalisis;
	}

	/**
	 * @param jButtonAgregarAnalisis the jButtonAgregarAnalisis to set
	 */
	public void setjButtonAgregarAnalisis(JButton jButtonAgregarAnalisis) {
		this.jButtonAgregarAnalisis = jButtonAgregarAnalisis;
	}

	/**
	 * @return the jButtonEliminarAnalisis
	 */
	public JButton getjButtonEliminarAnalisis() {
		return jButtonEliminarAnalisis;
	}

	/**
	 * @param jButtonEliminarAnalisis the jButtonEliminarAnalisis to set
	 */
	public void setjButtonEliminarAnalisis(JButton jButtonEliminarAnalisis) {
		this.jButtonEliminarAnalisis = jButtonEliminarAnalisis;
	}

	/**
	 * @return the jButtonModificarAnalisis
	 */
	public JButton getjButtonModificarAnalisis() {
		return jButtonModificarAnalisis;
	}

	/**
	 * @param jButtonModificarAnalisis the jButtonModificarAnalisis to set
	 */
	public void setjButtonModificarAnalisis(JButton jButtonModificarAnalisis) {
		this.jButtonModificarAnalisis = jButtonModificarAnalisis;
	}

	/**
	 * @return the imprimir
	 */
	public JButton getImprimir() {
		return imprimir;
	}

	/**
	 * @param imprimir the imprimir to set
	 */
	public void setImprimir(JButton imprimir) {
		this.imprimir = imprimir;
	}

	/**
	 * @return the salir
	 */
	public JButton getSalir() {
		return salir;
	}

	/**
	 * @param salir the salir to set
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	/**
	 * @return the imprimirMenu
	 */
	public JMenuItem getImprimirMenu() {
		return imprimirMenu;
	}

	/**
	 * @return the agregarMenu
	 */
	public JMenuItem getAgregarMenu() {
		return agregarMenu;
	}

	/**
	 * @param agregarMenu the agregarMenu to set
	 */
	public void setAgregarMenu(JMenuItem agregarMenu) {
		this.agregarMenu = agregarMenu;
	}

	/**
	 * @return the modificarMenu
	 */
	public JMenuItem getModificarMenu() {
		return modificarMenu;
	}

	/**
	 * @param modificarMenu the modificarMenu to set
	 */
	public void setModificarMenu(JMenuItem modificarMenu) {
		this.modificarMenu = modificarMenu;
	}

	/**
	 * @return the eliminarMenu
	 */
	public JMenuItem getEliminarMenu() {
		return eliminarMenu;
	}

	/**
	 * @param eliminarMenu the eliminarMenu to set
	 */
	public void setEliminarMenu(JMenuItem eliminarMenu) {
		this.eliminarMenu = eliminarMenu;
	}
	
}
