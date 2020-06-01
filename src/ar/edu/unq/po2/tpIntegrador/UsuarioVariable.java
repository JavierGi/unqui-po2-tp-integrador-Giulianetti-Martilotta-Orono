package ar.edu.unq.po2.tpIntegrador;

public class UsuarioVariable extends Usuario {
	
	private Inivel nivel;
	private CalculadorDeNivel calculador;
	
	public UsuarioVariable(AplicacionWeb app, String username) {
		
		super(app,username);
		this.calculador = new CalculadorDeNivel();
		this.nivel = this.calculador.calcularNivelDe(this, app);
	}

	@Override
	public String getNivel() {
		return this.nivel.getNivel();
	}

	@Override
	public void verificarMuestra(Muestra muestra, Voto voto) throws VotacionCerradaException {
		muestra.registrarVerificacion(voto);
	}

	@Override
	protected void setNivel(Inivel nivel) {
		this.nivel = nivel;
	}

}
