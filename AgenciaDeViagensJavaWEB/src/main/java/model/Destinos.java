package model;

public class Destinos {
	private int destino_id;
	private String pais, cidade;
	
	public Destinos(int destino_id, String pais, String cidade) {
		super();
		this.destino_id = destino_id;
		this.pais = pais;
		this.cidade = cidade;
	}
	
	public Destinos() {
		
	}
	
	public int getDestino_id() {
		return destino_id;
	}
	public void setDestino_id(int destino_id) {
		this.destino_id = destino_id;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
