package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ubicacion {

	Double latitud; //Medida en grados con decimales
	Double longitud; //Medida en grados con decimales
	
	
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	public Ubicacion(Double latitud, Double longitud) {
		super();
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}
	
	
	// El siguinete método retorna la distancia en kilómetros entre dos ubicaciones
	// Latitud y longitud deben estar medidos en grados
	public Double distanciaCon(Ubicacion ubi) {
		
				
		Double radioTierra = 6371d;//en kilómetros  
		Double distanciaLatitudes = Math.toRadians(this.getLatitud() - ubi.getLatitud());  
		Double distanciaLongitudes = Math.toRadians(this.getLongitud() - ubi.getLongitud());  
		Double senoDistanciaLatitudes = Math.sin(distanciaLatitudes / 2);  
		Double senoDistanciaLongitudes = Math.sin(distanciaLongitudes / 2);  
		Double va1 = Math.pow(senoDistanciaLatitudes, 2) + Math.pow(senoDistanciaLongitudes, 2)  
                * Math.cos(Math.toRadians(ubi.getLatitud())) * Math.cos(Math.toRadians(this.getLatitud()));  
		Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		Double distancia = radioTierra * va2;  
   
        return distancia;  
    }  
		
	
	/* Dada una lista de tipo Unocación, retorna una nueva lista con aquellas ubicaciones que estén 
	 a menos de x distancia de esta ubicación (medida en kilómetros)  */
	public ArrayList<Ubicacion> listaDeUbicacionesCercanas(ArrayList<Ubicacion> ubicaciones, Double distancia){
		
		return (ArrayList<Ubicacion>) ubicaciones.stream()
				.filter(u -> this.distanciaCon(u) <= distancia)
				.collect(Collectors.toList());
	}
	
	
	
	/* Dada una lista de tipo Muestra, retorna una nueva lista con aquellas muestras que estén 
	 a menos de x distancia de esta ubicación (medida en kilómetros)  */
	public ArrayList<Muestra> listaDeMuestrasCercanas(ArrayList<Muestra> muestras, Double distancia){
		
		return (ArrayList<Muestra>) muestras.stream()
				.filter(m -> this.distanciaCon(m.getUbicacion())<= distancia)
						.collect(Collectors.toList());
	
	}
	
}










