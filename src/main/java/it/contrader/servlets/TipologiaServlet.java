package it.contrader.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.TipologiaDTO;
import it.contrader.service.Service;
import it.contrader.service.TipologiaService;

public class TipologiaServlet extends HttpServlet{

	private static final long serialVersionUID = 3274628756131915894L;
	
	public TipologiaServlet() {
			
		}
	
	public void updateList(HttpServletRequest request) {
		Service<TipologiaDTO> service = new TipologiaService();
		List<TipologiaDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TipologiaDTO>service = new TipologiaService();
		String mode = request.getParameter("mode");
		TipologiaDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "TIPOLOGIALIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/tipologia/tipologiamanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/tipologia/readtipo.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/tipologia/updatetipo.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String tipo = request.getParameter("tipo").toString();
			dto = new TipologiaDTO(tipo);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tipologia/tipologiamanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			tipo = request.getParameter("tipo").toString();
			id = Integer.parseInt(request.getParameter("id"));
			dto = new TipologiaDTO(id, tipo);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/tipologia/tipologiamanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tipologia/tipologiamanager.jsp").forward(request, response);
			break;
		}
	}

}
