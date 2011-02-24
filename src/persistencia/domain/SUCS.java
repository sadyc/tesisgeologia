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
		if (clasificacion.equals("ML")) {
				nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - ML";
				descripcionAux="Limos inorgánicos, arenas muy finas y arcillosa, con ligera plásticidad.";
			} else {
				if (clasificacion.equals("CL")) {
					nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor a 50 - CL";
					descripcionAux="Arcillas inorgánicas de plasticidad baja a media, arcillas con grava.";
				} else {
					if (clasificacion.equals("OL")) {
						nombreAux= "Grano Fino - Limos y Arcillas con limite liquido menor de 50 - OL";
						descripcionAux="Limos orgánicos y arcillas orgánicas limosas de baja plasticidad.";
					} else {
						if (clasificacion.equals("MH")){
							nombreAux= "Grano Fino - Limos y Arcillas con limite liquido mayor a 50 - MH";
							descripcionAux="Limos inorgánicos, suelos arenosos finos o limosos con mica o diatomeas.";
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
																	if (clasificacion.equals("GC")){
																		nombreAux= "Grano Grueso - Gravas - Gravas con Finos - GC";
																		descripcionAux="Gravas arcillosas, mezclas grava-arena-arcilla.";
																		//clasificacion.equals("GW-GM")clasificacion.equals("GW-GC")clasificacion.equals("GP-GM")clasificacion.equals("GP-GC");
																	}else{
																		if (clasificacion.equals("GW-GM")) {
																			nombreAux= "Grano Grueso - Gravas - Gravas con Finos - GW-GM";
																			descripcionAux="Grava bien graduada con limo.";
																		}else{
																			if (clasificacion.equals("GW-GC")) {
																				nombreAux = "Grano Grueso - Gravas - Gravas con Finos - GW-GC";
																				descripcionAux="Grava bien graduada con arcilla.";
																			}else{
																				if (clasificacion.equals("GP-GM")){
																					nombreAux = "Grano Grueso - Gravas - Gravas con Finos - GP-GM";
																					descripcionAux="Grava mal graduada con limo.";
																				}else{
																					if (clasificacion.equals("GP-GC")){
																						nombreAux = "Grano Grueso - Gravas - Gravas con Finos - GP-GC";
																						descripcionAux="Grava mal graduada con arcilla.";
																					}else{
																						if (clasificacion.equals("SW-SM")){
																							nombreAux = "Grano Grueso - Arenas - Arenas con Finos - SC";
																							descripcionAux="Arena bien graduada con limo.";
																						}else{
																							if (clasificacion.equals("SW-SC")){
																								nombreAux = "Grano Grueso - Arenas - Arenas con Finos - SC";
																								descripcionAux="Arena bien graduada con arcilla.";
																							}else{
																								if (clasificacion.equals("SP-SM")){
																									nombreAux = "Grano Grueso - Arenas - Arenas con Finos - SC";
																									descripcionAux="Arena mal graduada con limo.";
																								}else{
																									nombreAux = "Grano Grueso - Arenas - Arenas con Finos - SC";
																									descripcionAux="Arena mal graduada con arcilla.";
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
									}
								}
							}
						}
					}
				}
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
