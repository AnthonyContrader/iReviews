package it.contrader.service;

import it.contrader.converter.EsercizioConverter;



import it.contrader.dao.EsercizioDAO;
import it.contrader.dto.EsercizioDTO;
import it.contrader.model.Esercizio;

public class EsercizioService extends AbstractService<Esercizio, EsercizioDTO> {
	

	
	
	
	//Istanzio DAO  e Converter specifici.
	public EsercizioService(){
	
		this.dao =  new EsercizioDAO();
		this.converter = new EsercizioConverter();
	}

	
	

	@Override
	public EsercizioDTO read(int codice) {
		
		return converter.toDTO(dao.read(codice));
	}

	@Override
	public boolean delete(int codice) {
		// TODO Auto-generated method stub
		 return dao.delete(codice);
	}









	



}
