package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class StreamTest {
	
	private Muestra muestra;
	private Muestra otraMuestra;
	private Usuario usuario;
	private Usuario otroUsuario;
	private Ubicacion ubicacion;
	private AplicacionWeb app;
	private Itipo tipo;
	private Voto voto;
	private Voto otroVoto;
	private CalculadorDeNivel calculador;
	
	@BeforeEach
	public void setUp(){
		
		this.app = new AplicacionWeb();
		this.calculador = new CalculadorDeNivel();
		this.ubicacion = new Ubicacion();
		this.usuario = new UsuarioVariable(app,"Pablo");
		this.otroUsuario = new UsuarioVariable(app,"ro");
		this.tipo = new Votable("Sordida");
		this.muestra = new Muestra(usuario,ubicacion,"Foto",tipo);
		this.otraMuestra = new Muestra(otroUsuario,ubicacion,"Foto",tipo);
		this.otroVoto = new Voto(otroUsuario,tipo);
		this.voto = new Voto(usuario,tipo);
		
	}

	
	void test() throws VotacionCerradaException {
		
		usuario.publicarMuestra(muestra);
		otroUsuario.publicarMuestra(otraMuestra);
		muestra.registrarVerificacion(voto);
		otraMuestra.agregarVoto(voto);
		muestra.registrarVerificacion(otroVoto);
		
		
		ArrayList<Voto> votacion = (ArrayList<Voto>) muestra.getVotacion().stream().filter(v -> v.getUsuario().getUsername() == "ro").collect(Collectors.toList());
		
		Inivel nivel = calculador.calcularNivelDe(otroUsuario, app);
		//ArrayList<Muestra> muestrasVotadas = 
		
		//assertTrue(calculador.cumpleConVotos(usuario, app));
		//assertTrue(app.dentroDePlazo(muestra, 30));
		assertTrue(nivel.getNivel() == "Experto");
		assertTrue(app.dentroDePlazo(muestra, 0));
		assertEquals(2,app.getMuestras().size());
		assertEquals(2,muestra.getVotacion().size());
		assertEquals(1,votacion.size());
		assertEquals(tipo,votacion.get(0).getTipo());
	}

}
