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

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Versión 2011 (Compilación 1.0)");

        jLabel4.setForeground(new java.awt.Color(102, 102, 0));
        jLabel4.setText("Finalizado Lunes 21 de Febrero de 2011");

        jLabel5.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18));
        jLabel5.setText("TesisGeología Soft.");

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 12));
        jLabel3.setForeground(new java.awt.Color(0, 51, 0));
        jLabel3.setText("tesisgeologia@gmail.com");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
        jLabel6.setText("Contacto: ");

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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

