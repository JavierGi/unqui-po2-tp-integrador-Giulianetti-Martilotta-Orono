package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeVerificacionExpertosTest {
	
	private EstadoVerificacionExpertos estado;
	private Usuario experto;
	private Usuario otroExperto;
	private Muestra muestra;
	private Voto voto;
	private Voto otroVoto;
	private Itipo tipo;
	private ArrayList<Voto> votos;
	
	
	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.experto = mock(UsuarioVariable.class);
		when(experto.getNivel()).thenReturn("Experto");
		this.otroExperto = mock(UsuarioVariable.class);
		when(otroExperto.getNivel()).thenReturn("Experto");
		this.voto = mock(Voto.class);
		this.otroVoto = mock(Voto.class);
		this.tipo = mock(Itipo.class);
		this.estado = new EstadoVerificacionExpertos(this.muestra);
		this.votos = new ArrayList<Voto>();
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
	void hayCoincidenciaEntreExpertos() {
		
		when(voto.getNivelUsuario()).thenReturn("Experto");
		when(voto.getUsuario()).thenReturn(experto);
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(otroVoto.getNivelUsuario()).thenReturn("Experto");
		when(otroVoto.getTipo()).thenReturn(tipo);
		when(otroVoto.getUsuario()).thenReturn(otroExperto);
		when(muestra.noRegistraVotoDe(otroExperto)).thenReturn(true);
		votos.add(voto);
		votos.add(otroVoto);
		//votos.add(otroVoto);
		when(muestra.getVotacion()).thenReturn(votos);
		when(muestra.cantidadVotosDeTipo(tipo)).thenReturn(2);
		
		estado.verificarModificacionDeEstado(otroVoto);
		//estado.verificarModificacionDeEstado(otroVoto);
		
		
		verify(muestra,times(1)).setEstado(any(EstadoDeMuestra.class));
		verify(muestra,times(1)).setCalculador(any(Icalculador.class));
		
	}
	
	

}
