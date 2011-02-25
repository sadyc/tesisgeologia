package cuGestionarMuestra;


	import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import persistencia.domain.Muestra;

/**
 * Clase GUI que reprensenta la ventana para una muestra.
 * 
 * @author TesisGeologia.
 * 
 * @version 1.0.
 */
	    
public class GUIMuestra extends javax.swing.JDialog {
	
    private javax.swing.JLabel cliente;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton seleccionarUbicacion;
    private javax.swing.JButton seleccionarOperador;
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem aceptarMenu;
    private javax.swing.JMenuItem cancelarMenu;
    private javax.swing.JMenuItem versionMenu;
    private javax.swing.JMenuItem jMenuItemSeleccionarCliente;
    private javax.swing.JMenuItem jMenuItemSeleccionarOperador;
    private javax.swing.JMenuItem jMenuItemSeleccionarUbicacion;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField profundidadInicial;
    private javax.swing.JTextField profundidadFinal;
    private javax.swing.JTextField peso;
    private javax.swing.JLabel operador;
    private javax.swing.JButton seleccionarCliente;
    private javax.swing.JLabel ubicacion;
    private javax.swing.JLabel usuario;
    
    

    
    /**
     * Constructor de la clase 
     * @param modal
     * @param nombreUsuario
     */
    public GUIMuestra(boolean modal, String nombreUsuario) {
        super();
        nombre = new JTextField(15);
        profundidadInicial = new JTextField(15);
		profundidadFinal = new JTextField(15);
		peso = new JTextField(15);
        setModal(modal);
	    initComponents();
	    usuario.setText("Usuario: "+ nombreUsuario);
	    setLocationRelativeTo(null);
    }
    
    
	/**
	 * Constructor con pasaje de parametros.
	 * @param fila almacena todos los datos de la muesta a modificar.
	 * @param nombreOperador.
	 * @param nombreCliente.
	 * @param nombreUsuario
	 */
	public GUIMuestra(Muestra muestra) {
	
		super();
		initComponents();
		nombre.setText(muestra.getNombreMuestra());
		peso.setText(muestra.getPeso().toString());
		profundidadInicial.setText(muestra.getProfundidadInicial().toString());
		profundidadFinal.setText(muestra.getProfundidadFinal().toString());
		ubicacion.setText("(*) Ubicaci�n: "+ muestra.getUbicacion().getNombreUbicacion());
		operador.setText("(*) Operador: "+ muestra.getOperadorLaboratorio().getNombre()+" "+muestra.getOperadorLaboratorio().getApellido());
		if (muestra.getCliente()!=null){
			cliente.setText(" Cliente: "+ muestra.getCliente().getNombre()+" "+muestra.getCliente().getApellido());
		}
		else{
			cliente.setText(" Cliente: ");
		}
		usuario.setText("Usuario: "+ muestra.getUsuario().getNombreUsuario());
		aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png")));
		aceptar.setText("Modificar");
		setModal(true);
		setLocationRelativeTo(null);
	}

  
    
