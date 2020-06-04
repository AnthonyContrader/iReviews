package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.ReviewDTO;
import it.contrader.model.Esercizio;
import it.contrader.model.User;
import it.contrader.service.EsercizioService;
import it.contrader.service.ReviewService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/review")
public class reviewController  {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private UserService userservice;
	@Autowired
	private EsercizioService esercizioService;
	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listReview", reviewService.getAll());
		request.getSession().setAttribute("listUser", userservice.getAll());
		request.getSession().setAttribute("listEsercizio", esercizioService.getAll());
	}
	
	@GetMapping("/getall")
	public String gettAll(HttpServletRequest request) {
		setAll(request);
		return "reviews";
	}
	
	@GetMapping("/delete")
	private String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		reviewService.delete(id);
		setAll(request);
		return "reviews";
	}
		
	@GetMapping ("/preupdate")
	private  String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", reviewService.read(id));
		return "updateReview";
	}
	
	@PostMapping("/insert")
	public String insert (HttpServletRequest request, @RequestParam("user") User user, @RequestParam("esercizio") Esercizio esercizio,
							@RequestParam("titolo") String titolo, @RequestParam("testo") String testo, @RequestParam("voto") Integer voto ){
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUser(user);
		reviewDTO.setTitolo(titolo);
		reviewDTO.setTesto(testo);
		reviewDTO.setEsercizio(esercizio);
		reviewDTO.setVoto(voto);
		reviewService.insert(reviewDTO);
		setAll(request);
		return "reviews";
		
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("id") Long id, @RequestParam("user") User user, @RequestParam("esercizio") Esercizio esercizio,
						@RequestParam("titolo") String titolo, @RequestParam("testo") String testo, @RequestParam("voto") Integer voto) {
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setId(id);
		reviewDTO.setUser(user);
		reviewDTO.setTitolo(titolo);
		reviewDTO.setTesto(testo);
		reviewDTO.setEsercizio(esercizio);
		reviewDTO.setVoto(voto);
		reviewService.insert(reviewDTO);
		setAll(request);
		return "reviews";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", reviewService.read(id));
		return "reaadReview";
	}
	
	
	
	
	
		
	
	

	
	
	

}
