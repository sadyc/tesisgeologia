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

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;

import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuReporte.report.MakeReport;
import cuReporte.report.ViewReport;

/**
 * @brief Clase que se utiliza para escuchar los sucesos que suceden en la ventana de clasificacion
 * @author TesisGeologia
 * @version 1.0
 *
 */
public class MediadorCalcularClasificacion extends Mediador{
	
	private GUIClasificacion GUIClasificacion;
	private Frame frame;
	private Object [][] data;
	
	/**
	 * Default Constructor
	 */
	@SuppressWarnings("deprecation")
	public MediadorCalcularClasificacion(String titulo){
		super();
		GUIClasificacion = new GUIClasificacion();
		GUIClasificacion.setTitle(titulo);
		GUIClasificacion.setListenerButtons(this);
		GUIClasificacion.setLocationRelativeTo(null);
		GUIClasificacion.setModal(true);
		GUIClasificacion.show();
	}
	
	/**
	 * Constructor parametrizado de la clase. 
	 * @param titulo, titulo de la ventana.
	 * @param muestra, muestra correspondiente a la clasificación.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public MediadorCalcularClasificacion(String titulo, Muestra muestra) throws Exception {
		super();
		boolean clasificar = true;
		cargarTablaDeAnalisis(muestra);
		ControlClasificacion control = new ControlClasificacion();
		if (!(data==null)){
			if (control.buscarAnalisis("200",muestra) && control.buscarAnalisis("40",muestra)&& control.buscarAnalisis("10",muestra)  && muestra.getIndicePlasticidad()!=0){
				muestra.setAashto(control.calcularClasificacionAASHTO(muestra));
			}
			else{

				JOptionPane.showMessageDialog(frame,"No se puede realizar la clasificación AASHTO, Faltan análisis para los tamices 10, 40 ó 200","Atención!", JOptionPane.ERROR_MESSAGE);
				clasificar = false;
			}
			if(control.buscarAnalisis("200",muestra) && control.buscarAnalisis("4",muestra) && muestra.getIndicePlasticidad()!=0){
				muestra.setSucs(control.calcularClasificacionSUCS(muestra));
			}
			else{
				JOptionPane.showMessageDialog(frame,"No se puede realizar la clasificación SUCS, Faltan análisis o índice de plasticidad","Atención!", JOptionPane.ERROR_MESSAGE);
				clasificar = false;
				
			}
		}
		if (clasificar){
			GUIClasificacion = new GUIClasificacion(muestra,data);
			GUIClasificacion.setTitle(titulo);
			GUIClasificacion.setListenerButtons(this);
			GUIClasificacion.setLocationRelativeTo(null);
			GUIClasificacion.setModal(true);
			GUIClasificacion.show();
		}
		else{
			new MediadorGestionarAnalisis("Gestionar Análisis", muestra);
		}
		
	}
	
	/**
	 * Levanta información almacenada en la base de datos y la copia 
	 * al atributo data de la clase mediador.
	 * @param Muestra, muestra de la que se desean obtener los an�lisis. 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
			
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
			
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
			
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
			
	}

	/**
	 * Método que permite permite realizar acciones dependiendo a los eventos que ocurren en la ventana.
	 */
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIClasificacion.getJButtonImprimir() == source || GUIClasificacion.getImprimirMenu()==source) {
			Object[] parameters= new Object [20];
			parameters [0] = GUIClasificacion.getMuestra().getText();
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
			parameters [14] = GUIClasificacion.getDescripcionSucs().getText().toString();
			parameters [15] = GUIClasificacion.getClasificacionAashto().getText(); 
			parameters [16] = GUIClasificacion.getDescripcionAashto().getText();
			MakeReport makeReporte = new MakeReport();
			makeReporte.make("report1");
			ViewReport view = new ViewReport(data, parameters);
			view.viewClasificacion();
			GUIClasificacion.dispose();
				
			}
		if (this.GUIClasificacion.getJButtonSalir() == source || GUIClasificacion.getSalirMenu()==source){
			GUIClasificacion.dispose();
		}
	
	}
	public Object[][] getData() {
		return data;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
		
}