    /**
     * Metodo que inicializa los componentes de la ventana.
     */
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        profundidadInicial = new javax.swing.JTextField();
        profundidadFinal = new javax.swing.JTextField();
        peso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ubicacion = new javax.swing.JLabel();
        seleccionarUbicacion = new javax.swing.JButton();
        operador = new javax.swing.JLabel();
        seleccionarOperador = new javax.swing.JButton();
        usuario = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        seleccionarCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSeleccionarUbicacion = new javax.swing.JMenuItem();
        jMenuItemSeleccionarOperador = new javax.swing.JMenuItem();
        jMenuItemSeleccionarCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aceptarMenu = new javax.swing.JMenuItem();
        cancelarMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        versionMenu = new javax.swing.JMenuItem();
        peso.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.') && (caracter != ','))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        profundidadInicial.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.') && (caracter != ','))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
        profundidadFinal.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.') && (caracter != ','))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargar Muestra\n");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setModal(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        aceptar.setText("Agregar");
        aceptar.setAutoscrolls(true);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setAutoscrolls(true);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        profundidadInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        profundidadFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        peso.setMinimumSize(new java.awt.Dimension(5, 20));
        peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel1.setText("(*) Nombre: ");

        jLabel2.setText("(*) Peso: ");

        jLabel3.setText("Profundidad Inicial: ");

        jLabel4.setText("Profundidad Final: ");

        ubicacion.setText("(*) Ubicaci�n: ");

        seleccionarUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/internet-web-browser-3.png"))); // NOI18N
        seleccionarUbicacion.setText("Seleccionar Ubicaci�n"); 

        operador.setText("(*) Operador: ");

        seleccionarOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-engineering-3.png"))); // NOI18N
        seleccionarOperador.setText("Seleccionar Operador");

        usuario.setText("Usuario: ");

        cliente.setText("Cliente: ");

        seleccionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-switch-user.png"))); // NOI18N
        seleccionarCliente.setText("Seleccionar Cliente");
        seleccionarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel5.setText("( grs. )");

        jLabel6.setText("( mts. )");

        jLabel7.setText("( mts. )");

        jMenu1.setText("Herramientas");

        jMenuItemSeleccionarUbicacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSeleccionarUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/internet-web-browser-3.png"))); // NOI18N
        jMenuItemSeleccionarUbicacion.setText("Seleccionar Ubicaci�n");
        jMenu1.add(jMenuItemSeleccionarUbicacion);

        jMenuItemSeleccionarOperador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSeleccionarOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/applications-engineering-3.png"))); // NOI18N
        jMenuItemSeleccionarOperador.setText("Seleccionar Operador");
        jMenu1.add(jMenuItemSeleccionarOperador);

        jMenuItemSeleccionarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSeleccionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-switch-user.png"))); // NOI18N
        jMenuItemSeleccionarCliente.setText("Seleccionar Cliente");
        jMenu1.add(jMenuItemSeleccionarCliente);
        jMenu1.add(jSeparator1);

        aceptarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        aceptarMenu.setText("Agregar");
        jMenu1.add(aceptarMenu);

        cancelarMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        cancelarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        cancelarMenu.setText("Cancelar");
        jMenu1.add(cancelarMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        versionMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        versionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        versionMenu.setText("Versi�n");
        jMenu2.add(versionMenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(aceptar)
                        .addGap(79, 79, 79)
                        .addComponent(cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(profundidadInicial)
                                    .addComponent(peso)
                                    .addComponent(profundidadFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ubicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(operador, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(seleccionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(seleccionarUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(seleccionarOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usuario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profundidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profundidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarUbicacion)
                    .addComponent(ubicacion))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarOperador)
                    .addComponent(operador))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarCliente)
                    .addComponent(cliente))
                .addGap(38, 38, 38)
                .addComponent(usuario)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

                                   

   	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	        // TODO add your handling code here:
	    }

	    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
	        // TODO add your handling code here:
	    }

	    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
	        // TODO add your handling code here:
	    }

	    private void formMouseClicked(java.awt.event.MouseEvent evt) {
	        // TODO add your handling code here:
	    }

	    public JButton getJButtonAceptar() {
	        return aceptar;
	    }

	    public JButton getJButtonCancelar() {
	        return cancelar;
	    }

	    public JButton getJButtonSeleccionarUbicacion() {
	        return seleccionarUbicacion;
	    }

	    public JButton getJButtonSeleccionarOperador() {
	        return seleccionarOperador;
	    }

	    public JLabel getjLabel1() {
	        return jLabel1;
	    }

	    public JLabel getjLabel2() {
	        return jLabel2;
	    }

	    public JLabel getjLabel3() {
	        return jLabel3;
	    }

	    public JLabel getjLabel4() {
	        return jLabel4;
	    }

	    public JLabel getUbicacion() {
	        return ubicacion;
	    }

	    /**
		 * @return the cliente
		 */
		public javax.swing.JLabel getCliente() {
			return cliente;
		}


		/**
		 * @param cliente the cliente to set
		 */
		public void setCliente(javax.swing.JLabel cliente) {
			this.cliente = cliente;
		}


		public JLabel getOperador() {
	        return operador;
	    }

	    public JLabel getjLabelUsuario() {
	        return usuario;
	    }

	    public JMenu getjMenu1() {
	        return jMenu1;
	    }

	    public JMenu getjMenu2() {
	        return jMenu2;
	    }

	    public JMenuBar getjMenuBar1() {
	        return jMenuBar1;
	    }

	    public JMenuItem getjMenuAceptar() {
	        return aceptarMenu;
	    }

	    public JMenuItem getjMenuCancelar() {
	        return cancelarMenu;
	    }

	    /**
	     * @return
	     */
	    public JMenuItem getjMenuVersion() {
	        return versionMenu;
	    }
	    
	    /**
		 * @return the seleccionarCliente
		 */
		public javax.swing.JButton getSeleccionarCliente() {
			return seleccionarCliente;
		}

		/**
		 * @return the jMenuItemSeleccionarCliente
		 */
		public javax.swing.JMenuItem getjMenuItemSeleccionarCliente() {
			return jMenuItemSeleccionarCliente;
		}

		/**
		 * @return the jMenuItemSeleccionarOperador
		 */
		public javax.swing.JMenuItem getjMenuItemSeleccionarOperador() {
			return jMenuItemSeleccionarOperador;
		}

		/**
		 * @return the jMenuItemSeleccionarUbicacion
		 */
		public javax.swing.JMenuItem getjMenuItemSeleccionarUbicacion() {
			return jMenuItemSeleccionarUbicacion;
		}

		public JTextField getNombre() {
	        return nombre;
	    }

	    public JTextField getPeso() {
	        return peso;
	    }

	    public JTextField getProfundidadInicial() {
	        return profundidadInicial;
	    }

	    public JTextField getProfundidadFinal() {
	        return profundidadFinal;
	    }
	    
	    /**
		 * @param ubicacion the ubicacion to set
		 */
		public void setUbicacion(String ubicacion) {
			this.ubicacion.setText(ubicacion);
		}
		
		/**
		 * @param operador the operador to set
		 */
		public void setOperador(String operador) {
			this.operador.setText(operador);
		}
		
		/**
		 * @param cliente the cliente to set
		 */
		public void setCliente(String cliente) {
			this.cliente.setText(cliente);
		}
		
		/**
		 * Metodo que permite escuchar los botoner de la ventana.
		 *
		 *@param lis actionEvent asignado a los botones.
		 */
		public void setListenerButtons(ActionListener lis){
			this.aceptar.addActionListener(lis);
			this.cancelar.addActionListener(lis);
			this.seleccionarOperador.addActionListener(lis);
			this.seleccionarUbicacion.addActionListener(lis);
			this.seleccionarCliente.addActionListener(lis);
			this.aceptarMenu.addActionListener(lis);
			this.cancelarMenu.addActionListener(lis);
			this.versionMenu.addActionListener(lis);
			this.jMenuItemSeleccionarCliente.addActionListener(lis);
			this.jMenuItemSeleccionarOperador.addActionListener(lis);
			this.jMenuItemSeleccionarUbicacion.addActionListener(lis);
		}
		
		
		/**
		 * retorna lo que hay en los texfield de la ventana.
		 * @return data.
		 */
		public String[] getData() {
			String[] data = new String[4];
			data[0]= nombre.getText();
			data[1]= peso.getText();
			data[2]= profundidadInicial.getText();
			data[3]= profundidadFinal.getText();
			return data;
		}
		
		/**
		 * Escucha lo ingresado por teclado.
		 * @param lis
		 */
		public void setKeyListener(KeyListener lis){
			nombre.addKeyListener(lis);
		    profundidadInicial.addKeyListener(lis);
		    profundidadFinal.addKeyListener(lis);
		    peso.addKeyListener(lis);
		}
		
		 /**
		 * @return the versionMenu
		 */
		public javax.swing.JMenuItem getVersionMenu() {
			return versionMenu;
		}	
	}
