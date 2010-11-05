package comun;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
* @author TesisGeología
*
*/
public class GUIPrincipal extends JFrame {

	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	private JMenuBar menu = null;
	private JMenu archivo;
	private JMenu editar;
	private JMenu ayuda;
	private JButton jButtongestionarMuestra;
	private JButton jButtonclasificacion;
	private JButton jButtonanalisis;
	private JButton jButtoncerrar;
	
	/**
	 * @return the gestionarMuestra
	 */
	public JButton getJButtonGestionarMuestra() {
		if (jButtongestionarMuestra == null) {
			jButtongestionarMuestra = new JButton();
			jButtongestionarMuestra.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtongestionarMuestra.setText("GESTIONAR MUESTRA");
		}
		return jButtongestionarMuestra;
	}




	/**
	 * @return the clasificacion
	 */
	public JButton getJButtonClasificacion() {
		if (jButtonclasificacion == null) {
			jButtonclasificacion = new JButton();
			jButtonclasificacion.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonclasificacion.setText("CLASIFICACION");
		}
		return jButtonclasificacion;
	}





	/**
	 * @return the analisis
	 */
	public JButton getJButtonAnalisis() {
		if (jButtonanalisis == null) {
			jButtonanalisis  = new JButton();
			jButtonanalisis.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonanalisis .setText("ANALISIS");
		}
		return jButtonanalisis ;
	}


	/**
	 * @return the cerrar
	 */
	public JButton getJButtonCerrar() {
		if (jButtoncerrar == null) {
			jButtoncerrar  = new JButton();
			jButtoncerrar.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtoncerrar .setText("Cerrar");
		}
		return jButtoncerrar ;
	}



	public GUIPrincipal(String title) throws Exception {
		super(title);
		if (this.menu==null) {
			menu = new JMenuBar();
			archivo = new JMenu("Archivo");
			editar = new JMenu("Editar");
			ayuda = new JMenu("Ayuda");
			menu.add(archivo);
			menu.add(editar);
			menu.add(ayuda);
			JMenuItem copiar = new JMenuItem("Copiar");
			JMenuItem cortar = new JMenuItem("Cortar");
			JMenuItem pegar = new JMenuItem("Pegar");
			editar.add(copiar);
			editar.add(cortar);
			editar.add(pegar);
			JMenuItem buscar = new JMenuItem("Buscar");
			JMenuItem agregar = new JMenuItem("Agregar Muestra");
			JMenuItem modificar = new JMenuItem("Modificar Muestra");
			JMenuItem salir = new JMenuItem("Salir");
			archivo.add(agregar);
			archivo.add(modificar);
			archivo.add(buscar);
			archivo.add(new JSeparator()); // Una rayita separadora.
			archivo.add(salir);
			JMenuItem version = new JMenuItem("Version");
			ayuda.add(version);
		}
		initialize();
	}


	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private  void initialize() {
		
		this.setSize(500,500);
		this.getContentPane().setLayout(new BorderLayout());
	 	this.setJMenuBar(this.getMenu());	
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	}

	
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new JPanel();
			this.panelCentro.setLayout(new GridBagLayout());
			this.panelCentro.add(getJButtonGestionarMuestra());
			this.panelCentro.add(getJButtonAnalisis());
			this.panelCentro.add(getJButtonClasificacion());;
		}
		return this.panelCentro;
	}
	

	public JPanel getPanelSur() {
		if (this.panelSur==null) {
			this.panelSur = new JPanel();
			this.panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.panelSur.add(getJButtonCerrar());
		}
		return this.panelSur;
	}



	
	/**
	 * @return the menuBar
	 */
	public JMenuBar getMenu(){
		return menu;
	}


	/**
	 * @param menuBar the menuBar to set
	 */
	public void setMenuBar(JMenuBar menu) {
		this.menu = menu;
	}

	public void setListenerButtons(ActionListener lis){
		this.jButtongestionarMuestra.addActionListener(lis);
		this.jButtonanalisis.addActionListener(lis);
		this.jButtonclasificacion.addActionListener(lis);
        this.jButtoncerrar.addActionListener(lis);
	}

}

