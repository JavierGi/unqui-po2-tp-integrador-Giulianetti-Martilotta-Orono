package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico extends Usuario {
	
	private String nivel;
	
	public UsuarioBasico(AplicacionWeb app, String username) {
		
		super(app,username);
		this.nivel = "Basico";
	}

	@Override
	protected String getNivel() {
		return this.nivel;
	}

	@Override
	protected void verificarMuestra(Muestra muestra, String voto) {
		muestra.registrarVoto(voto);
	}

}
