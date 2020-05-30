package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;

public class CalculadorExperto implements Icalculador {

	@Override
	public Itipo calcularTipo(Muestra muestra) {
		
		Itipo tipo = new Votable("Indefinido");
		if(muestra.getVotosDeNivel("Experto").size() == 1) {
			tipo = muestra.getVotosDeNivel("Experto").get(0).getTipo();
		}
		
		return tipo;
	}

	@Override
	public boolean hayEmpate(Muestra muestra, Integer score) {
		// TODO Auto-generated method stub
		return false;
	}

}
