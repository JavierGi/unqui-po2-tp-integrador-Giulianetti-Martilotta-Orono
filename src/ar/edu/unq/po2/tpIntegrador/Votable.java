package ar.edu.unq.po2.tpIntegrador;

public class Votable implements Itipo {
	
	private String tipo;
	public Votable(String nombre) {
		this.tipo = nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	

}
