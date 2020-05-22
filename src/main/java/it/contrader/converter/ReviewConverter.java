package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.ReviewDTO;
//import it.contrader.dto.UserDTO;
import it.contrader.model.Review;


public class ReviewConverter {

	public ReviewDTO toDTO(Review review) {

		ReviewDTO reviewDTO = new ReviewDTO(review.getId(), review.getUser_id(), review.getNegozio(), review.getTesto(),
				  review.getVoto());
		return reviewDTO;

	}

	public Review toEntity(ReviewDTO reviewDTO) {

		Review review = new Review(reviewDTO.getId(), reviewDTO.getUser_id(), reviewDTO.getNegozio(),
			   reviewDTO.getTesto(), reviewDTO.getVoto());
		return review;

	}

	public List<ReviewDTO> toDTOList(List<Review> reviewList) {
			// Crea una lista vuota.
			List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Review review : reviewList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			reviewDTOList.add(toDTO(review));
		}
		
		return reviewDTOList;
	}
}
