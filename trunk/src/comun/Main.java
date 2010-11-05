package comun;

import javax.swing.WindowConstants;

public class Main {
	public static void main(String[] args) { 
        try {
       	 
		 		GUIPrincipal exampleTable = new GUIPrincipal("SISTEMA DE CLASIFICACIÓN DE SUELOS");

		 	// Centramos el Frame en la pantalla
		 		exampleTable.setLocationRelativeTo(null);
		 		exampleTable.setVisible(true);
		 		exampleTable.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				 		
		  }
        catch (Exception exception) {
      	    exception.printStackTrace();
        }
	}

}
