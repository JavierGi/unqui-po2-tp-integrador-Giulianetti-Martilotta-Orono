package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico extends Usuario {
	
	private String nivel;
	
	public UsuarioBasico(AplicacionWeb app, String username) {
		
		super(app,username);
		this.nivel = "Basico";
	}

	@Override
	public String getNivel() {
		return this.nivel;
	}

	@Override
	protected void verificarMuestra(Muestra muestra, String voto) throws VotacionCerradaException {
		muestra.registrarVoto(voto);
	}

}
