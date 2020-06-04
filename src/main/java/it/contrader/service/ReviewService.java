package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ReviewConveter;
import it.contrader.dao.IReviewsDao;
import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;

@Service
public class ReviewService extends AbstractService<Review, ReviewDTO> {
	
	@Autowired
	private IReviewsDao dao;
	@Autowired
	private ReviewConveter conveter;

}
