/**
 * 
 */
package cuCalcularClasificacion;



import java.awt.Color;
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
import persistencia.domain.Muestra;
import cuCalcularClasificacion.Clasificaciones.GranoFino;
import cuCalcularClasificacion.Clasificaciones.GranoGrueso;

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
		persistencia.abrirTransaccion();
		try{
			Analisis analisis = new Analisis();
			ControlClasificacion control = new ControlClasificacion();
			String filtro = "muestra.nombreMuestra=='"+muestra.getNombreMuestra()+"'"; 
			List listaAnalisis = (List)persistencia.buscarListaFiltro(analisis.getClass(), filtro);
			int i = listaAnalisis.size()/2;// VEEEEEEEEEEEEEEEEERRRRRRRRRRRRRR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			analisis = (Analisis)listaAnalisis.get(i);
			if (analisis.getPorcentajePasante()>50) {
				GranoFino fino = new GranoFino();	
			}
			else{
				GranoGrueso grueso = new GranoGrueso();
			}
			
		}
		catch (Exception e){
			persistencia.realizarRollback();
		}
				
	}
	
	/**
	 * Emite grafico de la clasificacion
	 */
	public ChartPanel emitirGrafico(){
		// Create a simple XY chartXYSeries series
		System.out.println("no puedo hacer lo q sigeue");
		XYSeries series = new XYSeries("Nombre Muestra");
		series.add(100, 1);
		series.add(80,0.5);
		series.add(40,0.1);
		series.add(20,0.02);
		//series.add(3, 9);
		
		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
			
		// Generate the graph
		final NumberAxis rangeAxis = new NumberAxis("% Pasante");
        rangeAxis.setRange(0.0,100);
        
        final NumberAxis domainAxis = new NumberAxis("Tamaño de Particulas en Dcm");
        domainAxis.setInverted(true);
        domainAxis.setRange(0.00001, 1);
        System.out.println("no puedo hacer lo q sigeue");
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
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 350));
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
