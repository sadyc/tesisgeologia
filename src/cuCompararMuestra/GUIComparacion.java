package cuCompararMuestra;

import java.awt.BorderLayout;
import java.awt.Component;
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
public class GUIComparacion extends JDialog{

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
	
	// DATOS MUESTRA 1
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
	
	// DATOS MUESTRA 2
	private JLabel muestra2;
	private JLabel peso2;
	private JLabel profundidadInicial2;
	private JLabel profundidadFinal2;
	private JLabel ubicacion2;
	private JLabel clasificacion2;
	private JLabel descripcion2;
	private JLabel limiteLiquido2;
	private JLabel limitePlastico2;
	private JLabel indicePlasticidad2;
	private JLabel D60_2;
	private JLabel D30_2;
	private JLabel D10_2;
	private JLabel coeficienteUniformidad2;
	private JLabel gradoCurvatura2;
	private TablePanel tablePanel2;
	private Object [][] data2= new Object [3][5];

	/**
	 * This is the default constructor
	 */
	public GUIComparacion() {
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
		
		muestra2 = new JLabel("Muestra: ");
		peso2 = new JLabel("Peso: ");
		profundidadInicial2 = new JLabel("Profundidad Inicial: ");
		profundidadFinal2 = new JLabel("Profundidad Final: ");
		ubicacion2 = new JLabel ("Ubicación: ");
		clasificacion2 = new JLabel ("Clasificación: ");
		descripcion2 = new JLabel ("Descripción: ");
		limiteLiquido2 = new JLabel ("Límite Líquido (LL): ");
		limitePlastico2 = new JLabel ("Límite Plástico (LP): ");
		indicePlasticidad2 = new JLabel ("Íncide de Plasticidad (IP): ");
		D60_2 = new JLabel("D60(mm): ");
		D30_2 = new JLabel("D30(mm): ");
		D10_2 = new JLabel("D10(mm): ");
		coeficienteUniformidad2 = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura2 = new JLabel ("Grado de Curvatura (Cc): ");
		
		imprimir = new JButton("Imprimir");
		salir = new JButton("Salir");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data1  arreglo que almacena los datos de una muestra1. 
	 */
	public GUIComparacion (Muestra muestra1, Object [] [] data1, Muestra muestra2, Object [] [] data2) {
		super();
		this.data1 = data1;
		this.data2 = data2; 
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
		
		this.muestra2 = new JLabel(muestra2.getNombreMuestra());
		this.peso2 = new JLabel("Peso: "+muestra2.getPeso().toString()+"grs");
		this.profundidadInicial2= new JLabel("Profundidad Inicial: "+muestra2.getProfundidadInicial()+"mts");
		this.profundidadFinal2 = new JLabel("Profundidad Final: "+muestra2.getProfundidadFinal()+"mts");
		ubicacion2 = new JLabel ("Ubicacion: "+muestra2.getUbicacion().getNombreUbicacion());
		clasificacion2 = new JLabel ("Clasificacion: ");
		descripcion2 = new JLabel ("Descripcion: "+muestra2.getClasificacion().getDescripcion());
		limiteLiquido2 = new JLabel ("Límite Líquido (LL): ");    //FALTAN ASIGNARLES VALOREEEEEEEEEEES
		limitePlastico2 = new JLabel ("Límite Plástico (LP): ");	//***************************************
		indicePlasticidad2 = new JLabel ("Íncide de Plasticidad (IP): ");
		D60_2 = new JLabel("D60(mm): ");
		D30_2 = new JLabel("D30(mm): "); // INFORMACION QUE SACA DEL ANALISIS PERTENECIENTE A LA MUESTRA PASADA
		D10_2 = new JLabel("D10(mm): "); // COMO PARAMETRO.. NO SE BIEN COMO LOS SACA A ESTOS DATOS.
		coeficienteUniformidad2 = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura2 = new JLabel ("Grado de Curvatura (Cc): ");
		
		imprimir = new JButton("Imprimir");
		salir = new JButton("Cancelar");
		initialize();
	}
	
	/**
	 * @return the muestra1
	 */
	public JLabel getMuestra1() {
		return muestra1;
	}
	
	/**
	 * @return the muestra2
	 */
	public JLabel getMuestra2() {
		return muestra2;
	}
	
	/**
	 * @return the profundidadInicial1
	 */
	public JLabel getProfundidadInicial1() {
		return profundidadInicial1;
	}
	/**
	 * @return the profundidadInicial2
	 */
	public JLabel getProfundidadInicia2() {
		return profundidadInicial2;
	}

	/**
	 * @return the profundidadFinal1
	 */
	public JLabel getProfundidadFinal1() {
		return profundidadFinal1;
	}

	/**
	 * @return the profundidadFinal1
	 */
	public JLabel getProfundidadFina2() {
		return profundidadFinal2;
	}	
	
	/**
	 * @return the peso1
	 */
	public JLabel getPeso1() {
		return peso1;
	}

	/**
	 * @return the peso2
	 */
	public JLabel getPeso2() {
		return peso2;
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
			this.panelNorte.add(new JLabel("DATOS DE LA MUESTRA 2: "),gbc);
			gbc.ipady = 0;
			gbc.gridy = 1;
			this.panelNorte.add(ubicacion2,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(peso2,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(profundidadInicial2,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(profundidadFinal2,gbc);
			gbc.gridx = 4;
			gbc.gridy = 0;
			this.panelNorte.add(new JLabel("PLASTICIDAD: "),gbc);
			gbc.gridy = 1;
			this.panelNorte.add(limiteLiquido2,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(limitePlastico2,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(indicePlasticidad2,gbc);
			gbc.gridx = 5;
			gbc.gridy = 1;
			this.panelNorte.add(D60_2,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(D30_2,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(D10_2,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(new JLabel("----------------------------------"),gbc);
			gbc.gridy = 5;
			this.panelNorte.add(coeficienteUniformidad2,gbc);
			gbc.gridy = 6;
			gbc.ipady = 10;
			this.panelNorte.add(gradoCurvatura2,gbc);
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
			
			JPanel muestra2 = new JPanel();
			muestra2.setLayout(new BoxLayout(muestra2,BoxLayout.Y_AXIS));
			muestra2.add(this.getTablePanel2());
			muestra2.add(new JLabel("DATOS DE LA CLASIFICACION MUESTRA 2: "));
			muestra2.add(clasificacion2);
			muestra2.add(descripcion2);
			
			this.panelCenter.add(muestra1);
			this.panelCenter.add(muestra2);
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
	 * Metodo que permite escuchar los botoner imprimir y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.imprimir.addActionListener(lis);
		this.salir.addActionListener(lis);
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
	 * Metodo que retorna la tabla panel de la muestra 2.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel2() {
		if (this.tablePanel2==null) {
			this.tablePanel2 = new TablePanel();
	 		this.tablePanel2.setData(data2, getColumName());			
		}
		return this.tablePanel2;
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
	 * @param clasificacion2 the clasificacion2 to set
	 */
	public void setClasificacion2(String clasificacion) {
		this.clasificacion2.setText(clasificacion);
	}

	/**
	 * @param descripcion2 the descripcion2 to set
	 */
	public void setDescripcion2(String descripcion) {
		this.descripcion2.setText(descripcion);
	}

	/**
	 * @param limiteLiquido2 the limiteLiquido2 to set
	 */
	public void setLimiteLiquido2(String limiteLiquido) {
		this.limiteLiquido2.setText(limiteLiquido);
	}

	/**
	 * @param limitePlastico2 the limitePlastico2 to set
	 */
	public void setLimitePlastico2(String limitePlastico) {
		this.limitePlastico2.setText(limitePlastico);
	}

	/**
	 * @param indicePlasticidad2 the indicePlasticidad2 to set
	 */
	public void setIndicePlasticidad2(String indicePlasticidad) {
		this.indicePlasticidad2.setText(indicePlasticidad);
	}

	/**
	 * @param d60 the d60 to set
	 */
	public void setD60_2(String d60) {
		D60_2.setText(d60);
	}

	/**
	 * @param d30 the d30 to set
	 */
	public void setD30_2(String d30) {
		D30_2.setText(d30);
	}

	/**
	 * @param d10 the d10 to set
	 */
	public void setD10_2(String d10) {
		D10_2.setText(d10);
	}

	/**
	 * @param coeficienteUniformidad2 the coeficienteUniformidad2 to set
	 */
	public void setCoeficienteUniformidad2(String coeficienteUniformidad) {
		this.coeficienteUniformidad2.setText(coeficienteUniformidad);
	}

	/**
	 * @param gradoCurvatura2 the gradoCurvatura2 to set
	 */
	public void setGradoCurvatura2(String gradoCurvatura) {
		this.gradoCurvatura2.setText(gradoCurvatura);
	}
}
