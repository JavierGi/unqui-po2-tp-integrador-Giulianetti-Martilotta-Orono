package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
class AppWebTest {
	
	private AplicacionWeb aplicacion;
	private Usuario usuario;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		
		this.aplicacion = new AplicacionWeb();
		this.usuario = mock(Usuario.class);
		this.muestra = mock(Muestra.class);
	}

	@Test
	void testRegistrarUnUsuario() {
		
		aplicacion.registrarUsuario(usuario);
		assertEquals(aplicacion.cantidadDeUsuarios(),1);
	}
	
	void testRegistrarMuestra() {
		aplicacion.registrarMuestra(muestra);
		assertEquals(aplicacion.cantidadDeMuestras(),1);
	}

}
