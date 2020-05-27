package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MuestraTest {
	
	private Muestra muestra;
	private Usuario usuario;
	private Ubicacion ubicacion;
	private Ivinchuca vinchuca;
	private EstadoDeMuestra verificada;
	
	@BeforeEach
	public void setUp() {		
		this.ubicacion = mock(Ubicacion.class);
		this.usuario = mock(UsuarioBasico.class);
		this.vinchuca = mock(Sordida.class);
		this.muestra = new Muestra(usuario,ubicacion,"foto",vinchuca);
		this.verificada = mock(Verificada.class);
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
		verify(verificada).getEstado();
	}
	
	@Test
	void testMuestraCerradaNoRegistraVoto() throws VotacionCerradaException {		
		
		
		muestra.setEstado(verificada);
		when(verificada.getEstado()).thenReturn(false);
		
		assertThrows(VotacionCerradaException.class, () -> {
		    muestra.registrarVoto("voto");});
	
	}
	@Test
	void testSream() {
		
		ArrayList<String> votos = new ArrayList<String>();
		votos.add("pablo");
		votos.add("pablo");
		votos.add("pablo");
		votos.add("ro");
		votos.add("ro");
		
		@SuppressWarnings("unchecked")
		ArrayList<String> votacion = (ArrayList<String>) votos.stream().filter(v -> v.equals("pablo"))
		.collect(Collectors.toList());
				
		assertEquals(votacion.size(),3);
	}
	
}
