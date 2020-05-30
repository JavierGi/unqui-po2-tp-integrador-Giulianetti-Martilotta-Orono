package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificacionDeMuestraTest {
	
	private Muestra muestra;
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	private Itipo sordida;
	private Itipo chinche;
	private VerificadorBasicos verificador;
	private ArrayList<Voto> votacion;
	private ArrayList<Voto> votacion2;
	private ArrayList<ArrayList<Voto>> votaciones;
	
	@BeforeEach
	public void setUp() {
		
		this.muestra = mock(Muestra.class);
		this.verificador = new VerificadorBasicos();
		this.votacion = new ArrayList<Voto>();
		this.votacion2 = new ArrayList<Voto>();
		this.voto = mock(Voto.class);
		this.voto2 = mock(Voto.class);
		this.voto3= mock(Voto.class);
		this.sordida = mock(Vinchuca.class);
		this.chinche = mock(Vinchuca.class);
		this.votaciones = new ArrayList<ArrayList<Voto>>();
		
		
	}
	
	@Test
	void testVerificacionTipoDeMuestraSordida() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		this.votacion.add(voto3);
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(sordida);
		when(voto3.getTipo()).thenReturn(chinche);
		
		assertEquals("Sordida",	verificador.verificarMuestra(muestra));
		
		
	}
	
	@Test
	void testVerificacionDeUnEmpateEnLaVotacion() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Chinche");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		
		
		assertEquals("Indefinido",	verificador.verificarMuestra(muestra));
		
	}
	
	@Test
	void testVerificacionDeUnEmpateEnLaVotacion2() {
		
		this.votacion.add(voto);
		this.votacion.add(voto2);
		
		
		
		when(muestra.getVotacion()).thenReturn(votacion);
		when(sordida.getTipo()).thenReturn("Sordida");
		when(chinche.getTipo()).thenReturn("Sordida");
		when(voto.getTipo()).thenReturn(sordida);
		when(voto2.getTipo()).thenReturn(chinche);
		when(muestra.cantidadVotosDeTipo(sordida)).thenReturn(2);
		
		
		
		assertEquals(sordida.getTipo(),verificador.controlar(muestra).getTipo());
		
	}
}
