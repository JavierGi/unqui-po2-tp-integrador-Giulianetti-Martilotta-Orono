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
	private Icalculador calculador;

	public Muestra(Usuario usuario, Ubicacion ubicacion, String foto, Itipo vinchuca) {
		
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.foto = foto;
		this.vinchuca = vinchuca;
		this.estado = new EstadoVerificable(this);
		this.votacion = new ArrayList<Voto>();
		this.calculador = new CalculadorBasico();
	
	}

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void registrarVerificacion(Voto voto) throws VotacionCerradaException{
		
		this.estado.agregarVoto(voto);
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
		return this.calculador.calcularTipo(this);
	}
	

	public boolean noRegistraVotoDe(Usuario username) {
		
		return this.getVotosDe(username).size() == 0;
	}



	public void agregarVoto(Voto voto) {
		this.getVotacion().add(voto);
	}

	
	public ArrayList<Voto> getVotosDe(Usuario usuario) {
		
		return (ArrayList<Voto>) this.getVotacion()
										.stream()
										.filter(v -> v.getUsuario() == usuario)
										.collect(Collectors.toList());
		}


	public ArrayList<Voto> getVotosDeNivel(String nivel) {
				
		return (ArrayList<Voto>) this.getVotacion()
				.stream()
				.filter(v -> v.getNivelUsuario() == nivel)
				.collect(Collectors.toList());		
	
	}



	public Integer cantidadVotosDeTipo(Itipo tipo) {
		
		
		return (int) this.getVotacion().stream().filter(v -> v.getTipo().getTipo() == tipo.getTipo()).count();
	}



	public void setCalculador(Icalculador calculador) {
		this.calculador = calculador;
		
	}
}
