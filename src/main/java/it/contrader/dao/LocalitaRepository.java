package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Localita;

@Repository
public interface LocalitaRepository extends CrudRepository<Localita, Long> {

}
