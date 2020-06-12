package it.contrader.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "esercizio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Esercizio implements Serializable{

	private static final long serialVersionUID = -726113452175192059L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codice;
	private String nome;
	private String indirizzo;
	private Double prezzo_medio;
	@ManyToOne
	private Localita localita;
	@ManyToOne
	private Tipologia tipologia;
	

}
