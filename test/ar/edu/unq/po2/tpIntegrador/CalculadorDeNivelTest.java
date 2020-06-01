package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorDeNivelTest {
	
	private CalculadorDeNivel calculador;
	private Muestra muestra;
	private AplicacionWeb app;
	private Usuario usuarioBasico;
	private Usuario usuarioExperto;
	private ArrayList<Muestra> publicadas;
	private ArrayList<Muestra> votadas;
	
	@BeforeEach
	public void setUp() {
		
		this.app = mock(AplicacionWeb.class);
		this.muestra = mock(Muestra.class);
		this.usuarioBasico = mock(Usuario.class);
		this.usuarioExperto = mock(Usuario.class);
		this.calculador = new CalculadorDeNivel();
		this.publicadas = new ArrayList<Muestra>();
		this.votadas  = new ArrayList<Muestra>();
		
	}

	@Test
	void testCalcularNivelDeUsuarioBasico() {
		
		when(muestra.getUsuario()).thenReturn(usuarioBasico);
		when(app.muestrasPublicadasDe(usuarioBasico)).thenReturn(publicadas);
		when(app.muestrasVotadasPor(usuarioBasico)).thenReturn(publicadas);
		when(muestra.getFecha()).thenReturn(LocalDate.now());
		
		this.publicadas.add(muestra);
		
		calculador.calcularNivelDe(usuarioBasico, app);
		
		assertEquals("Basico", calculador.calcularNivelDe(usuarioBasico, app).getNivel());
		
	}
	
	@Test
	void testCalcularNivelDeUsuarioExperto() {
		
		when(muestra.getUsuario()).thenReturn(usuarioBasico);
		when(app.muestrasPublicadasDe(usuarioBasico)).thenReturn(publicadas);
		when(app.muestrasVotadasPor(usuarioBasico)).thenReturn(publicadas);
		when(muestra.getFecha()).thenReturn(LocalDate.now());
		
		for(int i = 0; i<31;i++) {
			this.publicadas.add(muestra);
		}
		
		calculador.calcularNivelDe(usuarioBasico, app);
		
		assertEquals("Experto", calculador.calcularNivelDe(usuarioBasico, app).getNivel());
		
	}

}
