package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	
	public String test() {
				
		ArrayList<String> votos = new ArrayList<String>();
		votos.add("pablo");
		votos.add("pablo");
		votos.add("pablo");
		votos.add("ro");
		votos.add("o");
		votos.add("o");
		votos.add("roo");
		votos.add("roo");
		votos.add("roo");
		
		
		@SuppressWarnings("unchecked")
		ArrayList<String> votacionSinRepetidos = (ArrayList<String>) votos.stream().distinct().collect(Collectors.toList());
		//HashMap<String,Long> tabla = new HashMap<String,Long>();
		
		//Long ganador = 0l;
		ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>(); 
		String ganador = "";
		Integer contador = 0;
		for(String voto : votacionSinRepetidos) {
			
			//Long ocurrencias = ganador = votos.stream().filter(v -> v.equals(voto)).count();
			//tabla.put(voto, ocurrencias);
			
			resultado.add((ArrayList<String>) votos.stream().filter(v -> v.equals(voto)).collect(Collectors.toList()));
			if(votos.stream().filter(v -> v.equals(voto)).count() > contador) {
				contador = (int) votos.stream().filter(v -> v.equals(voto)).count();
				ganador = voto;
			}
			
			
			
		}
		
		if(contador > totalDeVotos(resultado)) {
			return ganador;
		}else {
			return "Indefinido";
		}
	
		
	}

	public Integer totalDeVotos(ArrayList<ArrayList<String>> resultado) {
		
		ArrayList<Integer> votos = new ArrayList<Integer>();
		for(ArrayList<String> valor : resultado) {
			votos.add(valor.size());
		}
		
		votos = (ArrayList<Integer>) votos.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return votos.get(1);
	}	
	
	

}
