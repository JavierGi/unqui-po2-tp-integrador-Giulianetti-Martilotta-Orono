package ar.edu.unq.po2.tpIntegrador;

import java.util.Map;

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
	public Ivotable getEspecia() {	
		
		//Implementar que devuelva la que va ganando o en caso de empate indefinido
		return null;
				
	}

}
