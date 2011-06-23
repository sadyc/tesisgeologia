/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.BasicStroke;
import java.awt.Color;
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

import comun.Control;

import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
 * @brief Clase que se utiliza para gestionar los datos con persistencia en la base de datos del sistema.
 * @author TesisGeologia
 * @version 1.0
 */
public class ControlClasificacion extends Control {
	 public static String BASE = (new java.io.File("")).getAbsolutePath(); 
 	 public static String PATH_SOURCE_REPORT = BASE + "/src/cuCalcularClasificacion/";
 	 public String filtro;
 	 
	/**
	 * Constructor por defecto de la clase.
	 */
	public ControlClasificacion(){}
			
	/** 
	 * Realiza los calculos correspondientes para determinar la clasificacion SUCS de una muestra.
	 * @param muestra, muestra a calcularle la clasificaciÃ³n. 
	 */
	public SUCS calcularClasificacionSUCS(Muestra muestra) throws Exception{
		Float IndicePlasticidad = muestra.getIndicePlasticidad();
		Float limiteLiquido = muestra.getLimiteLiquido();
		calcularDiametro(muestra);
		muestra.setCoeficienteUniformidad(truncaNum(muestra.getD60()/muestra.getD10()));//Coeficiente de uniformidad
		Float gradoCurvatura = (truncaNum((muestra.getD30()*muestra.getD30()) /(muestra.getD10()*muestra.getD60())));//grado de curvatura.
		muestra.setGradoCurvatura(gradoCurvatura);
		String clasificacion= new String(); 
		filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'";
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		SUCS clasificacionSUCS = new SUCS();
		try{
			Analisis analisis = new Analisis();
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
			if (analisis.getPorcentajePasante()<=50){
				//suelo de particulas gruesas
				analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='4'");
				if (analisis.getPorcentajePasante()<=50){
					//Gravas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<5){
						//GravasLimpias
						if((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3)){
							clasificacion="GW";
						}else {
							clasificacion="GP";
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Gravas con finos
						if (IndicePlasticidad<4){
							clasificacion="GM";
						}
						else if (IndicePlasticidad>7){
							clasificacion=("GC");
						}
					}else{
						//Gravas Limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							clasificacion=("GW-GM");
						}else if(IndicePlasticidad<4 && IndicePlasticidad>7){
							clasificacion=("GW-GC");
						}else if((IndicePlasticidad<4) && !((muestra.getCoeficienteUniformidad()>=4) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3))){
							clasificacion=("GP-GM");
						}else{
							clasificacion=("GP-GC");
						}
					}
				}
				else{
					//Arenas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<=5){
						//Arenas Limpias
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) ){
							clasificacion=("SW");
						}else {
							clasificacion=("SP");
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Arenas con finos
						if (IndicePlasticidad<4){
							clasificacion=("SM");
						}else{
							clasificacion=("SC");
						}
					}else{
						//arenas limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//SW-SM
							clasificacion=("SW-SM");
						}else if ((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura()) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SW-SC
							clasificacion=("SW-SC");
						}else if (!((muestra.getCoeficienteUniformidad()>=6) && (1<=muestra.getGradoCurvatura())) && (muestra.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SP-SM
							clasificacion=("SP-SM");
						}else{
							//SP-SC
							clasificacion=("SP-SC");
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
			persistencia.cerrarTransaccion();
			persistencia.abrirTransaccion();
			System.out.println(clasificacion);
			clasificacionSUCS =((SUCS)persistencia.buscarObjeto(clasificacionSUCS.getClass(), "clasificacion=='"+clasificacion+"'"));
			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(),"nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
			muestra.setSucs(clasificacionSUCS);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e){
			persistencia.realizarRollback();
		}
			return clasificacionSUCS;	
	}
	
