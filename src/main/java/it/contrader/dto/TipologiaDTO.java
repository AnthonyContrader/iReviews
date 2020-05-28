package it.contrader.dto;

public class TipologiaDTO {
	private int id;
	private String tipo;
	
	public TipologiaDTO(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public TipologiaDTO() {
		super();
	}

	public TipologiaDTO(String tipo) {
		super();
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipologiaDTO [id=" + id + ", tipo=" + tipo + "]";
	}

	
	
	
	

}
