package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class VotoTest {
	
	private Voto voto;
	private Muestra muestra;
	private AplicacionWeb appWeb;
	private Usuario usuario;
	private Itipo sordida;
	private EstadoDeMuestra verificada;
	
	
	@BeforeEach
	public void setUp() {
		
		this.usuario = mock(UsuarioBasico.class);
		when(usuario.getNivel()).thenReturn("Basico");
		this.muestra = mock(Muestra.class);
		this.appWeb = mock(AplicacionWeb.class);
		this.sordida = mock(Vinchuca.class);
		when(sordida.getTipo()).thenReturn("Sordida");
		this.voto = new Voto(usuario, sordida);		
		this.verificada = mock(Verificada.class);
	}
	@Test
	void testSolicitoElNivelDelUsuarioQueVotoYRegistroEnVoto() {
		
		voto.getNivelUsuario();
		verify(usuario).getNivel();	
		assertEquals(voto.getNivelUsuario(),"Basico");
		
	}
	
	@Test
	void testSolicitoElTipoDetalladoEnLaVotacion() {
	
		voto.getTipo();
		verify(sordida).getTipo();
	}

}
