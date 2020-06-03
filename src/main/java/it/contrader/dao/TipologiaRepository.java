package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Tipologia;


@Repository
@Transactional
public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {

	
	Tipologia findByTipologia(String tipologia);

}