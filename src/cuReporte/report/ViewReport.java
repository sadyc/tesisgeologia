package cuReporte.report;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;


public class ViewReport {
	
	private Object[][] tabla;
	private Object [] datos;
    
    public ViewReport(Object[][] tabla, Object[] datos){
            this.tabla = tabla.clone();
            this.datos = datos.clone();
            
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

		Object[][] tablaAux =tabla ; //INFO A LLENAR EN EL REPORTE. la cantidad de filas son la cantidad de hojas :-/
		
		
		System.out.println("nombre de la muestra en arregloo datos--->" + datos[0]);
		Object[][] parameters = {{ "reportTitle", "Sistema Clasificador de Suelos" }, {"nombre",(String)datos[0]},{"ubicacion",(String)datos[1]},{"peso",(String)datos[2]},{"profundidadInicial",(String)datos[3]},{"profundidadFinal",(String)datos[4]},{"limiteLiquido", (String)datos[5]},{"limitePlastico",(String)datos[6]},{"indicePlasticidad",(String)datos[7]},{"D60",(String)datos[8]},{"D30",(String)datos[9]},{"D10",(String)datos[10]},{"gradoCurvatura",(String)datos[11]},{"coeficienteUniformidad",(String)datos[12]},{"clasificacionSucs",(String)datos[13]},{"detallesSucs",(String)datos[14]},{"clasificacionAashto",(String)datos[15]},{"detallesAastho",(String)datos[16]}};
     	String[] filedXml = {"NumeroTamiz", "AberturaMalla", "%Pasante", "%RetenidoAcumulado", "%RetenidoParcial"};   //Son los campos a llenar en el XML. Deben tener el mismo nombre.
 		String nameReport = "report1";
		this.viewReport(parameters, filedXml, nameReport, tablaAux);

	}
	
	
	
	
	

	}
