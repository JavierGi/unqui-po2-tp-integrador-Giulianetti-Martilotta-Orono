package ar.edu.unq.po2.tpIntegrador;

public abstract class Usuario {
	
	private AplicacionWeb app;
	private String username;
	//No puede haber dos usuarios con el mismo username
	
	public Usuario(AplicacionWeb app, String username) {
		this.app = app;
		this.username = username;
	}
	public void publicarMuestra(Muestra muestra) {
		this.app.registrarMuestra(muestra);
	}
	protected abstract String getNivel();
	
	public String getUsername() {
		return this.username;
	}
	protected abstract void verificarMuestra(Muestra muestra, String string) throws VotacionCerradaException;

}
