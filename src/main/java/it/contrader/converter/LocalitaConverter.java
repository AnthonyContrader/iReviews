package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.LocalitaDTO;
import it.contrader.model.Localita;

 public class LocalitaConverter  implements Converter<Localita, LocalitaDTO> {
	

	@Override
	public LocalitaDTO toDTO(Localita localita) {
		LocalitaDTO localitaDTO = new LocalitaDTO(localita.getId(), localita.getCitta());
		return localitaDTO;
	}

	@Override
	public Localita toEntity(LocalitaDTO localitaDTO) {
		Localita localita = new Localita(localitaDTO.getId(), localitaDTO.getCitta());
		return localita;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<LocalitaDTO> toDTOList(List<Localita> localitaList) {
		List<LocalitaDTO> localitaDTOList = new ArrayList<LocalitaDTO>();
		
	
		for(Localita localita : localitaList) {
			localitaDTOList.add(toDTO(localita));
		}
		return localitaDTOList;
	}

	
	
}
