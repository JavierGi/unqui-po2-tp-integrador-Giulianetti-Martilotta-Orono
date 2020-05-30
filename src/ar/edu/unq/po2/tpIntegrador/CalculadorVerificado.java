package ar.edu.unq.po2.tpIntegrador;

public class CalculadorVerificado implements Icalculador {
	
	private Itipo tipo;
	public CalculadorVerificado(Voto voto) {
		
		this.tipo = voto.getTipo();
	}

	@Override
	public Itipo calcularTipo(Muestra muestra) {
		// TODO Auto-generated method stub
		return this.tipo;
	}

	@Override
	public boolean hayEmpate(Muestra muestra, Integer score) {
		// TODO Auto-generated method stub
		return false;
	}

}
