
package cuCalcularClasificacion;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;

import comun.Mediador;
import comun.MediadorVersion;

import cuGestionarAnalisis.ControlGestionarAnalisis;
import cuGestionarAnalisis.MediadorGestionarAnalisis;
import cuLimiteConsistencia.MediadorAltaLimiteConsistencia;
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
	private Muestra muestra;
	private boolean clasificoA;
	private boolean clasificoS;
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
	 * @param titulo 
	 * @throws HeadlessException
	 * @throws Exception
	 */
	public void realizarClasificaciones(String titulo) throws HeadlessException, Exception{
		ControlClasificacion control = new ControlClasificacion();
		if(control.buscarAnalisis("200",muestra) && control.buscarAnalisis("4",muestra)){
			control.calcularClasificacionSUCS(muestra);
			if (control.buscarAnalisis("200",muestra) && control.buscarAnalisis("40",muestra)&& control.buscarAnalisis("10",muestra)  && muestra.getIndicePlasticidad()!=0){
				control.calcularClasificacionAASHTO(muestra);
				GUIClasificacion = new GUIClasificacion(muestra,data);
				GUIClasificacion.setTitle(titulo);
				GUIClasificacion.setListenerButtons(this);
				GUIClasificacion.setLocationRelativeTo(null);
				GUIClasificacion.setModal(true);
				GUIClasificacion.show();
			}
			else{
				int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"No se puede realizar la clasificación AASHTO.\nDebe previamente cargar los Análisis para los tamices 10, 40 y 200 ¿Desea cargarlos?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(quitOption==JOptionPane.YES_OPTION){
					MediadorGestionarAnalisis analisis = new MediadorGestionarAnalisis("Gestionar Análisis de la muestra "+muestra.getNombreMuestra(), muestra);
				}else{
					GUIClasificacion = new GUIClasificacion(muestra,data);
					GUIClasificacion.setTitle(titulo);
					GUIClasificacion.setListenerButtons(this);
					GUIClasificacion.setLocationRelativeTo(null);
					GUIClasificacion.setModal(true);
					GUIClasificacion.show();
				}
			}
		}
		else{
			int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"No se puede realizar la clasificacion SUCS.\nDebe previamente cargar los Análisis para los tamices 4 y 200 ¿Desea cargarlos?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(quitOption==JOptionPane.YES_OPTION){
				MediadorGestionarAnalisis analisis = new MediadorGestionarAnalisis("Gestionar Análisis de la muestra "+muestra.getNombreMuestra(), muestra);
				clasificoS=false;
			}else{
				clasificoS=false;
				if (control.buscarAnalisis("200",muestra) && control.buscarAnalisis("40",muestra)&& control.buscarAnalisis("10",muestra)  && muestra.getIndicePlasticidad()!=0){
					control.calcularClasificacionAASHTO(muestra);
				}
				else{
					quitOption = JOptionPane.showConfirmDialog(new JFrame(),"No se puede realizar la clasificacion AASHTO.\nDebe previamente cargar los Análisis para los tamices 10, 40 y 200 ¿Desea cargarlos?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if(quitOption==JOptionPane.YES_OPTION){
						MediadorGestionarAnalisis analisis = new MediadorGestionarAnalisis("Gestionar Análisis de la muestra "+muestra.getNombreMuestra(), muestra);
						clasificoS=false;
					}else{
						clasificoA=false;
						if (clasificoA || clasificoS){
							GUIClasificacion = new GUIClasificacion(muestra,data);
							GUIClasificacion.setTitle(titulo);
							GUIClasificacion.setListenerButtons(this);
							GUIClasificacion.setLocationRelativeTo(null);
							GUIClasificacion.setModal(true);
							GUIClasificacion.show();
						}
					}
				}
			}
		}
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
		this.muestra=muestra;
		clasificoA = true;
		clasificoS = true;
		cargarTablaDeAnalisis(muestra);
		if(muestra.getIndicePlasticidad()==0){
			JOptionPane.showMessageDialog(frame,"No se puede calcular ninguna clasificación, falta índice de plasticidad","Atención!", JOptionPane.ERROR_MESSAGE);
			MediadorAltaLimiteConsistencia mediadorAlta = new MediadorAltaLimiteConsistencia(muestra);
			if (mediadorAlta.isAltaConsistencia()){
				realizarClasificaciones(titulo);
			}else{
				clasificoA = false;
				clasificoS = false;
			}
		}else{
			realizarClasificaciones(titulo);
		}

	}

	/**
	 * Levanta información almacenada en la base de datos y la copia 
	 * al atributo data de la clase mediador.
	 * @param Muestra, muestra de la que se desean obtener los an�lisis. 
	 */
	@SuppressWarnings({ "unchecked","rawtypes" })
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
			parameters [17] = muestra.getOperadorLaboratorio().getNombre()+" "+muestra.getOperadorLaboratorio().getApellido();
			parameters [18] = muestra.getCliente().getNombre()+" "+muestra.getCliente().getApellido();
			MakeReport makeReporte = new MakeReport();
			makeReporte.make("report1");
			ViewReport view = new ViewReport(data, parameters);
			view.viewClasificacion();
		}
		if (this.GUIClasificacion.getJButtonSalir() == source || GUIClasificacion.getSalirMenu()==source){
			GUIClasificacion.dispose();
		}
		if(this.GUIClasificacion.getVersionMenu() == source){
			new MediadorVersion();
		}

	}
	public Object[][] getData() {
		return data;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}

