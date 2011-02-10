package cuGestionarMuestra;


	import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.JTextField;

	/*
	 * To change this template, choose Tools | Templates
	 * and open the template in the editor.
	 */

	/*
	 * GUIMuestra.java
	 *
	 * Created on 10/12/2010, 02:28:18
	 */

	/**
	 *
	 * @author TesisGeologia.
	 */
	public class GUIMuestra extends javax.swing.JDialog {

	    // Variables declaration - do not modify
	    private javax.swing.JButton aceptar;
	    private javax.swing.JButton cancelar;
	    private javax.swing.JButton seleccionarUbicacion;
	    private javax.swing.JButton seleccionarOperador;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel ubicacion;
	    private javax.swing.JLabel operador;
	    private javax.swing.JLabel usuario;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem aceptarMenu;
	    private javax.swing.JMenuItem cancelarMenu;
	    private javax.swing.JMenuItem versionMenu;
	    private javax.swing.JTextField nombre;
	    private javax.swing.JTextField peso;
	    private javax.swing.JTextField profundidadInicial;
	    private javax.swing.JTextField profundidadFinal;
	    // End of variables declaration


	    
	    /** Creates new form GUIMuestra */
	    public GUIMuestra(boolean modal) {
	        super();
	        nombre = new JTextField(15);
			profundidadInicial = new JTextField(15);
			profundidadFinal = new JTextField(15);
			peso = new JTextField(15);
			ubicacion = new JLabel("(*) Ubicacion: ");
			operador = new JLabel ("(*) Operador: ");
	        initComponents();
	        setModal(modal);
	        this.setLocationRelativeTo(null);
	    }
	    
	    /**
		 * This is the parametrized constructor used in modification
		 * @param data  arreglo que almacena los datos de una muestra. 
		 */
		public GUIMuestra(String[] fila,String nombreOperador) {
		
			super();
			nombre = new JTextField(15);
			profundidadInicial = new JTextField(15);
			profundidadFinal = new JTextField(15);
			peso = new JTextField(15);
			nombre.setText(fila[1]);
			peso.setText(fila[2]);
			profundidadInicial.setText(fila[3]);
			profundidadFinal.setText(fila[4]);
			ubicacion = new JLabel("(*) Ubicacion: "+ fila[0]);
			operador = new JLabel ("(*) Operador: "+ nombreOperador);
			
			seleccionarUbicacion = new JButton("SELECCIONAR UBICACION");
			seleccionarOperador = new JButton("SELECCIONAR OPERADOR");
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
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        seleccionarUbicacion = new javax.swing.JButton();
	        seleccionarOperador = new javax.swing.JButton();
	        usuario = new javax.swing.JLabel();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        aceptarMenu = new javax.swing.JMenuItem();
	        cancelarMenu = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();
	        versionMenu = new javax.swing.JMenuItem();
	        aceptar = new JButton("AGREGAR");
			cancelar = new JButton("CANCELAR");
	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Cargar Muestra\n");
	        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
	        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        setModal(true);
	        addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                formMouseClicked(evt);
	            }
	        });

	        
	        



	        
	        aceptar.setAutoscrolls(true);

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Cargar Muestra\n");
	        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
	        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        setModal(true);
	        addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                formMouseClicked(evt);
	            }
	        });

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



	        peso.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));



	        profundidadInicial.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField3ActionPerformed(evt);
	            }
	        });


	        profundidadFinal.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField4ActionPerformed(evt);
	            }
	        });


	        jLabel1.setText("(*) Nombre: ");



	        jLabel3.setText("(*) Profundidad Inicial : mts");

	        jLabel2.setText("(*) Peso: gr");


	        jLabel4.setText("(*) Profundidad Final : mts");

	        jLabel3.setText("(*) Profundidad Inicial : mts");

	        seleccionarUbicacion.setText("Seleccionar Ubicaci�n");

	        jLabel4.setText("(*) Profundidad Final : mts");

	        seleccionarOperador.setText("Seleccionar Operador");

	        usuario.setText("Usuario:");

	        jMenu1.setText("Herramientas");

	        aceptarMenu.setText("Agregar");
	        jMenu1.add(aceptarMenu);

	        cancelarMenu.setText("Cancelar");
	        jMenu1.add(cancelarMenu);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Ayuda");

	        versionMenu.setText("Versi�n");
	        jMenu2.add(versionMenu);

	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);
	        
	        JPanel jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
            jPanel1.add(new JPanel(),BorderLayout.WEST);
            jPanel1.add(new JPanel(),BorderLayout.SOUTH);
	        
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
	                            .addComponent(profundidadFinal)
	                            .addComponent(profundidadInicial)
	                            .addComponent(peso)
	                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
	                        .addGap(272, 272, 272))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(usuario)
	                        .addContainerGap(484, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(aceptar)
	                        .addGap(58, 58, 58)
	                        .addComponent(cancelar)
	                        .addGap(160, 160, 160))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(ubicacion)
	                            .addComponent(operador))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(seleccionarOperador)
	                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                .addComponent( seleccionarUbicacion)
	                                .addGap(30, 30, 30))))))
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
	                    .addComponent(jLabel2))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(profundidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(profundidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(seleccionarUbicacion)
	                    .addComponent(ubicacion))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(operador)
	                        .addGap(37, 37, 37)
	                        .addComponent(usuario))
	                    .addComponent(seleccionarOperador))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cancelar)
	                    .addComponent(aceptar))
	                .addContainerGap())
	        );
	        setResizable(false);
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

	    public JMenuItem getjMenuVersion() {
	        return versionMenu;
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
		 * @param ubicacion the operador to set
		 */
		public void setOperador(String operador) {
			this.operador.setText(operador);
		}
		
		/**
		 * Metodo que permite escuchar los botoner aceptar y cancelar.
		 *
		 *@param lis actionEvent asignado a los botones.
		 */
		public void setListenerButtons(ActionListener lis){
			this.aceptar.addActionListener(lis);
			this.cancelar.addActionListener(lis);
			this.seleccionarOperador.addActionListener(lis);
			this.seleccionarUbicacion.addActionListener(lis);
			this.aceptarMenu.addActionListener(lis);
			this.cancelarMenu.addActionListener(lis);
			this.versionMenu.addActionListener(lis);
		}
		
		
		public String[] getData() {
			String[] data = new String[4];
			data[0]= nombre.getText();
			data[1]= peso.getText();
			data[2]= profundidadInicial.getText();
			data[3]= profundidadFinal.getText();
			return data;
		}
	
	}
