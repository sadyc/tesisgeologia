package cuGestionarUsuario;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import persistencia.domain.Usuario;


/**
 * Clase GUI que reprensenta la ventana para un usuario.
 * @author TesisGeologia.
 * @version 1.0.
 *
 */
public class GUIUsuario extends javax.swing.JDialog {
		   
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRePassword;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHerramientas;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemVersion;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldTelefono;
   

    
    /**
     * Constructor por defecto.
     */
    public GUIUsuario() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    /**
     * Constructor con pasaje de parametros.
     * @param usuario
     */
    public GUIUsuario(Usuario usuario){
    	initComponents();
    	jTextFieldApellido.setText(usuario.getApellido());
    	jTextFieldDni.setText(usuario.getDni());
    	jTextFieldEmail.setText(usuario.getEmail());
    	jTextFieldNombre.setText(usuario.getNombre());
    	jTextFieldNombreUsuario.setText(usuario.getNombreUsuario());
    	jTextFieldTelefono.setText(usuario.getTel());
    	jComboBoxCategoria.setSelectedItem(usuario.getCategoria());
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
    	jButtonAgregar.setText("Modificar");
    	setResizable(false);
        setLocationRelativeTo(null);
    }
    
    /**
     * Inicializa los componentes de la ventana.
     */
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelRePassword = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldDni.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.'))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefono = new JTextField(15);
        jTextFieldTelefono.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-'))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jLabelCategoria = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHerramientas = new javax.swing.JMenu();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemVersion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabelNombre.setText("(*) Nombre: ");

        jLabelApellido.setText("(*) Apellido: ");

        jLabelDni.setText("(*) DNI: ");

        jLabelTelefono.setText("Tel�fono: ");

        jLabelEmail.setText("E-mail: ");

        jLabelNombreUsuario.setText("(*) Nombre Usuario: ");

        jLabelPassword.setText("(*) Password: ");

        jLabelRePassword.setText("(*) Reingrese Password: ");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jButtonAgregar.setText("Agregar");
        
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Operador", "Restringido" }));

        jLabelCategoria.setText("(*) Categor�a: ");

        jMenuHerramientas.setText("Herramientas");
        
        jMenuItemAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jMenuItemAgregar.setText("Agregar");
        jMenuHerramientas.add(jMenuItemAgregar);

        jMenuHerramientas.add(jSeparator2);

        jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCancelar.setText("Cancelar");
        jMenuHerramientas.add(jMenuItemCancelar);

        jMenuBar1.add(jMenuHerramientas);

        jMenuAyuda.setText("Ayuda");

        jMenuItemVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        
        jMenuItemVersion.setText("Versi�n");
        jMenuAyuda.add(jMenuItemVersion);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelApellido)
                    .addComponent(jLabelDni))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                .addGap(91, 91, 91))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelTelefono)
                                .addComponent(jLabelEmail)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButtonAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreUsuario)
                                    .addComponent(jLabelPassword)
                                    .addComponent(jLabelRePassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField2)
                                    .addComponent(jPasswordField)
                                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabelCategoria)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellido))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDni))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreUsuario))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }                        

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

	/**
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jButtonAgregar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
		jComboBoxCategoria.addActionListener(lis);
		jMenuItemAgregar.addActionListener(lis);
		jMenuItemVersion.addActionListener(lis);
		jMenuItemCancelar.addActionListener(lis);
		
	}

	/**
	 * @return the jTextFieldApellido
	 */
	public javax.swing.JTextField getjTextFieldApellido() {
		return jTextFieldApellido;
	}

	/**
	 * @param jTextFieldApellido the jTextFieldApellido to set
	 */
	public void setjTextFieldApellido(javax.swing.JTextField jTextFieldApellido) {
		this.jTextFieldApellido = jTextFieldApellido;
	}

	/**
	 * @return the jTextFieldDni
	 */
	public javax.swing.JTextField getjTextFieldDni() {
		return jTextFieldDni;
	}

	/**
	 * @param jTextFieldDni the jTextFieldDni to set
	 */
	public void setjTextFieldDni(javax.swing.JTextField jTextFieldDni) {
		this.jTextFieldDni = jTextFieldDni;
	}

	/**
	 * @return the jTextFieldEmail
	 */
	public javax.swing.JTextField getjTextFieldEmail() {
		return jTextFieldEmail;
	}

	/**
	 * @param jTextFieldEmail the jTextFieldEmail to set
	 */
	public void setjTextFieldEmail(javax.swing.JTextField jTextFieldEmail) {
		this.jTextFieldEmail = jTextFieldEmail;
	}

	/**
	 * @return the jTextFieldNombre
	 */
	public javax.swing.JTextField getjTextFieldNombre() {
		return jTextFieldNombre;
	}

	/**
	 * @param jTextFieldNombre the jTextFieldNombre to set
	 */
	public void setjTextFieldNombre(javax.swing.JTextField jTextFieldNombre) {
		this.jTextFieldNombre = jTextFieldNombre;
	}

	/**
	 * @return the jTextFieldNombreUsuario
	 */
	public javax.swing.JTextField getjTextFieldNombreUsuario() {
		return jTextFieldNombreUsuario;
	}

	/**
	 * @param jTextFieldNombreUsuario the jTextFieldNombreUsuario to set
	 */
	public void setjTextFieldNombreUsuario(
			javax.swing.JTextField jTextFieldNombreUsuario) {
		this.jTextFieldNombreUsuario = jTextFieldNombreUsuario;
	}

	/**
	 * @return the jTextFieldTelefono
	 */
	public javax.swing.JTextField getjTextFieldTelefono() {
		return jTextFieldTelefono;
	}

	/**
	 * @param jTextFieldTelefono the jTextFieldTelefono to set
	 */
	public void setjTextFieldTelefono(javax.swing.JTextField jTextFieldTelefono) {
		this.jTextFieldTelefono = jTextFieldTelefono;
	}

	/**
	 * @return the jButtonAgregar
	 */
	public javax.swing.JButton getjButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * @return the jButtonCancelar
	 */
	public javax.swing.JButton getjButtonCancelar() {
		return jButtonCancelar;
	}

	/**
	 * @return the jComboBoxCategoria
	 */
	public javax.swing.JComboBox getjComboBoxCategoria() {
		return jComboBoxCategoria;
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
	 * @return the jMenuItemVersion
	 */
	public javax.swing.JMenuItem getjMenuItemVersion() {
		return jMenuItemVersion;
	}

	/**
	 * @return the jPasswordField
	 */
	public javax.swing.JPasswordField getjPasswordField() {
		return jPasswordField;
	}

	/**
	 * @return the jPasswordField2
	 */
	public javax.swing.JPasswordField getjPasswordField2() {
		return jPasswordField2;
	}

	/**
	 * @return the jLabelNombreUsuario
	 */
	public javax.swing.JLabel getjLabelNombreUsuario() {
		return jLabelNombreUsuario;
	}

	/**
	 * @return the jLabelPassword
	 */
	public javax.swing.JLabel getjLabelPassword() {
		return jLabelPassword;
	}

	/**
	 * @return the jLabelRePassword
	 */
	public javax.swing.JLabel getjLabelRePassword() {
		return jLabelRePassword;
	}

	
	
}