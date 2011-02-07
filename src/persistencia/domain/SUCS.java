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
 * Clase que se utiliza para la clasificacion de la muestra de la 
 * forma SUCS.
 * @author TesisGeologia
 * @version 1.0
 */
@PersistenceCapable
public class SUCS extends Clasificacion {
	
	protected Collection<Muestra> muestras = new HashSet();
	
	/**
	 * @brief Constructor por defecto.
	 */
	public SUCS(){
		super();
	}
	
	/**
	 * Constructor con pasaje de parametros.
	 * @param clasificacion.
	 */
	public SUCS(String clasificacion){
		Frame frame = new Frame();
		String nombreAux = new String();
		String descripcionAux = new String();
		if (clasificacion.equals("ML") || clasificacion.equals("CL") || clasificacion.equals("OL") || clasificacion.equals("MH") || clasificacion.equals("CH")||clasificacion.equals("OH")||clasificacion.equals("PT")||clasificacion.equals("SW")||clasificacion.equals("SP")||clasificacion.equals("SC")||clasificacion.equals("SM")||clasificacion.equals("GW")||clasificacion.equals("GP")||clasificacion.equals("GM")||clasificacion.equals("GC")){
			if (clasificacion.equals("ML")) {
				nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - ML";
				descripcionAux="Limos inorgánicos y arenas muy finas, limos límpios, arenas finas, limosas o arcillosa, o limos arcillosos con ligera plásticidad.";
			} else {
				if (clasificacion.equals("CL")) {
					nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - CL";
					descripcionAux="Arcillas inorgánicas de plasticidad baja a media, arcillas con grava, arcillas arenosas, arcillas limosas.";
				} else {
					if (clasificacion.equals("OL")) {
						nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor de 50 - OL";
						descripcionAux="Limos orgánicos y arcillas orgánicas limosas de baja plasticidad.";
					} else {
						if (clasificacion.equals("MH")){
							nombreAux= "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - MH";
							descripcionAux="Limos inorgánicos, suelos arenosos finos o limosos con mica o diatomeas, limos elásticos.";
						}
						else{
							if (clasificacion.equals("CH")) {
								nombreAux= "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - CH";
								descripcionAux="Arcillas inorgánicas de plasticidad alta.";
							} else {
								if (clasificacion.equals("OH")) {
									nombreAux= "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - OH";
									descripcionAux="Arcillas orgánicas de plasticidad media a elevada; limos orgánicos.";
								} else {
									if (clasificacion.equals("PT")) {
										nombreAux= "Muy Organicos - PT";
										descripcionAux= "Turba y otros suelos de alto contenido orgánico.";
									} else {
										if (clasificacion.equals("SW")) {
											nombreAux= "Grano Grueso - Arenas - Arenas Limpias - SW";
											descripcionAux="Arenas bien graduadas, arenas con grava, pocos finos o  sin finos.";
										} else {
											if (clasificacion.equals("SP")) {
												nombreAux= "Grano Grueso - Arenas - Arenas Limpias - SP";
												descripcionAux="Arenas mal graduadas, arenas con grava, pocos finos o sin finos.";
											} else {
												if (clasificacion.equals("SC")) {
													nombreAux= "Grano Grueso - Arenas - Arenas con Finos - SC";
													descripcionAux="Arenas arcillosas, mezclas arena-arcilla.";
												} else {
													if (clasificacion.equals("SM")) {
														nombreAux= "Grano Grueso - Arenas - Arenas con Finos - SM";
														descripcionAux="Arenas limosas, mezclas de arena y limo.";
													} else {
														if (clasificacion.equals("GW")) {
															nombreAux= "Grano Grueso - Gravas - Gravas Limpias - GW";
															descripcionAux="Gravas, bien graduadas, mezclas grava-arena, pocos finos  o sin finos.";
														} else {
															if (clasificacion.equals("GP")) {
																nombreAux= "Grano Grueso - Gravas - Gravas Limpias - GP";
																descripcionAux="Gravas mal graduadas, mezclas grava-arena, pocos finos o sin finos.";
															} else {
																if (clasificacion.equals("GM")) {
																	nombreAux= "Grano Grueso - Gravas - Gravas con Finos - GM";
																	descripcionAux="Gravas limosas, mezclas grava-arena-limo.";
																} else {
																	nombreAux= "Grano Grueso - Gravas - Gravas con Finos - GC";
																	descripcionAux="Gravas arcillosas, mezclas grava-arena-arcilla.";
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(frame,"Estan mal pasados los nombres de la clasificacion","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);	
		}
		this.clasificacion = clasificacion;
		this.nombre =nombreAux;
		this.descripcion= descripcionAux;
		
	}
	/**
	 * Asigna la descripcion correspondiente de la clasificacion.
	 * @param nombre, nombre de la clasificacion.
	 */
	public void setClasificacionSUCS(String clasificacion) {
		
	}
	
}
