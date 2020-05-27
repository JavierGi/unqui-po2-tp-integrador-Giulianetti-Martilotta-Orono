package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Voto {
	
	private Usuario usuario;
	private Ivotable votable;
	private String nivelUsuario;
	private LocalDate fechaVoto;


	public Voto(Usuario usuario, Ivotable votable) {
		
		this.usuario = usuario;
		this.nivelUsuario = usuario.getNivel();
		this.votable = votable;
		this.fechaVoto = LocalDate.now();
		
	}


	public String getNivelUsuario() {
		// TODO Auto-generated method stub
		return this.nivelUsuario;
	}


	public String getTipo() {
		return this.votable.getTipo();		
	}

}
