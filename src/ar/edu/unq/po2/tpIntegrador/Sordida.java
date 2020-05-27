package ar.edu.unq.po2.tpIntegrador;


// Las especies de vinchuca implementan Ivinchuca para poder publicar y elegir entre algo de tipo vinchuca
// y tambien implementan Ivotable para darle polimorfismo a la votacion

public class Sordida implements Ivinchuca,Ivotable {
	
	private String especie;
	public Sordida() {
		
		this.especie = "Sordida";
	}

	@Override
	public String getTipo() {
		return this.especie;
	}

}
