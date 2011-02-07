/**
 * 
 */
package persistencia.domain;

import java.awt.Frame;
import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.PersistenceCapable;
import javax.swing.JOptionPane;


/**
 * @author TesisGeologia.
 * @version 1.0.
 */
@PersistenceCapable
public class AASHTO extends Clasificacion{
	Frame frame;
	protected Collection<Muestra> muestras = new HashSet();
	/**
	 * @brief Constructor por defecto.
	 * @param nombre, nombre de la clasific
	 */
	public AASHTO() {
		super();
	}
	
	
	public void setClasificacionAASHTO(String nombre) {
		System.out.println(nombre);
		if (nombre.equals("A1a")|| nombre.equals("A1b")|| nombre.equals("A3")|| nombre.equals("A24")|| nombre.equals("A25")|| nombre.equals("A26")|| nombre.equals("A27")|| nombre.equals("A4")|| nombre.equals("A5")|| nombre.equals("A6")|| nombre.equals("A7")|| nombre.equals("A75")|| nombre.equals("A76")){
			if (nombre.equals("A1a")|| nombre.equals("A1b") ) {
				this.nombre = "Granulares - A1 - "+nombre;
				this.descripcion="Suelo con fragmentos de roca, grava y arena como componente principal y con caracteristicas como subgrado de excelente a bueno";
			}
			else{
				if (nombre.equals("A3")) {
					this.nombre = "Granulares - "+nombre;
					descripcion="Suelo con arena fina como componente principal y con caracteristicas como subgrado de excelente a bueno";
				}
				else {
					if (nombre.equals("A24")||nombre.equals("A25")||nombre.equals("A26")||nombre.equals("A27")) {
						this.nombre = "Granulares - A2 - "+nombre;
						this.descripcion = "Suelo con grava y arena arcillosa o limosa como componente principal y con caracteristicas como subgrado de excelente a bueno";
					} else {
						if (nombre.equals("A4")||nombre.equals("A5")) {
							this.nombre = "Limoso Arcilloso - "+nombre;
							this.descripcion = "Suelo limoso con caracteristicas como subgrado de pobre a malo";
						}
						else{
							this.nombre = "Limoso Arcilloso - "+nombre;
							this.descripcion = "Suelo arcilloso con caracteristicas como subgrado de pobre a malo";
						}
					}
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(frame,"Estan mal pasados los nombres de la clasificacion","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