	/**
	 * Realiza los calculos correspondientes para determinar la clasificaciÃ³n AASHTO de una muestra.
	 * @param muestra, muestra a calcularle clasificaciÃ³n. 
	 */
	public AASHTO calcularClasificacionAASHTO(Muestra muestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		String clasificacion= new String();
		AASHTO clasificacionAASHTO = new AASHTO();
		filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'";
		calcularDiametro(muestra);
		muestra.setCoeficienteUniformidad(truncaNum(muestra.getD60()/muestra.getD10()));
		Float gradoCurvatura = (truncaNum(muestra.getD30()*muestra.getD30()) /(muestra.getD10()*muestra.getD60()));//grado de curvatura.
		muestra.setGradoCurvatura(gradoCurvatura);
		try{
			Analisis analisis = new Analisis();
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='10'");
			if (analisis.getPorcentajePasante()<50){
				clasificacion=("A1a");
			}
			else{
				analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='40'");
				if (analisis.getPorcentajePasante()<=50){
					clasificacion=("A1b");
				}
				else{
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), filtro+" && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<10){
						clasificacion=("A3");
					}
					else{
						if (analisis.getPorcentajePasante()<35){
							Float limiteLiquido = muestra.getLimiteLiquido();
							if (limiteLiquido<=40){
								if (muestra.getIndicePlasticidad()<10){
									clasificacion=("A24");
								}
								else{
									clasificacion=("A26");
								}
							}	
							else{
								if (muestra.getIndicePlasticidad()<10){
									clasificacion=("A25");
								}
								else{
									clasificacion=("A27");
								}
							}
						}
						else{
							Float limiteLiquido = muestra.getLimiteLiquido();
							if (limiteLiquido<=40){
								if (muestra.getIndicePlasticidad()<10){
									clasificacion=("A4");
								}
								else{
									clasificacion=("A6");
								}
							}	
							else{
								if (muestra.getIndicePlasticidad()<10){
									clasificacion=("A5");
								}
								else{
									clasificacion=("A7");
								}
							}
						}
					}
				}
			}
			persistencia.cerrarTransaccion();
			persistencia.abrirTransaccion();
			clasificacionAASHTO =((AASHTO)persistencia.buscarObjeto(clasificacionAASHTO.getClass(), "clasificacion=='"+clasificacion+"'"));
			muestra = (Muestra)persistencia.buscarObjeto(muestra.getClass(),"nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
			muestra.setAashto(clasificacionAASHTO);
			muestra.setCoeficienteUniformidad(truncaNum(muestra.getD60()/muestra.getD10()));
			muestra.setGradoCurvatura(gradoCurvatura);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e){
			System.out.println("No pudo insertar la clasificaciï¿½n con persistencia");
			persistencia.realizarRollback();
		}
		return clasificacionAASHTO;
	}
	
	/**
	 * Metodo que calcula el D60 D30 D10 de una clasifiaciÃ³n.
	 * @param muestra.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private void calcularDiametro(Muestra muestra) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Analisis analisis = new Analisis();
		filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'";
		List listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), filtro);
		persistencia.cerrarTransaccion();
		int i = 0;
		boolean d60 = false;
		boolean d30 = false;
		boolean d10 = false;
		while (listaAnalisis.size()>i){
			analisis = (Analisis)listaAnalisis.get(i);
			if (analisis.getPorcentajePasante()<60 && !d60){
				double pasante2 = analisis.getPorcentajePasante();
				double abertura2 = analisis.getTamiz().getAberturaMalla();
				analisis = (Analisis)listaAnalisis.get(i-1);
				double pasante1 = analisis.getPorcentajePasante();
				double abertura1 = analisis.getTamiz().getAberturaMalla();
				double exponente = (Math.log10(abertura1)-((pasante1-60)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
				Float calculo = new Float(Math.pow(10,exponente));
				muestra.setD60(truncaNum(calculo));
				analisis= (Analisis)listaAnalisis.get(i);
				d60 = true;
			}
			if (analisis.getPorcentajePasante()<30 && !d30){
				double pasante2 = analisis.getPorcentajePasante();
				double abertura2 = analisis.getTamiz().getAberturaMalla();
				analisis = (Analisis)listaAnalisis.get(i-1);
				double pasante1 = analisis.getPorcentajePasante();
				double abertura1 = analisis.getTamiz().getAberturaMalla();
				double exponente = (Math.log10(abertura1)-((pasante1-30)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
				Float calculo = new Float(Math.pow(10,exponente));
				muestra.setD30(truncaNum(calculo));
				d30 = true;
				analisis= (Analisis)listaAnalisis.get(i);
			}
			if (analisis.getPorcentajePasante()<10 && !d10){
				double pasante2 = analisis.getPorcentajePasante();
				double abertura2 = analisis.getTamiz().getAberturaMalla();
				analisis = (Analisis)listaAnalisis.get(i-1);
				double pasante1 = analisis.getPorcentajePasante();
				double abertura1 = analisis.getTamiz().getAberturaMalla();
				double exponente = (Math.log10(abertura1)-((pasante1-10)*(Math.log10(abertura1)-Math.log10(abertura2))/(pasante1-pasante2)));
				Float calculo = new Float(Math.pow(10,exponente));
				muestra.setD10(truncaNum(calculo));		
				d10 = true;
			}
			analisis = (Analisis)listaAnalisis.get(i);
			i++;	
		}
		Float aberturaMalla = new Float(analisis.getTamiz().getAberturaMalla());
		if (!d60) {
			muestra.setD60(aberturaMalla);
		}
		if (!d30){
			muestra.setD30(aberturaMalla);
		}
		if (!d10){
			muestra.setD10(aberturaMalla);
		}
		persistencia.abrirTransaccion();
		Muestra muestraAux = new Muestra();
		muestraAux = (Muestra)persistencia.buscarObjeto(muestraAux.getClass(),"nombreMuestra=='"+muestra.getNombreMuestra()+"' && ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'");
		muestraAux.setD10(muestra.getD10());
		muestraAux.setD30(muestra.getD30());
		muestraAux.setD60(muestra.getD60());
		persistencia.cerrarTransaccion();
}

	
	/**

	 * Emite grafico de la clasificaciÃ³n.
	 * @param muestra. Muestra a la que se le calcula el grï¿½fico de curva granulomÃ©trica.
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked","rawtypes" })
	public ChartPanel curvaGranulometrica(Muestra muestra) throws Exception{
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
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		final NumberAxis rangeAxis = new NumberAxis("% Pasante");
        rangeAxis.setRange(0.0,120);

        final NumberAxis domainAxis = new LogarithmicAxis("TamaÃ±o de PartÃ­culas en mm");

        domainAxis.setInverted(true);
        domainAxis.setRange(0.01, 100);
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        final XYPlot plot1 = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
        final JFreeChart chart = new JFreeChart("Curva GranulomÃ©trica", plot1);
        XYItemRenderer rend = chart.getXYPlot().getRenderer();
        StandardXYItemRenderer rr = (StandardXYItemRenderer)rend;
        rr.setBaseShapesVisible(true);
        rr.setSeriesPaint(0, Color.black);
        plot1.setBackgroundPaint(Color.yellow);
        plot1.setDomainGridlinesVisible(true);
        plot1.setDomainGridlinePaint(Color.black);
        plot1.setRangeGridlinePaint(Color.black);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 350));
        exportarJPG(plot1,"curvaGranulometrica.jpg");
        return chartPanel;
    }
	/**
	 * Metodo que permite exportar el grï¿½fico de curva granulomï¿½trica a un archivo *.JPG
	 * @param plot
	 * @param fileName
	 * @throws Exception
	 */
	public void exportarJPG (XYPlot plot, String fileName) throws Exception {
		final XYPlot plot1 = (XYPlot) plot.clone();
		if (fileName.compareTo("curvaGranulometrica.jpg")==0){

			final JFreeChart chart1 = new JFreeChart("Curva GranulomÃ©trica", plot1);
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
	 * Emite grafico de la clasificaciÃ³n
	 * @throws Exception 
	 */
	public ChartPanel cartaPlasticidad(Muestra muestra) throws Exception{
		final XYSeries series = new XYSeries("Linea A");
		final XYSeries series2 = new XYSeries("Linea U");
		final XYSeries series3 = new XYSeries("Linea B");
		series3.add(0,50);
		series3.add(100,50);
		Float ll= muestra.getLimiteLiquido();
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
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		final NumberAxis rangeAxis = new NumberAxis("Ã�ndice de Plasticidad, IP");
        rangeAxis.setRange(0.0,60);
        final NumberAxis domainAxis = new NumberAxis("LÃ­mite LÃ­quido, LL");
        domainAxis.setRange(0.0, 100);
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        final XYPlot plot1 = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
        final JFreeChart chart = new JFreeChart("Carta de Plasticidad", plot1);
        plot1.getRenderer().setSeriesStroke(1, new BasicStroke( 
        	        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
        	        1.0f, new float[] {6.0f, 6.0f}, 0.0f 
        	    ));
        plot1.setBackgroundPaint(Color.YELLOW);
        XYItemRenderer rend = chart.getXYPlot().getRenderer();
        StandardXYItemRenderer rr = (StandardXYItemRenderer)rend;
        rr.setSeriesPaint(0, Color.black);
        rr.setSeriesPaint(1,Color.red);
        rr.setSeriesPaint(2, Color.cyan);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 350));
        exportarJPG(plot1,"cartaPlasticidad.jpg");
        return chartPanel;
    }
	
	/**
	 * Busca un analisis y retorna un valor booleano 
	 * con el resultado de la busqueda.
	 * @param tamiz
	 * @return, retorna el valor de la bÃºsqueda del analisis correspondiente.
	 * @throws Exception
	 */
	public boolean buscarAnalisis(String tamiz, Muestra muestra) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"' && muestra.ubicacion.nombreUbicacion=='"+muestra.getUbicacion().getNombreUbicacion()+"' && muestra.ubicacion.ciudad=='"+muestra.getUbicacion().getCiudad()+"'";
		Analisis aux = new Analisis();
		aux = (Analisis)persistencia.buscarObjeto(aux.getClass(),filtro+" && tamiz.numeroTamiz=='"+tamiz+"'");
		if(aux==null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
    * Trunca el nÃºmero a sÃ³lo un decimal.
    * @param num, el nÃºmero a truncar.
    * @return valor, el nÃºmero pasado como parÃ¡metro ya truncado.
    * @throws Exception
    */
	public static Float truncaNum(Float num) throws Exception{
		float valor = 0;
		valor = num;
		valor = valor*1000;
        valor = java.lang.Math.round(valor);
        valor = valor/1000;
        return valor;
    }
	
}
