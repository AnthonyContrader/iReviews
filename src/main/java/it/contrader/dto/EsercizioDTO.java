package it.contrader.dto;

public class EsercizioDTO {
	
	private int codice;
	private String nome;
	private double prezzo_medio;
	private int id_tipologia;
	private String indirizzo;
	private int id_citta;
	
	public EsercizioDTO() {
		
	}
	
	
	public EsercizioDTO(String nome, double prezzo_medio, int id_tipologia, String indirizzo, int id_citta) {
		
		this.nome = nome;
		this.prezzo_medio = prezzo_medio;
		this.id_tipologia = id_tipologia;
		this.indirizzo = indirizzo;
		this.id_citta = id_citta;
	}


	public EsercizioDTO(int codice, String nome, double prezzo_medio, int id_tipologia, String indirizzo,
			int id_citta) {
		
		this.codice = codice;
		this.nome = nome;
		this.prezzo_medio = prezzo_medio;
		this.id_tipologia = id_tipologia;
		this.indirizzo = indirizzo;
		this.id_citta = id_citta;
	}


	public int getCodice() {
		return this.codice;
	}


	public void setCodice(int codice) {
		this.codice = codice;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrezzo_medio() {
		return prezzo_medio;
	}


	public void setPrezzo_medio(double prezzo_medio) {
		this.prezzo_medio = prezzo_medio;
	}


	public int getId_tipologia() {
		return id_tipologia;
	}


	public void setId_tipologia(int id_tipologia) {
		this.id_tipologia = id_tipologia;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public int getId_citta() {
		return id_citta;
	}


	public void setId_citta(int id_citta) {
		this.id_citta = id_citta;
	}
	
	@Override
	public String toString() {
		return  codice + "\t"  + nome +"\t\t" +   prezzo_medio + "\t\t" + id_tipologia + "\t\t" +  indirizzo + "\t\t" + id_citta ;
	}

}
