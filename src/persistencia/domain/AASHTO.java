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
 * Clase que define una clasificacion aashto.
 * @author TesisGeologia.
 * @version 1.0.
 */
@PersistenceCapable
public class AASHTO extends Clasificacion{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Collection<Muestra> muestras = new HashSet();
	
	/**
	 * @brief Constructor por defecto.
	 */
	public AASHTO() {
		super();
	}
	
	/**
	 * Constructor con pasaje de parametros.
	 * @param clasificacion.
	 */
	public AASHTO(String clasificacion){
		String nombreAux = new String();
		String descripcionAux = new String();
		Frame frame = new Frame();
		if (clasificacion.equals("A1a")|| clasificacion.equals("A1b")|| clasificacion.equals("A3")|| clasificacion.equals("A24")|| clasificacion.equals("A25")|| clasificacion.equals("A26")|| clasificacion.equals("A27")|| clasificacion.equals("A4")|| clasificacion.equals("A5")|| clasificacion.equals("A6")|| clasificacion.equals("A7")|| clasificacion.equals("A75")|| clasificacion.equals("A76")){
			if (clasificacion.equals("A1a")|| clasificacion.equals("A1b") ) {
				nombreAux = "Granulares - A1 - "+clasificacion;
				descripcionAux="Suelo con fragmentos de roca, grava y arena con caracteristicas como subgrado de excelente a bueno";
			}
			else{
				if (clasificacion.equals("A3")) {
					nombreAux = "Granulares - "+clasificacion;
					descripcionAux="Suelo con arena fina como componente principal y con caracteristicas como subgrado de excelente a bueno";
				}
				else {
					if (clasificacion.equals("A24")||clasificacion.equals("A25")||clasificacion.equals("A26")||clasificacion.equals("A27")) {
						nombreAux = "Granulares - A2 - "+clasificacion;
						descripcionAux = "Suelo con grava y arena arcillosa o limosa, con caracteristicas como subgrado de excelente a bueno";
					} else {
						if (clasificacion.equals("A4")||clasificacion.equals("A5")) {
							nombreAux = "Limoso Arcilloso - "+clasificacion;
							descripcionAux = "Suelo limoso con caracteristicas como subgrado de pobre a malo";
						}
						else{
							nombreAux = "Limoso Arcilloso - "+clasificacion;
							descripcionAux = "Suelo arcilloso con caracteristicas como subgrado de pobre a malo";
						}
					}
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(frame,"Estan mal pasados los nombres de la clasificación","ERROR!!!", JOptionPane.ERROR_MESSAGE);
		}
		this.clasificacion = clasificacion;
		this.nombre =nombreAux;
		this.descripcion= descripcionAux;
		
	}
	
}
