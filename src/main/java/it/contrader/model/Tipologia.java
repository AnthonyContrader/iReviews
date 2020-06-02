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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipologia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipologia implements Serializable{

	private static final long serialVersionUID = 7556097426324925271L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipologia")
	private String tipologia;
	
	@OneToMany(mappedBy = "tipologia",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Esercizio>listEsercizio;

}
