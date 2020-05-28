package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Muestra {
	
	private Usuario usuario;
	private Ubicacion ubicacion;
	private String foto;
	private Ivinchuca vinchua;
	private EstadoDeMuestra estado;
	private ArrayList<Voto> votacion;

	public Muestra(Usuario usuario, Ubicacion ubicacion, String foto, Ivinchuca vinchuca) {
		
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.foto = foto;
		this.vinchua = vinchuca;
		this.estado = new EstadoVerificable(this);
		this.votacion = new ArrayList<Voto>();
	
	}

	public void registrarVoto(String voto) throws VotacionCerradaException{
		
		if(this.esVerificable()) {
			this.foto = voto;
		}else {
			throw new VotacionCerradaException("La votacion ya esta cerrada");
		}
		
	}
	
	public String exVotacionCerrada() {
		return "No verificable";
	}

	public boolean esVerificable() {
		
		return this.estado.getEstado();
	}

	public void setEstado(EstadoDeMuestra estado) {
		this.estado = estado;		
	}
	
	public EstadoDeMuestra getEstado() {
		return this.estado;
	}

	public ArrayList<Voto> getVotacion() {
		// TODO Auto-generated method stub
		return this.votacion;
	}

	public Ivinchuca getEspecie() {
		// TODO Auto-generated method stub
		return this.vinchua;
	}
	
	
	public String test(ArrayList<String> votos) {

		@SuppressWarnings("unchecked")
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
	
	

}
