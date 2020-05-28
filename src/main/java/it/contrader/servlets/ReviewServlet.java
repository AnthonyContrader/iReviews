package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ReviewDTO;
import it.contrader.service.ReviewService;
import it.contrader.service.Service;


public class ReviewServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	public ReviewServlet() {
		
	}

	public void updateList(HttpServletRequest request) {
		Service<ReviewDTO> service = new ReviewService();
		List<ReviewDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ReviewDTO> service = new ReviewService();
		String mode = request.getParameter("mode");
		ReviewDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "REVIEWLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/review/reviewmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/review/readreview.jsp").forward(request, response);				
			}			
			else getServletContext().getRequestDispatcher("/review/updatereview.jsp").forward(request, response);			
			break;

		case "INSERT":
			int voto = Integer.parseInt(request.getParameter("voto").toString());
			int user_id = Integer.parseInt(request.getParameter("user_id").toString());
			String id_esercizio = request.getParameter("id_esercizio").toString();
			String testo = request.getParameter("testo").toString();
			String titolo = request.getParameter("titolo").toString();
			dto = new ReviewDTO (voto, user_id, id_esercizio, testo, titolo);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/review/reviewmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			voto = Integer.parseInt(request.getParameter("voto"));
			user_id = Integer.parseInt(request.getParameter("user_id"));
			id_esercizio = request.getParameter("id_esercizio");
			testo = request.getParameter("testo");
			titolo = request.getParameter("titolo");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ReviewDTO (id,voto, user_id, id_esercizio, testo, titolo);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/review/reviewmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/review/reviewmanager.jsp").forward(request, response);
			break;
		}
	}
}
