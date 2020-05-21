package it.contrader.service;

import it.contrader.dto.UserDTO;

import java.util.List;

import it.contrader.converter.ReviewConverter;
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
	
	public ReviewDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return reviewConverter.toDTO(reviewDAO.read(id));
	}
	
	public List<ReviewDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return reviewConverter.toDTOList(reviewDAO.getAll());
	}
}
