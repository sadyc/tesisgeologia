package comun;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * Permite obtener una imagen a raiz de la fuente (recurso) pasado
 * 
 * @author Bettiol Nicolas
 * @author Rumie Vittar Pablo
 * @author Velez Matias
 * 
 * @version 1.0 --- 2010
 *
 *@see java.awt.Graphics;
 *@see java.awt.Image;
 *@see javax.swing.ImageIcon;
 *@see javax.swing.JPanel;
 *
 */


@SuppressWarnings("serial")
public class FondoJPG extends JPanel {

    private Image fondo;

    public FondoJPG() {
    	fondo = new ImageIcon(getClass().getResource("/src/cuReporte/report/image/LogoSCS.jpg")).getImage();
    }

   public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paint(g);
  }
}