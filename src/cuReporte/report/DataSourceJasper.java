package cuReporte.report;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.Hashtable;

public class DataSourceJasper implements JRDataSource {  
	
	private Object[][] data;

	@SuppressWarnings("rawtypes")
	private Hashtable tabla = null; 
	private int index = -1;

	@SuppressWarnings("rawtypes")
	public DataSourceJasper(Object[][] newData, Hashtable newTabla) {
		data = newData;
		tabla = newTabla;
	}

	public boolean next() throws JRException {		
		index++;
		return (index < data.length);
	}

	public Object getFieldValue(JRField field) throws JRException {
		String fieldName = field.getName();
		Object res = data[index][((Integer) tabla.get(fieldName)).intValue()];
		return res;
	}

}
