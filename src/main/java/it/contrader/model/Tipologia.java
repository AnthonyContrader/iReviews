package it.contrader.model;

public class Tipologia {
	private int id;
	private String tipo;
	
	public Tipologia(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Tipologia(String tipo) {
		super();
		this.tipo = tipo;
	}

	public Tipologia() {
		super();
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
		return "Tipologia [id=" + id + ", tipo=" + tipo + "]";
	}
	
	
	
	
	

}
