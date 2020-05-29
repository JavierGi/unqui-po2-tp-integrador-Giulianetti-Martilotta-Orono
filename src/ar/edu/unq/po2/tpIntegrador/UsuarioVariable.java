package ar.edu.unq.po2.tpIntegrador;

public class UsuarioVariable extends Usuario {
	
	private String nivel;
	
	public UsuarioVariable(AplicacionWeb app, String username) {
		
		super(app,username);
		this.nivel = "Basico";
	}

	@Override
	public String getNivel() {
		return this.nivel;
	}

	@Override
	public void verificarMuestra(Muestra muestra, Voto voto) throws VotacionCerradaException {
		muestra.registrarVoto(voto);
	}

}
