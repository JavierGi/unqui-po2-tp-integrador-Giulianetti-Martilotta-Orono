package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico extends Usuario {
	
	private String nivel;
	
	public UsuarioBasico(AplicacionWeb app) {
		
		super(app);
		this.nivel = "Basico";
	}

}
