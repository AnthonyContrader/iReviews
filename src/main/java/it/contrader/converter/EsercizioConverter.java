package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.EsercizioDTO;

import it.contrader.model.Esercizio;


public class EsercizioConverter implements Converter<Esercizio, EsercizioDTO>{
	
	/**
	 * Crea un oggetto di tipo EsercizioDTO e lo riempie con i campi del parametro esercizio di tipo Esercizio.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public EsercizioDTO toDTO(Esercizio esercizio) {
	     EsercizioDTO esercizioDTO = new EsercizioDTO( esercizio.getCodice(),esercizio.getNome(), esercizio.getPrezzo_medio(), esercizio.getId_tipologia(), esercizio.getIndirizzo(), esercizio.getId_citta());
		return esercizioDTO;
	}

	/**
	 * Crea un oggetto di tipo Esercizio e lo riempie con i campi del parametro esercizio di tipo EsercizioDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Esercizio toEntity(EsercizioDTO esercizioDTO) {
		Esercizio esercizio= new Esercizio( esercizioDTO.getCodice(),esercizioDTO.getNome(), esercizioDTO.getPrezzo_medio(), esercizioDTO.getId_tipologia(), esercizioDTO.getIndirizzo(),esercizioDTO.getId_citta());
		return esercizio;
	}
	
	/**
	 * Metodo per convertire le liste di Esercizio.
	 */
	@Override
	public List<EsercizioDTO> toDTOList(List<Esercizio> esercizioList) {
		//Crea una lista vuota.
		List<EsercizioDTO> esercizioDTOList = new ArrayList<EsercizioDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Esercizio esercizio : esercizioList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			esercizioDTOList.add(toDTO(esercizio));
		}
		return esercizioDTOList;
	}


}
