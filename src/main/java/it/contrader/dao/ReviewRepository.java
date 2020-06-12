package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
