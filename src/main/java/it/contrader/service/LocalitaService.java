package it.contrader.service;

import it.contrader.converter.LocalitaConverter;
import it.contrader.dao.LocalitaDAO;
import it.contrader.dto.LocalitaDTO;
import it.contrader.model.Localita;


public class LocalitaService extends AbstractService<Localita, LocalitaDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public LocalitaService(){
		this.dao = new LocalitaDAO();
		this.converter = new LocalitaConverter();
	}
	
}