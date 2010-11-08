package cuGestionarAnalisis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
* @author TesisGeología
*
*/
public class GUIGestionarAnalisis extends JFrame {

	private JPanel panelCentro=null;
	private JPanel panelSur=null;
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	private JMenuBar menu = null;
	private JMenu archivo;
	private JMenu editar;
	private JMenu ayuda;
	private JButton jButtonAgregarAnalisis;
	private JButton jButtonEliminarAnalisis;
	private JButton jButtonModificarAnalisis;
	private JButton jButtoncerrar;
	
	



	public GUIGestionarAnalisis() throws Exception {
		super();
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
			JMenuItem agregar = new JMenuItem("Agregar Analisis");
			JMenuItem modificar = new JMenuItem("Modificar Analisis");
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
		
		this.setSize(500,400);
		this.getContentPane().setLayout(new BorderLayout());
	 	this.setJMenuBar(this.getMenu());	
	 	this.getContentPane().add(this.getPanelCentro(),BorderLayout.CENTER);
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	}

	
	public JPanel getPanelCentro() {
		if (this.panelCentro==null) {
			this.panelCentro= new JPanel();
			this.panelCentro.setLayout(new GridBagLayout());
			this.panelCentro.add(getJButtonAgregarAnalisis());
			this.panelCentro.add(getJButtonModificarAnalisis());
			this.panelCentro.add(getJButtonEliminarAnalisis());;
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

	/**
	 * @return the 
	 */
	public JButton getJButtonAgregarAnalisis() {
		if (jButtonAgregarAnalisis == null) {
			jButtonAgregarAnalisis = new JButton();
			jButtonAgregarAnalisis.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonAgregarAnalisis.setText("AGREGAR ANALISIS");
		}
		return jButtonAgregarAnalisis;
	}




	/**
	 * @return the 
	 */
	public JButton getJButtonEliminarAnalisis() {
		if (jButtonEliminarAnalisis == null) {
			jButtonEliminarAnalisis = new JButton();
			jButtonEliminarAnalisis.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonEliminarAnalisis.setText("ELIMINAR ANALISIS");
		}
		return jButtonEliminarAnalisis;
	}





	/**
	 * @return the 
	 */
	public JButton getJButtonModificarAnalisis() {
		if (jButtonModificarAnalisis == null) {
			jButtonModificarAnalisis  = new JButton();
			jButtonModificarAnalisis.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonModificarAnalisis .setText("MODIFICAR ANALISIS");
		}
		return jButtonModificarAnalisis ;
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
	public void setListenerButtons(ActionListener lis){
		this.jButtonAgregarAnalisis.addActionListener(lis);
		this.jButtonModificarAnalisis.addActionListener(lis);
		this.jButtonEliminarAnalisis.addActionListener(lis);
        this.jButtoncerrar.addActionListener(lis);
	}

}
