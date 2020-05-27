package it.contrader.dto;

public class LocalitaDTO {

	private int id;
	
	private String citta;

	public LocalitaDTO(int id, String citta) {
		super();
		this.id = id;
		this.citta = citta;
	}

	public LocalitaDTO(String citta) {
		super();
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
		return "LocalitaDTO [id=" + id + ", citta=" + citta + "]";
	}

	
	
}
