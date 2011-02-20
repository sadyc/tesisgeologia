/**
 * 
 */
package cuCalcularClasificacion;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.IAnalisis;
import persistencia.domain.HMuestra;

import comun.Mediador;

import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuGestionarMuestra.GUIMuestraDetallada;
import cuReporte.report.MakeReport;
import cuReporte.report.ViewReport;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 *
 */
public class MediadorCalcularClasificacion extends Mediador{
	private GUIClasificacion GUIClasificacion;
	
	private HMuestra muestra = new HMuestra();
	private Frame frame;
	private GUIMuestraDetallada GUIMuestraDetallada;
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
	public MediadorCalcularClasificacion(String titulo, HMuestra muestra) throws Exception {
		super();
		boolean clasificar = true;
		cargarTablaDeAnalisis(muestra);
		ControlClasificacion control = new ControlClasificacion();
		if (!(data==null)){
			if (control.buscarAnalisis("200") && control.buscarAnalisis("40")&& control.buscarAnalisis("10")  && muestra.getIndicePlasticidad()!=0){
				//if (muestra.getAashto()==null) {
					control.calcularClasificacionAASHTO(muestra);
				//}
			}
			else{
				JOptionPane.showMessageDialog(frame,"No se puede realizar la clasificacion AASHTO, Faltan analisis para los tamices 10, 40 0 200","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				clasificar = false;
			}
			if(control.buscarAnalisis("200") && control.buscarAnalisis("4") && muestra.getIndicePlasticidad()!=0){
				//if (muestra.getSucs()==null){
					control.calcularClasificacionSUCS(muestra);
				//}
			}
			else{
				JOptionPane.showMessageDialog(frame,"No se puede realizar la clasificacion SUCS, Faltan analisis o indice de plasticidad","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
				clasificar = false;
				
			}
		}
		
		if (clasificar){
			GUIClasificacion = new GUIClasificacion(muestra,data);
			GUIClasificacion.setTitle(titulo);
			GUIClasificacion.setModal(true);
			GUIClasificacion.setListenerButtons(this);
			GUIClasificacion.show();
		}
		else{
			new MediadorGestionarAnalisis("Gestionar Analisis", muestra);
		}
		
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 * @param nombreMuestra 
	 */
	public void cargarTablaDeAnalisis(HMuestra muestra)throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		IAnalisis analisis = new IAnalisis();
		Class clase = analisis.getClass();
		Collection muestras = control.coleccionAnalisisDeMuestra(clase, muestra);
		Iterator<IAnalisis> it = muestras.iterator();
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
			Object[] parameters= new Object [20];
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
			parameters [13] = GUIClasificacion.getClasificacionSucs().getText();
			parameters [14] = GUIClasificacion.getDescripcionSucs().getText();
			parameters [15] = GUIClasificacion.getClasificacionSucs().getText();
			parameters [16] = GUIClasificacion.getDescripcionSucs().getText();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}

