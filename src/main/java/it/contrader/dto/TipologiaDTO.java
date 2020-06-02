package it.contrader.dto;

import java.util.List;

import it.contrader.model.Esercizio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipologiaDTO {
	
	private Long id;
	
	
	private String tipologia;
	
	
	List<Esercizio>listEsercizio;

}
