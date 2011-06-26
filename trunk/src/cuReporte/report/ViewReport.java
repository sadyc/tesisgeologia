package cuReporte.report;


import java.awt.Dialog.ModalExclusionType;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;


public class ViewReport {
	
	private Object[][] tabla;
	private Object [] datos;
	public static String BASE = (new java.io.File("")).getAbsolutePath(); 
    
    public ViewReport(Object[][] tabla, Object[] datos){
            this.tabla = tabla.clone();
            this.datos = datos.clone();
            
    }
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void viewReport(Object[][] param, String[] fieldXml,
			String nameReport, Object[][] values) {
		try {
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
			JasperViewer reporte = new JasperViewer(JasperFillManager.fillReport(fileNameReport, parameters, data));
			reporte.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            reporte.show();
		} catch (JRException exc) {
			exc.printStackTrace(System.out);
		}
	}
	public void viewClasificacion() {

		Object[][] tablaAux =tabla ; 
		Object[][] parameters = {{ "reportTitle", "Sistema Clasificador de Suelos" }, {"nombre",(String)datos[0]},{"ubicacion",(String)datos[1]},{"peso",(String)datos[2]},{"profundidadInicial",(String)datos[3]},{"profundidadFinal",(String)datos[4]},{"limiteLiquido", (String)datos[5]},{"limitePlastico",(String)datos[6]},{"indicePlasticidad",(String)datos[7]},{"D60",(String)datos[8]},{"D30",(String)datos[9]},{"D10",(String)datos[10]},{"gradoCurvatura",(String)datos[11]},{"coeficienteUniformidad",(String)datos[12]},{"clasificacionSucs",(String)datos[13]},{"detallesSucs",(String)datos[14]},{"clasificacionAashto",(String)datos[15]},{"detallesAashto",(String)datos[16]},{"pathSistema",BASE},{"tituloAashto","CLASIFICACIÓN AASHTO"},{"tituloSucs","CLASIFICACIÓN SUCS"}};
     	String[] filedXml = {"NumeroTamiz", "AberturaMalla", "%Pasante", "%RetenidoAcumulado", "%RetenidoParcial"};
 		String nameReport = "report1";
		this.viewReport(parameters, filedXml, nameReport, tablaAux);

	}

}
