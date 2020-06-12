package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Localita;
import it.contrader.model.Tipologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="codice")
public class EsercizioDTO {
	
	private Long codice;

	private String nome;
	
	
	private String indirizzo;
	
	
	private Double prezzo_medio;
	
	
	private Localita localita;
	
	private Tipologia tipologia;

}
