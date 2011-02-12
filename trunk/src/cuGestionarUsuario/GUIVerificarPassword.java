package cuGestionarUsuario;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIVerificarPassword extends javax.swing.JDialog {

	
	// Variables declaration - do not modify
    private JButton jButtonAceptar;
    private JButton jButtonCancelar;
    private JLabel jLabel1;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPasswordField password;
    // End of variables declaration
    
    
    /** Creates new form GUIBuscar */
    public GUIVerificarPassword() {
    	super();
    	setLocationRelativeTo(null);
        setResizable(false);
    	setModal(true);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Password:");
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem1.setText("Aceptar");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Cancelar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                        
                    .addComponent(jButtonAceptar))
                
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))
                   
                    .addComponent(jButtonCancelar))
         
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         
         
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
         
        ));

        pack();
    }// </editor-fold>

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    /**
	 * Metodo que permite escuchar los botones Aceptar, Cancelar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		jMenuItem1.addActionListener(lis);
		jMenuItem2.addActionListener(lis);
		jButtonAceptar.addActionListener(lis);
		jButtonCancelar.addActionListener(lis);
		
	}
	
	/**
	 * @return the jButtonAceptar
	 */
	public javax.swing.JButton getJButtonBuscar() {
		return jButtonAceptar;
	}

	/**
	 * @return the jButtonCancelar
	 */
	public javax.swing.JButton getJButtonCancelar() {
		return jButtonCancelar;
	}

	public JTextField getPassword() {
		return password;
	}

	/**
	 * @return the jMenuItem1
	 */
	public JMenuItem getjMenuItemAceptar() {
		return jMenuItem1;
	}

	/**
	 * @return the jMenuItem2
	 */
	public JMenuItem getjMenuItemCancelar() {
		return jMenuItem2;
	}

}
