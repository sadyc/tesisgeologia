/**
 * 
 */
package cuCalcularClasificacion;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import persistencia.Persistencia;
import persistencia.domain.AASHTO;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.SUCS;
import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
 * @author TesisGeologia
 * @version 1.0
 */
public class ControlClasificacion {
	 public static String BASE = (new java.io.File("")).getAbsolutePath(); 
 	 public static String PATH_SOURCE_REPORT = BASE + "/src/cuCalcularClasificacion/";
	/**
	 * Constructor por defecto de la clase.
	 */
	public ControlClasificacion(){}
	
		
	/** 
	 * Realiza los calculos correspondientes para determinar la clasificacion de una muestra.
	 * @param muestra 
	 */
	public void calcularClasificacionSUCS(Muestra muestra) throws Exception{
		Float IndicePlasticidad = muestra.getIndicePlasticidad();
		Float limiteLiquido = muestra.getLimiteLiquido();
		calcularDiametro(muestra);
		
		muestra.setCoeficienteUniformidad(muestra.getD60()/muestra.getD10());//Coeficiente de uniformidad
		Float gradoCurvatura = ((muestra.getD30()*muestra.getD30()) /(muestra.getD10()*muestra.getD60()));//grado de curvatura.
		muestra.setGradoCurvatura(gradoCurvatura);
		String clasificacion= new String(); 
		
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try{
			Analisis analisis = new Analisis();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'"; 
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
			System.out.println(muestra.getNombreMuestra());
			if (analisis.getPorcentajePasante()<=50){
				//suelo de particulas gruesas
				analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='4'");
				if (analisis.getPorcentajePasante()<=50){
					//Gravas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<5){
						//GravasLimpias
						if((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3)){
							//GW
							clasificacion="GW";
						}else {
							//GP
							clasificacion="GP";
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Gravas con finos
						if (IndicePlasticidad<4){
							//GM
							clasificacion="GM";
						}
						else if (IndicePlasticidad>7){
							//GC
							clasificacion=("GC");
						}
					}else{
						//Gravas Limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//GW-GM
						}else if(IndicePlasticidad<4 && IndicePlasticidad>7){
							//GW-GC
						}else if((IndicePlasticidad<4) && !((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3))){
							//GP-GM
						}else{
							//GP-GC
						}
					}
				}
				else{
					//Arenas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<=5){
						//Arenas Limpias
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) ){
							//SW
							clasificacion=("SW");
						}else {
							//SP
							clasificacion=("SP");
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Arenas con finos
						if (IndicePlasticidad<4){
							//SM
							clasificacion=("SM");
						}else{
							//SC
							clasificacion=("SC");
						}
					}else{
						//arenas limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//SW-SM
						}else if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SW-SC
						}else if (!((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura())) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SP-SM
						}else{
							//SP-SC
						}
						
					}
					
				}
			}
			else {
				//suelo de particulas finas
				if (limiteLiquido<=50){
					//Limos y arcillas
					if ((IndicePlasticidad>7)){
						//CL
						clasificacion=("CL");
					}else if (IndicePlasticidad<4){
						//ML
						clasificacion=("ML");
					}else if (limiteLiquido<0.75){
						//OL
						clasificacion=("OL");
					}
				}else {
					//limos y arcilla > 50
					if ((IndicePlasticidad>7)){
						//CH
						clasificacion=("CH");
					}else if (IndicePlasticidad<4){
						//MH
						clasificacion=("MH");
					}else if (limiteLiquido<0.75){
						//OH
						clasificacion=("OH");
					}
				}
			}
			SUCS clasificacionSUCS = new SUCS();
			clasificacionSUCS =((SUCS)persistencia.buscarObjeto(clasificacionSUCS.getClass(), "clasificacion=='"+clasificacion+"'"));
			muestra = ((Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'"));
			muestra.setSucs(clasificacionSUCS);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e){
			persistencia.realizarRollback();
		}
				
	}
	
	/**
	 * Realiza los calculos correspondientes para determinar la clasificacion de una muestra.
	 * @param muestra 
	 */
	public void calcularClasificacionAASHTO(Muestra muestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		
		String clasificacion= new String();
		Float IndicePlasticidad = muestra.getIndicePlasticidad();
		Float limiteLiquido = muestra.getLimiteLiquido();
		calcularDiametro(muestra);
		
		muestra.setCoeficienteUniformidad(muestra.getD60()/muestra.getD10());//Coeficiente de uniformidad
		Float gradoCurvatura = ((muestra.getD30()*muestra.getD30()) /(muestra.getD10()*muestra.getD60()));//grado de curvatura.
		muestra.setGradoCurvatura(gradoCurvatura);
		try{
			Analisis analisis = new Analisis();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'";
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='10'");
			System.out.println(muestra.getNombreMuestra());
			if (analisis.getPorcentajePasante()<50){
				clasificacion=("A1a");
			}
			else{
				analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='40'");
				if (analisis.getPorcentajePasante()<=50){
					//A-1-b
					clasificacion=("A1b");
				}
				else{
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<10){
						//A-3
						clasificacion=("A3");
					}
					else{
						if (analisis.getPorcentajePasante()<35){
							//A-2
							analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='40'");
							if (analisis.getPorcentajePasante()<=50){
								if (muestra.getIndicePlasticidad()<10){
									//A-2-4
									clasificacion=("A24");
								}
								else{
									//A-2-6
									clasificacion=("A26");
								}
							}	
							else{
								if (muestra.getIndicePlasticidad()<10){
									//A-2-5
									clasificacion=("A25");
								}
								else{
									//A-2-7
									clasificacion=("A27");
								}
							}
						}
						else{
							analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='40'");
							if (analisis.getPorcentajePasante()<=50){
								if (muestra.getIndicePlasticidad()<10){
									//A-2-4
									clasificacion=("A4");
								}
								else{
									//A-2-6
									clasificacion=("A6");
								}
							}	
							else{
								if (muestra.getIndicePlasticidad()<10){
									//A-2-5
									clasificacion=("A5");
								}
								else{
									//A-2-7
									clasificacion=("A7");
								}
							}
						}
					}
				}
			}
			persistencia.cerrarTransaccion();
			persistencia.abrirTransaccion();
			
			AASHTO clasificacionAASHTO = new AASHTO();
			clasificacionAASHTO =((AASHTO)persistencia.buscarObjeto(clasificacionAASHTO.getClass(), "clasificacion=='"+clasificacion+"'"));
			muestra = ((Muestra)persistencia.buscarObjeto(muestra.getClass(), "nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'"));
			muestra.setAashto(clasificacionAASHTO);
			
			persistencia.cerrarTransaccion();
		}
		catch (Exception e){
			System.out.println("No pudo insertar la clasificacion con persistencia");
			e.printStackTrace();
			persistencia.realizarRollback();
		}
				
	}
	
	/**
	 * Metodo que calcula el D60 D30 D10 de una clasifiacion.
	 * @param nombreMuestra
	 * @throws Exception
	 */
	private void calcularDiametro(Muestra muestra) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Analisis analisis = new Analisis();
		List listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"'");
		persistencia.cerrarTransaccion();
		int i = 0;
		boolean d60 = false;//estas variables se ultilizan para no calcular dos veces
		boolean d30 = false;//los diametros.
		boolean d10 = false;
		while (listaAnalisis.size()>i){
			analisis = (Analisis)listaAnalisis.get(i);
			if (analisis.getPorcentajePasante()<60 && !d60){
				//calcular el d60
				double pasante2 = analisis.getPorcentajePasante();
				double abertura2 = analisis.getTamiz().getAberturaMalla();
				analisis = (Analisis)listaAnalisis.get(i-1);
				double pasante1 = analisis.getPorcentajePasante();
				double abertura1 = analisis.getTamiz().getAberturaMalla();
				double exponente = (Math.log10(abertura1)-
						((pasante1-60)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
				Float calculo = new Float(Math.pow(10,exponente));
				muestra.setD60(calculo);
				d60 = true;
			}
			if (analisis.getPorcentajePasante()<30 && !d30){
					//calcular el d30
					double pasante2 = analisis.getPorcentajePasante();
					double abertura2 = analisis.getTamiz().getAberturaMalla();
					analisis = (Analisis)listaAnalisis.get(i-1);
					double pasante1 = analisis.getPorcentajePasante();
					double abertura1 = analisis.getTamiz().getAberturaMalla();
					double exponente = (Math.log10(abertura1)-
							((pasante1-30)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
					Float calculo = new Float(Math.pow(10,exponente));
					muestra.setD30(calculo);
					d30 = true;
					analisis= (Analisis)listaAnalisis.get(i);
				}
				if (analisis.getPorcentajePasante()<10 && !d10){
						//calcular el d10
						double pasante2 = analisis.getPorcentajePasante();
						double abertura2 = analisis.getTamiz().getAberturaMalla();
						analisis = (Analisis)listaAnalisis.get(i-1);
						double pasante1 = analisis.getPorcentajePasante();
						double abertura1 = analisis.getTamiz().getAberturaMalla();
						double exponente = (Math.log10(abertura1)-
								((pasante1-10)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
						Float calculo = new Float(Math.pow(10,exponente));
						muestra.setD10(calculo);
						d10 = true;
					}
				i++;	
		}
		if (!d60) {
			Float aberturaMalla = new Float(analisis.getTamiz().getAberturaMalla());
			muestra.setD60(aberturaMalla);
		}
		if (!d30){
			muestra.setD30(muestra.getD60());
		}
		if (!d10){
			muestra.setD10(muestra.getD30());
		}
	}

	
	/**
	 * Emite grafico de la clasificacion
	 * @throws Exception 
	 */
	public ChartPanel emitirGrafico(Muestra muestra) throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection coleccionAnalisis = control.coleccionAnalisisDeMuestra(clase, muestra);
		Iterator<Analisis> it = coleccionAnalisis.iterator();
		XYSeries series = new XYSeries("Nombre: "+muestra.getNombreMuestra());
		while (it.hasNext()){
			analisis = it.next();
			series.add(analisis.getPorcentajePasante(),analisis.getTamiz().getAberturaMalla());
		}
		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
			
		// Generate the graph
		final NumberAxis rangeAxis = new NumberAxis("% Pasante");
        rangeAxis.setRange(0.0,120);
        
        final NumberAxis domainAxis = new LogarithmicAxis("Tamaño de Particulas en mm");
        domainAxis.setInverted(true);
        domainAxis.setRange(0.01, 100);
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        
        final XYPlot plot1 = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
                
        final JFreeChart chart = new JFreeChart("Curva Granulométrica", plot1);
        chart.setBackgroundPaint(Color.white);   
              
        XYItemRenderer rend = chart.getXYPlot().getRenderer();
        StandardXYItemRenderer rr = (StandardXYItemRenderer)rend;
        rr.setBaseShapesVisible(true);
        rr.setSeriesPaint(0, Color.black);
                
        plot1.setBackgroundPaint(Color.yellow);
        plot1.setDomainCrosshairPaint(Color.black);
        plot1.setDomainMinorGridlinePaint(Color.blue);
        plot1.setDomainGridlinesVisible(true);
        
        plot1.setDomainGridlinePaint(Color.black);
        plot1.setRangeGridlinePaint(Color.black);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 350));
        exportarJPG(plot1,"curvaGranulometrica.jpg");
        return chartPanel;
    }
	
	public void exportarJPG (XYPlot plot, String fileName) throws Exception {
		final XYPlot plot1 = (XYPlot) plot.clone();
		if (fileName.compareTo("curvaGranulometrica.jpg")==0){
			final JFreeChart chart1 = new JFreeChart("Curva Granulométrica", plot1);
			plot1.setBackgroundPaint(Color.white);
			ChartUtilities.saveChartAsJPEG(new File(PATH_SOURCE_REPORT+fileName), chart1, 500, 300);
		}
		else{
			final JFreeChart chart1 = new JFreeChart("Carta de Plasticidad", plot1);
			plot1.setBackgroundPaint(Color.white);
			ChartUtilities.saveChartAsJPEG(new File(PATH_SOURCE_REPORT+fileName), chart1, 500, 300);
		}
	}
	
	/**
	 * Emite grafico de la clasificacion
	 * @throws Exception 
	 */
	public ChartPanel cartaPlasticidad(Muestra muestra) throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		
		final XYSeries series = new XYSeries("Linea A");
		final XYSeries series2 = new XYSeries("Linea U");
		final XYSeries series3 = new XYSeries("Linea B");
		series3.add(0,50);
		series3.add(100,50);
		Float ll= muestra.getLimiteLiquido();
		Float ip= muestra.getIndicePlasticidad();
		
		
		while (ll-20<=100){
			series.add(0.73*(ll-20),ll);
			ll= ll + 5;
		}
		ll = muestra.getLimiteLiquido();
		series2.add(0,8);
		while (ll-20<=100){
			series2.add(0.9*(ll-8),ll);
			ll= ll + 5;
		}
		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
			
		// Generate the graph
		final NumberAxis rangeAxis = new NumberAxis("Indice de Plasticidad, IP");
        rangeAxis.setRange(0.0,60);
        
        final NumberAxis domainAxis = new NumberAxis("Limite Liquido, LL");
        domainAxis.setRange(0.0, 100);
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        
        final XYPlot plot1 = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
                
        final JFreeChart chart = new JFreeChart("Carta de Plasticidad", plot1);
        chart.setBackgroundPaint(Color.white);
        plot1.getRenderer().setSeriesStroke(1, new BasicStroke( 
        	        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
        	        1.0f, new float[] {6.0f, 6.0f}, 0.0f 
        	    ));
                      
        plot1.setBackgroundPaint(Color.yellow);
        plot1.setDomainCrosshairPaint(Color.black);
        plot1.setDomainMinorGridlinePaint(Color.blue);
        plot1.setDomainGridlinesVisible(true);
        
        plot1.setDomainGridlinePaint(Color.black);
        plot1.setRangeGridlinePaint(Color.black);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 350));
        exportarJPG(plot1,"cartaPlasticidad.jpg");
        return chartPanel;
    }
	
	/**
	 * Busca un analisis y retorna un valor booleano 
	 * con el resultado de la busqueda.
	 * @param tamiz
	 * @return
	 * @throws Exception
	 */
	public boolean buscarAnalisis(String tamiz) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Analisis aux = new Analisis();
		aux = (Analisis)persistencia.buscarObjeto(aux.getClass(),"tamiz.numeroTamiz=='"+tamiz+"'");
		if(aux==null){
			return false;
		}else{
			return true;
		}
		
	}
}
