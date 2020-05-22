package it.contrader.service;

import it.contrader.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import it.contrader.converter.ReviewConverter;
import it.contrader.model.Review;
import it.contrader.dao.ReviewDAO;
import it.contrader.dto.ReviewDTO;

public class ReviewService {
	
	private ReviewDAO reviewDAO;
	private ReviewConverter reviewConverter;
	
	public ReviewService() {
		reviewDAO= new ReviewDAO();
		reviewConverter= new ReviewConverter();
	}
	
	
	public boolean insert(ReviewDTO dto) {
		
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return reviewDAO.insert(reviewConverter.toEntity(dto));
		
		
	}

	public boolean delete(int id) {		
		return reviewDAO.delete(id);	
		
	}
	
	public List<ReviewDTO> read(int user_id) {
		List<Review> review = this.reviewDAO.read(user_id);
		List<ReviewDTO> reviewDto = new ArrayList<>();
		for (Review reviews : review) {
			reviewDto.add(reviewConverter.toDTO(reviews));
		}
		return reviewDto;
	}
	
	public List<ReviewDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return reviewConverter.toDTOList(reviewDAO.getAll());
	}
	
	public boolean update (ReviewDTO reviewDTO) {
		return reviewDAO.update(reviewConverter.toEntity(reviewDTO));
	}
}
