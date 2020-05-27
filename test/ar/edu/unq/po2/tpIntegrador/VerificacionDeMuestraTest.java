package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificacionDeMuestraTest {
	
	private Muestra muestra;
	private Voto voto;
	private Voto voto2;
	private Voto voto3;
	private Usuario basico;
	private Ubicacion ubicacion;
	private Ivinchuca vinchuca;
	
	@BeforeEach
	public void setUp() {
		
		this.basico = mock(UsuarioBasico.class);
		this.ubicacion = mock(Ubicacion.class);
		this.vinchuca = mock(Sordida.class);
		this.muestra = new Muestra(basico,ubicacion,"foto",vinchuca);
	}

	@Test
	void testPidoTipoAVinchucaSinVotos() {
		//Implementar
		
	}

}
