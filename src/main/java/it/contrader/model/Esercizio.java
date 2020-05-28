package it.contrader.model;

public class Esercizio {
	
	private int codice;
	private String nome;
	private Double prezzo_medio;
	private Integer id_tipologia;
	private String indirizzo;
	private Integer id_citta;
	
	
	public Esercizio(String nome, double prezzo_medio, int id_tipologia, String indirizzo, int id_citta) {
		super();
		this.nome = nome;
		this.prezzo_medio = prezzo_medio;
		this.id_tipologia = id_tipologia;
		this.indirizzo = indirizzo;
		this.id_citta = id_citta;
	}


	public Esercizio(int codice, String nome, double prezzo_medio, int id_tipologia, String indirizzo,
			int id_citta) {
		super();
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
	
	//Metodo per il confronto degli oggetti
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Esercizio other = (Esercizio) obj;
			if (codice != other.codice)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (prezzo_medio == 0.0) {
				if (other.prezzo_medio != 0.0)
					return false;
			} else if (!prezzo_medio.equals(other.prezzo_medio))
				return false;
			if (id_tipologia == 0) {
				if (other.id_tipologia != 0)
					return false;
			} else if (!id_tipologia.equals(other.id_tipologia))
				return false;
			if (indirizzo == null) {
				if (other.indirizzo != null)
					return false;
			} else if (!indirizzo.equals(other.indirizzo))
				return false;
			if (id_citta == 0) {
				if (other.id_citta != 0)
					return false;
			} else if (!id_citta.equals(other.id_citta))
				return false;
			return true;
		}
	
	

}
