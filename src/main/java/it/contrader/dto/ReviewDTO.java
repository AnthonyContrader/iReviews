package it.contrader.dto;

import it.contrader.model.User;

public class ReviewDTO {
	
	private int id;//identificatore recensione
	private UserDTO user;//identificatore utente che ha scritto recensione
	private String negozio;//indica il negozio a cui si riferisce la recensione
	private String testo;//testo della recensione
	private int voto;//voto da 1 a 10
	

	
	
	
	public ReviewDTO() {
		super();
	}
	
	
    public ReviewDTO(String negozio, String testo, int voto) {
		super();
		this.negozio = negozio;
		this.testo = testo;
		this.voto = voto;
	}


    public ReviewDTO(int id ,UserDTO user, String negozio, String testo, int voto) {
		super();
		this.id=id;
		this.user = user;
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


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
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
		return "Review [id=" + id + ", user=" + user + ", negozio=" + negozio + ", testo=" + testo + ", voto=" + voto
				+ "]";
	}

}
