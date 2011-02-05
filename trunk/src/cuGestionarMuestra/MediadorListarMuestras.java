package cuGestionarMuestra;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import persistencia.domain.Analisis;
import persistencia.domain.Muestra;
import cuCalcularClasificacion.ControlClasificacion;
import cuGestionarAnalisis.ControlGestionarAnalisis;

/**
* @author TesisGeología
*
*/
public class MediadorListarMuestras implements ActionListener, KeyListener, MouseListener {
	
	private GUIABMMuestra GUIABMMuestra = null;
	private GUIMuestraDetallada GUIMuestraDetallada = null;
	private Muestra muestra1 = new Muestra();
	private Object [] seleccionado = new Object [4];
	private boolean seleccionoMuestra = false;
	private Object [] [] dataAnalisis;
	private Object [][] data;
	private Component frame;
	
	/**
	 * Constructor por defecto de la clase.
	 * @throws Exception
	 */
	public MediadorListarMuestras() throws Exception {
		super();
		
		cargarTablaDeMuestras();
		String [] columAux = {"Ubicacion","Nombre","Peso","Profundidad Inicial","Profundidad Final"};
		GUIABMMuestra = new GUIABMMuestra("Lista de Muestras",data,columAux);
		GUIABMMuestra.setListenerButtons(this);
		GUIABMMuestra.setListenerTable(this);
		GUIABMMuestra.setMouseListener(this);
		GUIABMMuestra.setKeyListener(this);
		GUIABMMuestra.addActionListener(this);
		GUIABMMuestra.getJButtonAgregar().setEnabled(false);
		GUIABMMuestra.getAgregarMenu().setEnabled(false);
		GUIABMMuestra.getJButtonEliminar().setEnabled(false);
		GUIABMMuestra.getEliminarMenu().setEnabled(false);
		GUIABMMuestra.getJButtonModificar().setEnabled(false);
		GUIABMMuestra.getModificarMenu().setEnabled(false);
		GUIABMMuestra.setModal(true);
		GUIABMMuestra.show();
	}
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo data de la clase mediador.
	 */
	public void cargarTablaDeMuestras()throws Exception{
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = new Muestra();
		Class clase = muestra.getClass();
		Collection muestras = control.coleccionMuestras(clase);
		Iterator<Muestra> it = muestras.iterator();
		data = new Object [muestras.size()] [8];
		int i = 0;
		while (it.hasNext()){
			muestra = it.next();
			data [i][0]= muestra.getUbicacion().getNombreUbicacion();
			data [i][1]= muestra.getNombreMuestra();
			data [i][2]= muestra.getPeso();
		    data [i][3]= muestra.getProfundidadInicial();
		    data [i][4]= muestra.getProfundidadFinal();
		    data [i][5]= muestra.getOperador().getNombre()+" "+muestra.getOperador().getApellido();
		    data [i][6]= muestra.getUbicacion().getLatitud();
		    data [i][7]= muestra.getUbicacion().getLongitud();
		    i++;
		}
	}
		
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.GUIABMMuestra.getJButtonSalir() == source || this.GUIABMMuestra.getSalirMenu()== source){
			GUIABMMuestra.dispose();
		}
		if (this.GUIMuestraDetallada.getJButtonSalir() == source || this.GUIMuestraDetallada.getSalirMenu()== source){
			GUIMuestraDetallada.dispose();
		}
		if (this.GUIABMMuestra.getJButtonSeleccionar()==source || this.GUIABMMuestra.getSeleccionarMenu()==source){
			seleccionarMuestra();
			detallarMuestra();
		}
		
		if (this.GUIMuestraDetallada.getJButtonImprimir() == source || this.GUIMuestraDetallada.getImprimirMenu()== source){
			System.out.println("Imprimiendo:");
			System.out.println("wait...........");
		}
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Comparar Muestras"
	 */
	public void detallarMuestra(){
		try {
			if (seSeleccionoMuestra()){
				muestra1 = getSeleccionado();
				dataAnalisis = cargarTablaDeAnalisis(muestra1);
				GUIMuestraDetallada= new GUIMuestraDetallada(muestra1,dataAnalisis);
				GUIMuestraDetallada.setTitle("Detalles de la Muestra");
				GUIMuestraDetallada.setListenerButtons(this);
				GUIMuestraDetallada.getjButtonAgregarAnalisis().setEnabled(false);
				GUIMuestraDetallada.getjButtonEliminarAnalisis().setEnabled(false);
				GUIMuestraDetallada.getjButtonModificarAnalisis().setEnabled(false);
				GUIMuestraDetallada.getAgregarMenu().setEnabled(false);
				GUIMuestraDetallada.getModificarMenu().setEnabled(false);
				GUIMuestraDetallada.getEliminarMenu().setEnabled(false);
				GUIMuestraDetallada.setModal(true);
				GUIMuestraDetallada.show();
				
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se puede detallar la muestra. ERROR!!"); 
		}
	  
	}
		
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos al atributo dataAnalisis de la clase mediador.
	 * @param nombreMuestra, es el nombre de la muestra de la cual se desean obtener los analisis.
	 * @return data, es la tabla con los datos de los analisis correspondientes a la muestra.
	 */
	public Object [] [] cargarTablaDeAnalisis(Muestra muestra)throws Exception{
		
		ControlGestionarAnalisis control = new ControlGestionarAnalisis();
		Analisis analisis = new Analisis();
		Class clase = analisis.getClass();
		Collection muestras = control.coleccionAnalisisDeMuestra(clase, muestra);
		Iterator<Analisis> it = muestras.iterator();
		int i = 0;
		Object [] [] data = new Object [muestras.size()] [5];
		while (it.hasNext()){
			analisis = it.next();
			data [i][0]= analisis.getTamiz().getNumeroTamiz();
			data [i][1]= analisis.getPesoRetenido();
			data [i][2]= analisis.getPorcentajePasante();
		    data [i][3]= analisis.getPorcentajeRetenidoAcumulado();		        
		    data [i][4]= analisis.getPorcentajeRetenidoParcial();
		    i++;
		}
		return data;
	}
	
	/**
	 * Acciones a realizar cuando se selecciona la opcion de "Seleccionar Muestra"
	 */
	public void seleccionarMuestra(){
			System.out.println("Button Seleccionar Muestra");
			try {
				seleccionado = GUIABMMuestra.getTablePanel().getRow(GUIABMMuestra.getTablePanel().getSelectedRow());
				seleccionoMuestra = true;
				GUIABMMuestra.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,"Se ha seleccionado un elemento invalido","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
   				   		
		}
	
	
	/**
	 * @return the seleccionado
	 */
	public Muestra getSeleccionado() throws Exception {
		ControlGestionarMuestra control = new ControlGestionarMuestra();
		Muestra muestra = (control.obtenerMuestra((String)seleccionado[1],(String)seleccionado[0]));
		return muestra;
	}
	
	/**
	 * @return the seleccionoMuestra
	 */
	public boolean seSeleccionoMuestra() {
		return seleccionoMuestra;
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
		
	public void mouseClicked(MouseEvent e){
		if (e.getClickCount() == 2)
			seleccionarMuestra();
			detallarMuestra();
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER)
        	seleccionarMuestra();
        	detallarMuestra();
			System.out.println("ando el enter");
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}