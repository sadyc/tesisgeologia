package cuGestionarUsuario;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import comun.TablePanel;

/**
 * Clase GUI que reprensenta la ventana para gestionar usuarios.
 * @author TesisGeologia.
 * @version 1.0.
 *
 */
@SuppressWarnings("serial")
public class GUIGestionarUsuario extends JDialog{
	
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JComboBox jComboBoxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu herramientasMenu;
    private javax.swing.JMenu versionMenu;
    private javax.swing.JMenuItem jMenuAgregar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEliminar;
    private javax.swing.JMenuItem jMenuModificar;private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuSeleccionar;
    private javax.swing.JMenuItem jMenuVersion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldBuscar;
    private Object [][] data;
    private TablePanel tablePanel;
    // End of variables declaration
    
    /**
	 * Constructor de la clase.
	 * @param datos, contiene la informacion de las ubicaciones almacenadas.
	 */
	public GUIGestionarUsuario(Object [][] datos) {
		super();
		setModal(true);
		setResizable(true);
        data = datos;
		tablePanel = getTablePanel();
		initComponents();
	}

	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSeleccionar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField(25);
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBuscar = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        herramientasMenu = new javax.swing.JMenu();
        jMenuAgregar = new javax.swing.JMenuItem();
        jMenuModificar = new javax.swing.JMenuItem();
        jMenuEliminar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuSeleccionar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSalir = new javax.swing.JMenuItem();
        versionMenu = new javax.swing.JMenu();
        jMenuVersion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jButtonAgregar.setText("Agregar");

        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
        jButtonModificar.setText("Modificar");

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list-remove-5.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");

        jButtonSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jButtonSeleccionar.setText("Seleccionar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAgregar)
                .addGap(10, 10, 10)
                .addComponent(jButtonModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButtonSeleccionar)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSeleccionar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonAgregar))
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel5);
        jPanel1.add(jPanel6);

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButtonSalir.setText("Salir");
        jPanel1.add(jButtonSalir);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jLabel1.setText("Buscar : ");
        jPanel2.add(jLabel1);
        jComboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre Usuario","Nombre", "Apellido", "DNI","Categoría" }));
        jComboBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBuscarActionPerformed(evt);
            }
        });
        

        jTextFieldBuscar.setMinimumSize(new java.awt.Dimension(15, 20));
        jTextFieldBuscar.addKeyListener(new KeyAdapter() {
      	  public void keyReleased(final KeyEvent e) {
          	   if (jComboBoxBuscar.getSelectedItem()=="Nombre Usuario"){
          		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),3));
          	   }
          	   if (jComboBoxBuscar.getSelectedItem()=="Nombre"){
          		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),0));
          	   }
          	   if (jComboBoxBuscar.getSelectedItem()=="Apellido"){
          		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),1));
          	   }
          	   if (jComboBoxBuscar.getSelectedItem()=="DNI"){
        		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),2));
        	   }
          	   if (jComboBoxBuscar.getSelectedItem()=="Categoría"){
          		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),4));
      	   }
          	 }
      });
        jPanel2.add(jTextFieldBuscar);

        jLabel2.setText("Por :");
        jPanel2.add(jLabel2);
        jPanel2.add(jComboBoxBuscar);

        

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(tablePanel);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(20, 289));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        herramientasMenu.setText("Herramientas");

        jMenuAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
        jMenuAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
        jMenuAgregar.setText("Agregar");
        herramientasMenu.add(jMenuAgregar);

        jMenuModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
        jMenuModificar.setText("Modificar");
        herramientasMenu.add(jMenuModificar);

        jMenuEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list-remove-5.png"))); // NOI18N
        jMenuEliminar.setText("Eliminar");
        herramientasMenu.add(jMenuEliminar);
        herramientasMenu.add(jSeparator2);

        jMenuSeleccionar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
        jMenuSeleccionar.setText("Seleccionar");
        herramientasMenu.add(jMenuSeleccionar);

        herramientasMenu.add(jSeparator1);

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jMenuSalir.setText("Salir");
        herramientasMenu.add(jMenuSalir);

        jMenuBar1.add(herramientasMenu);

        versionMenu.setText("Acerca de SCS");

        jMenuVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
        jMenuVersion.setText("Versión");
        versionMenu.add(jMenuVersion);

        jMenuBar1.add(versionMenu);

        setJMenuBar(jMenuBar1);

        this.setSize(1100 , 650);
    }

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {
    }

	/**
	 * This method retorna boton salir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSalir() {
		return jButtonSalir;
	}
	
	/**
	 * Método que permite escuchar los botones Seleccionar, Buscar y Salir.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jButtonSeleccionar.addActionListener(lis);
		jButtonSalir.addActionListener(lis);
		jButtonAgregar.addActionListener(lis);
		jButtonModificar.addActionListener(lis);
		jButtonEliminar.addActionListener(lis);
		jMenuEliminar.addActionListener(lis);
	    jMenuModificar.addActionListener(lis);
	    jMenuSalir.addActionListener(lis);
	    jMenuSeleccionar.addActionListener(lis);
	    jMenuVersion.addActionListener(lis);
	}
	/**
	 * Metodo que permite escuchar la tabla panel.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerTable(MouseListener lis){
		this.tablePanel.addMouseListener(lis);
	}
	

	/** 
     *@return data  
    */
	public static String[] getColumName(){
		String [] columAux = {"Nombre","Apellido","DNI","Nombre Usuario","Categoría","E-mail","Teléfono"};
		return columAux;
	}

	/**
	 * Metodo que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel() {
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, getColumName());
	 		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	 	    tcr.setHorizontalAlignment(SwingConstants.CENTER);
	 	    for (int i = 0; i < 7; i++) {
	 	    	tablePanel.getTable().getColumnModel().getColumn(i).setCellRenderer(tcr);
			}
		}
		return this.tablePanel;
	}

	/**
	 * @return the jButtonAgregar
	 */
	public JButton getjButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * @return the jButtonModificar
	 */
	public JButton getjButtonModificar() {
		return jButtonModificar;
	}

	/**
	 * @return the jButtonEliminar
	 */
	public JButton getjButtonEliminar() {
		return jButtonEliminar;
	}
	
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
        jTextFieldBuscar.addKeyListener(lis);
	}
	
	/**
	 * @return the jButtonSalir
	 */
	public javax.swing.JButton getjButtonSalir() {
		return jButtonSalir;
	}

	/**
	 * @return the jButtonSeleccionar
	 */
	public javax.swing.JButton getjButtonSeleccionar() {
		return jButtonSeleccionar;
	}

	/**
	 * @return the jComboBoxBuscar
	 */
	public javax.swing.JComboBox getjComboBoxBuscar() {
		return jComboBoxBuscar;
	}
	

    /**
	 * @return the jMenuAgregar
	 */
	public javax.swing.JMenuItem getjMenuAgregar() {
		return jMenuAgregar;
	}

	/**
	 * @return the jMenuEliminar
	 */
	public javax.swing.JMenuItem getjMenuEliminar() {
		return jMenuEliminar;
	}

	/**
	 * @return the jMenuModificar
	 */
	public javax.swing.JMenuItem getjMenuModificar() {
		return jMenuModificar;
	}

	/**
	 * @return the jMenuSalir
	 */
	public javax.swing.JMenuItem getjMenuSalir() {
		return jMenuSalir;
	}

	/**
	 * @return the jMenuSeleccionar
	 */
	public javax.swing.JMenuItem getjMenuSeleccionar() {
		return jMenuSeleccionar;
	}

	/**
	 * @return the jMenuVersion
	 */
	public javax.swing.JMenuItem getjMenuVersion() {
		return jMenuVersion;
	}
	
	/**
	 * @return the jTextFieldBuscar
	 */
	public javax.swing.JTextField getjTextFieldBuscar() {
		return jTextFieldBuscar;
	}
}
