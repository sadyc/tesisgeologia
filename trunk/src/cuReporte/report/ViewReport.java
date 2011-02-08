package cuReporte.report;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;


public class ViewReport {
	
	private static Object[][] valores;
    
    public ViewReport(Object[][] valores){
            this.valores = valores.clone();
            
    }
	public void viewReport(Object[][] param, String[] fieldXml,
			String nameReport, Object[][] values) {
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
			System.out.println("AAAAAAAAAAA      "+ht);
			String fileNameReport = MakeReport.PATH_OUTPUT_REPORT + nameReport + ".jasper";
			System.out.println("Reporte:     " + fileNameReport);
			JasperViewer.viewReport(JasperFillManager.fillReport(
					fileNameReport, parameters, data));
		} catch (JRException exc) {
			System.out.println("Excepcion del reporte");
			exc.printStackTrace(System.out);
		}
	}
	public void viewPersons() {

		Object[][] values = valores ; //INFO A LLENAR EN EL REPORTE. la cantidad de filas son la cantidad de hojas :-/
		
		
		
		Object[][] parameters = { { "datePrint", "29/11/1988" },{ "reportTitle", "Sistema Clasificador de Suelos" }, {"nombre", "nombre: "},{"ubicacion","ubicacion:"},{"peso","peso:"},{"profundidadInicial","profundidadINI:"},{"profundidadFinal","profundidaFIN: "} };
     	String[] filedXml = {"NumeroTamiz", "AberturaMalla", "%Pasante", "%RetenidoAcumulado", "%RetenidoParcial"};// "nombre", "ubicacion", "peso", "profundidadInicial", "profundidadFinal", "limiteLiquido", "limitePlastico", "indicePlasticidad", "D60", "D30" , "D10", "coefUniformidad", "gradoCurvatura",*/ "numeroTamiz", "aberturaMalla", "%Pasante", "%RetenidoAcumulado", "%RetenidoParcial"};//, "clasificacionAashto", "descripcionAashto", "clasificacionSucs", "descripcionSucs"};   //Son los campos a llenar en el XML. Deben tener el mismo nombre.
 
		String nameReport = "report1";
		this.viewReport(parameters, filedXml, nameReport, values);
	}

	public static void main(String[] args) {

		ViewReport ve = new ViewReport(valores);
		ve.viewPersons();

	}

	}