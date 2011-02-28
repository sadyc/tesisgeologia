package cuLogin;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


 
/**
 * Clase que implementa la interfaz grafica de la ventana de login.
 *
 * @author TesisGeologia
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GUILogin extends javax.swing.JDialog {

	 // Variables declaration - do not modify
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHerramientas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAceptar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemVersion;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jnombreUsuario;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JLabel password;
    // End of variables declaration

	/** Creates new form GUILogin */
    public GUILogin(boolean modal) {
        super();
        setTitle("Login Usuario");
        initComponents();
    }

   
    /**
     * Método que inicializa los componentes de la ventana.
     */
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        nombreUsuario = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jnombreUsuario = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHerramientas = new javax.swing.JMenu();
        jMenuItemAceptar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemVersion = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nombreUsuario.setText("Nombre Usuario: ");

        password.setText("Password: ");

        jnombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombreUsuarioActionPerformed(evt);
            }
        });

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jMenuHerramientas.setText("Herramientas");

        jMenuItemAceptar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItemAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jMenuItemAceptar.setText("Aceptar");
        jMenuHerramientas.add(jMenuItemAceptar);
        jMenuHerramientas.add(jSeparator1);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuHerramientas.add(jMenuItemSalir);

        jMenuBar1.add(jMenuHerramientas);

        jMenuAyuda.setText("Ayuda");

        jMenuItemVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItemVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        jMenuItemVersion.setText("Versión");
        jMenuAyuda.add(jMenuItemVersion);

        jMenuBar1.add(jMenuAyuda);
        
        jnombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombreUsuarioActionPerformed(evt);
            }
        });
        
        
        jpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombreUsuarioActionPerformed(evt);
            }
        });
        
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonAceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jnombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreUsuario))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>

    private void jnombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUILogin dialog = new GUILogin(true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

   



   
	
	/**
	 * @return the jButtonAceptar
	 */
	public javax.swing.JButton getjButtonAceptar() {
		return jButtonAceptar;
	}

	/**
	 * @param jButtonAceptar the jButtonAceptar to set
	 */
	public void setjButtonAceptar(javax.swing.JButton jButtonAceptar) {
		this.jButtonAceptar = jButtonAceptar;
	}

	/**
	 * @return the jButtonCancelar
	 */
	public javax.swing.JButton getjButtonCancelar() {
		return jButtonCancelar;
	}

	/**
	 * @param jButtonCancelar the jButtonCancelar to set
	 */
	public void setjButtonCancelar(javax.swing.JButton jButtonCancelar) {
		this.jButtonCancelar = jButtonCancelar;
	}

	/**
	 * @return the jMenuAyuda
	 */
	public javax.swing.JMenu getjMenuAyuda() {
		return jMenuAyuda;
	}

	/**
	 * @param jMenuAyuda the jMenuAyuda to set
	 */
	public void setjMenuAyuda(javax.swing.JMenu jMenuAyuda) {
		this.jMenuAyuda = jMenuAyuda;
	}

	/**
	 * @return the jMenuBar1
	 */
	public javax.swing.JMenuBar getjMenuBar1() {
		return jMenuBar1;
	}

	/**
	 * @param jMenuBar1 the jMenuBar1 to set
	 */
	public void setjMenuBar1(javax.swing.JMenuBar jMenuBar1) {
		this.jMenuBar1 = jMenuBar1;
	}

	/**
	 * @return the jMenuHerramientas
	 */
	public javax.swing.JMenu getjMenuHerramientas() {
		return jMenuHerramientas;
	}

	/**
	 * @param jMenuHerramientas the jMenuHerramientas to set
	 */
	public void setjMenuHerramientas(javax.swing.JMenu jMenuHerramientas) {
		this.jMenuHerramientas = jMenuHerramientas;
	}

	/**
	 * @return the jMenuItemAceptar
	 */
	public javax.swing.JMenuItem getjMenuItemAgregar() {
		return jMenuItemAceptar;
	}

	/**
	 * @param jMenuItemAceptar the jMenuItemAceptar to set
	 */
	public void setjMenuItemAgregar(javax.swing.JMenuItem jMenuItemAgregar) {
		this.jMenuItemAceptar = jMenuItemAgregar;
	}

	/**
	 * @return the jMenuItemSalir
	 */
	public javax.swing.JMenuItem getjMenuItemSalir() {
		return jMenuItemSalir;
	}

	/**
	 * @param jMenuItemSalir the jMenuItemSalir to set
	 */
	public void setjMenuItemSalir(javax.swing.JMenuItem jMenuItemSalir) {
		this.jMenuItemSalir = jMenuItemSalir;
	}

	/**
	 * @return the jMenuItemVersion
	 */
	public javax.swing.JMenuItem getjMenuItemVersion() {
		return jMenuItemVersion;
	}

	/**
	 * @param jMenuItemVersion the jMenuItemVersion to set
	 */
	public void setjMenuItemVersion(javax.swing.JMenuItem jMenuItemVersion) {
		this.jMenuItemVersion = jMenuItemVersion;
	}

	/**
	 * @return the jnombreUsuario
	 */
	public javax.swing.JTextField getJnombreUsuario() {
		return jnombreUsuario;
	}

	/**
	 * @param jnombreUsuario the jnombreUsuario to set
	 */
	public void setJnombreUsuario(javax.swing.JTextField jnombreUsuario) {
		this.jnombreUsuario = jnombreUsuario;
	}

	/**
	 * @return the jpassword
	 */
	public javax.swing.JPasswordField getJpassword() {
		return jpassword;
	}

	/**
	 * @param jpassword the jpassword to set
	 */
	public void setJpassword(javax.swing.JPasswordField jpassword) {
		this.jpassword = jpassword;
	}

	/**
	 * @return the nombreUsuario
	 */
	public javax.swing.JLabel getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(javax.swing.JLabel nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public javax.swing.JLabel getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(javax.swing.JLabel password) {
		this.password = password;
	}

	/**
	 * Método que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonAceptar.addActionListener(lis);
		this.jButtonCancelar.addActionListener(lis);
		this.jMenuItemSalir.addActionListener(lis);
		this.jMenuItemAceptar.addActionListener(lis);
	}
	
	/**
	 * @return the jTextFieldNombre
	 */
	public javax.swing.JTextField getjTextFieldNombreUsuario() {
		return jnombreUsuario;
	}

	/**
	 * @return the jTextFieldNombreUbicacion
	 */
	public javax.swing.JTextField getjTextFieldPassword() {
		return jpassword;
	}
	
	/**
	 * Escucha lo ingresado por teclado.
	 * @param lis
	 */
	public void setKeyListener(KeyListener lis){
		jnombreUsuario.addKeyListener(lis);
	    jpassword.addKeyListener(lis);
	  
	}
}
