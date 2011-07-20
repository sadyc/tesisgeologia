package comun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que se utiliza para que cada mediador extienda a esta clase. 
 * @author TesisGeologia.
 * @version 1.0
 */
public abstract class Mediador implements ActionListener,MouseListener,ItemListener,KeyListener{


	/**
	 * Método que permite visualizar la ventana.
	 */
	public void show(){
	}
	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
	public void actionPerformed(ActionEvent arg0) {
	}
	/**
	 * Método que permite realizar acciones dependiendo a los clicks realizados por el mouse en la ventana.
	 */
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {    
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {

	}
	public void keyPressed(KeyEvent arg0) {

	}
	public void keyReleased(KeyEvent arg0) {

	}
	/**
	 * @Brief Metodo para validar correo electronico.
	 * @param correo, es la direccion de correo electronico a verificar si esa correctamente construida. 
	 * @return si la direccion de correo electronico cumple con la estructura de una direccion de e-mail.
	 */

	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^[\\w\\-\\_]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * @brief Retorna si un valor de DNI es valido.
	 * @param dni, String que sera evaluado. 
	 * @return test, variable booleana que almacena el valor de la validez del dni 
	 */
	public Boolean isDni(String dni){
		boolean test = true;
		if (dni.length()!=10){
			test = false;
		}else{
			if ((dni.charAt(0)>= 48 && dni.charAt(0)<= 57) && (dni.charAt(1)>= 48 && dni.charAt(1)<= 57)
					&& (dni.charAt(2)== 46) && (dni.charAt(3)>= 48 && dni.charAt(3)<= 57)
					&&(dni.charAt(4)>= 48 && dni.charAt(4)<= 57) && (dni.charAt(5)>= 48 && dni.charAt(5)<= 57)
					&& (dni.charAt(6)== 46) && (dni.charAt(7)>= 48 && dni.charAt(7)<= 57)
					&&(dni.charAt(8)>= 48 && dni.charAt(8)<= 57) && (dni.charAt(9)>= 48 && dni.charAt(9)<= 57)){
				test=true;
			}
			else{
				test = false;
			}

		}
		return test;
	}
	public Boolean isCuit (String cuil){
		boolean test = true;
		if (cuil.length()!=13){
			test = false;
		}
		else{
			String num = cuil.substring(0, 2);
			if (((num.compareTo("34")==0) ||(num.compareTo("24")==0) ||(num.compareTo("20")==0) ||(num.compareTo("23")==0) ||(num.compareTo("27")==0) ||(num.compareTo("30")==0) || (num.compareTo("33")==0))&& (cuil.charAt(2) ==45) && (cuil.charAt(3) >=48 && cuil.charAt(3)<=57)
					&& (cuil.charAt(4) >=48 && cuil.charAt(4)<=57)&& (cuil.charAt(5) >=48 && cuil.charAt(5)<=57)&& (cuil.charAt(6) >=48 && cuil.charAt(6)<=57)
					&& (cuil.charAt(7) >=48 && cuil.charAt(7)<=57)&& (cuil.charAt(8) >=48 && cuil.charAt(8)<=57)&& (cuil.charAt(9) >=48 && cuil.charAt(9)<=57)
					&& (cuil.charAt(10) >=48 && cuil.charAt(10)<=57) && (cuil.charAt(11) ==45) && (cuil.charAt(12) >=48 && cuil.charAt(12)<=57)){
				test = true;
			}
			else{
				test = false;
			}
		}
		return test;
	}
    
    
    public Boolean isCuil (String cuil){
    	boolean test = true;
    	if (cuil.length()!=13){
    		test = false;
    	}
    	else{
    		String num = cuil.substring(0, 1);
      		if (((num.compareTo("30")==0) || (num.compareTo("33")==0))&& (cuil.charAt(2) ==45) && (cuil.charAt(3) >=48 && cuil.charAt(3)<=57)
      				&& (cuil.charAt(4) >=48 && cuil.charAt(4)<=57)&& (cuil.charAt(5) >=48 && cuil.charAt(5)<=57)&& (cuil.charAt(6) >=48 && cuil.charAt(6)<=57)
      				&& (cuil.charAt(7) >=48 && cuil.charAt(7)<=57)&& (cuil.charAt(8) >=48 && cuil.charAt(8)<=57)&& (cuil.charAt(9) >=48 && cuil.charAt(9)<=57)
      				&& (cuil.charAt(10) >=48 && cuil.charAt(10)<=57) && (cuil.charAt(11) ==45) && (cuil.charAt(12) >=48 && cuil.charAt(12)<=57)){
    			test = true;
    		}
      		else{
      			test = false;
      		}
    	}
    	return test;
    }
    
}
