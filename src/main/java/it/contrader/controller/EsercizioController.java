package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.contrader.dto.EsercizioDTO;
import it.contrader.model.Localita;
import it.contrader.model.Tipologia;
import it.contrader.service.EsercizioService;
import it.contrader.service.LocalitaService;
import it.contrader.service.TipologiaService;

@Controller
@RequestMapping("/esercizio")
public class EsercizioController {
	
	

		@Autowired
		private EsercizioService service;
		
		@Autowired
		private LocalitaService serviceLocalita;
		
		@Autowired
		private TipologiaService serviceTipologia;

		

		@GetMapping("/getall")
		public String getAll(HttpServletRequest request) {
			setAll(request);
			return "eserciziomanager";
		}

		@GetMapping("/delete")
		public String delete(HttpServletRequest request, @RequestParam("codice") Long codice) {
			service.delete(codice);
			setAll(request);
			return "eserciziomanager";
		}

		@GetMapping("/preupdate")
		public String preUpdate(HttpServletRequest request, @RequestParam("codice") Long codice) {
			request.getSession().setAttribute("dto", service.read(codice));
			return "updateesercizio";
		}

		@PostMapping("/update")
		public String update(HttpServletRequest request, @RequestParam("codice") Long codice,
				@RequestParam("nome") String nome,
				@RequestParam("prezzo_medio") Double prezzo_medio, 
				@RequestParam("tipologia") Tipologia tipologia,
				@RequestParam("indirizzo") String indirizzo,
				@RequestParam("localita") Localita localita) {

			EsercizioDTO dto = new EsercizioDTO();
			dto.setCodice(codice);
			dto.setNome(nome);
			dto.setPrezzo_medio(prezzo_medio);
			dto.setTipologia(tipologia);
			dto.setIndirizzo(indirizzo);
			dto.setLocalita(localita);
			service.update(dto);
			setAll(request);
			return "eserciziomanager";

		}

		@PostMapping("/insert")
		public String insert(HttpServletRequest request, 
				@RequestParam("nome") String nome,
				@RequestParam("prezzo_medio") Double prezzo_medio, 
				@RequestParam("tipologia") Tipologia tipologia,
				@RequestParam("indirizzo") String indirizzo,
				@RequestParam("localita") Localita localita) {

			EsercizioDTO dto = new EsercizioDTO();
			
			dto.setNome(nome);
			dto.setPrezzo_medio(prezzo_medio);
			dto.setTipologia(tipologia);
			dto.setIndirizzo(indirizzo);
			dto.setLocalita(localita);
			service.update(dto);
			setAll(request);
			return "eserciziomanager";

		}
			

		@GetMapping("/read")
		public String read(HttpServletRequest request, @RequestParam("codice") Long codice) {
			request.getSession().setAttribute("dto", service.read(codice));
			return "readesercizio";
		}

		

		private void setAll(HttpServletRequest request) {
			request.getSession().setAttribute("list", service.getAll());
			request.getSession().setAttribute("listLocalita", serviceLocalita.getAll());
			request.getSession().setAttribute("listTipologia", serviceTipologia.getAll());
		}

}
