package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeVerificacionExpertosTest {
	
	private EstadoDeMuestra estado;
	private Usuario experto;
	private Usuario otroExperto;
	private Muestra muestra;
	private Voto voto;
	private Itipo tipo;
	
	
	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.experto = mock(UsuarioVariable.class);
		when(experto.getNivel()).thenReturn("Experto");
		this.otroExperto = mock(UsuarioVariable.class);
		when(otroExperto.getNivel()).thenReturn("Experto");
		this.voto = mock(Voto.class);
		this.tipo = mock(Itipo.class);
		this.estado = new EstadoVerificacionExpertos(this.muestra);
	}
	
	
	@Test
	void testVerificadorRegistraVotoDeUsuarioExperto() throws VotacionCerradaException {
		
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		estado.agregarVoto(voto);
		
		verify(muestra).agregarVoto(voto);
		verify(muestra, times(0)).setEstado(any(EstadoDeMuestra.class));
	}
	
	@Test 
	void testCoinsidenDosExpertosEnSuVotacion(){
		
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(muestra.noRegistraVotoDe(experto)).thenReturn(true);
		estado.agregarVoto(voto);
		
	}

}
