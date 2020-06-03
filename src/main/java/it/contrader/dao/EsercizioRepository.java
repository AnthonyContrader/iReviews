package it.contrader.dao;


import javax.transaction.Transactional;





import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Esercizio;



@Repository
@Transactional
public interface EsercizioRepository extends CrudRepository<Esercizio, Long> {
	
    Esercizio findByCodiceAndNome( Long codice,String nome);

}
