/**
 * 
 */
package cuGestionarAnalisis;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import comun.TablePanel;

import persistencia.domain.Muestra;
import persistencia.domain.Tamiz;

/**
 * @author TesisGeologia
 *
 * Clase que define la interfaz para manipular un Analisis
 */

public class GUIAltaAnalisis extends javax.swing.JDialog {
	
	// Variables declaration - do not modify
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButtonSeleccionarTamiz;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMuestra;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelTamiz;
    private javax.swing.JLabel jLabelUbicacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemTamiz;
    private javax.swing.JTextField pesoRetenido;
    // End of variables declaration

    /** Creates new form GUIAltaAnalisis */
    public GUIAltaAnalisis() {
        super();
        setModal(true);
        setResizable(false);
        initComponents();
    }
    
    public GUIAltaAnalisis(Muestra muestra) {
		super();
		pesoRetenido = new JTextField(15);
		jLabelMuestra = new JLabel("Muestra: "+muestra.getNombreMuestra());
		jLabelUbicacion = new JLabel("Ubicacion: "+muestra.getUbicacion().getNombreUbicacion());
		jLabelPeso = new JLabel("Peso: "+muestra.getPeso());
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

        jLabel4 = new javax.swing.JLabel();
        jLabelTamiz = new javax.swing.JLabel();
        jButtonSeleccionarTamiz = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemTamiz = new javax.swing.JMenuItem();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jMenuItemCancelar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setText("Peso retenido por el Tamiz: ");
        jLabelTamiz.setText("Tamiz: ");

        jButtonSeleccionarTamiz.setText("Seleccionar Tamiz");
        jButtonSeleccionarTamiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarTamizActionPerformed(evt);
            }
        });

        aceptar.setText("Agregar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");

        jLabel6.setText("Gramos");

        jMenu1.setText("Herramientas");

        jMenuItemTamiz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTamiz.setText("Seleccionar Tamiz");
        jMenu1.add(jMenuItemTamiz);

        jMenuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItemAgregar.setText("Agregar");
        jMenu1.add(jMenuItemAgregar);

        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemCancelar.setText("Salir");
        jMenu1.add(jMenuItemCancelar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPeso)
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamiz, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesoRetenido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jButtonSeleccionarTamiz))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMuestra)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUbicacion)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMuestra)
                .addGap(11, 11, 11)
                .addComponent(jLabelUbicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPeso)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamiz)
                    .addComponent(jButtonSeleccionarTamiz))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesoRetenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jButtonSeleccionarTamizActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

	public void setListenerButtons(ActionListener lis) {
		aceptar.addActionListener(lis);
	    cancelar.addActionListener(lis);
	    jButtonSeleccionarTamiz.addActionListener(lis);
	    jMenuItemAgregar.addActionListener(lis);
	    jMenuItemCancelar.addActionListener(lis);
	    jMenuItemTamiz.addActionListener(lis);
	    
		
	}
	/**
	 * @return the aceptar
	 */
	public javax.swing.JButton getJButtonAceptar() {
		return aceptar;
	}

	/**
	 * @return the cancelar
	 */
	public javax.swing.JButton getJButtonCancelar() {
		return cancelar;
	}

	/**
	 * @return the jButtonSeleccionarTamiz
	 */
	public javax.swing.JButton getJButtonSeleccionarTamiz() {
		return jButtonSeleccionarTamiz;
	}
	/**
	 * @param jLabelTamiz the jLabelTamiz to set
	 */
	public void setTamiz(String tamiz) {
		jLabelTamiz.setText("Tamiz: "+tamiz);
	}

	public JTextField getPesoRetenido() {
		return pesoRetenido;
	}

	

	

}

