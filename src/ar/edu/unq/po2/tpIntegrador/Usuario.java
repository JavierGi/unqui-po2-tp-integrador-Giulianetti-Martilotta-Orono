package ar.edu.unq.po2.tpIntegrador;

public abstract class Usuario {
	
	private AplicacionWeb app;
	
	public Usuario(AplicacionWeb app) {
		this.app = app;
	}
	public void publicarMuestra(Muestra muestra) {
		this.app.registrarMuestra(muestra);
	}

}
