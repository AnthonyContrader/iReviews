package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "esercizio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Esercizio implements Serializable {
	
	private static final long serialVersionUID = 9032981255053098876L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codice")
	private Long codice;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "prezzo_medio")
	private Double prezzo_medio;
	
	@OneToMany(mappedBy = "esercizio", cascade = CascadeType.ALL)
	List<Review>listReviews;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_citta", referencedColumnName = "id")
	private Localita localita;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipologia", referencedColumnName = "id")
	private Tipologia tipologia;
	

}
