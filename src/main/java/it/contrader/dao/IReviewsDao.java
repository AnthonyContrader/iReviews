package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import it.contrader.model.Esercizio;
import it.contrader.model.Review;

@Repository
@Transactional
public interface IReviewsDao extends CrudRepository<Review, Long>{
	
	Esercizio findByEsercizio (Esercizio esercizio);

}
