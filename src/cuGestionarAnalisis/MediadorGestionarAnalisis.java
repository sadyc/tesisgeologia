package cuGestionarAnalisis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.domain.AASHTO;
import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import persistencia.domain.SUCS;
import persistencia.domain.Tamiz;

import comun.Mediador;
import comun.MediadorVersion;

import cuCalcularClasificacion.MediadorCalcularClasificacion;
import cuGestionarMuestra.GUIMuestraDetallada;



/**
 *@brief Clase que se utiliza para escuchar los eventos que suceden en la ventana "Gestionar Análisis".
 *@author TesisGeología
 *@version 1.0
 */

public class MediadorGestionarAnalisis extends Mediador{
	
	private GUIMuestraDetallada GUImuestraDetallada;
	private Muestra muestra;
	private Analisis analisis;
	private Object [][] data;
	private Component frame;
	
	/**
	 * This is the default constructor
	 * @param botonClasificar 
	 * @throws Exception 
	 */
	public MediadorGestionarAnalisis(String titulo, Muestra muestra) throws Exception {
		super();
		this.muestra = muestra;
		cargarTablaDeAnalisis();
		GUImuestraDetallada = new GUIMuestraDetallada(this.muestra,data);
		GUImuestraDetallada.setTitle(titulo);
		GUImuestraDetallada.setListenerButtons(this);
		GUImuestraDetallada.setModal(true);
		GUImuestraDetallada.setLocationRelativeTo(null);
		show();
	}
	
	/**
	 * Levanta informacion almacenada en la base de datos
	 * y la copia al atributo data de la clase mediador.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void cargarTablaDeAnalisis()throws Exception{
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection coleccionAnalisis = control.coleccionAnalisisDeMuestra(clase,muestra);
		Iterator<Analisis> it = coleccionAnalisis.iterator();
		data = new Object [coleccionAnalisis.size()] [5];
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
	/**
	 * Método que permite visualizar la ventana. 
	 */
	@SuppressWarnings("deprecation")
	public void show(){
		GUImuestraDetallada.show();
	}
	
	
	/**
	 * @return the gestionarAnalisis.
	 */
	public GUIMuestraDetallada getMuestraDetallada() {
		return GUImuestraDetallada;
	}	
	
	/**
	 * Método que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUImuestraDetallada.getjButtonAgregarAnalisis() == source || GUImuestraDetallada.getAgregarMenu()==source){
			agregarAnalisis();
		}
		if (this.GUImuestraDetallada.getjButtonModificarAnalisis() == source || GUImuestraDetallada.getModificarMenu()==source){
			modificarAnalisis();
		}
		if (this.GUImuestraDetallada.getjButtonEliminarAnalisis() == source || GUImuestraDetallada.getEliminarMenu()==source){
			eliminarAnalisis();
		}
		if (this.GUImuestraDetallada.getJButtonSalir() == source || GUImuestraDetallada.getSalirMenu()==source){
			GUImuestraDetallada.dispose();
		}
		if(this.GUImuestraDetallada.getVersionMenu() == source){
			new MediadorVersion();
		}
		if(this.GUImuestraDetallada.getjButtonCalcularClasificacion() == source){
			try {
				GUImuestraDetallada.dispose();
				new MediadorCalcularClasificacion("Clasificacion de la muestra "+muestra.getNombreMuestra(),muestra);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opción de "Eliminar Analisis"
	 */
	public void eliminarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonEliminar");
		if (GUImuestraDetallada.getTablePanel1().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a eliminar","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else{
		    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro de eliminar el Análisis?\nRecuerde que se eliminarán las Clasificaciones asociadas a la Muestra","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(quitOption==JOptionPane.YES_OPTION){
            	ControlGestionarAnalisis control = new ControlGestionarAnalisis();
            	String [] fila = GUImuestraDetallada.getTablePanel1().getRow(GUImuestraDetallada.getTablePanel1().getSelectedRow());
            	Tamiz tamiz = new Tamiz();
            	tamiz.setNumeroTamiz(fila[0]);
              	analisis = new Analisis(Float.parseFloat(fila[1]),muestra,tamiz);
              	try {
					control.eliminarAnalisis(analisis);
					control.recalcularAnalisis(analisis);
					GUImuestraDetallada.dispose();
					muestra.setAashto(new AASHTO());
					muestra.setSucs(new SUCS());
					new MediadorGestionarAnalisis("Análisis de la muestra "+ muestra.getNombreMuestra(), muestra);
				} catch (Exception e1) {
					e1.printStackTrace();
				}              	    	
            }
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opción de "Modificar Analisis"
	 */
	public void modificarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonModificar");
		if (GUImuestraDetallada.getTablePanel1().getSelectedRow() == -1){
			JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningún elemento a modificar","Atención!", JOptionPane.ERROR_MESSAGE);
		}
		else{
			String [] fila = GUImuestraDetallada.getTablePanel1().getRow(GUImuestraDetallada.getTablePanel1().getSelectedRow());
			new MediadorModificarAnalisis(muestra,Float.parseFloat(fila[1]),(String)fila[0]);
			GUImuestraDetallada.dispose();
			try {
				new MediadorGestionarAnalisis("Análisis de la muestra "+muestra.getNombreMuestra(), muestra);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opción de "Agregar Analisis"
	 */
	public void agregarAnalisis(){
		System.out.println("GestionarAnalisis.actionPerformed() jButtonAgregar");
		MediadorAltaAnalisis altaAnalisis = new MediadorAltaAnalisis(muestra);
		if (altaAnalisis.isAltaAnalisis()){
			this.GUImuestraDetallada.getTablePanel1().addRow(altaAnalisis.getData());
		}
	}


	public void itemStateChanged(ItemEvent arg0) {
	}


	public void mouseClicked(MouseEvent arg0) {
	}


	public void mouseEntered(MouseEvent arg0) {
	}


	public void mouseExited(MouseEvent arg0) {
	}


	public void mousePressed(MouseEvent arg0) {
	}


	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}