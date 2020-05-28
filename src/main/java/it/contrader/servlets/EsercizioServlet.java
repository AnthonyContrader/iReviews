package it.contrader.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.EsercizioDTO;

import it.contrader.service.EsercizioService;
import it.contrader.service.Service;


public class EsercizioServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EsercizioServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EsercizioDTO> service = new EsercizioService();
		List<EsercizioDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EsercizioDTO> service = new EsercizioService();
		String mode = request.getParameter("mode");
		EsercizioDTO dto;
		int id;
		boolean ans;
		int codice;
		int id_citta;
	

		switch (mode.toUpperCase()) {

		case "ESERCIZIOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/esercizio/eserciziomanager.jsp").forward(request, response);
			break;

		case "READ":
		
			codice = Integer.parseInt(request.getParameter("codice"));
			dto = service.read(codice);
			request.setAttribute("dto", dto);
			//System.out.println(request.getParameter("codice"));
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/esercizio/readesercizio.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/esercizio/updateesercizio.jsp").forward(request, response);
			
			break;

		case "INSERT":
			
			String nome = request.getParameter("nome").toString();
			double prezzo_medio = Double.parseDouble(request.getParameter("prezzo_medio"));
			int id_tipologia = Integer.parseInt(request.getParameter("id_tipologia"));
			String indirizzo = request.getParameter("indirizzo").toString();
		    id_citta = Integer.parseInt(request.getParameter("id_citta"));
			dto = new EsercizioDTO (nome,prezzo_medio,id_tipologia,indirizzo,id_citta);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/esercizio/eserciziomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
	
			nome = request.getParameter("nome");
			prezzo_medio = Double.parseDouble(request.getParameter("prezzo_medio"));
			id_tipologia = Integer.parseInt(request.getParameter("id_tipologia"));
			indirizzo=request.getParameter("indirizzo");
			id_citta=Integer.parseInt(request.getParameter("id_citta"));
			codice=Integer.parseInt(request.getParameter("codice"));
			dto = new EsercizioDTO (codice,nome, prezzo_medio, id_tipologia,indirizzo,id_citta);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/esercizio/eserciziomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			codice = Integer.parseInt(request.getParameter("codice"));
			ans = service.delete(codice);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/esercizio/eserciziomanager.jsp").forward(request, response);
			break;
		}
	}

}
