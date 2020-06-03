package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Service;

import it.contrader.converter.EsercizioConverter;
import it.contrader.dao.EsercizioRepository;
import it.contrader.dto.EsercizioDTO;
import it.contrader.model.Esercizio;

@Service
public class EsercizioService extends AbstractService<Esercizio, EsercizioDTO> {
	
	@Autowired
	private EsercizioConverter converter;
	@Autowired
	private EsercizioRepository repository;

	public EsercizioDTO findByCodiceAndNome(Long codice, String nome) {
		return converter.toDTO(repository.findByCodiceAndNome(codice, nome));
	}

}
