package ar.edu.unq.po2.tpIntegrador;

public class Verificada extends EstadoDeMuestra {
	
	private Boolean verificable;
	
	public Verificada(Muestra muestra) {
		super(muestra);
		this.verificable = false;
	}

	@Override
	protected boolean getEstado() {
		return this.verificable;
	}

	@Override
	protected Itipo getEspecia() {
		// Implementar que devuelva que tipo es si se puede devolver un tipo
		return null;
	}

}
