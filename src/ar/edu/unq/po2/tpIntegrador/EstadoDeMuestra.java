package ar.edu.unq.po2.tpIntegrador;

public abstract class EstadoDeMuestra {
	
	protected Muestra muestra;
	public EstadoDeMuestra(Muestra muestra) {
		
		this.muestra = muestra;
	}

	protected abstract boolean getEstado();

	protected abstract Itipo getEspecia();

	protected abstract void agregarVoto(Voto voto);

}
