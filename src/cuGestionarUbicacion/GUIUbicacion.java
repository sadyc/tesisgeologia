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
	
	private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox jComboBoxProvincia;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelLatitud;
    private javax.swing.JLabel jLabelLongitud;
    private javax.swing.JLabel jLabelNombreUbicacion;
    private javax.swing.JLabel jLabelProvincia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuVersion;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldLongitud;
    private javax.swing.JTextField jTextFieldLatitud;
    private javax.swing.JTextField jTextFieldNombreUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration

    
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
        jLabelLatitud = new javax.swing.JLabel();
        jLabelLongitud = new javax.swing.JLabel();
        jComboBoxProvincia = new javax.swing.JComboBox();
        jLabelProvincia = new javax.swing.JLabel();
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuVersion = new javax.swing.JMenuItem();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-add.png"))); // NOI18N
        jButtonAceptar.setText("Agregar");

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialog-no.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
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
        
        jLabelProvincia.setText("Provincia : ");

        jLabelNombreUbicacion.setText("(*) Nombre Ubicación :");

        jLabelCiudad.setText("(*) Ciudad:");

        jLabelLatitud.setText("Latitud:");

        jLabelLongitud.setText("Longitud:");

        jComboBoxProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Capital Federal", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago Del Estero", "Tierra Del Fuego", "Tucuman" }));

        jLabel1.setText("(grados)");

        jLabel2.setText("(grados)");

        jMenu1.setText("Herramientas");

        jMenuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItemAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit-add.png"))); // NOI18N
        jMenuItemAgregar.setText("Agregar");
        jMenu1.add(jMenuItemAgregar);

        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dialog-no.png"))); // NOI18N
        jMenuItemCancelar.setText("Cancelar");
        jMenu1.add(jMenuItemCancelar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoSCS.png"))); // NOI18N
        jMenuVersion.setText("Versión");
        jMenu2.add(jMenuVersion);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLatitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelLongitud, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabelNombreUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLatitud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jTextFieldLongitud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombreUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButtonCancelar))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(25, 25, 25))
        );

        pack();
    }

       

       
    
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
