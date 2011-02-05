package cuReporte;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JButton;
import report.*;

public class PruebaReporte extends JFrame { 

	private JPanel jContentPane = null;
	private JButton jButtonPruebaReporte = null;

	public PruebaReporte() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	public PruebaReporte(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public PruebaReporte(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public PruebaReporte(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes jButtonPruebaReporte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPruebaReporte() {
		if (jButtonPruebaReporte == null) {
			jButtonPruebaReporte = new JButton();
			jButtonPruebaReporte.setText("Probar Reporte");
			jButtonPruebaReporte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ViewReport viewReport = new ViewReport();
					viewReport.viewPersons();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonPruebaReporte;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PruebaReporte pruebaReporte = new PruebaReporte ();
		pruebaReporte.show(); 

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJButtonPruebaReporte(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

}
