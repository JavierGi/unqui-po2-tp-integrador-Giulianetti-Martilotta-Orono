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
		verify(muestra).registrarVoto(voto);		

	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void demoLambda() {
		
		ArrayList<String> lista  = new ArrayList<String>();
		
		lista.add("Pablo");
		lista.add("Pablo");
		lista.add("ro");
		
		assertTrue(lista.stream().filter(v-> v.equals("o")).collect(Collectors.toList()).size()>0);
		
	}
}
