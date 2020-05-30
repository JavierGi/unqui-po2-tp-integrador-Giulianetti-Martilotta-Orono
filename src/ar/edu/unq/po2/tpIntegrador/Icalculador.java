package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.stream.Stream;

public interface Icalculador {

	
	public Itipo calcularTipo(Muestra muestra);
	
	public boolean hayEmpate(Muestra muestra, Integer score);


}
