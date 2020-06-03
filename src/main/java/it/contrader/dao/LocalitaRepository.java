package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Localita;

@Repository
@Transactional
public interface LocalitaRepository extends CrudRepository<Localita, Long> {

	
	Localita findByCitta(String citta);

}
