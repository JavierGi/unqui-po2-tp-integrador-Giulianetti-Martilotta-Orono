package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadorExpertoTest {
	
	private Icalculador calculadorExperto;
	private Muestra muestra;
	private Voto voto;
	private Voto otroVoto;
	private Usuario usuario;
	private Usuario otroUsuario;
	private Itipo tipo;
	private Itipo otroTipo;
	private ArrayList<Voto> votacion;

	
	@BeforeEach
	public void setUp(){
		
		this.usuario = mock(Usuario.class);
		this.otroUsuario = mock(Usuario.class);
		this.voto = mock(Voto.class);
		this.otroVoto = mock(Voto.class);
		this.tipo = mock(Itipo.class);
		this.otroTipo = mock(Itipo.class);
		this.muestra = mock(Muestra.class);
		this.votacion = new ArrayList<Voto>();
		this.calculadorExperto = new CalculadorExperto();
		
	}
	@Test
	void testPidoElTipoAunaMuestraConUnSoloVoto() {
		
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(voto.getUsuario()).thenReturn(usuario);
		votacion.add(voto);
		when(muestra.getVotosDeNivel("Experto")).thenReturn(votacion);
		
		assertEquals("Sordida" , calculadorExperto.calcularTipo(muestra).getTipo());
		
	}
	
	@Test
	void testPidoElTipoAunaMuestraConDistintosVotos() {
		
		when(voto.getTipo()).thenReturn(tipo);
		when(tipo.getTipo()).thenReturn("Sordida");
		when(voto.getUsuario()).thenReturn(usuario);
		when(otroVoto.getTipo()).thenReturn(otroTipo);
		when(otroTipo.getTipo()).thenReturn("Chinche");
		when(otroVoto.getUsuario()).thenReturn(otroUsuario);
		votacion.add(voto);
		votacion.add(otroVoto);
		when(muestra.getVotosDeNivel("Experto")).thenReturn(votacion);
		
		assertEquals("Indefinido" , calculadorExperto.calcularTipo(muestra).getTipo());
	}

}
