package cuGestionarOperador;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import persistencia.domain.Persona;

/**
 * Clase GUI que reprensenta la ventana para una muestra.
 * @author TesisGeologia.
 * @verion 1.0.
 */
@SuppressWarnings("serial")
public class GUIOperador extends javax.swing.JDialog {
		   
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JMenu jMenuVersion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHerramientas;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemVersion;
   
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
   

    
    /**
     * Constructor por defecto.
     */
    public GUIOperador() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    /**
     * Constructor con pasaje de parametros.
     * @param operador
     */
    public GUIOperador(Persona operador){
    	initComponents();
    	jTextFieldApellido.setText(operador.getApellido());
    	jTextFieldDni.setText(operador.getDni());
    	jTextFieldEmail.setText(operador.getEmail());
    	jTextFieldNombre.setText(operador.getNombre());
      	jTextFieldTelefono.setText(operador.getTel());
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); 
     	jButtonAgregar.setText("Modificar");
       	setResizable(false);
        setLocationRelativeTo(null);
    }
    
    
    /**
     * Metodo que inicializa los objetos de la ventana.
     */
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDni = new JTextField(15);
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
        
        
        jButtonAgregar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHerramientas = new javax.swing.JMenu();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenuVersion = new javax.swing.JMenu();
        jMenuItemVersion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabelNombre.setText("(*) Nombre: ");

        jLabelApellido.setText("(*) Apellido: ");

        jLabelDni.setText("(*) DNI: ");

        jLabelTelefono.setText("Teléfono: ");

        jLabelEmail.setText("E-mail: ");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jButtonAgregar.setText("Agregar");

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");

        jMenuHerramientas.setText("Herramientas");

        jMenuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItemAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jMenuItemAgregar.setText("Agregar");
        jMenuHerramientas.add(jMenuItemAgregar);

        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jMenuItemCancelar.setText("Cancelar");
        jMenuHerramientas.add(jMenuItemCancelar);
        jMenuHerramientas.add(jSeparator2);

        jMenuBar1.add(jMenuHerramientas);

        jMenuVersion.setText("Acerca de SCS");

        jMenuItemVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        jMenuItemVersion.setText("Versión");
        jMenuVersion.add(jMenuItemVersion);

        jMenuBar1.add(jMenuVersion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelApellido)
                            .addComponent(jLabelDni))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jTextFieldApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jTextFieldDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAgregar)
                        .addGap(69, 69, 69)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(29, Short.MAX_VALUE))
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
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonCancelar))
                .addGap(19, 19, 19))
        );

        pack();
    }//         

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
    }                                               

	/**
	 * Método que permite escuchar los botones de la ventana.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jButtonAgregar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
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
	 * @param jLabelApellido the jLabelApellido to set
	 */
	public void setjLabelApellido(String jLabelApellido) {
		this.jLabelApellido.setText(jLabelApellido);
	}

	/**
	 * @param jLabelDni the jLabelDni to set
	 */
	public void setjLabelDni(String jLabelDni) {
		this.jLabelDni.setText(jLabelDni);
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
	
	
	public void setKeyListener(KeyListener lis){
		jTextFieldDni.addKeyListener(lis);
		jTextFieldApellido.addKeyListener(lis);
	    jTextFieldEmail.addKeyListener(lis);
	    jTextFieldNombre.addKeyListener(lis);
	    jTextFieldTelefono.addKeyListener(lis);
	}
	



		 	
}