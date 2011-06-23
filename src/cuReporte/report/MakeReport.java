package cuReporte.report;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

public class MakeReport {
	
	public static String BASE = (new java.io.File("")).getAbsolutePath(); 
	public static String PATH_SOURCE_REPORT = BASE + "/src/cuReporte/report/xml/";
 
	public static String PATH_OUTPUT_REPORT = BASE + "/classes/cuReporte/report/xml/";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void make(String nameReport) {
		try {
			
			String osName = System.getProperty("os.name" );
			System.out.println(osName);
            if (osName.equals("Linux")) {
                    PATH_SOURCE_REPORT = BASE + "/src/cuReporte/report/xml/";
                    PATH_OUTPUT_REPORT = BASE + "/classes/cuReporte/report/xml/";
            }
            else {
                    PATH_SOURCE_REPORT = BASE + "\\src\\cuReporte\\report\\xml\\";
                    PATH_OUTPUT_REPORT = BASE + "\\classes\\cuReporte\\report\\xml\\";
                    
            }
			System.setProperty("org.xml.sax.driver","org.apache.xerces.parsers.SAXParser");
			String fileXML = PATH_SOURCE_REPORT + nameReport + ".xml";
			String fileJASPER = PATH_OUTPUT_REPORT + nameReport + ".jasper";
			String fileJRPRINT = PATH_OUTPUT_REPORT + nameReport + ".jrprint";

			long start = System.currentTimeMillis();

			System.out.println("Compile Report to File : " +  nameReport);
			System.out.println("fileXML:"+fileXML);
			System.out.println("fileJASPER:"+fileJASPER);
			JasperCompileManager.compileReportToFile(fileXML, fileJASPER);
			System.out.println("Compiling time : "+ (System.currentTimeMillis() - start) + "\n");
			System.out.println("Fill Report to File : " + fileJRPRINT);
			HashMap directorio = new HashMap();
			directorio.put("pathSistema", BASE);//  ACA TA LA COSA FEA
			JasperFillManager.fillReportToFile(fileJASPER, fileJRPRINT, directorio,new JREmptyDataSource());
			System.out.println("Filling time : "+ (System.currentTimeMillis() - start) + "\n");

			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

 }
	
	public static void main(String[] args) {

		
		String nameReport = "report1";
		MakeReport.make(nameReport);

}
	
	
}
