package it.contrader.service;

import it.contrader.dto.UserDTO;
import it.contrader.converter.ReviewConverter;
import it.contrader.dao.ReviewDAO;
import it.contrader.dto.ReviewDTO;

public class ReviewService {
	
	private ReviewDAO reviewDao;
	private ReviewConverter reviewConverter;
	
	public ReviewService() {
		reviewDao= new ReviewDAO();
		reviewConverter= new ReviewConverter();
	}

	public boolean insert(ReviewDTO dto) {
		
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return reviewDao.insert(reviewConverter.toEntity(dto));
	}
}
