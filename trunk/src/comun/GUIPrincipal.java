package comun;

import java.awt.*;

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
			JButton boton1 = new JButton("GESTIONAR MUESTRA");
			JButton boton2 = new JButton("REALIZAR ANÁLISIS");
			JButton boton3 = new JButton("CLASIFICACIÓN");
			this.panelCentro.add(boton1);
			this.panelCentro.add(boton2);
			this.panelCentro.add(boton3);
		}
		return this.panelCentro;
	}
	

	public JPanel getPanelSur() {
		if (this.panelSur==null) {
			this.panelSur = new JPanel();
			this.panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton boton1 = new JButton("Cerrar");
			this.panelSur.add(boton1);
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


}

