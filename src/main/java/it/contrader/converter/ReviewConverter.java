package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;

public class ReviewConverter implements Converter<Review, ReviewDTO> {

	@Override
	public ReviewDTO toDTO(Review review) {
		ReviewDTO reviewDTO=new ReviewDTO(review.getId(),review.getVoto(),review.getUser_id(),review.getId_esercizio(),review.getTesto(), review.getTitolo());
		// TODO Auto-generated method stub
		return reviewDTO;
	}

	@Override
	public Review toEntity(ReviewDTO reviewDTO) {
		Review review=new Review(reviewDTO.getId(),reviewDTO.getVoto(),reviewDTO.getUser_id(),reviewDTO.getId_esercizio(),reviewDTO.getTesto(), reviewDTO.getTitolo());
		
		return review;
	}

	@Override
	public List<ReviewDTO> toDTOList(List<Review> reviewList) {
		List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
				for (Review review : reviewList) {
					reviewDTOList.add(toDTO(review));
				}				
				return reviewDTOList;
	}
}