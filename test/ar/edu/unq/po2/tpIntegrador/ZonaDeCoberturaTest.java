package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ZonaDeCoberturaTest {
	
	private ZonaDeCobertura zona;
	private Ubicacion epicentro;
	
	@BeforeEach
	public void setUp() {		
		
		this.epicentro = mock(Ubicacion.class);
		this.zona = new ZonaDeCobertura("Zona A",epicentro,30d);
	}

	@Test
	void testUnaZonaDeCoberturaA() {		
		assertTrue(zona.getNombre() == "Zona A");
	}
	
	@Test
	void testUbicacionEpicentroDeLaZona(){
		
		zona.getEpicentro();
		verify(epicentro).getUbicacion();
	}
	
	@Test
	void testMuestrasEnZonaA() {
		
		
	}

}
