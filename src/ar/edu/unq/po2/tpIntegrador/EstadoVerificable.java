package ar.edu.unq.po2.tpIntegrador;

public class EstadoVerificable extends EstadoDeMuestra {
	
	private boolean esVerificable;
	
	public EstadoVerificable() {
		super();
		this.esVerificable = true;		
	}
	
	public boolean getEstado() {
		return this.esVerificable;
	}

}
