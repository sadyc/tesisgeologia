package cuGestionarAnalisis;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import persistencia.domain.Muestra;

/**
 * @brief Clase que define la interfaz para manipular un Análisis.
 * @author TesisGeologia
 * @version 1.0
 * 
 */

@SuppressWarnings("serial")
public class GUIAltaAnalisis extends javax.swing.JDialog {
	
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButtonSeleccionarTamiz;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMuestra;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelTamiz;
    private javax.swing.JLabel jLabelUbicacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemTamiz;
    private javax.swing.JTextField pesoRetenido;
	private JMenu version;
	private JMenuItem versionMenu;

    /**
     * Constructor por defecto de la clase.
     */
    public GUIAltaAnalisis() {
        super();
        setModal(true);
        setResizable(false);
        initComponents();
    }
    
    /**
     * Constructor parametrizado de la clase.
     * @param muestra, muestra a la que se le cargará un análisis.
     */
    public GUIAltaAnalisis(Muestra muestra) {
		super();
		pesoRetenido = new JTextField(15);
		jLabelMuestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		jLabelUbicacion = new JLabel("Ubicación: "+muestra.getUbicacion().getNombreUbicacion());
		jLabelPeso = new JLabel("Peso: "+muestra.getPeso());
		jLabelTamiz = new javax.swing.JLabel();
		jLabelTamiz.setText("Tamiz: ");
		initComponents();
	}
    
    /**
     * Constructor parametrizado de la clase.
     * @param muestra, muestra a la que se le cargará un análisis.
     * @param peso, peso que se cargará como análisis de la muestra.
     * @param numeroTamiz, tamiz correspondiente al análisis a cargar.
     */
    public GUIAltaAnalisis(Muestra muestra,Float peso, String numeroTamiz) {
		super();
		pesoRetenido = new JTextField(15);
		pesoRetenido.setText(peso.toString());
		jLabelMuestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		jLabelUbicacion = new JLabel("Ubicación: "+muestra.getUbicacion().getNombreUbicacion());
		jLabelPeso = new JLabel("Peso: "+muestra.getPeso());
		jLabelTamiz = new javax.swing.JLabel();
		jLabelTamiz.setText("Tamiz: "+numeroTamiz);
		initComponents();
	}

    /**
     * Inicializa los componentes de la ventana. 
     */
    private void initComponents() {
    	version = new JMenu("Acerca de SCS");
    	versionMenu = new JMenuItem("Versión");
	    versionMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        versionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoSCS.png")));
		version.add(versionMenu);
    	jLabel4 = new javax.swing.JLabel();
        jButtonSeleccionarTamiz = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        pesoRetenido.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.') && (caracter != ','))
              {
                 e.consume();
              }
           }
        });
        jMenuItemTamiz = new javax.swing.JMenuItem();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png")));
	    cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png")));
	    jButtonSeleccionarTamiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kexi.png")));
	    jMenuItemTamiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kexi.png")));
	    jMenuItemAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png")));
	    jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png")));
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setText("Peso retenido por el Tamiz: ");
        jButtonSeleccionarTamiz.setText("Seleccionar Tamiz");
        jButtonSeleccionarTamiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarTamizActionPerformed(evt);
            }
        });        
        aceptar.setText("Agregar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        cancelar.setText("Cancelar");
        jLabel6.setText("Gramos");
        jMenu1.setText("Herramientas");
        jMenuItemTamiz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTamiz.setText("Seleccionar Tamiz");
        jMenu1.add(jMenuItemTamiz);
        jMenuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItemAgregar.setText("Agregar");
        jMenu1.add(jMenuItemAgregar);
        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemCancelar.setText("Salir");
        jMenu1.add(jMenuItemCancelar);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(version);
        setJMenuBar(jMenuBar1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPeso)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamiz, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesoRetenido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jButtonSeleccionarTamiz))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMuestra)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUbicacion)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMuestra)
                .addGap(11, 11, 11)
                .addComponent(jLabelUbicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPeso)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamiz)
                    .addComponent(jButtonSeleccionarTamiz))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesoRetenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );
        this.setLocationRelativeTo(null);

        pack();
    }

    private void jButtonSeleccionarTamizActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
    }

	public void setListenerButtons(ActionListener lis) {
		aceptar.addActionListener(lis);
	    cancelar.addActionListener(lis);
	    jButtonSeleccionarTamiz.addActionListener(lis);
	    jMenuItemAgregar.addActionListener(lis);
	    jMenuItemCancelar.addActionListener(lis);
	    jMenuItemTamiz.addActionListener(lis);
	    versionMenu.addActionListener(lis);
	}
	/**
	 * @return the aceptar
	 */
	public javax.swing.JButton getJButtonAceptar() {
		return aceptar;
	}

	/**
	 * @return the cancelar
	 */
	public javax.swing.JButton getJButtonCancelar() {
		return cancelar;
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

	/**
	 * @return the jButtonSeleccionarTamiz
	 */
	public javax.swing.JButton getJButtonSeleccionarTamiz() {
		return jButtonSeleccionarTamiz;
	}
	/**
	 * @param jLabelTamiz the jLabelTamiz to set
	 */
	public void setTamiz(String tamiz) {
		jLabelTamiz.setText("Tamiz: "+tamiz);
	}

	public JTextField getPesoRetenido() {
		return pesoRetenido;
	}

	/**
	 * @return the jMenuItemAgregar
	 */
	public javax.swing.JMenuItem getjMenuItemAgregar() {
		return jMenuItemAgregar;
	}

	/**
	 * @return the jMenuItemCancelar
	 */
	public javax.swing.JMenuItem getjMenuItemCancelar() {
		return jMenuItemCancelar;
	}

	/**
	 * @return the jMenuItemTamiz
	 */
	public javax.swing.JMenuItem getjMenuItemTamiz() {
		return jMenuItemTamiz;
	}
	
	public void setKeyListener(KeyListener lis){
		pesoRetenido.addKeyListener(lis);
	}

}

