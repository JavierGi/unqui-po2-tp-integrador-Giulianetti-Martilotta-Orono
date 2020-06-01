package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AplicacionWeb {
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Muestra> muestras;
	
	public AplicacionWeb() {
		
		this.usuarios = new ArrayList<Usuario>();
		this.muestras = new ArrayList<Muestra>();
	}
	
	public ArrayList<Muestra> getMuestras(){
		return this.muestras;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public Integer cantidadDeUsuarios() {
		return this.usuarios.size();
	}

	public void registrarMuestra(Muestra muestra) {
		this.muestras.add(muestra);		
	}

	public Integer cantidadDeMuestras() {
		return this.getMuestras().size();
	}

	public ArrayList<Muestra> muestrasPublicadasDe(Usuario usuario) {

		return (ArrayList<Muestra>) this.muestras.stream().filter(m -> m.getUsuario() == usuario).collect(Collectors.toList());
	}

	public ArrayList<Muestra> muestrasVotadasPor(Usuario usuario) {
		
		return (ArrayList<Muestra>) this.muestras.stream().filter(m -> m.registraVotoDeUsuario(usuario)).collect(Collectors.toList());
	}
	
	public boolean dentroDePlazo(Muestra muestra,Integer plazo) {
		
		return Period.between(muestra.getFecha(), LocalDate.now()).getDays() <= plazo;
	}
	
	
	

}
