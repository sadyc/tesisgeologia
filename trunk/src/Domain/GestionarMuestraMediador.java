package Domain;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Domain.Singleton;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;



/**
 * @author TesisGeologia
 *
 */
/**
 * @author NAVE
 *
 */
public class GestionarMuestraMediador implements ActionListener,MouseListener,ItemListener{

	private GestionarMuestra gestionarMuestra = null;
	Object [][] data = new Object [5] [5];
	private Component frame;
	private PersistenceManager pm = null;
	private Transaction tx = null;
	
	public GestionarMuestraMediador(String nombreVentana) {
		super();
		cargarBD();
		this.gestionarMuestra = new GestionarMuestra(nombreVentana,data);
		// se configura como escuchador de los evenetos de la ventana 
		// al el mismo (mediador)
		this.gestionarMuestra.setListenerButtons(this);
		this.gestionarMuestra.setListenerTable(this);
		
	}
	
	
	/**
	 * Levanta informacion almacenada en la 
	 * base de datos.
	 */
	public void cargarBD(){
		pm = Singleton.getInstance();
		tx = pm.currentTransaction();
		int i = 0;
		try
		{
		    tx.begin();
		    Extent e = pm.getExtent(Muestra.class, true);
		    Iterator iter=e.iterator();
		    Muestra mu = new Muestra();
		    while (iter.hasNext()){
		    	mu = (Muestra)iter.next();
		    	data [i][0]= mu.getNombreMuestra();
		        data [i][1]= mu.getPeso();		        
		        data [i][2]= mu.getProfundidadInicial();
		        data [i][3]= mu.getProfundidadFinal();
		        data [i][4]= mu.getOperador().getDni();
		        i++;
		    }
		    tx.commit();
		}
		catch (Exception e){
		    if (tx.isActive()){
		        tx.rollback();
		    }
		}
        pm.close();
    }
	
	/**
	 * 
	 * 
	 */ 
	public void InsertarMuestraBD(Muestra mu){
		pm = Singleton.getInstance();
		tx = pm.currentTransaction();
		try
        {
            tx.begin();
            System.out.println("Persisting products");
            pm.makePersistent(mu);
            tx.commit();
            System.out.println("Muestra have been persisted");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
     		  pm.close();
        }
        
	}
	
	
	
	/**
	 * 
	 * 
	 */ 
	public void eliminarMuestraBD(){
		pm = Singleton.getInstance();
		tx = pm.currentTransaction();
		try{
		 tx.begin();
		 Extent e = pm.getExtent(Muestra.class, true);
		 Iterator iter=e.iterator();
		 Muestra mu = new Muestra(); 
		 String nombreMuestra= ((gestionarMuestra.getTablePanel().getRow((gestionarMuestra.getTablePanel().getSelectedRow())))[0]);
		 while (iter.hasNext() && (mu.getNombreMuestra().compareTo(nombreMuestra))!=0){
		   mu = (Muestra)iter.next();
		 }
		 pm.deletePersistent(mu);
		 gestionarMuestra.getTablePanel().removeRow(gestionarMuestra.getTablePanel().getSelectedRow());
         tx.commit();
		}
		catch (Exception e)
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
 		  pm.close();
		
	}
	
	
	/**
	 * 
	 * 
	 */
	public void ModificarMuestraBD(){
		pm = Singleton.getInstance();
		tx = pm.currentTransaction();
		try{
			 tx.begin();
			 Extent e = pm.getExtent(OperadorDeLaboratorio.class, true);
			 Iterator iter=e.iterator();
	         System.out.println("Persisting products");
	         ModificarMuestraMediador modificarMuestra = new ModificarMuestraMediador(gestionarMuestra.getTablePanel().getRow((gestionarMuestra.getTablePanel().getSelectedRow())));
			 modificarMuestra.show();
	         eliminarMuestraBD();
			 gestionarMuestra.getTablePanel().removeRow(gestionarMuestra.getTablePanel().getSelectedRow());
			 OperadorDeLaboratorio op = new OperadorDeLaboratorio("asd","asd",1);
			 Muestra mu = new Muestra((modificarMuestra.getData()[0]),Integer.parseInt(modificarMuestra.getData()[1]),Float.parseFloat(modificarMuestra.getData()[2]),Float.parseFloat(modificarMuestra.getData()[3]),op);
  			 InsertarMuestraBD(mu);
			 this.gestionarMuestra.getTablePanel().addRow(modificarMuestra.getData());
			 pm.makePersistent(mu);
             tx.commit();
             System.out.println("Muestra have been persisted");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        
	}
	
	
	
	
	
	
		
	public void show()	{
		 gestionarMuestra.show();
	}
	
	public GestionarMuestra getGestionarMuestra() {
		return gestionarMuestra;
	}
	
	public void setGestionarMuestra(GestionarMuestra gestionarMuestra) {
		this.gestionarMuestra = gestionarMuestra;
	}
	
	/**
	 * Metodo que necesita definir al implementar la interface ActionListener 
	 * Para tratar los eventos de acciones de los componentes 
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
	   	if (this.gestionarMuestra.getJButtonAgregar() == source){
	   		AltaMuestraMediador altaMuestra = new AltaMuestraMediador();
     		System.out.println("GestionarMediador.actionPerformed() jButtonAgregar");
     		altaMuestra.show();   
     		OperadorDeLaboratorio op = new OperadorDeLaboratorio("asd","asd",1);
        	Muestra mu = new Muestra((altaMuestra.getData()[0]),Integer.parseInt(altaMuestra.getData()[1]),Float.parseFloat(altaMuestra.getData()[2]),Float.parseFloat(altaMuestra.getData()[3]),op);
        	if (altaMuestra.getData()[0] != null){  // alta
        		this.gestionarMuestra.getTablePanel().addRow(altaMuestra.getData());
        		InsertarMuestraBD(mu);
     
     		}
	   	}
		if (this.gestionarMuestra.getJButtonEliminar() == source){
			if (gestionarMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a eliminar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
			    int quitOption = JOptionPane.showConfirmDialog(new JFrame(),"¿Esta Seguro de eliminar la fila?","Eliminar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	            if(quitOption==JOptionPane.YES_OPTION){
	            	eliminarMuestraBD();
	            }
			}
		}
		if (this.gestionarMuestra.getJButtonModificar() == source){
			if (gestionarMuestra.getTablePanel().getSelectedRow() == -1){
				JOptionPane.showMessageDialog(frame,"No se ha seleccionado ningun elemento a modificar","ERROR!!!!!!!!!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				ModificarMuestraMediador modificarMuestra = new ModificarMuestraMediador(gestionarMuestra.getTablePanel().getRow((gestionarMuestra.getTablePanel().getSelectedRow())));
				if (modificarMuestra.getData()[0] != null){  // si apreto cancelar no me agrega nada
					ModificarMuestraBD();				
				}	
			}
		}
	}
	
	/**
	 * Metodos que necesita definir al implementar la interface MouseListener 
	 * Para tratar los eventos de mouse 
	 */
	public void mouseClicked(MouseEvent arg0) {
		Object source = arg0.getSource();
		if (this.gestionarMuestra.getTablePanel() == source)
			System.out.println("GestionarMediador.actionPerformed() jJTableTabla");
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
	/**
	 * @returns data 
	*/
	
	public Object[] getData(){
		return this.data;
	}
	public void itemStateChanged(ItemEvent e) {
	}

}
