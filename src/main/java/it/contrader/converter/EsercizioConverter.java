package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.EsercizioDTO;
import it.contrader.model.Esercizio;

@Component
public class EsercizioConverter extends AbstractConverter<Esercizio, EsercizioDTO> {

	@Override
	public Esercizio toEntity(EsercizioDTO esercizioDTO) {
		Esercizio esercizio= new Esercizio(esercizioDTO.getCodice(), esercizioDTO.getNome(), esercizioDTO.getIndirizzo(), esercizioDTO.getPrezzo_medio(), esercizioDTO.getLocalita(), esercizioDTO.getTipologia());
		return esercizio;
	}

	@Override
	public EsercizioDTO toDTO(Esercizio esercizio) {
		EsercizioDTO esercizioDTO = new EsercizioDTO(esercizio.getCodice(), esercizio.getNome(), esercizio.getIndirizzo(), esercizio.getPrezzo_medio(), esercizio.getLocalita(), esercizio.getTipologia());
		return esercizioDTO;
	}

}
