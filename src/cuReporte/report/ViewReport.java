package cuReporte.report;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;


public class ViewReport {
	
	private static String[] []valores;
    
    public ViewReport(String[][] valores){
            this.valores = valores.clone();
            
    }
	public void viewReport(Object[][] param, String[] fieldXml,
			String nameReport, String[][] values) {
		// Reporte
		try {
			// parametros
			java.util.HashMap parameters = new java.util.HashMap(); 
		
			for (int i = 0; i <param.length; i++) {
				parameters.put(param[i][0], param[i][1]);
			}
			java.util.Hashtable ht = new java.util.Hashtable();
		
			for (int i = 0; i < fieldXml.length; i++) {
				ht.put(fieldXml[i], new Integer(i));
			}
			
			DataSourceJasper data = new DataSourceJasper(values, ht);
			String fileNameReport = MakeReport.PATH_OUTPUT_REPORT + nameReport + ".jasper";
			System.out.println("Reporte:" + fileNameReport);

			JasperViewer.viewReport(JasperFillManager.fillReport(
					fileNameReport, parameters, data));
		} catch (JRException exc) {
			exc.printStackTrace(System.out);
		}
	}
	public void viewPersons() {

		String[][] values = valores ; //INFO A LLENAR EN EL REPORTE.
		
		
		//parameters
		//Object[][] parameters = { { "reportTitle", "Listado de Personas." },{ "datePrint", "11-11-05" } };
		Object[][] parameters = { { "datePrint", "11-11-07" },{ "reportTitle", "Listado de Personas." },{ "datePrint", "11-11-07" },{ "reportTitle", "Listado de Personas." } };
     	String[] filedXml = { "nombre", "ubicacion", "peso" ,"profindidadInicial", "profundidadFinal", "limiteLiquido", "limitePlastico", "indicePlasticidad", "D60", "D30" , "D10", "coefUniformidad", "gradoCurvatura"};   //Son los campos a llenar en el XML. Deben tener el mismo nombre.
 
		String nameReport = "report1";

		this.viewReport(parameters, filedXml, nameReport, values);
	}

	public static void main(String[] args) {

		ViewReport ve = new ViewReport(valores);
		ve.viewPersons();

	}

	}
