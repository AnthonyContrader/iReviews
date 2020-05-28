package it.contrader.service;

import it.contrader.converter.ReviewConverter;
import it.contrader.dao.ReviewDAO;
import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;


public class ReviewService extends AbstractService<Review, ReviewDTO> {

	public ReviewService(){
		this.dao = new ReviewDAO();
		this.converter = new ReviewConverter();
	}
}
