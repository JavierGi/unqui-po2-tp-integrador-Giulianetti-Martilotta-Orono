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
	private Itipo vinchuca;
	private EstadoDeMuestra estado;
	private ArrayList<Voto> votacion;

	public Muestra(Usuario usuario, Ubicacion ubicacion, String foto, Itipo vinchuca) {
		
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.foto = foto;
		this.vinchuca = vinchuca;
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

	public Itipo getEspecie() {
		// TODO Auto-generated method stub
		return this.vinchuca;
	}	
	

}
