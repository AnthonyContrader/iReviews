package it.contrader.dto;

import java.util.List;


import it.contrader.model.Esercizio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalitaDTO {
	
	private Long id;

	
	private String citta;


	private String provincia;

	
	private String stato;
	

	private List<Esercizio>listesercizio;
	

}
