/**
 * 
 */
package cuCalcularClasificacion;



import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.datanucleus.query.expression.CaseExpression;
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
	public void calcularClasificacionSUCS(Muestra muestra) throws Exception{
		Persistencia persistencia = new Persistencia();
		Float IndicePlasticidad = new Float(2);//estos datos ver de donde los obtengo
		Float limiteLiquido = new Float(2);
		Clasificacion clasificacion = new Clasificacion();
		
		persistencia.abrirTransaccion();
		try{
			Analisis analisis = new Analisis();
			ControlClasificacion control = new ControlClasificacion();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"'"; 
			analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+"' && tamiz.numeroTamiz=='200'");
			if (analisis.getPorcentajePasante()<=50){
				//suelo de particulas gruesas
				analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+"' && tamiz.numeroTamiz=='4'");
				if (analisis.getPorcentajePasante()<=50){
					//Gravas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+"' && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<5){
						//GravasLimpias
						if((muestra.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3)){
							//GW
						}else {
							//GP
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Gravas con finos
						if (IndicePlasticidad<4){
							//GM
						}
						else if (IndicePlasticidad>7){
							//GC
						}
					}else{
						//Gravas Limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//GW-GM
						}else if(IndicePlasticidad<4 && IndicePlasticidad>7){
							//GW-GC
						}else if((IndicePlasticidad<4) && !((muestra.getCoeficienteUniformidad()>=4) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3))){
							//GP-GM
						}else{
							//GP-GC
						}
					}
				}
				else{
					//Arenas
					analisis = (Analisis)persistencia.buscarObjeto(analisis.getClass(), "muestra.nombreMuestra=='"+"' && tamiz.numeroTamiz=='200'");
					if (analisis.getPorcentajePasante()<=5){
						//Arenas Limpias
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) ){
							//SW
						}else {
							//SP
						}
					}else if (analisis.getPorcentajePasante()>12){
						//Arenas con finos
						if (IndicePlasticidad<4){
							//SM
						}else{
							//SC
						}
					}else{
						//arenas limpias y con finos.
						if ((muestra.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad<4)){
							//SW-SM
						}else if ((muestra.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura()) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
							//SW-SC
						}else if (!((muestra.getCoeficienteUniformidad()>=6) && (1<=clasificacion.getGradoCurvatura())) && (clasificacion.getGradoCurvatura()<=3) && (IndicePlasticidad>7)){
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
					}else if (IndicePlasticidad<4){
						//ML
					}else if (limiteLiquido<0.75){
						//OL
					}
				}else {
					//limos y arcilla > 50
					if ((IndicePlasticidad>7)){
						//CH
					}else if (IndicePlasticidad<4){
						//MH
					}else if (limiteLiquido<0.75){
						//OH
					}
				}
			}
						
		}
		catch (Exception e){
			persistencia.realizarRollback();
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
		Collection coleccionAnalisis = control.coleccionAnalisisDeMuestra(clase, muestra.getNombreMuestra());
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
	
	/**
	 * Compara las clasificaciones de dos muetras. 
	 */
	public void compararMuetras(){
	}
}
