/**
 * 
 */
package cuGestionarUbicacion;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import persistencia.domain.Ubicacion;

/**
 * Clase GUI que reprensenta la ventana para una ubicacion.
 * @author TesisGeologia.
 * @version 1.0.
 *
 */
@SuppressWarnings("serial")
public class GUIUbicacion extends javax.swing.JDialog {
	
	 private javax.swing.JButton jButtonAceptar;
	    private javax.swing.JButton jButtonCancelar;
	    private javax.swing.JComboBox jComboBoxLatitud;
	    private javax.swing.JComboBox jComboBoxLongitud;
	    private javax.swing.JComboBox jComboBoxProvincia;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JLabel jLabelCiudad;
	    private javax.swing.JLabel jLabelNombreUbicacion;
	    private javax.swing.JLabel jLabelProvincia;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItemAgregar;
	    private javax.swing.JMenuItem jMenuItemCancelar;
	    private javax.swing.JMenuItem jMenuVersion;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JPopupMenu.Separator jSeparator1;
	    private javax.swing.JTabbedPane jTabbedPane1;
	    private javax.swing.JTextField jTextFieldCiudad;
	    private javax.swing.JTextField jTextFieldGradLong;
	    private javax.swing.JTextField jTextFieldGradoLat;
	    private javax.swing.JTextField jTextFieldLatitud;
	    private javax.swing.JTextField jTextFieldLongitud;
	    private javax.swing.JTextField jTextFieldMinLat;
	    private javax.swing.JTextField jTextFieldMinLong;
	    private javax.swing.JTextField jTextFieldNombreUbicacion;
	    private javax.swing.JTextField jTextFieldSegLat;
	    private javax.swing.JTextField jTextFieldSegLong;

    
    /**
     * Constructor por defecto.
     */
    public GUIUbicacion() {
    	super();
    	setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldNombreUbicacion = new javax.swing.JTextField();
        jTextFieldLongitud = new javax.swing.JTextField();
        jTextFieldLatitud = new javax.swing.JTextField();
        initComponents();
        
    }
    
   
    /**
     * Constructor con pasaje de parametros.
     * @param ubicacion
     */
    public GUIUbicacion(Ubicacion ubicacion) {
    	super();
    	setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldNombreUbicacion = new javax.swing.JTextField();
        jTextFieldLongitud = new javax.swing.JTextField();
        jTextFieldLatitud = new javax.swing.JTextField();
        jTextFieldCiudad.setText(ubicacion.getCiudad());
        jTextFieldNombreUbicacion.setText(ubicacion.getNombreUbicacion());
        jTextFieldLongitud.setText(ubicacion.getLongitud().toString());
        jTextFieldLatitud.setText(ubicacion.getLatitud().toString());
        initComponents();
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png")));
        jButtonAceptar.setText("Modificar");
    }
    
