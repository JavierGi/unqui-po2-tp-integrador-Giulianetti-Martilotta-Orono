package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculadorBasico implements Icalculador {
	
	public CalculadorBasico() {
		
	}
	
	
	public Itipo calcularTipo(Muestra muestra) {
		
		int contador = 0;
		Itipo ganador = null;
		for(Voto voto : muestra.getVotacion()) {
			if(muestra.cantidadVotosDeTipo(voto.getTipo()) > contador) {
				contador = muestra.cantidadVotosDeTipo(voto.getTipo());
				ganador = voto.getTipo();
			}
			
		}
		
		if(hayEmpate(muestra, contador)) {
			ganador = new Votable("Indefinido");
		}
		
		return ganador;
		
	}

	public boolean hayEmpate(Muestra muestra, Integer contador) {
			
		return muestra.getVotacion().stream()
				.filter(v -> muestra.cantidadVotosDeTipo(v.getTipo()) == contador)
				.collect(Collectors.toList())
				.size()>1;
	}



}
