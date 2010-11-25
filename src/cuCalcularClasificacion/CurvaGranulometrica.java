/**
 * 
 */
package cuCalcularClasificacion;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CurvaGranulometrica {
	public static void main(String[] args) {
		// Create a simple XY chart
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
        
        final NumberAxis domainAxis = new NumberAxis("Tamaño de Particulas en mm");
        domainAxis.setInverted(true);
        domainAxis.setRange(0.00001, 1);
        
        final XYItemRenderer renderer = new StandardXYItemRenderer();

        final XYPlot plot = new XYPlot(dataset, rangeAxis,domainAxis,renderer);
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        
        final JFreeChart chart = new JFreeChart("Curva Granulometrica", plot);
        

        //domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        //para marcar los puntos. todavia no resuelto
				
		try {
		ChartUtilities.saveChartAsJPEG(new File("C:\\chart4.jpg"), chart, 500, 300);
		} catch (IOException e) {
		System.err.println("Problem occurred creating chart.");
		}
		}
}