package cuGestionarUsuario;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import comun.MediadorVersion;

import persistencia.domain.Usuario;
import cuLogin.Encriptar;

/**
 * @brief Clase que se utiliza para realizar los sucesos en la ventana de verificar password.
 * 
 * @author TesisGeologia
 * @version 1.0
 *
 */
public class MediadorVerificarPassword implements ActionListener, KeyListener, MouseListener {
        private GUIVerificarPassword GUIVerificarPassword;
        private String dni;
        private boolean correcto;
        private Component frame;
        private ControlGestionarUsuario control = new ControlGestionarUsuario();
        
        /**
         * Contructor por default.
         * 
         */
        public MediadorVerificarPassword (String DNI, String nombreUsuario){
                super();
                dni = DNI;
                correcto = false;
                GUIVerificarPassword = new GUIVerificarPassword();
                GUIVerificarPassword.setTitle("Nombre Usuario: "+nombreUsuario);
                GUIVerificarPassword.setListenerButtons(this);
                GUIVerificarPassword.setLocationRelativeTo(null);
                GUIVerificarPassword.show();
        }
        
        private void buscar() {
                System.out.println("Verificar.actionPerformed() jButtonAceptar");
                try{
                        if (GUIVerificarPassword.getjPasswordField1().getText().equals("")){
                                JOptionPane.showMessageDialog(frame,"El password no puede ser vacio.","Atención!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                                Usuario usuario = control.obtenerUsuario(dni);
                                Encriptar encriptar = new Encriptar();
                                String password = "";
                                try {
                                        password = encriptar.hash(GUIVerificarPassword.getjPasswordField1().getText());
                                } catch (Exception e1) {
                                        e1.printStackTrace();
                                }
                                if      (password.compareTo(usuario.getPassword())!=0){
                                        JOptionPane.showMessageDialog(frame,"La contraseña es incorrecta.","Atención!", JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                        correcto = true;
                                }
                        }
                }
                catch (Exception e) {
                }
        }

        
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
                Object source = arg0.getSource();
                if (this.GUIVerificarPassword.getjButton1() == source || this.GUIVerificarPassword.getjMenuItem1() == source) {
                        buscar();
                        GUIVerificarPassword.dispose();
                }
                if (this.GUIVerificarPassword.getjButton2() == source || this.GUIVerificarPassword.getjMenuItem2() == source){
                        GUIVerificarPassword.dispose();
                }
                if (GUIVerificarPassword.getjMenu2()==source){
                	new MediadorVersion();
                }
        }
                
        /**
         * @return the busco
         */
        public boolean getCorrecto() {
                return correcto;
        }
        

        @Override
        public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub
                
        }

        @Override
        public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub
                
        }
        public static void main (String args[]){
        	new MediadorVerificarPassword("33", "nbettiol");
        }
        
}