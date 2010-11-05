package cuGestionarTamiz;

import java.util.Collection;
import java.util.HashSet;

import persistencia.domain.Analisis;
import persistencia.domain.Tamiz;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Analisis> analisisTamiz = new HashSet();;
		Tamiz tam1 = new Tamiz (99,11,analisisTamiz);
		MediadorTamiz tamiz = new MediadorTamiz(tam1);
		
	}

}
