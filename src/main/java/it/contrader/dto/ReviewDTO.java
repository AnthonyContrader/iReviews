package it.contrader.dto;

import it.contrader.model.User;

public class ReviewDTO {
	
	private int id;//identificatore recensione
	private int user_id;//identificatore utente che ha scritto recensione
	private String negozio;//indica il negozio a cui si riferisce la recensione
	private String testo;//testo della recensione
	private int voto;//voto da 1 a 10
	

	
	
	
	public ReviewDTO() {
		super();
	}
	
	
    public ReviewDTO(int user_id,String negozio, String testo, int voto) {
		super();
		this.user_id=user_id;
		this.negozio = negozio;
		this.testo = testo;
		this.voto = voto;
	}


    public ReviewDTO(int id, int user_id, String negozio, String testo, int voto) {
		super();
		this.id=id;
		this.user_id = user_id;
		this.negozio = negozio;
		this.testo = testo;
		this.voto = voto;
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


	public String getNegozio() {
		return negozio;
	}


	public void setNegozio(String negozio) {
		this.negozio = negozio;
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


	@Override
	public String toString() {
		return "Review [id=" + id + ", user=" + user_id + ", negozio=" + negozio + ", testo=" + testo + ", voto=" + voto
				+ "]";
	}

}
