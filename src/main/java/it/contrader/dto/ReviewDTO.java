package it.contrader.dto;

import it.contrader.model.Esercizio;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
	
	private Long id;
	
	
	private String titolo;
	
	
	private String testo;
	
	
	private Integer voto;
	
	
	private User user;
	
	private Esercizio esercizio;

}
