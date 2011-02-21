/**
 * 
 */
package comun;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
* @brief Clase que se utiliza para crear un panel con una imagen que se utilizará como fondo de la ventana principal.
* @author TesisGeología
* @version 1.0
*/
public class PanelConFondo extends JPanel {
    private Image imagen;

    
	/**
	 * Constructor por defecto de la clase.
	 */
    public PanelConFondo() {
        imagen = new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage();
        
    }

    /**
     * Constructor parametrizado de la clase.
     * @param imagenInicial, es la imagen que contiene el panel.
     */
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


