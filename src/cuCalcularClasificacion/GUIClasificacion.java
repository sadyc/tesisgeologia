/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;

import org.jfree.chart.ChartPanel;

import persistencia.domain.Clasificacion;
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
	private JPanel panelEste=null;
	private JPanel panelOeste=null;
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
	private ChartPanel curva;
	private ChartPanel carta;
		
	private TablePanel tablePanel;
	private Object [][] data = null;

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
	 * @throws Exception 
	 */
	public GUIClasificacion(Muestra muestra, Object [] [] data) throws Exception {
		super();
		ControlClasificacion control = new ControlClasificacion();
		curva = control.emitirGrafico(muestra);
		carta = control.cartaPlasticidad(muestra);
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
		peso = new JLabel("Peso: "+muestra.getPeso().toString()+"grs");
		profundidadInicial= new JLabel("Profundidad Inicial: "+muestra.getProfundidadInicial()+"mts");
		profundidadFinal = new JLabel("Profundidad Final: "+muestra.getProfundidadFinal()+"mts");
		ubicacion = new JLabel ("Ubicacion: "+muestra.getUbicacion().getNombreUbicacion());
		
		if (muestra.getSucs()==null){
			descripcion = new JLabel ("Descripcion: ");
			clasificacion = new JLabel ("Clasificacion: ");
		}
		else{
			clasificacion = new JLabel ("Clasificacion: "+muestra.getSucs().getNombre());
			descripcion = new JLabel ("Descripcion: "+muestra.getSucs().getDescripcion());
		}
		limiteLiquido = new JLabel ("Límite Líquido (LL): "+muestra.getLimiteLiquido());    
		limitePlastico = new JLabel ("Límite Plástico (LP): "+ muestra.getLimitePlastico());	
		indicePlasticidad = new JLabel ("Íncide de Plasticidad (IP): "+muestra.getIndicePlasticidad());
		D60 = new JLabel("D60: "+muestra.getD60()+" mm");
		D30 = new JLabel("D30: "+muestra.getD30()+" mm"); 
		D10 = new JLabel("D10: "+muestra.getD10()+" mm"); 
		coeficienteUniformidad = new JLabel("Coef. Uniformidad (Cu): "+muestra.getCoeficienteUniformidad());
		gradoCurvatura = new JLabel ("Grado de Curvatura (Cc): "+muestra.getGradoCurvatura());
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
	  	//this.getContentPane().add(this.getPanelEste(),BorderLayout.WEST);
	  	//this.getContentPane().add(this.getPanelOeste(),BorderLayout.EAST);
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
			this.panelCenter.add(getPanelEste());
			
			this.panelCenter.add(new JLabel("DATOS DE LA CLASIFICACION S.U.C.S: "));
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
	 * Metodo que retorna el panelSur.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelEste() {
		if (this.panelEste==null) {
			this.panelEste= new JPanel();
			this.panelEste.setLayout(new BoxLayout(this.panelEste,BoxLayout.X_AXIS));
			this.panelEste.add(curva);
			this.panelEste.add(carta);
			}
			return this.panelEste;
	}
	
	/**
	 * Metodo que retorna el panelSur.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelOeste() {
		if (this.panelOeste==null) {
			this.panelOeste= new JPanel();
			this.panelOeste.setLayout(new BoxLayout(this.panelOeste,BoxLayout.X_AXIS));
			this.panelOeste.add(carta);
			}
			return this.panelOeste;
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

	/**
	 * @return the ubicacion
	 */
	public JLabel getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(JLabel ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(JLabel peso) {
		this.peso = peso;
	}

	/**
	 * @return the limiteLiquido
	 */
	public JLabel getLimiteLiquido() {
		return limiteLiquido;
	}

	/**
	 * @param limiteLiquido the limiteLiquido to set
	 */
	public void setLimiteLiquido(JLabel limiteLiquido) {
		this.limiteLiquido = limiteLiquido;
	}

	/**
	 * @return the limitePlastico
	 */
	public JLabel getLimitePlastico() {
		return limitePlastico;
	}

	/**
	 * @param limitePlastico the limitePlastico to set
	 */
	public void setLimitePlastico(JLabel limitePlastico) {
		this.limitePlastico = limitePlastico;
	}

	/**
	 * @return the d60
	 */
	public JLabel getD60() {
		return D60;
	}

	/**
	 * @param d60 the d60 to set
	 */
	public void setD60(JLabel d60) {
		D60 = d60;
	}

	/**
	 * @return the d30
	 */
	public JLabel getD30() {
		return D30;
	}

	/**
	 * @param d30 the d30 to set
	 */
	public void setD30(JLabel d30) {
		D30 = d30;
	}

	/**
	 * @return the d10
	 */
	public JLabel getD10() {
		return D10;
	}

	/**
	 * @param d10 the d10 to set
	 */
	public void setD10(JLabel d10) {
		D10 = d10;
	}

	/**
	 * @return the coeficienteUniformidad
	 */
	public JLabel getCoeficienteUniformidad() {
		return coeficienteUniformidad;
	}

	/**
	 * @param coeficienteUniformidad the coeficienteUniformidad to set
	 */
	public void setCoeficienteUniformidad(JLabel coeficienteUniformidad) {
		this.coeficienteUniformidad = coeficienteUniformidad;
	}

	/**
	 * @return the gradoCurvatura
	 */
	public JLabel getGradoCurvatura() {
		return gradoCurvatura;
	}

	/**
	 * @param gradoCurvatura the gradoCurvatura to set
	 */
	public void setGradoCurvatura(JLabel gradoCurvatura) {
		this.gradoCurvatura = gradoCurvatura;
	}

	/**
	 * @param profundidadInicial the profundidadInicial to set
	 */
	public void setProfundidadInicial(JLabel profundidadInicial) {
		this.profundidadInicial = profundidadInicial;
	}

	/**
	 * @param profundidadFinal the profundidadFinal to set
	 */
	public void setProfundidadFinal(JLabel profundidadFinal) {
		this.profundidadFinal = profundidadFinal;
	}
 
	/**
	 * @return the indicePlasticidad
	 */
	public JLabel getIndicePlasticidad() {
		return indicePlasticidad;
	}

	/**
	 * @param indicePlasticidad the indicePlasticidad to set
	 */
	public void setIndicePlasticidad(JLabel indicePlasticidad) {
		this.indicePlasticidad = indicePlasticidad;
	}
	

}
