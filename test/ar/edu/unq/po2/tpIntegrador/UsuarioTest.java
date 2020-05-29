package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

class UsuarioTest {
	
	private Usuario usuario;
	private AplicacionWeb app;
	private Muestra muestra;
	private Voto voto;
	private EstadoDeMuestra estadoExpertos;
	
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuario = new UsuarioVariable(app,"Pablov");
		this.voto = mock(Voto.class);
		this.estadoExpertos = mock(VerificacionExpertos.class);
	}
	
	
	@Test
	void testUsuarioBasicoPublicaMuestra() {	
		usuario.publicarMuestra(muestra);
		verify(app).registrarMuestra(muestra);		
	}
	
	@Test
	void testUsuarioBasicoVerificaMuestra() throws VotacionCerradaException {
		
		usuario.verificarMuestra(muestra,voto);
		when(voto.getUsuario()).thenReturn(usuario);
		when(voto.getNivelUsuario()).thenReturn("Basico");
		verify(muestra).registrarVerificacion(voto);

	}
}
