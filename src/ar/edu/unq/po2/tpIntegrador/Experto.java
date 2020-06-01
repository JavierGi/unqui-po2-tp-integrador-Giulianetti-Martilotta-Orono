package ar.edu.unq.po2.tpIntegrador;

public class Experto implements Inivel {
	
	private String nivel;
	
	public Experto() {
		
		this.nivel = "Experto";
		
	}

	@Override
	public String getNivel() {
		// TODO Auto-generated method stub
		return this.nivel;
	}

}
