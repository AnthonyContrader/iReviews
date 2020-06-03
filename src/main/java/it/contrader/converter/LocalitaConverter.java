package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.LocalitaDTO;
import it.contrader.model.Localita;

@Component
public class LocalitaConverter extends AbstractConverter<Localita, LocalitaDTO> {

	@Override
	public Localita toEntity(LocalitaDTO localitaDTO) {
		Localita localita = new Localita(localitaDTO.getId(), localitaDTO.getCitta(),localitaDTO.getProvincia(),localitaDTO.getStato(),localitaDTO.getListesercizio());
		return localita;
	}

	@Override
	public LocalitaDTO toDTO(Localita localita) {
		LocalitaDTO localitaDTO = new LocalitaDTO(localita.getId(), localita.getCitta(),localita.getProvincia(),localita.getStato(),localita.getListesercizio());
		return localitaDTO;
	}

}