    /**
     * Inicializar de los objetos de la ventana.
     */
    private void initComponents() {
    	 jButtonAceptar = new javax.swing.JButton();
    	 jButtonCancelar = new javax.swing.JButton();
         jLabelNombreUbicacion = new javax.swing.JLabel();
         jLabelCiudad = new javax.swing.JLabel();
         jComboBoxProvincia = new javax.swing.JComboBox();
         jLabelProvincia = new javax.swing.JLabel();
         jTextFieldCiudad = new javax.swing.JTextField();
         jTextFieldNombreUbicacion = new javax.swing.JTextField();
         jTabbedPane1 = new javax.swing.JTabbedPane();
         jPanel2 = new javax.swing.JPanel();
         jLabel3 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         jTextFieldGradoLat = new javax.swing.JTextField();
         jTextFieldGradLong = new javax.swing.JTextField();
         jTextFieldGradoLat.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jTextFieldGradLong.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jLabel5 = new javax.swing.JLabel();
         jTextFieldMinLat = new javax.swing.JTextField();
         jLabel6 = new javax.swing.JLabel();
         jTextFieldSegLat = new javax.swing.JTextField();
         jTextFieldMinLat.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jTextFieldSegLat.addKeyListener(new KeyAdapter()
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
         jLabel7 = new javax.swing.JLabel();
         jLabel8 = new javax.swing.JLabel();
         jTextFieldMinLong = new javax.swing.JTextField();
         jTextFieldSegLong = new javax.swing.JTextField();
         jTextFieldMinLong.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jTextFieldSegLong.addKeyListener(new KeyAdapter()
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
         jLabel9 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         jComboBoxLatitud = new javax.swing.JComboBox();
         jComboBoxLongitud = new javax.swing.JComboBox();
         jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jTextFieldLatitud = new javax.swing.JTextField();
         jTextFieldLongitud = new javax.swing.JTextField();
         jTextFieldLongitud.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != ',') && (caracter != '.') )
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jTextFieldLatitud.addKeyListener(new KeyAdapter()
         {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();

               if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '.') && (caracter != ','))
               {
                  e.consume();  // ignorar el evento de teclado
               }
            }
         });
         jLabel11 = new javax.swing.JLabel();
         jMenuBar1 = new javax.swing.JMenuBar();
         jMenu1 = new javax.swing.JMenu();
         jMenuItemAgregar = new javax.swing.JMenuItem();
         jSeparator1 = new javax.swing.JPopupMenu.Separator();
         jMenuItemCancelar = new javax.swing.JMenuItem();
         jMenu2 = new javax.swing.JMenu();
         jMenuVersion = new javax.swing.JMenuItem();

         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

         jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-add.png"))); // NOI18N
         jButtonAceptar.setText("Agregar");

         jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialog-no.png"))); // NOI18N
         jButtonCancelar.setText("Cancelar");

         jLabelNombreUbicacion.setText("(*) Nombre Ubicación:");

         jLabelCiudad.setText("(*) Ciudad:");

         jComboBoxProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Capital Federal", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago Del Estero", "Tierra Del Fuego", "Tucumán" }));

         jLabelProvincia.setText("Provincia:");

         jLabel3.setText("Latitud: ");

         jLabel4.setText("Longitud: ");

         jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel5.setText("°");

         jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel6.setText("'");

         jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel7.setText("''");

         jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel8.setText("°");

         jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel9.setText("'");

         jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
         jLabel10.setText("''");

         jComboBoxLatitud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Norte", "Sur" }));

         jComboBoxLongitud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Este", "Oeste" }));

         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
         jPanel2.setLayout(jPanel2Layout);
         jPanel2Layout.setHorizontalGroup(
             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel2Layout.createSequentialGroup()
                 .addGap(83, 83, 83)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel4)
                     .addComponent(jLabel3))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jTextFieldGradLong, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                     .addComponent(jTextFieldGradoLat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(4, 4, 4)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel5)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jTextFieldMinLat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel8)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jTextFieldMinLong)))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel6)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextFieldSegLat, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                     .addGroup(jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel9)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextFieldSegLong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel7)
                         .addGap(18, 18, 18)
                         .addComponent(jComboBoxLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel2Layout.createSequentialGroup()
                         .addComponent(jLabel10)
                         .addGap(18, 18, 18)
                         .addComponent(jComboBoxLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addContainerGap(26, Short.MAX_VALUE))
         );
         jPanel2Layout.setVerticalGroup(
             jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel2Layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel5)
                     .addComponent(jLabel6)
                     .addComponent(jTextFieldSegLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jComboBoxLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jTextFieldMinLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jTextFieldGradoLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel7)
                     .addComponent(jLabel3))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel4)
                     .addComponent(jTextFieldGradLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel8)
                     .addComponent(jTextFieldMinLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel9)
                     .addComponent(jTextFieldSegLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel10)
                     .addComponent(jComboBoxLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         jTabbedPane1.addTab("Grados", jPanel2);

         jLabel1.setText("Latitud: ");

         jLabel2.setText("Longitud: ");

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                 .addGap(87, 87, 87)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel2)
                     .addComponent(jLabel1))
                 .addGap(89, 89, 89)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jTextFieldLongitud)
                     .addComponent(jTextFieldLatitud, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                 .addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(jTextFieldLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel2)
                     .addComponent(jTextFieldLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         jTabbedPane1.addTab("Decimal", jPanel1);

         jLabel11.setText("Coordenadas: ");

         jMenu1.setText("Herramientas");

         jMenuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
         jMenuItemAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-add.png"))); // NOI18N
         jMenuItemAgregar.setText("Agregar");
         jMenu1.add(jMenuItemAgregar);
         jMenu1.add(jSeparator1);

         jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
         jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialog-no.png"))); // NOI18N
         jMenuItemCancelar.setText("Cancelar");
         jMenu1.add(jMenuItemCancelar);

         jMenuBar1.add(jMenu1);

         jMenu2.setText("Versión");

         jMenuVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
         jMenuVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoSCS.png"))); // NOI18N
         jMenuVersion.setText("Acerca de SCS");
         jMenu2.add(jMenuVersion);

         jMenuBar1.add(jMenu2);

         setJMenuBar(jMenuBar1);

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addContainerGap(89, Short.MAX_VALUE)
                 .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(121, 121, 121)
                 .addComponent(jButtonCancelar)
                 .addGap(74, 74, 74))
             .addGroup(layout.createSequentialGroup()
                 .addGap(29, 29, 29)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel11)
                         .addContainerGap())
                     .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jLabelProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                             .addComponent(jLabelNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jLabelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                             .addComponent(jComboBoxProvincia, 0, 187, Short.MAX_VALUE)
                             .addComponent(jTextFieldNombreUbicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                         .addContainerGap(73, Short.MAX_VALUE))))
             .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabelProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(23, 23, 23)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabelNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jTextFieldNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                 .addComponent(jLabel11)
                 .addGap(18, 18, 18)
                 .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jButtonAceptar)
                     .addComponent(jButtonCancelar))
                 .addContainerGap())
         );

         pack();
     }// </editor-fold>
       

       
    
    /**
	 * Método que permite escuchar los botones y los item
	 * del menu.
	 *
	 *@param mediadorModificarUbicacion actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonAceptar.addActionListener(lis);
		this.jButtonCancelar.addActionListener(lis);
		this.jMenuItemAgregar.addActionListener(lis);
		this.jMenuItemCancelar.addActionListener(lis);
		this.jMenuVersion.addActionListener(lis);
	}
	
	public String[] getData() {
		String[] data = new String[5];
		data[0]= jTextFieldNombreUbicacion.getText();
		data[1]= jTextFieldCiudad.getText();
		data[2]= jComboBoxProvincia.getSelectedItem().toString();
		if (jTextFieldLongitud.getText().equals(""))
			data[3]="0";
		else
			data[3]= jTextFieldLongitud.getText();
		if (jTextFieldLatitud.getText().equals(""))
			data[4]="0";
		else
			data[4]= jTextFieldLatitud.getText();
		return data;
	}
	
	public void setKeyListener(KeyListener lis){
		jTextFieldCiudad.addKeyListener(lis);
	    jTextFieldNombreUbicacion.addKeyListener(lis);
	}


    /**
	 * @return the jButtonCancelar
	 */
	public javax.swing.JButton getjButtonCancelar() {
		return jButtonCancelar;
	}

	/**
	 * @return the jButtonAceptar
	 */
	public javax.swing.JButton getjButtonAceptar() {
		return jButtonAceptar;
	}

	/**
	 * @return the jComboBoxProvincia
	 */
	public javax.swing.JComboBox getjComboBoxProvincia() {
		return jComboBoxProvincia;
	}

	/**
	 * @return the jMenuVersion
	 */
	public javax.swing.JMenuItem getjMenuVersion() {
		return jMenuVersion;
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
	 * @return the jTextFieldCiudad
	 */
	public javax.swing.JTextField getjTextFieldCiudad() {
		return jTextFieldCiudad;
	}

	/**
	 * @return the jTextFieldLongitud
	 */
	public javax.swing.JTextField getjTextFieldLongitud() {
		return jTextFieldLongitud;
	}

	/**
	 * @return the jTextFieldLatitud
	 */
	public javax.swing.JTextField getjTextFieldLatitud() {
		return jTextFieldLatitud;
	}

	/**
	 * @return the jTextFieldNombreUbicacion
	 */
	public javax.swing.JTextField getjTextFieldNombreUbicacion() {
		return jTextFieldNombreUbicacion;
	}

	
}
