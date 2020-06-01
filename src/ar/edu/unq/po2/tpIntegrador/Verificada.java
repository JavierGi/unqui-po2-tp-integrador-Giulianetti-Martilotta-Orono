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
	public void verificarModificacionDeEstado(Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void agregarVoto(Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void concretarVotación(Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Itipo getEspecie() {
		// TODO Auto-generated method stub
		return null;
	}

}
