/**
 * 
 */
package cuCalcularClasificacion;


import java.lang.Math;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import persistencia.Persistencia;
import persistencia.domain.Analisis;
import persistencia.domain.Clasificacion;
import persistencia.domain.Muestra;
import cuCalcularClasificacion.Clasificaciones.SUCS;
import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
 * @author TesisGeologia
 * @version 1.0
 */
public class ControlClasificacion {

	/**
	 * Constructor por defecto de la clase.
	 */
	public ControlClasificacion(){}
	
	/**
	 * Retorna la muestra persistente que cumpla con el nombre pasado como parametro.
	 * @param nombreMuestra
	 * @return
	 */
	public Muestra obtenerMuestra (Class clase, String nombreMuestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Muestra aux = new Muestra();
		try {
			aux =(Muestra)persistencia.buscarObjeto(clase, "nombreMuestra=='"+nombreMuestra+"'");
			persistencia.cerrarTransaccion();
		}
		catch (Exception e) {
			persistencia.realizarRollback();
		}
		return aux;
	}
	
	/**
	 * Realiza los calculos correspondientes para determinar la clasificacion de una muestra.
	 * @param muestra 
	 */
	public void calcularClasificacionSUCS(Muestra muestra,SUCS clasificacion) throws Exception{
		Float IndicePlasticidad = muestra.getIndicePlasticidad();
		Float limiteLiquido = muestra.getLimiteLiquido();
		calcularDiametro(muestra.getNombreMuestra(),clasificacion);
		
		clasificacion.setCoeficienteUniformidad(clasificacion.getD60()/clasificacion.getD10());//Coeficiente de uniformidad
		Float gradoCurvatura = ((clasificacion.getD30()*clasificacion.getD30()) /(clasificacion.getD10()*clasificacion.getD60()));//grado de curvatura.
		clasificacion.setGradoCurvatura(gradoCurvatura);
		
		
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		try{
			Analisis analisis = new Analisis();
			ControlClasificacion control = new ControlClasificacion();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"'"; 
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
						if((clasificacion.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3)){
							//GW
							clasificacion.setClasificacionSUCS("GW");
						}else {
							//GP
							clasificacion.setClasificacionSUCS("GP");
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Gravas con finos
						if (IndicePlasticidad<4){
							//GM
							clasificacion.setClasificacionSUCS("GM");
						}
						else if (IndicePlasticidad>7){
							//GC
							clasificacion.setClasificacionSUCS("GC");
						}
					}else{
						//Gravas Limpias y con finos.
						if ((clasificacion.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//GW-GM
							//clasificacion.setClasificacionSUCS("GW-GM");
						}else if(IndicePlasticidad<4 && IndicePlasticidad>7){
							//GW-GC
						}else if((IndicePlasticidad<4) && !((clasificacion.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3))){
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
						if ((clasificacion.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) ){
							//SW
							clasificacion.setClasificacionSUCS("SW");
						}else {
							//SP
							clasificacion.setClasificacionSUCS("SP");
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Arenas con finos
						if (IndicePlasticidad<4){
							//SM
							clasificacion.setClasificacionSUCS("SM");
						}else{
							//SC
							clasificacion.setClasificacionSUCS("SC");
						}
					}else{
						//arenas limpias y con finos.
						if ((clasificacion.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//SW-SM
						}else if ((clasificacion.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SW-SC
						}else if (!((clasificacion.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura())) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
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
						clasificacion.setClasificacionSUCS("CL");
					}else if (IndicePlasticidad<4){
						//ML
						clasificacion.setClasificacionSUCS("ML");
					}else if (limiteLiquido<0.75){
						//OL
						clasificacion.setClasificacionSUCS("OL");
					}
				}else {
					//limos y arcilla > 50
					if ((IndicePlasticidad>7)){
						//CH
						clasificacion.setClasificacionSUCS("CH");
					}else if (IndicePlasticidad<4){
						//MH
						clasificacion.setClasificacionSUCS("MH");
					}else if (limiteLiquido<0.75){
						//OH
						clasificacion.setClasificacionSUCS("OH");
					}
				}
			}
			//muestra = (Muestra) persistencia.buscarObjeto(muestra.getClass(),filtro);
			persistencia.insertarObjeto(clasificacion);
			muestra.setClasificacion(clasificacion);
			persistencia.cerrarTransaccion();
		}
		catch (Exception e){
			persistencia.realizarRollback();
		}
				
	}
	
	
	/**
	 * Metodo que calcula el D60 D30 D10 de una clasifiacion.
	 * @param nombreMuestra
	 * @throws Exception
	 */
	private void calcularDiametro(String nombreMuestra,Clasificacion clasificacion) throws Exception {
		Persistencia persistencia = new Persistencia();
		persistencia.abrirTransaccion();
		Analisis analisis = new Analisis();
		List listaAnalisis = persistencia.buscarListaFiltro(analisis.getClass(), "muestra.nombreMuestra=='"+nombreMuestra+"'");
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
				
				clasificacion.setD60(calculo);
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
					clasificacion.setD30(calculo);
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
						clasificacion.setD10(calculo);
						d10 = true;
					}
				i++;	
		}
		if (!d60) {
			Float aberturaMalla = new Float(analisis.getTamiz().getAberturaMalla());
			clasificacion.setD60(aberturaMalla);
		}
		if (!d30){
			clasificacion.setD30(clasificacion.getD60());
		}
		if (!d10){
			clasificacion.setD10(clasificacion.getD30());
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
		XYSeries series = new XYSeries("Nombre Muestra");
		while (it.hasNext()){
			analisis = it.next();
			series.add(analisis.getPorcentajePasante(),analisis.getTamiz().getAberturaMalla());
		}
		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
			
		// Generate the graph
		final NumberAxis rangeAxis = new NumberAxis("% Pasante");
        rangeAxis.setRange(0.0,100);
        
        final NumberAxis domainAxis = new NumberAxis("Tamaño de Particulas en mm");
        domainAxis.setInverted(true);
        //domainAxis.setRange(0.00001, 1);
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        
        final XYPlot plot1 = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot1.setOrientation(PlotOrientation.HORIZONTAL);
                
        final JFreeChart chart = new JFreeChart("Curva Granulometrica", plot1);
        chart.setBackgroundPaint(Color.white);   
              
        XYItemRenderer rend = chart.getXYPlot().getRenderer();
        StandardXYItemRenderer rr = (StandardXYItemRenderer)rend;
        rr.setBaseShapesVisible(true);
        rr.setSeriesPaint(0, Color.black);
                
        plot1.setBackgroundPaint(Color.yellow);//lightGray
        plot1.setDomainCrosshairPaint(Color.black);
        plot1.setDomainMinorGridlinePaint(Color.blue);
        plot1.setDomainGridlinesVisible(true);
        
        plot1.setDomainGridlinePaint(Color.black);
        plot1.setRangeGridlinePaint(Color.black);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 350));
        return chartPanel;
    }
	
	
	
	/**
	 * Imprime la clasificacion y el grafico.
	 */
	public void imprimirClasificacion(){
	}
}
