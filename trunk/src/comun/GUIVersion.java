package comun;

import java.awt.event.ActionListener;

/**
 * Clase que implementa la interfaz de la ventana "Versión".
 * 
 * @author tesisGeologia.
 * 
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class GUIVersion extends javax.swing.JDialog {


	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	// End of variables declaration    


	/**
	 * Constructor por defecto.
	 */
	public GUIVersion() {
		super();
		initComponents();
		this.setLocationRelativeTo(null);

	}


	/**
	 * Inicializa los componentes de la ventana.
	 */
	private void initComponents() {

		   jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jButtonCancelar = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14));
	        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
	        jLabel1.setText("\"Sistema Clasificador de Suelos\" (S.C.S)");

	        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 11));
	        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
	        jLabel2.setText("Version 2011 (Compliación 1.0)");

	        jLabel4.setForeground(new java.awt.Color(102, 102, 0));
	        jLabel4.setText("Desarrollado por alumnos de la Universidad Nacional de Río Cuarto.");
	        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

	        jLabel5.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18));
	        jLabel5.setText("TesisGeología Soft.");

	        jLabel3.setFont(new java.awt.Font("Gill Sans", 1, 11));
	        jLabel3.setForeground(new java.awt.Color(0, 51, 0));
	        jLabel3.setText("tesisgeologia@gmail.com");

	        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
	        jLabel6.setText("Contacto: ");

	        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
	        jButtonCancelar.setText("Cerrar");
	        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButtonCancelarActionPerformed(evt);
	            }
	        });

	        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png"))); // NOI18N

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(116, 116, 116)
	                .addComponent(jLabel6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel3)
	                .addContainerGap(75, Short.MAX_VALUE))

	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(289, Short.MAX_VALUE)
	                .addComponent(jButtonCancelar)
	                .addContainerGap())

	            .addGroup(layout.createSequentialGroup()
	                .addGap(128, 128, 128)
	                .addComponent(jLabel2)
	                .addContainerGap(88, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(66, 66, 66)
	                .addComponent(jLabel1)
	                .addContainerGap(29, Short.MAX_VALUE))

	            .addGroup(layout.createSequentialGroup()
	                .addGap(43, 43, 43)
	                .addComponent(jLabel4)
	                .addContainerGap(37, Short.MAX_VALUE))

	            .addGroup(layout.createSequentialGroup()
	                .addGap(76, 76, 76)
	                .addComponent(jButton2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel5)
	                .addContainerGap(114, Short.MAX_VALUE))

	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel5))
	                .addGap(18, 18, 18)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jLabel2)
	                .addGap(18, 18, 18)
	                .addComponent(jLabel4)
	                .addGap(32, 32, 32)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel6)
	                    .addComponent(jLabel3))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
	                .addComponent(jButtonCancelar)
	                .addContainerGap())
	        );

	        pack();


    }   

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                

	}                                               

	public void setListenerButtons(ActionListener lis){
		this.jButtonCancelar.addActionListener(lis);
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

}