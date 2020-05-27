package it.contrader.model;

public class Localita {

	private int id;
	private String citta;
		
	public Localita(String citta) {
		super();
		this.citta = citta;

	}


	public Localita(int id, String citta) {
		super();
		this.id = id;
		this.citta = citta;

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	@Override
	public String toString() {
		return "Localita [id=" + id + ", citta=" + citta + "]";
	}


	
}

