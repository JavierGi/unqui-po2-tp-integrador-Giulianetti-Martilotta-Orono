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
	private Itipo chinche;
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	private EstadoDeMuestra verificada;
	private Icalculador calculador;
	
	@BeforeEach
	public void setUp() {		
		this.ubicacion = mock(Ubicacion.class);
		this.usuario = mock(UsuarioVariable.class);
		this.usuario2 = mock(UsuarioVariable.class);
		this.vinchuca = mock(Vinchuca.class);
		this.muestra = new Muestra(usuario,ubicacion,"foto",vinchuca);
		this.voto = mock(Voto.class);
		this.voto2 = mock(Voto.class);
		this.voto3 = mock(Voto.class);
		this.verificada = mock(Verificada.class);
		this.chinche = mock(Vinchuca.class);
		this.calculador = mock(Icalculador.class);
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
	
	@Test
	void testUnaMuestraDevuelveLosVotosDeUnUsuario() throws VotacionCerradaException {
		
		when(usuario.getUsername()).thenReturn("pablo");
		
		when(voto.getUsuario()).thenReturn(usuario);
		
		muestra.agregarVoto(voto);
		
		
		assertEquals(1,muestra.getVotosDe(usuario).size());
		
	}
	
	@Test
	void testUnaMuestraDevuelveLosVotosDeNivelExperto() {
		
		when(voto.getNivelUsuario()).thenReturn("Experto");
		when(voto2.getNivelUsuario()).thenReturn("Experto");
		when(voto3.getNivelUsuario()).thenReturn("Basico");

		
		muestra.agregarVoto(voto);
		muestra.agregarVoto(voto2);
		muestra.agregarVoto(voto3);
		
		assertEquals(2, muestra.getVotosDeNivel("Experto").size());
		
	}
	
	@Test 
	void testUnMuestraDevuelveCantidadDeVotosDeUnTipo(){
		
		when(voto.getTipo()).thenReturn(vinchuca);
		when(voto2.getTipo()).thenReturn(chinche);
		when(vinchuca.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		
		muestra.agregarVoto(voto);
		muestra.agregarVoto(voto2);
		
		assertEquals(1,muestra.cantidadVotosDeTipo(vinchuca));	
		
	}
	
	@Test
	void testPidoTipoALaMuestra() {
		
		
		muestra.setCalculador(calculador);
		muestra.getEspecie();
		verify(calculador,times(1)).calcularTipo(muestra);
		
	}
	
	@Test
	void testConsultoSiLaMuestraTieneVotosDeUnUsuario() {
		
		when(voto.getUsuario()).thenReturn(usuario2);
		
		muestra.agregarVoto(voto);
		
		assertTrue(muestra.registraVotoDeUsuario(usuario2));
		assertFalse(muestra.registraVotoDeUsuario(usuario));	
		
	}



	
}
