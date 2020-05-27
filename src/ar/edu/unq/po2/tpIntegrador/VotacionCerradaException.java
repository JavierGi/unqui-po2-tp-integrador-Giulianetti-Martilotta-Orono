package ar.edu.unq.po2.tpIntegrador;


// Excepcion lanzada para cuando se quiere votar una Muestra en estado verificada
public class VotacionCerradaException extends Exception {
	
	public VotacionCerradaException(String mensaje) {
		super(mensaje);
	}

}
