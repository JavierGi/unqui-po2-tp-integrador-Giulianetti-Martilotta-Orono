package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UsuarioTest {
	
	private Usuario usuario;
	private AplicacionWeb app;
	private Muestra muestra;
	
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuario = new UsuarioVariable(app,"Pablov");
	}
	
	
	@Test
	void testUsuarioBasicoPublicaMuestra() {	
		usuario.publicarMuestra(muestra);
		verify(app).registrarMuestra(muestra);
		assertEquals(usuario.getNivel(),"Basico");
	}
	
	@Test
	void testUsuarioBasicoVerificaMuestra() throws VotacionCerradaException {
		usuario.verificarMuestra(muestra,"Vinchuca");
		verify(muestra).registrarVoto("Vinchuca");		
	}
	
	@Test
	void testUsuarioNoPuedeVotarMuestraVerificada() throws VotacionCerradaException {
					
		when(muestra.esVerificable()).thenReturn(false);
		usuario.verificarMuestra(muestra, "Chinche");		
		
		verify(muestra).registrarVoto("Chinche");
		
		
	}

}
