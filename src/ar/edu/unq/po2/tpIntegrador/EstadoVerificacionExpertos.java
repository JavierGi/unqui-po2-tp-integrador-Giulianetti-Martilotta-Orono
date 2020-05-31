package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EstadoVerificacionExpertos extends EstadoDeMuestra {
	
	
	public EstadoVerificacionExpertos(Muestra muestra) {
		super(muestra);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean getEstado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Itipo getEspecie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarVoto(Voto voto) {
		
		if(this.muestra.noRegistraVotoDe(voto.getUsuario())) {
			
			this.concretarVotación(voto);
			this.verificarModificacionDeEstado(voto);
						
		}
	}

	@Override
	public void verificarModificacionDeEstado(Voto voto) {
		
		if(this.muestra.cantidadVotosDeTipo(voto.getTipo()) > 1) {
			
			this.muestra.setEstado(new Verificada(this.muestra));
			this.muestra.setCalculador(new CalculadorVerificado(voto));
		}
		
	}


	@Override
	protected void concretarVotación(Voto voto) {
		
		this.muestra.agregarVoto(voto);
	}

}
