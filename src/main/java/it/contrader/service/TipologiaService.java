package it.contrader.service;

import it.contrader.converter.TipologiaConverter;
import it.contrader.dao.TipologiaDAO;
import it.contrader.dto.TipologiaDTO;
import it.contrader.model.Tipologia;

public class TipologiaService extends AbstractService<Tipologia, TipologiaDTO>{
	
	public TipologiaService(){
		this.dao = new TipologiaDAO();
		this.converter = new TipologiaConverter();
	}

}
