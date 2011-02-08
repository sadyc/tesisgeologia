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
		control.cartaPlasticidad(muestra);
		/*if (muestra.getAashto()==null) {
			control.calcularClasificacionAASHTO(muestra);
		}
		if (muestra.getSucs()==null){
			control.calcularClasificacionSUCS(muestra);
		}
		*/
		GUIClasificacion = new GUIClasificacion(muestra,data);
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
			Object[] parameters= new Object [17];
			parameters [0] = GUIClasificacion.getUbicacion().getText();
			parameters [1] = GUIClasificacion.getUbicacion().getText();
			parameters [2] = GUIClasificacion.getPeso().getText();
			parameters [3] = GUIClasificacion.getProfundidadInicial().getText();
			parameters [4] = GUIClasificacion.getProfundidadFinal().getText();
			parameters [5] = GUIClasificacion.getLimiteLiquido().getText();
			parameters [6] = GUIClasificacion.getLimitePlastico().getText();
			parameters [7] = GUIClasificacion.getIndicePlasticidad().getText();
			parameters [8] = GUIClasificacion.getD60().getText();
			parameters [9] = GUIClasificacion.getD30().getText();
			parameters [10] = GUIClasificacion.getD10().getText();
			parameters [11] = GUIClasificacion.getGradoCurvatura().getText();
			parameters [12] = GUIClasificacion.getCoeficienteUniformidad().getText();
			parameters [13] = GUIClasificacion.getD60().getText();
			parameters [14] = GUIClasificacion.getD60().getText();
			parameters [15] = GUIClasificacion.getD60().getText();
			parameters [16] = GUIClasificacion.getD60().getText();
			MakeReport makeReporte = new MakeReport();
			makeReporte.make("report1");
			ViewReport view = new ViewReport(data, parameters);
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

