package cuLimiteConsistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import persistencia.domain.Muestra;

/**
 * Clase que implementa la interfaz de la ventana "Limite de Consistencia"
 * @author TesisGeolgia
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GUILimiteConsistencia extends javax.swing.JDialog {

	
    private javax.swing.JMenuItem agregar;
    private javax.swing.JMenu menuVersion;
    private javax.swing.JMenuItem cancelar;
    private javax.swing.JMenu herramientas;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldLL;
    private javax.swing.JTextField jTextFieldLP;
    private javax.swing.JLabel limiteLiquido;
    private javax.swing.JLabel limitePlastico;
    private javax.swing.JLabel nombreMuestra;
    private javax.swing.JLabel pesoMuestra;
    private javax.swing.JMenuItem version;
    
    
   
    public GUILimiteConsistencia(String title, Muestra muestra) {
        super();
        setTitle(title);
      
        nombreMuestra = new javax.swing.JLabel("Nombre: "+muestra.getNombreMuestra());
        pesoMuestra  = new javax.swing.JLabel("Peso: "+muestra.getPeso()+ " (gr.)");
        if (muestra.getLimiteLiquido() == 0 && muestra.getLimitePlastico() == 0){
        	  jTextFieldLL = new JTextField();
              jTextFieldLP = new JTextField(); 
        }else {
        	jTextFieldLL = new JTextField(muestra.getLimiteLiquido().toString());
            jTextFieldLP = new JTextField(muestra.getLimitePlastico().toString());
        }
        initComponents();
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png")));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png")));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-add.png")));
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dialog-no.png")));
        version.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoSCS.png")));
       
}

    /**
     * Método que inicializa los componentes de la ventana. 
     */
    private void initComponents() {
    	
    	this.setModal(true);

        jSeparator1 = new javax.swing.JSeparator();
        limiteLiquido = new javax.swing.JLabel();
        limitePlastico = new javax.swing.JLabel();
        
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
     
        jButtonCancelar = new javax.swing.JButton();
        
        jMenuBar1 = new javax.swing.JMenuBar();
        herramientas = new javax.swing.JMenu();
        agregar = new javax.swing.JMenuItem();
        agregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cancelar = new javax.swing.JMenuItem();
        cancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));

        menuVersion = new javax.swing.JMenu();
        version = new javax.swing.JMenuItem();
        
        jTextFieldLL.addKeyListener(new KeyAdapter()
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
        
        jTextFieldLP.addKeyListener(new KeyAdapter()
        {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '.')&& (caracter != ','))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        limiteLiquido.setText("Límite Líquido (LL)");

        limitePlastico.setText("Límite Plástico (LP)");
        
        jLabel3.setText("ml.");

        jLabel4.setText("ml.");

        jButtonAgregar.setText("Agregar");
        
        jButtonCancelar.setText("Cancelar");
                
        herramientas.setText("Herramientas");

        agregar.setText("Agregar");
        herramientas.add(agregar);
        herramientas.add(jSeparator2);

        cancelar.setText("Cancelar");
        herramientas.add(cancelar);

        jMenuBar1.add(herramientas);

        menuVersion.setText("Acerca de SCS");

        version.setText("Versión");
        menuVersion.add(version);

        jMenuBar1.add(menuVersion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jButtonAgregar)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addGap(149, 149, 149))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreMuestra)
                    .addComponent(pesoMuestra)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limiteLiquido)
                            .addComponent(limitePlastico))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldLP)
                            .addComponent(jTextFieldLL, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nombreMuestra)
                .addGap(26, 26, 26)
                .addComponent(pesoMuestra)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(limiteLiquido))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(limitePlastico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }
    
    /**
	 * @return the agregar
	 */
	public javax.swing.JMenuItem getAgregar() {
		return agregar;
	}

	/**
	 * @param agregar the agregar to set
	 */
	public void setAgregar(javax.swing.JMenuItem agregar) {
		this.agregar = agregar;
	}

	/**
	 * @return the menuVersion
	 */
	public javax.swing.JMenu getAyuda() {
		return menuVersion;
	}

	/**
	 * @param menuVersion the menuVersion to set
	 */
	public void setAyuda(javax.swing.JMenu ayuda) {
		this.menuVersion = ayuda;
	}

	/**
	 * @return the cancelar
	 */
	public javax.swing.JMenuItem getCancelar() {
		return cancelar;
	}

	/**
	 * @param cancelar the cancelar to set
	 */
	public void setCancelar(javax.swing.JMenuItem cancelar) {
		this.cancelar = cancelar;
	}

	/**
	 * @return the herramientas
	 */
	public javax.swing.JMenu getHerramientas() {
		return herramientas;
	}

	/**
	 * @param herramientas the herramientas to set
	 */
	public void setHerramientas(javax.swing.JMenu herramientas) {
		this.herramientas = herramientas;
	}

	/**
	 * @return the jButtonAgregar
	 */
	public javax.swing.JButton getjButtonAgregar() {
		return jButtonAgregar;
	}

	/**
	 * @param jButtonAgregar the jButtonAgregar to set
	 */
	public void setjButtonAgregar(javax.swing.JButton jButtonAgregar) {
		this.jButtonAgregar = jButtonAgregar;
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

	/**
	 * @return the jLabel3
	 */
	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	/**
	 * @param jLabel3 the jLabel3 to set
	 */
	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	/**
	 * @return the jLabel4
	 */
	public javax.swing.JLabel getjLabel4() {
		return jLabel4;
	}

	/**
	 * @param jLabel4 the jLabel4 to set
	 */
	public void setjLabel4(javax.swing.JLabel jLabel4) {
		this.jLabel4 = jLabel4;
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
	 * @return the jSeparator1
	 */
	public javax.swing.JSeparator getjSeparator1() {
		return jSeparator1;
	}

	/**
	 * @param jSeparator1 the jSeparator1 to set
	 */
	public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
		this.jSeparator1 = jSeparator1;
	}

	/**
	 * @return the jSeparator2
	 */
	public javax.swing.JPopupMenu.Separator getjSeparator2() {
		return jSeparator2;
	}

	/**
	 * @param jSeparator2 the jSeparator2 to set
	 */
	public void setjSeparator2(javax.swing.JPopupMenu.Separator jSeparator2) {
		this.jSeparator2 = jSeparator2;
	}

	/**
	 * @return the jTextFieldLL
	 */
	public javax.swing.JTextField getjTextFieldLL() {
		return jTextFieldLL;
	}

	/**
	 * @param jTextFieldLL the jTextFieldLL to set
	 */
	public void setjTextFieldLL(javax.swing.JTextField jTextFieldLL) {
		this.jTextFieldLL = jTextFieldLL;
	}

	/**
	 * @return the jTextFieldLP
	 */
	public javax.swing.JTextField getjTextFieldLP() {
		return jTextFieldLP;
	}

	/**
	 * @param jTextFieldLP the jTextFieldLP to set
	 */
	public void setjTextFieldLP(javax.swing.JTextField jTextFieldLP) {
		this.jTextFieldLP = jTextFieldLP;
	}

	/**
	 * @return the limiteLiquido
	 */
	public javax.swing.JLabel getLimiteLiquido() {
		return limiteLiquido;
	}

	/**
	 * @param limiteLiquido the limiteLiquido to set
	 */
	public void setLimiteLiquido(javax.swing.JLabel limiteLiquido) {
		this.limiteLiquido = limiteLiquido;
	}

	/**
	 * @return the limitePlastico
	 */
	public javax.swing.JLabel getLimitePlastico() {
		return limitePlastico;
	}

	/**
	 * @param limitePlastico the limitePlastico to set
	 */
	public void setLimitePlastico(javax.swing.JLabel limitePlastico) {
		this.limitePlastico = limitePlastico;
	}

	/**
	 * @return the nombreMuestra
	 */
	public javax.swing.JLabel getNombreMuestra() {
		return nombreMuestra;
	}

	/**
	 * @param nombreMuestra the nombreMuestra to set
	 */
	public void setNombreMuestra(javax.swing.JLabel nombreMuestra) {
		this.nombreMuestra = nombreMuestra;
	}

	/**
	 * @return the pesoMuestra
	 */
	public javax.swing.JLabel getPesoMuestra() {
		return pesoMuestra;
	}

	/**
	 * @param pesoMuestra the pesoMuestra to set
	 */
	public void setPesoMuestra(javax.swing.JLabel pesoMuestra) {
		this.pesoMuestra = pesoMuestra;
	}

	/**
	 * @return the version
	 */
	public javax.swing.JMenuItem getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(javax.swing.JMenuItem version) {
		this.version = version;
	}
	
	  private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                               
		    
	    }     

	/**
	 * Metodo que permite escuchar los botoner aceptar y cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonAgregar.addActionListener(lis);
		this.jButtonCancelar.addActionListener(lis);
		this.agregar.addActionListener(lis);
		this.cancelar.addActionListener(lis);
		version.addActionListener(lis);
	}



}
