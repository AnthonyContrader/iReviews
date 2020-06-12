package it.contrader.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "localita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localita implements Serializable{
	
	private static final long serialVersionUID = 6823143909772965715L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String citta;
	private String provincia;
	private String stato;

}
