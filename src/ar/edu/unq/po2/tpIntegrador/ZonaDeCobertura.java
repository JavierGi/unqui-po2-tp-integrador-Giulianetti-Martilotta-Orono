package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class ZonaDeCobertura {

	private String nombre;
	private Ubicacion epicentro;
	private Double distancia;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double distancia) {
		
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.distancia = distancia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Double> getEpicentro() {

		return this.epicentro.getUbicacion();
	}

}
