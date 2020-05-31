package ar.edu.unq.po2.tpIntegrador;

import java.util.Map;
import java.util.stream.Collectors;

public class EstadoVerificable extends EstadoDeMuestra {
	
	private boolean esVerificable;
	
	public EstadoVerificable(Muestra muestra) {
		super(muestra);
		this.esVerificable = true;		
	}
	
	public boolean getEstado() {
		return this.esVerificable;
	}

	@Override
	public Itipo getEspecie() {	
		return null;				
	}

	public void agregarVoto(Voto voto) {
		
		if(super.muestra.noRegistraVotoDe(voto.getUsuario())) {
			this.verificarModificacionDeEstado(voto);			
			this.concretarVotaci�n(voto);	
		}
		
	}

	public void concretarVotaci�n(Voto voto) {
		
		this.muestra.agregarVoto(voto);
		
	}

	public void verificarModificacionDeEstado(Voto voto) {
		
		if(voto.getNivelUsuario() == "Experto") {
			this.muestra.setEstado(new EstadoVerificacionExpertos(this.muestra));
			this.muestra.setCalculador(new CalculadorExperto());
		}
		
	}



}
