/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import persistencia.domain.AASHTO;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.SUCS;

import comun.Mediador;

import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuReporte.report.MakeReport;
import cuReporte.report.ViewReport;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 *
 */
public class MediadorCalcularClasificacion extends Mediador{
	private GUIClasificacion GUIClasificacion;
	
	private Muestra muestra = new Muestra();
	private Object [][] data;
	
	/**
	 * Default Constructor
	 */
	public MediadorCalcularClasificacion(String titulo){
		super();
		GUIClasificacion = new GUIClasificacion();
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setModal(true);
		GUIClasificacion.setListenerButtons(this);
		GUIClasificacion.show();
	}
	
	/**
	 * 
	 * @param titulo
	 * @param muestra
	 * @throws Exception
	 */
	public MediadorCalcularClasificacion(String titulo, Muestra muestra) throws Exception {
		super();
		cargarTablaDeAnalisis(muestra);
		ControlClasificacion control = new ControlClasificacion();
		

		//AASHTO clasificacion2 = new AASHTO();
		//control.calcularClasificacionAASHTO(muestra,clasificacion2);

		SUCS clasificacion = new SUCS();
		control.calcularClasificacionSUCS(muestra,clasificacion);
		GUIClasificacion = new GUIClasificacion(clasificacion,muestra,data);
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setModal(true);
		GUIClasificacion.setListenerButtons(this);
		GUIClasificacion.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param nombreMuestra 
	 */
	public void cargarTablaDeAnalisis(Muestra muestra)throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection muestras = control.coleccionAnalisisDeMuestra(clase, muestra);
		Iterator<Analisis> it = muestras.iterator();
		data = new Object [muestras.size()] [5];
		int i = 0;
		while (it.hasNext()){
			analisis = it.next();
			data [i][0]= analisis.getTamiz().getNumeroTamiz();
			data [i][1]= analisis.getPesoRetenido();
			data [i][2]= analisis.getPorcentajePasante();
		    data [i][3]= analisis.getPorcentajeRetenidoAcumulado();		        
		    data [i][4]= analisis.getPorcentajeRetenidoParcial();
		    i++;
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIClasificacion.getJButtonImprimir() == source) {
			String [][]data1 = new String [2] [22];
			data1 [0][0] = GUIClasificacion.getUbicacion().getText();
			data1 [0][1] = GUIClasificacion.getUbicacion().getText();
			data1 [0][2] = GUIClasificacion.getPeso().getText();
			data1 [0][3] = GUIClasificacion.getProfundidadInicial().getText();
			data1 [0][4] = GUIClasificacion.getProfundidadFinal().getText();
			data1 [0][5] = GUIClasificacion.getLimiteLiquido().getText();
			data1 [0][6] = GUIClasificacion.getLimitePlastico().getText();
			data1 [0][7] = GUIClasificacion.getIndicePlasticidad().getText();
			data1 [0][8] = GUIClasificacion.getD60().getText();
			data1 [0][9] = GUIClasificacion.getD30().getText();
			data1 [0][10] = GUIClasificacion.getD10().getText();
			data1 [0][11] = GUIClasificacion.getD60().getText();
			data1 [0][12] = GUIClasificacion.getD60().getText();
			data1 [0][13] = GUIClasificacion.getD60().getText();
			data1 [0][13] = GUIClasificacion.getD60().getText();
			data1 [0][14] = GUIClasificacion.getD60().getText();
			data1 [0][15] = GUIClasificacion.getD60().getText();
			data1 [0][16] = GUIClasificacion.getD60().getText();
			data1 [0][17] = GUIClasificacion.getD60().getText();
			data1 [1][13] = GUIClasificacion.getD60().getText();
			data1 [1][14] = GUIClasificacion.getD60().getText();
			data1 [1][15] = GUIClasificacion.getD60().getText();
			data1 [1][16] = GUIClasificacion.getD60().getText();
			data1 [1][17] = GUIClasificacion.getD60().getText();
			data1 [0][18] = GUIClasificacion.getD60().getText();
			data1 [0][19] = GUIClasificacion.getD60().getText();
			data1 [0][20] = GUIClasificacion.getD60().getText();
			data1 [0][21] = GUIClasificacion.getD60().getText();
			MakeReport makeReporte = new MakeReport();
			makeReporte.make("report1");
			ViewReport view = new ViewReport(data1);
			view.viewPersons();
			GUIClasificacion.dispose();
				
			}
		if (this.GUIClasificacion.getJButtonSalir() == source){
			GUIClasificacion.dispose();
		}
	}
	public Object[][] getData() {
		return data;
	}
}

