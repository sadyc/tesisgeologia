package cuGestionarMuestra;

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
 * 
 * Clase que define la interfaz para gestionar las muestras.
 * @author TesisGeologia
 * 
 * @version 1.0.
 */
public class GUIABMMuestra extends JDialog{


	private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JComboBox jComboBoxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAgregar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEliminar;
    private javax.swing.JMenuItem jMenuModificar;
    private javax.swing.JMenuItem jMenuSalir;
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
   	private String [] columName;
	private Object [][] data;
	private TablePanel tablePanel;
	

	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIABMMuestra(String title, Object [][] datos, String [] colum) {
		super();
		columName = colum;
		setTitle(title);
		data = datos.clone();
		initComponents();
	}
	
	/**
	 * Inicializa los objetos que contiene la ventana.
	 */
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
	        jComboBoxBuscar = new javax.swing.JComboBox();
	        jComboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre Muestra", "Nombre Ubicación", "Operador","Cliente" }));
	        jComboBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jComboBoxBuscarActionPerformed(evt);
	            }
	        });
	        jLabel1 = new javax.swing.JLabel();
	        jTextFieldBuscar = new javax.swing.JTextField(25);
	        jTextFieldBuscar.addKeyListener(new KeyAdapter() {
	        	  public void keyReleased(final KeyEvent e) {
	            	   if (jComboBoxBuscar.getSelectedItem()=="Nombre Muestra"){
	            		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),1));
	            	   }
	            	   if (jComboBoxBuscar.getSelectedItem()=="Nombre Ubicación"){
	            		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),0));
	            	   }
	            	   if (jComboBoxBuscar.getSelectedItem()=="Operador"){
	            		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),5));
	            	   }
	            	   if (jComboBoxBuscar.getSelectedItem()=="Cliente"){
	            		   tablePanel.getSorter().setRowFilter(RowFilter.regexFilter(jTextFieldBuscar.getText(),6));
	            	   }
	               }
	        });
	           
	        tablePanel = InicializarTabla();
	        jLabel2 = new javax.swing.JLabel();
	        
	        jScrollPane1 = new javax.swing.JScrollPane();
	        
	        jPanel3 = new javax.swing.JPanel();
	        jPanel4 = new javax.swing.JPanel();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jMenuAgregar = new javax.swing.JMenuItem();
	        jMenuModificar = new javax.swing.JMenuItem();
	        jMenuEliminar = new javax.swing.JMenuItem();
	        jSeparator2 = new javax.swing.JPopupMenu.Separator();
	        jMenuSeleccionar = new javax.swing.JMenuItem();
	        jSeparator1 = new javax.swing.JPopupMenu.Separator();
	        jMenuSalir = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();
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

	        jTextFieldBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
	        jTextFieldBuscar.setMinimumSize(new java.awt.Dimension(15, 20));
	        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextFieldBuscarActionPerformed(evt);
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

	        jMenu1.setText("Herramientas");

	        jMenuAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
	        jMenuAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png"))); // NOI18N
	        jMenuAgregar.setText("Agregar");
	        jMenu1.add(jMenuAgregar);

	        jMenuModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
	        jMenuModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo-4.png"))); // NOI18N
	        jMenuModificar.setText("Modificar");
	        jMenu1.add(jMenuModificar);

	        jMenuEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
	        jMenuEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list-remove-5.png"))); // NOI18N
	        jMenuEliminar.setText("Eliminar");
	        jMenu1.add(jMenuEliminar);
	        jMenu1.add(jSeparator2);

	        jMenuSeleccionar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
	        jMenuSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-ok-apply-6.png"))); // NOI18N
	        jMenuSeleccionar.setText("Seleccionar");
	        jMenu1.add(jMenuSeleccionar);

	        jMenu1.add(jSeparator1);

	        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
	        jMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
	        jMenuSalir.setText("Salir");
	        jMenu1.add(jMenuSalir);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Ayuda");

	        jMenuVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
	        jMenuVersion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N
	        jMenuVersion.setText("Versión");
	        jMenu2.add(jMenuVersion);

	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);

	        pack();
	        this.setSize(1300 , 700);
	    }
	 
	 
	 private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
	 }
	 private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                                
	 }  

		
	/**
	 * This method retorna botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * This method retorna boton eliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonEliminar() {
		return jButtonEliminar;
	}

	/**
	 * This method retorna boton eliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonSeleccionar() {
		return jButtonSeleccionar;
	}
	
	/**
	 * This method retorna botonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonModificar() {
		return jButtonModificar;
	}
	
	

	/**
	 * Método que permite escuchar los botones de la ventana.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jButtonAgregar.addActionListener(lis);
		jButtonEliminar.addActionListener(lis);
		jButtonModificar.addActionListener(lis);
		jButtonSeleccionar.addActionListener(lis);
		jButtonSalir.addActionListener(lis);
		jMenuAgregar.addActionListener(lis);
		jMenuEliminar.addActionListener(lis);
	    jMenuModificar.addActionListener(lis);
	    jMenuSalir.addActionListener(lis);
	    jMenuSeleccionar.addActionListener(lis);
	    jMenuVersion.addActionListener(lis);
	}
	
	/**
	 * Método que permite escuchar la tabla panel.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerTable(MouseListener lis){
		this.tablePanel.addMouseListener(lis);
	}
	

	/** 
     *@return data  
     * */
	public String[] getColumName(){
		return columName;
	}

	public void setColumName(String [] columName){
		this.columName = columName.clone();
	}
	
	/**
	 * Método que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public TablePanel InicializarTabla() {
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, columName);
	 		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	 	    tcr.setHorizontalAlignment(SwingConstants.CENTER);
	 	    for (int i = 0; i < 7; i++) {
	 	    	tablePanel.getTable().getColumnModel().getColumn(i).setCellRenderer(tcr);
			}
		}
		
		return this.tablePanel;
	}
	
	
	/**
	 * Escucha el doble click de la tabla.
	 * @param lis
	 */
	public void setMouseListener(MouseListener lis){
        tablePanel.addTableMouseListener(lis);
    }
	
	/**
	 * Escuchas las tecals ingresadas por teclado.
	 * @param lis
	 */
	public void setKeyListener(KeyListener lis){
        tablePanel.addTableKeyListener(lis);
        jTextFieldBuscar.addKeyListener(lis);
	}
	
	/**
	 * @return the jButtonAgregar
	 */
	public javax.swing.JButton getjButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * @return the jButtonEliminar
	 */
	public javax.swing.JButton getjButtonEliminar() {
		return jButtonEliminar;
	}

	/**
	 * @return the jButtonModificar
	 */
	public javax.swing.JButton getjButtonModificar() {
		return jButtonModificar;
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
	/**
	 * @return the jComboBoxBuscar
	 */
	public javax.swing.JComboBox getjComboBoxBuscar() {
		return jComboBoxBuscar;
	}
	
	
	/**
	 * @return the tablePanel
	 */
	public TablePanel getTablePanel() {
		return tablePanel;
	}
}
