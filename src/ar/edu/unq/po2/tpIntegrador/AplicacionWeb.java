package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class AplicacionWeb {
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Muestra> muestras;
	
	public AplicacionWeb() {
		
		this.usuarios = new ArrayList<Usuario>();
		this.muestras = new ArrayList<Muestra>();
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
		return this.muestras.size();
	}
	
	

}
