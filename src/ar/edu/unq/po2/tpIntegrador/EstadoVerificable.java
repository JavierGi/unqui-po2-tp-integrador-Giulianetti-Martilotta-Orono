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
	public Itipo getEspecia() {	
		
		//Implementar que devuelva la que va ganando o en caso de empate indefinido
		return null;
				
	}

	public void agregarVoto(Voto voto) {
		
		if(this.noRegistraVotoDe(voto.getUsuario())) {
			
			this.verificarModificaciónDeEstado(voto);
			this.concretarVotación(voto);	
		}
	}

	public void concretarVotación(Voto voto) {
		
		this.muestra.getVotacion().add(voto);
		
	}

	public void verificarModificaciónDeEstado(Voto voto) {
		
		if(voto.getNivelUsuario() == "Experto") {
			this.muestra.setEstado(new VerificacionExpertos(this.muestra));
		}
		
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean noRegistraVotoDe(Usuario usuario) {

		
		return this.muestra.getVotacion().stream().equals(usuario.getUsername());
	}
}
