package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;

@Component
public class ReviewConveter extends AbstractConverter<Review, ReviewDTO> {

	@Override
	public Review toEntity(ReviewDTO reviewDTO) {
		Review review = null;
		if ( reviewDTO!= null) {
			review = new Review(reviewDTO.getId(), reviewDTO.getTitolo(), reviewDTO.getTesto(), reviewDTO.getVoto(), reviewDTO.getUser(), reviewDTO.getEsercizio());
		}
		return review;
	
	}

	@Override
	public ReviewDTO toDTO(Review review) {
		ReviewDTO reviewDTO = null;
		if(review != null) {
			reviewDTO = new ReviewDTO(review.getId(), review.getTitolo(), review.getTesto(), review.getVoto(), review.getUser(), review.getEsercizio());
		}
		return reviewDTO;
	}

}
