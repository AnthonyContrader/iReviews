package it.contrader.dto;

import java.util.List;
import it.contrader.model.Localita;
import it.contrader.model.Review;
import it.contrader.model.Tipologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsercizioDTO {
	
private Long codice;
	
	
	private String nome;
	
	
	private String indirizzo;
	
	
	private Double prezzo_medio;
	
	
	List<Review>listReviews;
	
	
	private Localita localita;
	
	
	private Tipologia tipologia;

}
