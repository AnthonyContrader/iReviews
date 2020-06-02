package it.contrader.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "localita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "citta")
	private String citta;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "stato")
	private String stato;
	
	@OneToMany(mappedBy = "localita", cascade = CascadeType.ALL)
	private List<Esercizio>listesercizio;
	
	

}
