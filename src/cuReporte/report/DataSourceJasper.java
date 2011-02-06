package cuReporte.report;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.Hashtable;



	public class DataSourceJasper implements JRDataSource {  

		private String[][] data;

		private Hashtable tabla = null; // entrada: nombre campo - valor: indice en

		// el arreglo (Integer)

		private int index = -1;

		public DataSourceJasper(String[][] newData, Hashtable newTabla) {
			System.out.println("Data:  " +newData[0][3]);
			System.out.println("Data:  " +newData[0][4]);
			System.out.println("Data:  " +newData[0][5]);
			data = newData;
			tabla = newTabla;
			
			System.out.println("Data:  " +data[0][3]);
			System.out.println("Data:  " +data[0][4]);
			System.out.println("Data:  " +data[0][5]);
			System.out.println("Datalenght:  " +data.length);
		
		}

		/**
		 * (non-Javadoc)
		 * 
		 * @see dori.jasper.engine.JRDataSource#next()
		 */
		public boolean next() throws JRException {		
			index++;
			return (index < data.length);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see dori.jasper.engine.JRDataSource#getFieldValue(dori.jasper.engine.JRField)
		 */
		public Object getFieldValue(JRField field) throws JRException {
	 		//String value = null;
			String fieldName = field.getName();
			Object res = data[index][((Integer) tabla.get(fieldName)).intValue()];
			return res;
		}

}
