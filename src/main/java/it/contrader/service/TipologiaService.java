package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.dto.TipologiaDTO;
import it.contrader.converter.TipologiaConverter;
import it.contrader.dao.TipologiaRepository;
import it.contrader.model.Tipologia;


@Service
public class TipologiaService extends AbstractService<Tipologia, TipologiaDTO> {

	@Autowired
	private TipologiaConverter converter;
	@Autowired
	private TipologiaRepository repository;

	public TipologiaDTO findByTipologia(String tipologia) {
		return converter.toDTO(repository.findByTipologia(tipologia));
	}
}