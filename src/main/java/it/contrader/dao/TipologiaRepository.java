package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Tipologia;

@Repository
public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {

}
