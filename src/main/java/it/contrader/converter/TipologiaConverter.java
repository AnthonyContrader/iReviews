package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TipologiaDTO;
import it.contrader.model.Tipologia;

@Component
public class TipologiaConverter extends AbstractConverter<Tipologia, TipologiaDTO> {

	@Override
	public Tipologia toEntity(TipologiaDTO tipologiaDTO) {
		Tipologia tipologia = new Tipologia(tipologiaDTO.getId(), tipologiaDTO.getTipologia());
		return tipologia;
	}

	@Override
	public TipologiaDTO toDTO(Tipologia tipologia) {
		TipologiaDTO tipologiaDTO = new TipologiaDTO(tipologia.getId(), tipologia.getTipologia());
		return tipologiaDTO;
	}

}
