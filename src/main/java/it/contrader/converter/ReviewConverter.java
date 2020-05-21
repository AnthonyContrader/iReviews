package it.contrader.converter;

import it.contrader.dto.ReviewDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Review;
import it.contrader.model.User;

public class ReviewConverter {
	
	
	
	public ReviewDTO toDTO(Review review) {
		
		
		UserDTO user = new UserDTO();
		user.setId(review.getUser());
		ReviewDTO reviewDTO = new ReviewDTO(review.getId(),user,review.getNegozio(), review.getTesto(), review.getVoto());
		return reviewDTO;
	}

	public Review toEntity(ReviewDTO reviewDTO) {
		
		Review review = new Review(reviewDTO.getId(), reviewDTO.getUser().getId(), reviewDTO.getNegozio(), reviewDTO.getTesto(), reviewDTO.getVoto());
		return review;
	}
}
