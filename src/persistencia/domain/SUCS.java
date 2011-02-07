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
	 * Asigna la descripcion correspondiente de la clasificacion.
	 * @param nombre, nombre de la clasificacion.
	 */
	public void setClasificacionSUCS(String nombre) {
		Frame frame = new Frame();
		if (nombre.equals("ML") || nombre.equals("CL") || nombre.equals("OL") || nombre.equals("MH") || nombre.equals("CH")||nombre.equals("OH")||nombre.equals("PT")||nombre.equals("SW")||nombre.equals("SP")||nombre.equals("SC")||nombre.equals("SM")||nombre.equals("GW")||nombre.equals("GP")||nombre.equals("GM")||nombre.equals("GC")){
			if (nombre.equals("ML")) {
				this.nombre = "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - ML";
				this.descripcion="Limos inorgánicos y arenas muy finas, limos límpios, arenas finas, limosas o arcillosa, o limos arcillosos con ligera plásticidad.";
			} else {
				if (nombre.equals("CL")) {
					this.nombre = "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - CL";
					this.descripcion="Arcillas inorgánicas de plasticidad baja a media, arcillas con grava, arcillas arenosas, arcillas limosas.";
				} else {
					if (nombre.equals("OL")) {
						this.nombre = "Grano Fino - Limos y Arcillas con limite liquido menor de 50 - OL";
						this.descripcion="Limos orgánicos y arcillas orgánicas limosas de baja plasticidad.";
					} else {
						if (nombre.equals("MH")){
							this.nombre = "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - MH";
							this.descripcion="Limos inorgánicos, suelos arenosos finos o limosos con mica o diatomeas, limos elásticos.";
						}
						else{
							if (nombre.equals("CH")) {
								this.nombre = "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - CH";
								this.descripcion="Arcillas inorgánicas de plasticidad alta.";
							} else {
								if (nombre.equals("OH")) {
									this.nombre = "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - OH";
									this.descripcion="Arcillas orgánicas de plasticidad media a elevada; limos orgánicos.";
								} else {
									if (nombre.equals("PT")) {
										this.nombre = "Muy Organicos - PT";
										this.descripcion = "Turba y otros suelos de alto contenido orgánico.";
									} else {
										if (nombre.equals("SW")) {
											this.nombre = "Grano Grueso - Arenas - Arenas Limpias - SW";
											this.descripcion="Arenas bien graduadas, arenas con grava, pocos finos o  sin finos.";
										} else {
											if (nombre.equals("SP")) {
												this.nombre = "Grano Grueso - Arenas - Arenas Limpias - SP";
												this.descripcion="Arenas mal graduadas, arenas con grava, pocos finos o sin finos.";
											} else {
												if (nombre.equals("SC")) {
													this.nombre = "Grano Grueso - Arenas - Arenas con Finos - SC";
													this.descripcion="Arenas arcillosas, mezclas arena-arcilla.";
												} else {
													if (nombre.equals("SM")) {
														this.nombre = "Grano Grueso - Arenas - Arenas con Finos - SM";
														this.descripcion="Arenas limosas, mezclas de arena y limo.";
													} else {
														if (nombre.equals("GW")) {
															this.nombre = "Grano Grueso - Gravas - Gravas Limpias - GW";
															this.descripcion="Gravas, bien graduadas, mezclas grava-arena, pocos finos  o sin finos.";
														} else {
															if (nombre.equals("GP")) {
																this.nombre = "Grano Grueso - Gravas - Gravas Limpias - GP";
																this.descripcion="Gravas mal graduadas, mezclas grava-arena, pocos finos o sin finos.";
															} else {
																if (nombre.equals("GM")) {
																	this.nombre = "Grano Grueso - Gravas - Gravas con Finos - GM";
																	this.descripcion="Gravas limosas, mezclas grava-arena-limo.";
																} else {
																	this.nombre = "Grano Grueso - Gravas - Gravas con Finos - GC";
																	this.descripcion="Gravas arcillosas, mezclas grava-arena-arcilla.";
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
	}
	
}
