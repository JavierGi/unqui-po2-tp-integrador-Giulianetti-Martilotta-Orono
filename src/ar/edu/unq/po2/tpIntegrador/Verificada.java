package ar.edu.unq.po2.tpIntegrador;

public class Verificada extends EstadoDeMuestra {
	
	private Boolean verificable;
	
	public Verificada() {
		this.verificable = false;
	}

	@Override
	protected boolean getEstado() {
		return this.verificable;
	}

}
