package ar.edu.unq.po2.tpIntegrador;

public class Vinchuca implements Itipo {
	
	private String especie;
	public Vinchuca(Itipo tipo) {
		
		this.especie = tipo.getTipo();
	}
	

	@Override
	public String getTipo() {
		return this.especie;
	}

}
