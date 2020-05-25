package ar.edu.unq.po2.tpIntegrador;

public class Muestra {
	
	private Usuario usuario;
	private Ubicacion ubicacion;
	private String foto;
	private Ivinchuca vinchua;
	private EstadoDeMuestra estado;

	public Muestra(Usuario usuario, Ubicacion ubicacion, String foto, Ivinchuca vinchuca) {
		
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.foto = foto;
		this.vinchua = vinchuca;
		this.estado = new EstadoVerificable();
	
	}

	public void registrarVoto(String voto) throws VotacionCerradaException{
		
		if(this.esVerificable()) {
			this.foto = voto;
		}else {
			throw new VotacionCerradaException("La votacion ya esta cerrada");
		}
		
	}
	
	public String exVotacionCerrada() {
		return "No verificable";
	}

	public boolean esVerificable() {
		
		return this.estado.getEstado();
	}

	public void setEstado(EstadoDeMuestra estado) {
		this.estado = estado;		
	}

}
