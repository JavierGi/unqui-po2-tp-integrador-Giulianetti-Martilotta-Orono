package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelBasicoTest {
	
	
	private AplicacionWeb app;
	private Usuario usuarioBasico;
	
	
	@BeforeEach
	public void setUp() {
		
		
		this.app = mock(AplicacionWeb.class);
		this.usuarioBasico = mock(Usuario.class);		
		
	}
	

	
	void test() {
		
		when(app.muestrasPublicadasDe(usuarioBasico).size()).thenReturn(20);
		
		assertTrue(app.muestrasPublicadasDe(usuarioBasico).size() == 20);
	}

}
