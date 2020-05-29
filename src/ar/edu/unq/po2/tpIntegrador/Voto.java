package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Voto {
	
	private Usuario usuario;
	private Itipo votable;
	private String nivelUsuario;
	private LocalDate fechaVoto;


	public Voto(Usuario usuario, Itipo votable) {
		
		this.usuario = usuario;
		this.nivelUsuario = usuario.getNivel();
		this.votable = votable;
		this.fechaVoto = LocalDate.now();
		
	}


	public String getNivelUsuario() {
		// TODO Auto-generated method stub
		return this.nivelUsuario;
	}


	public Itipo getTipo() {
		return this.votable;		
	}


	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

}
