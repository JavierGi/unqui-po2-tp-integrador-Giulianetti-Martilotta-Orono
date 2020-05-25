package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
		
		Exception exception = assertThrows(VotacionCerradaException.class, () -> {
		    muestra.registrarVoto("voto");});
		    
		assertEquals(exception.getMessage(),"La votacion ya esta cerrada");
	}


}
