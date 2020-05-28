package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TipologiaDTO;
import it.contrader.model.Tipologia;

public class TipologiaConverter implements Converter<Tipologia, TipologiaDTO> {

	@Override
	public TipologiaDTO toDTO(Tipologia tipologia) {
		TipologiaDTO tipologiaDTO = new TipologiaDTO(tipologia.getId(), tipologia.getTipo());
		return tipologiaDTO;
	}

	@Override
	public Tipologia toEntity(TipologiaDTO tipologiaDTO) {
		Tipologia tipologia = new Tipologia(tipologiaDTO.getId(), tipologiaDTO.getTipo());
		return tipologia;
	}

	@Override
	public List<TipologiaDTO> toDTOList(List<Tipologia> tipologiaList) {
		List<TipologiaDTO>tipologiaDTOList = new ArrayList<>();
		for(Tipologia tipologia : tipologiaList) {
			tipologiaDTOList.add(toDTO(tipologia));
		}
		return tipologiaDTOList;
	}

}

