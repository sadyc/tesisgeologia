/**
 * 
 */
package comun;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
    private Image imagen;

    
	
    public PanelConFondo() {
        imagen = new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage();
        
    }

	    public PanelConFondo(Image imagenInicial) {
	        if (imagenInicial != null) {
	            imagen = imagenInicial;
	        }
	    }

	    @Override
	    public void paint(Graphics g) {
	        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);

	        setOpaque(false);
	        
	        super.paint(g);
	    }
	}


