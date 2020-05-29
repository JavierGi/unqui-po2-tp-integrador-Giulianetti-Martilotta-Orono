package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EstadoVerificacionBasicosTest {
	
	private Muestra muestra;
	private Usuario basico;
	private Voto voto;
	private EstadoDeMuestra estado;
	private Usuario experto;

	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.basico = mock(UsuarioVariable.class);
		this.voto = mock(Voto.class);
		this.estado = new EstadoVerificable(muestra);
		this.experto = mock(UsuarioVariable.class);
	}
	
	@Test
	void testMuestraRegistraVotoDeUsuarioBasico() {
		
		
		when(basico.getNivel()).thenReturn("Basico");
		when(muestra.noRegistraVotoDe(basico)).thenReturn(true);
		when(voto.getUsuario()).thenReturn(basico);
		estado.agregarVoto(voto);
		
		
		verify(muestra).agregarVoto(voto);
	}
	
	@Test
	void testMuestraNoRegistraVotoDeUsuarioBasicoQueYaVoto() {
		
		
		when(basico.getNivel()).thenReturn("Basico");
		when(muestra.noRegistraVotoDe(basico)).thenReturn(false);
		when(voto.getUsuario()).thenReturn(basico);
		estado.agregarVoto(voto);
		
		
		verify(muestra, times(0)).agregarVoto(voto);
	}
	
	@Test
	void testUnUsuarioExpertoVotaPorPrimeraVesUnaMuestraEnVerificacionBasica() {
		
		when(experto.getNivel()).thenReturn("Experto");
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getNivelUsuario()).thenReturn("Experto");
		estado.agregarVoto(voto);		
		
		verify(muestra).setEstado(any(EstadoDeMuestra.class));
		verify(muestra, times(1)).agregarVoto(voto);
		
	}


}
