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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import persistencia.domain.Muestra;

import comun.TablePanel;

/**
 * Clase que define la interfaz grafica para mostrar
 * una muestra con sus datos y poder gestionar los analisis
 * de la misma.
 * 
 * @author tesisGeologia.
 * 
 */

@SuppressWarnings("serial")
public class GUIMuestraDetallada extends JDialog{

	private JMenuBar menu ;
	private JMenu herramientas;
	private JMenu version;
	private JMenuItem agregarMenu;
	private JMenuItem modificarMenu;
	private JMenuItem eliminarMenu;
	private JMenuItem salirMenu;
	private JMenuItem versionMenu;
		
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
	private JButton jButtonCalcularClasificacion;
	private JButton salir;
	private JLabel descripcion2;
	private JLabel clasificacion2;
	
	/**
	 * Constructor por defecto.
	 */
	public GUIMuestraDetallada() {
		super();
		
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
		initialize();
	}
	
	/**
	 * Constructor parametrizado de la clase GUIMuestraDetallada.
	 * @param data1 arreglo que almacena los datos de una muestra1.
	 * @param muestra1 Muestra que se utiliza para completar la ventana. 
	 */
	public GUIMuestraDetallada (Muestra muestra1, Object [] [] data1) {
		super();
		this.data1 = data1;
		this.muestra1 = new JLabel("DATOS DE LA MUESTRA: "+muestra1.getNombreMuestra());
		this.peso1 = new JLabel("Peso: "+muestra1.getPeso().toString()+"(grs)");
		this.profundidadInicial1= new JLabel("Profundidad Inicial: "+muestra1.getProfundidadInicial()+"mts");
		this.profundidadFinal1 = new JLabel("Profundidad Final: "+muestra1.getProfundidadFinal()+"mts");
		ubicacion1 = new JLabel ("Ubicación: "+muestra1.getUbicacion().getNombreUbicacion());
		
		if (muestra1.getSucs()==null){
			clasificacion1 = new JLabel ("Clasificación: ");
			descripcion1 = new JLabel ("Descripción: ");			
		}
		else{
			clasificacion1 = new JLabel ("Clasificación: "+muestra1.getSucs().getClasificacion());
			descripcion1 = new JLabel ("Descripción: "+muestra1.getSucs().getDescripcion());
		}
		if (muestra1.getAashto()==null){
			clasificacion2 = new JLabel ("Clasificación: ");
			descripcion2 = new JLabel ("Descripción: ");
		}
		else{
			clasificacion2 = new JLabel ("Clasificación: "+muestra1.getAashto().getClasificacion());
			descripcion2 = new JLabel ("Descripción: "+muestra1.getAashto().getDescripcion());
		}
		limiteLiquido1 = new JLabel ("Límite Líquido (LL): "+muestra1.getLimiteLiquido()); 
		limitePlastico1 = new JLabel ("Límite Plástico (LP): "+muestra1.getLimitePlastico());
		indicePlasticidad1 = new JLabel ("Íncide de Plasticidad (IP): "+muestra1.getIndicePlasticidad());
		D60_1 = new JLabel("D60(mm): "+muestra1.getD60());
		D30_1 = new JLabel("D30(mm): "+muestra1.getD30()); 
		D10_1 = new JLabel("D10(mm): "+muestra1.getD10()); 
		coeficienteUniformidad1 = new JLabel("Coef. Uniformidad (Cu): "+muestra1.getCoeficienteUniformidad());
		gradoCurvatura1 = new JLabel ("Grado de Curvatura (Cc): "+muestra1.getGradoCurvatura());
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
	 * @return the jButtonCalcularClasificacion
	 */
	public JButton getjButtonCalcularClasificacion() {
		return jButtonCalcularClasificacion;
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
	 * Método que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		jButtonAgregarAnalisis = new JButton("Agregar");
		jButtonAgregarAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
		jButtonEliminarAnalisis = new JButton("Eliminar");
		jButtonEliminarAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list-remove-5.png"))); // NOI18N
		jButtonModificarAnalisis  = new JButton("Modificar");
		jButtonModificarAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
		jButtonCalcularClasificacion  = new JButton("Calcular Clasificación");
		jButtonCalcularClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accessories-calculator-3.png"))); // NOI18N
		salir = new JButton("Salir");
		salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
		menu = new JMenuBar();
		herramientas = new JMenu ("Archivo");
		herramientas = new JMenu("Herramientas");
		version = new JMenu("Acerca de SCS");
		menu.add(herramientas);
		menu.add(herramientas);
		menu.add(version);
		salirMenu = new JMenuItem("Salir");
		salirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
		
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		versionMenu = new JMenuItem("Versión");
		versionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
		version.add(versionMenu);	
		
		agregarMenu = new JMenuItem("Agregar Análisis");
		agregarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
		herramientas.add(agregarMenu);
		modificarMenu = new JMenuItem("Modificar Análisis");
		modificarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
		herramientas.add(modificarMenu);
		eliminarMenu = new JMenuItem("Eliminar Análisis");
		eliminarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list-remove-5.png"))); // NOI18N
		herramientas.add(eliminarMenu);
		herramientas.add(new JSeparator());
		
		
		
		herramientas.add(new JSeparator());
		herramientas.add(salirMenu);
		this.setSize(1300 , 700);
		this.getContentPane().setLayout(new BorderLayout()); 		
		this.getContentPane().add(this.getPanelNorte(),BorderLayout.NORTH);
		this.setJMenuBar(this.getMenu());
	  	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	  	this.getContentPane().add(this.getPanelCenter(),BorderLayout.CENTER);
	 	this.setLocationRelativeTo(null);
	}
   
	
	/**
	 * Método que retorna el panelNorte.
	 *
	 * @return Jpanel
	 */
		
	public JPanel getPanelNorte() { 
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
			this.panelNorte.add(muestra1,gbc);
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
	 * Método que retorna el panelCenter.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelCenter() {
		JPanel analisis = new JPanel();
		analisis.setLayout(new BoxLayout(analisis,BoxLayout.Y_AXIS));
		analisis.add(this.getTablePanel1());
		if (this.panelCenter==null) {
			this.panelCenter = new JPanel();
			GridBagLayout gridbag = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 0.50;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.fill=GridBagConstraints.HORIZONTAL;
			this.panelCenter.setLayout(gridbag);
			gbc.ipady = 15;
			this.panelCenter.add(new JLabel("Clasificación SUCS"),gbc);
			gbc.ipady = 0;
			gbc.gridy = 1;
			this.panelCenter.add(clasificacion1,gbc);
			gbc.gridy = 2;
			this.panelCenter.add(descripcion1,gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panelCenter.add(new JLabel("Clasificación AASHTO"),gbc);
			gbc.gridy = 1;
			this.panelCenter.add(clasificacion2,gbc);
			gbc.gridy = 2;
			this.panelCenter.add(descripcion2,gbc);
		}
		analisis.add(panelCenter);
			return analisis;
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
			this.panelSur.add(getjButtonAgregarAnalisis());
			this.panelSur.add(getjButtonModificarAnalisis());
			this.panelSur.add(getjButtonEliminarAnalisis());
			this.panelSur.add(getjButtonCalcularClasificacion());
			this.panelSur.add(salir);
			
			}
			return this.panelSur;
	}
	
	/**
	 * Método que permite escuchar los botones de la ventana.
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		salir.addActionListener(lis);
		jButtonAgregarAnalisis.addActionListener(lis);
		jButtonModificarAnalisis.addActionListener(lis);
		jButtonEliminarAnalisis.addActionListener(lis);
		jButtonCalcularClasificacion.addActionListener(lis);
		salirMenu.addActionListener(lis);
		agregarMenu.addActionListener(lis);
		modificarMenu.addActionListener(lis);
		eliminarMenu.addActionListener(lis);
		versionMenu.addActionListener(lis);
	}
	
	/**
	 * Método que retorna la tabla panel de la muestra 1.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel1() {
		if (this.tablePanel1==null) {
			this.tablePanel1 = new TablePanel();
	 		this.tablePanel1.setData(data1, getColumName());
	 		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	 	    tcr.setHorizontalAlignment(SwingConstants.CENTER);
	 	    for (int i = 0; i < 5; i++) {
	 	    	tablePanel1.getTable().getColumnModel().getColumn(i).setCellRenderer(tcr);
	 	    	
			}
		}
		return this.tablePanel1;
	}

	/** 
     *@return columName  
     * */
	public static String[] getColumName(){
		String[] columnName = {"Nro Tamiz","Peso Retenido (grs.)","% Pasante","% Retenido Acumulado","% Retenido Parcial"};
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

	/**
	 * @return the salirMenu
	 */
	public JMenuItem getSalirMenu() {
		return salirMenu;
	}

	/**
	 * @param salirMenu the salirMenu to set
	 */
	public void setSalirMenu(JMenuItem salirMenu) {
		this.salirMenu = salirMenu;
	}

	/**
	 * @return the versionMenu
	 */
	public JMenuItem getVersionMenu() {
		return versionMenu;
	}

	/**
	 * @param versionMenu the versionMenu to set
	 */
	public void setVersionMenu(JMenuItem versionMenu) {
		this.versionMenu = versionMenu;
	}

}
