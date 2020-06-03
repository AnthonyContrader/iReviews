package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import it.contrader.converter.LocalitaConverter;
import it.contrader.dao.LocalitaRepository;
import it.contrader.dto.LocalitaDTO;
import it.contrader.model.Localita;

@Service
public class LocalitaService extends AbstractService<Localita, LocalitaDTO> {

	@Autowired
	private LocalitaConverter converter;
	@Autowired
	private LocalitaRepository repository;

	public LocalitaDTO findByCitta(String citta) {
		return converter.toDTO(repository.findByCitta(citta));
	}

}
