package cuGestionarUsuario;

import java.awt.event.ActionListener;

/**
 * Clase GUI que reprensenta la ventana para verificar un password.
 * @author TesisGeologia.
 * @version 1.0.
 *
 */
public class GUIVerificarPassword extends javax.swing.JDialog {
	
	  
    /**
     * Constructor por defecto.
     */
    public GUIVerificarPassword() {
    	super();
    	setLocationRelativeTo(null);
        setResizable(false);
    	setModal(true);
        initComponents();
        pack();
    }

    
    /**
     * Constructor con pasaje de parametros.
     * @param parent
     * @param modal
     */
    public GUIVerificarPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    /**
     * Inicializa los componentes de la ventana. 
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Password: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jButton1.setText("Aceptar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButton2.setText("Cancelar");

        jMenu1.setText("Herramientas");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jMenuItem1.setText("Aceptar");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jMenuItem2.setText("Cancelar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        jMenuItem3.setText("Versión");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration
    
    
    /**
	 * Metodo que permite escuchar los botones Aceptar, Cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jMenuItem1.addActionListener(lis);
		jMenuItem2.addActionListener(lis);
		jButton1.addActionListener(lis);
		jButton2.addActionListener(lis);
		
	}

	/**
	 * @return the jButton1
	 */
	public javax.swing.JButton getjButton1() {
		return jButton1;
	}

	/**
	 * @param jButton1 the jButton1 to set
	 */
	public void setjButton1(javax.swing.JButton jButton1) {
		this.jButton1 = jButton1;
	}

	/**
	 * @return the jButton2
	 */
	public javax.swing.JButton getjButton2() {
		return jButton2;
	}

	/**
	 * @param jButton2 the jButton2 to set
	 */
	public void setjButton2(javax.swing.JButton jButton2) {
		this.jButton2 = jButton2;
	}

	/**
	 * @return the jLabel1
	 */
	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	/**
	 * @param jLabel1 the jLabel1 to set
	 */
	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	/**
	 * @return the jMenu1
	 */
	public javax.swing.JMenu getjMenu1() {
		return jMenu1;
	}

	/**
	 * @param jMenu1 the jMenu1 to set
	 */
	public void setjMenu1(javax.swing.JMenu jMenu1) {
		this.jMenu1 = jMenu1;
	}

	/**
	 * @return the jMenu2
	 */
	public javax.swing.JMenu getjMenu2() {
		return jMenu2;
	}

	/**
	 * @param jMenu2 the jMenu2 to set
	 */
	public void setjMenu2(javax.swing.JMenu jMenu2) {
		this.jMenu2 = jMenu2;
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
	 * @return the jMenuItem1
	 */
	public javax.swing.JMenuItem getjMenuItem1() {
		return jMenuItem1;
	}

	/**
	 * @param jMenuItem1 the jMenuItem1 to set
	 */
	public void setjMenuItem1(javax.swing.JMenuItem jMenuItem1) {
		this.jMenuItem1 = jMenuItem1;
	}

	/**
	 * @return the jMenuItem2
	 */
	public javax.swing.JMenuItem getjMenuItem2() {
		return jMenuItem2;
	}

	/**
	 * @param jMenuItem2 the jMenuItem2 to set
	 */
	public void setjMenuItem2(javax.swing.JMenuItem jMenuItem2) {
		this.jMenuItem2 = jMenuItem2;
	}

	/**
	 * @return the jMenuItem3
	 */
	public javax.swing.JMenuItem getjMenuItem3() {
		return jMenuItem3;
	}

	/**
	 * @param jMenuItem3 the jMenuItem3 to set
	 */
	public void setjMenuItem3(javax.swing.JMenuItem jMenuItem3) {
		this.jMenuItem3 = jMenuItem3;
	}

	/**
	 * @return the jPasswordField1
	 */
	public javax.swing.JPasswordField getjPasswordField1() {
		return jPasswordField1;
	}

	/**
	 * @param jPasswordField1 the jPasswordField1 to set
	 */
	public void setjPasswordField1(javax.swing.JPasswordField jPasswordField1) {
		this.jPasswordField1 = jPasswordField1;
	}
}
