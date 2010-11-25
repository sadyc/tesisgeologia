/**
 * 
 */
package cuCalcularClasificacion;

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
		gradoCurvatura = new JLabel ("Grado de Curvatura (Cc): ");
		
		imprimir = new JButton("Imprimir");
		salir = new JButton("Salir");
		initialize();
	}
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIClasificacion(Muestra muestra, Object [] [] data) {
		super();
		this.data = data; 
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
		this.muestra = new JLabel(muestra.getNombreMuestra());
		this.peso = new JLabel("Peso: "+muestra.getPeso().toString()+"grs");
		this.profundidadInicial= new JLabel("Profundidad Inicial: "+muestra.getProfundidadInicial()+"mts");
		this.profundidadFinal = new JLabel("Profundidad Final: "+muestra.getProfundidadFinal()+"mts");
		ubicacion = new JLabel ("Ubicacion: "+muestra.getUbicacion().getNombreUbicacion());
		clasificacion = new JLabel ("Clasificacion: ");
		descripcion = new JLabel ("Descripcion: "+muestra.getClasificacion().getDescripcion());
		limiteLiquido = new JLabel ("Límite Líquido (LL): ");    //FALTAN ASIGNARLES VALOREEEEEEEEEEES
		limitePlastico = new JLabel ("Límite Plástico (LP): ");	//***************************************
		indicePlasticidad = new JLabel ("Íncide de Plasticidad (IP): ");
		D60 = new JLabel("D60(mm): ");
		D30 = new JLabel("D30(mm): "); // INFORMACION QUE SACA DEL ANALISIS PERTENECIENTE A LA MUESTRA PASADA
		D10 = new JLabel("D10(mm): "); // COMO PARAMETRO.. NO SE BIEN COMO LOS SACA A ESTOS DATOS.
		coeficienteUniformidad = new JLabel("Coef. Uniformidad (Cu): ");
		gradoCurvatura = new JLabel ("Grado de Curvatura (Cc): ");
		
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
		this.setSize(1000 , 700);
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
			this.panelNorte.add(new JLabel("DATOS DE LA MUESTRA: "),gbc);
			gbc.ipady = 0;
			gbc.gridy = 1;
			this.panelNorte.add(ubicacion,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(peso,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(profundidadInicial,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(profundidadFinal,gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.panelNorte.add(new JLabel("PLASTICIDAD: "),gbc);
			gbc.gridy = 1;
			this.panelNorte.add(limiteLiquido,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(limitePlastico,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(indicePlasticidad,gbc);
			gbc.gridx = 2;
			gbc.gridy = 1;
			this.panelNorte.add(D60,gbc);
			gbc.gridy = 2;
			this.panelNorte.add(D30,gbc);
			gbc.gridy = 3;
			this.panelNorte.add(D10,gbc);
			gbc.gridy = 4;
			this.panelNorte.add(new JLabel("----------------------------------"),gbc);
			gbc.gridy = 5;
			this.panelNorte.add(coeficienteUniformidad,gbc);
			gbc.gridy = 6;
			gbc.ipady = 10;
			this.panelNorte.add(gradoCurvatura,gbc);
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
			this.panelCenter.add(this.getTablePanel());
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
	 * Metodo que permite escuchar los botoner imprimir y cancelar.
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

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion.setText(clasificacion);
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion.setText(descripcion);
	}

	/**
	 * @param limiteLiquido the limiteLiquido to set
	 */
	public void setLimiteLiquido(String limiteLiquido) {
		this.limiteLiquido.setText(limiteLiquido);
	}

	/**
	 * @param limitePlastico the limitePlastico to set
	 */
	public void setLimitePlastico(String limitePlastico) {
		this.limitePlastico.setText(limitePlastico);
	}

	/**
	 * @param indicePlasticidad the indicePlasticidad to set
	 */
	public void setIndicePlasticidad(String indicePlasticidad) {
		this.indicePlasticidad.setText(indicePlasticidad);
	}

	/**
	 * @param d60 the d60 to set
	 */
	public void setD60(String d60) {
		D60.setText(d60);
	}

	/**
	 * @param d30 the d30 to set
	 */
	public void setD30(String d30) {
		D30.setText(d30);
	}

	/**
	 * @param d10 the d10 to set
	 */
	public void setD10(String d10) {
		D10.setText(d10);
	}

	/**
	 * @param coeficienteUniformidad the coeficienteUniformidad to set
	 */
	public void setCoeficienteUniformidad(String coeficienteUniformidad) {
		this.coeficienteUniformidad.setText(coeficienteUniformidad);
	}

	/**
	 * @param gradoCurvatura the gradoCurvatura to set
	 */
	public void setGradoCurvatura(String gradoCurvatura) {
		this.gradoCurvatura.setText(gradoCurvatura);
	}
	
	
}
