package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Esercizio;

@Repository
public interface EsercizioRepository extends CrudRepository<Esercizio, Long> {

}
