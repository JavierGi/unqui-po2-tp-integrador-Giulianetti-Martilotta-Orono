package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerificadorBasicos implements IverificadorDeMuestras {
	
	public VerificadorBasicos() {
		
	}
	
	public String verificarMuestra(Muestra muestra) {
		
		ArrayList<String> votos = this.generarListaDeTipos(muestra.getVotacion());

		
		ArrayList<String> votacionSinRepetidos = (ArrayList<String>) votos.stream()
		.distinct()
		.collect(Collectors.toList());
		

		ArrayList<ArrayList<String>> listaGeneralVotos = new ArrayList<ArrayList<String>>();

		String ganador = "";

		Integer cantidadVotosGanador = 0;
		
		for(String voto : votacionSinRepetidos) {			
	
			Integer cantidadVotos = this.cantidadVotosDe(votos.stream(),voto);				
			listaGeneralVotos.add(this.votosDe(votos.stream(), voto));	
			if( cantidadVotos > cantidadVotosGanador) {
				cantidadVotosGanador = this.cantidadVotosDe(votos.stream(),voto);
				ganador = voto;
			}	
		}
		
		if(hayEmpate(listaGeneralVotos,cantidadVotosGanador)) {
			ganador = "Indefinido";
		}
			
		return ganador;
	}

	public ArrayList<String> generarListaDeTipos(ArrayList<Voto> votacion) {
		
		ArrayList<String> votos = new ArrayList<String>();
		for(Voto voto : votacion) {
			votos.add(voto.getTipo().getTipo());
		}
		return votos;
	}

	private ArrayList<String> votosDe(Stream<String> stream, String voto) {
		
		return (ArrayList<String>) stream.filter(v -> v.equals(voto)).collect(Collectors.toList());
		
	}

	private Integer cantidadVotosDe(Stream<String> stream, String voto) {
		return (int)stream
						.filter(v -> v.equals(voto))
						.count();
	}
	

	public Boolean hayEmpate(ArrayList<ArrayList<String>> resultado, Integer cantidad) {
		
		if(resultado.size()>1) {
			ArrayList<Integer> votos = new ArrayList<Integer>();
			for(ArrayList<String> valor : resultado) {
				votos.add(valor.size());
			}			
			votos = (ArrayList<Integer>) votos.stream()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
				
			return cantidad == votos.get(1);
		}else {
			return false;
		}
	}	
	
	
	public Itipo controlar(Muestra muestra) {
		
		int contador = 0;
		Itipo ganador = null;
		for(Voto voto : muestra.getVotacion()) {
			if(muestra.cantidadVotosDeTipo(voto.getTipo()) > contador) {
				contador = muestra.cantidadVotosDeTipo(voto.getTipo());
				ganador = voto.getTipo();
			}
			
		}
		
		if(empate(muestra, contador)) {
			ganador = new Votable("Indefinido");
		}
		
		return ganador;
		
	}

	public boolean empate(Muestra muestra, int contador) {
			
		return muestra.getVotacion().stream()
				.filter(v -> muestra.cantidadVotosDeTipo(v.getTipo()) == contador)
				.collect(Collectors.toList())
				.size()>1;
	}



}
