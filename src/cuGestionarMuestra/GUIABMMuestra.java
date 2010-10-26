package cuGestionarMuestra;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
//import java.awt.HeadlessException;


import javax.swing.*;

import comun.TablePanel;


/**
 * @author TesisGeologia
 * 
 * Clase que define la interfaz para dar de alta una muestra   
 */
public class GUIABMMuestra extends JFrame {


	/**
	 * @param title
	 * @throws java.awt.HeadlessException
	 */

	private JPanel panelSur=null;
	private TablePanel tablePanel=null;
	private JButton jButtonAgregar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonModificar = null;
	private Object [][] data;
	
	
	private static final String systemDefault = javax.swing.UIManager.getSystemLookAndFeelClassName();	
	
	/**
	 * This is the parametrized constructor used in modification
	 * @param data  arreglo que almacena los datos de una muestra. 
	 */
	public GUIABMMuestra(String title, Object [][] datos) {
		super(title);
		data = datos;
		initialize();
	}

	/**
	 * Metodo que inicializa la interfaz.
	 *
	 * @return void
	 */
	private  void initialize() {
		this.setSize(803, 200);
        // Seteamos el BorderLayout
		this.getContentPane().setLayout(new BorderLayout());
 		
	 	// Se aaden los componentes al Frame
	 	// Agregamos la tabla  al Frame
	 	this.getContentPane().add(this.getTablePanel(),BorderLayout.CENTER);
	 	// Agregamos el Panel Sur al Frame
	 	this.getContentPane().add(this.getPanelSur(),BorderLayout.SOUTH);
	}
	
	/**
	 * This method initializes botonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new java.awt.Rectangle(21,113,89,34));
			jButtonAgregar.setText("Agregar");
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes botonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new java.awt.Rectangle(277,113,89,34));
			jButtonEliminar.setText("Eliminar");
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes botonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new java.awt.Rectangle(149,113,89,34));
			jButtonModificar.setText("Modificar");
		}
		return jButtonModificar;
	}
	
	/**
	 * Metodo que permite escuchar los botoner Agregar, Eliminar, Modificar.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerButtons(ActionListener lis){
		this.jButtonAgregar.addActionListener(lis);
		this.jButtonEliminar.addActionListener(lis);
		this.jButtonModificar.addActionListener(lis);
        
	}
	/**
	 * Metodo que permite escuchar la tabla panel.
	 *
	 *@param lis actionEvent asignado a los botones.
	 */
	public void setListenerTable(MouseListener lis){
		this.tablePanel.addMouseListener(lis);
	}
	



    /** 
     *@return data  
     * */
	/**public static String[][] getData(){
		String[][] data = {
				{"11","12","13","14","1"},
				{"21","22","23","24","2"},
				{"31","32","33","","3"}
				};
		return data;
	}*/

	/** 
     *@return data  
     * */
	public static String[] getColumName(){
		String[] columnName = {"Nombre","Peso","Profundidad Inicial","Profundidad Final", "Operador ID"};
		return columnName;
	}

	/**
	 * Metodo que retorna el panelSur.
	 *
	 * @return Jpanel
	 */
	public JPanel getPanelSur() {
		if (this.panelSur==null) {
		this.panelSur = new JPanel();
		// Se pone el FlowLayout en el Panel Sur
		this.panelSur.setLayout(new FlowLayout());
		// Se aaden los componentes al panel Sur
		this.panelSur.add(getJButtonAgregar());
		this.panelSur.add(getJButtonModificar());
		this.panelSur.add(getJButtonEliminar());
		}
		return this.panelSur;
	}

	/**
	 * Metodo que retorna la tabla panel.
	 *
	 * @return TablePanel
	 */
	public TablePanel getTablePanel() {
		if (this.tablePanel==null) {
			this.tablePanel = new TablePanel();
	 		this.tablePanel.setData(data, getColumName());			
		}
		return this.tablePanel;
	}
	
	/**
	 * Metodo que elimina una fila de la tabla Panel
	 *
	 * @param nro  Corresponde al numero de la fila a eleminar
	 */
	public void EliminarFila(int nro){
    	this.tablePanel.removeRow(nro);    	
    }
	
}
