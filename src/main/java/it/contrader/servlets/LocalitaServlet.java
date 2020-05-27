package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.LocalitaDTO;
import it.contrader.service.Service;
import it.contrader.service.LocalitaService;


public class LocalitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocalitaServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<LocalitaDTO> service = new LocalitaService();
		List<LocalitaDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LocalitaDTO> service = new LocalitaService();
		String mode = request.getParameter("mode");
		LocalitaDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "LOCALITALIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/localita/localitamanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/localita/readlocalita.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/localita/updatelocalita.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String citta = request.getParameter("citta").toString();
			dto = new LocalitaDTO (citta);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/localita/localitamanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			citta = request.getParameter("citta").toString();
			id = Integer.parseInt(request.getParameter("id"));
			dto = new LocalitaDTO (id, citta);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/localita/localitamanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/localita/localitamanager.jsp").forward(request, response);
			break;
		}
	}
}