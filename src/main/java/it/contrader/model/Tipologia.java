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
@Table(name = "tipologia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipologia implements Serializable{
	
	private static final long serialVersionUID = -8090573747142717069L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipologia;
	

}
