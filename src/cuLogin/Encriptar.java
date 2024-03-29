package cuLogin;
import java.security.MessageDigest;
/**
 * Esta clase define el metodo para encriptar un string como contraseña.
 * 
 * @author tesisGeologia.
 * 
 * @version 1.0
 */
public class Encriptar {
	
    public Encriptar(){}


	/**
	* Encripta un String con el algoritmo MD5.
	* @return String
	* @throws Exception
	*/
	public String hash(String clear) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(clear.getBytes());
		int size = b.length;
		StringBuffer h = new StringBuffer(size);
			for (int i = 0; i < size; i++) {
				int u = b[i]&255;
				if (u<16){
					h.append("0"+Integer.toHexString(u));
				}else {
		h.append(Integer.toHexString(u));
				}
		}
		
		return h.toString();
	} 
		
}
