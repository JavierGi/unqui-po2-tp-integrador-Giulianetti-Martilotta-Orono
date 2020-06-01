package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
class AppWebTest {
	
	private AplicacionWeb aplicacion;
	private Usuario usuario;
	private Muestra muestra;
	static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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
	
	@Test
	void testRegistrarMuestra() {	
		
		aplicacion.registrarMuestra(muestra);
		assertEquals(aplicacion.cantidadDeMuestras(),1);		
	}
	
	@Test
	void testPidoMuestrasDeUnUsuario(){
		
		when(muestra.getUsuario()).thenReturn(usuario);
		aplicacion.registrarMuestra(muestra);
		assertTrue(aplicacion.muestrasPublicadasDe(usuario).size() == 1);
	}
	
	@Test
	void testPidoMuestrasVotadasPorUnUsuario() {
		
		when(muestra.registraVotoDeUsuario(usuario)).thenReturn(true);		
		aplicacion.registrarMuestra(muestra);
		assertTrue(aplicacion.muestrasVotadasPor(usuario).size() == 1);
		
	}
	
	@Test
	void testTrueSiLaFechaDeMuestraEstaDentroDeUnPlazo() {
		
		LocalDate fecha = LocalDate.parse("03/05/2020",fmt);
		when(muestra.getFecha()).thenReturn(fecha);
		
		assertTrue(aplicacion.dentroDePlazo(muestra, 30));
		assertFalse(aplicacion.dentroDePlazo(muestra, 20));
	}
	
}
