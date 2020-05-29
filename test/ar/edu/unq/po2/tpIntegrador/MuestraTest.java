package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.org.apache.xpath.internal.functions.Function;


class MuestraTest {
	
	private Muestra muestra;
	private Usuario usuario;
	private Usuario usuario2;
	private Ubicacion ubicacion;
	private Itipo vinchuca;
	private Voto voto;
	private EstadoDeMuestra verificada;
	private EstadoDeMuestra verificacionExpertos;
	
	@BeforeEach
	public void setUp() {		
		this.ubicacion = mock(Ubicacion.class);
		this.usuario = mock(UsuarioVariable.class);
		this.usuario2 = mock(UsuarioVariable.class);
		this.vinchuca = mock(Vinchuca.class);
		this.muestra = new Muestra(usuario,ubicacion,"foto",vinchuca);
		this.voto = mock(Voto.class);
		this.verificada = mock(Verificada.class);
		this.verificacionExpertos = mock(VerificacionExpertos.class);
	}
	
	@Test
	void testUnaMuestraSePublicaConUnaVotacion() {
		assertTrue(muestra.getVotacion().isEmpty());
	}
	
	@Test
	void testUnaMuestraSeIniciaConUnEstadoEnVerificacion() {
		assertEquals(muestra.esVerificable(), true);
	}
	
	@Test
	void testSeCierraLaVotacionDeUnaMuestra() {
		
		muestra.setEstado(verificada);
		
		when(verificada.getEstado()).thenReturn(false);		
		
		assertEquals(muestra.esVerificable(),false);
	}
	
	
	@Test
	void testUsuarioQueGeneroMuestraNoPuedeVotar() throws VotacionCerradaException {
		
		when(usuario.getUsername()).thenReturn("pablo");
		when(usuario2.getUsername()).thenReturn("ro");
		when(voto.getUsuario()).thenReturn(usuario2);
		
		muestra.registrarVerificacion(voto);
		muestra.registrarVerificacion(voto);
		
		
		assertEquals(1,muestra.getVotacion().size());
	}
	



	
}
