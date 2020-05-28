package it.contrader.model;


public class Review {//classe che implementa la recensione 
	private int id;//identificatore recensione
	private int voto;//voto da 1 a 10
	private int user_id;//identificatore utente che ha scritto recensione
	private String id_esercizio;
	private String testo;//testo della recensione
	private String titolo;//indica il negozio a cui si riferisce la recensione
	
	

	public Review() {
		super();
	}
	
	
 public Review(int voto, int user_id, String id_esercizio, String testo, String titolo) {
		super();
		this.voto=voto;
		this.user_id=user_id;
		this.id_esercizio=id_esercizio;
		this.testo=testo;
		this.titolo=titolo;
	}


 public Review(int id,int voto, int user_id, String id_esercizio, String testo, String titolo ) {
		super();
		this.id=id;
		this.voto=voto;
		this.user_id=user_id;
		this.id_esercizio=id_esercizio;
		this.testo=testo;
		this.titolo=titolo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getTesto() {
		return testo;
	}


	public void setTesto(String testo) {
		this.testo = testo;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getId_esercizio() {
		return id_esercizio;
	}


	public void setId_esercizi(String id_esercizio) {
		this.id_esercizio = id_esercizio;
	}

   
	@Override
	public String toString() {
		return "Review [id=" + id + ", voto=" + voto + ", user_id=" + user_id + ", id_esercizio=" + id_esercizio + ", testo=" + testo + ", titolo=" + titolo
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;		
		return true;
	}
 
 
}
