package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ReviewDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.ReviewService;

public class ReviewController implements Controller {
	
	private static String sub_package = "review.";
	private ReviewService reviewService;
	private String choice;
	
  public ReviewController() {
		
	this.reviewService= new ReviewService();
	}

	@Override
	public void doControl(Request request) {
		
		 int id;
		 UserDTO user = new UserDTO();
		 String negozio;
		 String testo;
		 int voto;
		 
		 String mode = (String) request.get("mode");
		  choice = (String) request.get("choice");
		 switch(mode) {
		 
		 /*case "REVIEWLIST":
				List<ReviewDTO> reviewDTO = reviewService.getAll();
				//Impacchetta la request con la lista degli user
				request.put("review", reviewDTO);
				MainDispatcher.getInstance().callView("Review", request);
				break;*/
		
	case "INSERT":
		// id = (int) request.get("id");
		// user = (UserDTO) request.getString("user");
		negozio = request.get("negozio").toString();
		testo = request.get("testo").toString();
		voto = (int) request.get("voto");
		
		user.setId(1);
		//costruisce l'oggetto user da inserire
		ReviewDTO reviewtoinsert = new ReviewDTO(0, user, negozio,testo,voto);
		//invoca il service
		reviewService.insert(reviewtoinsert);
		request = new Request();
		request.put("mode", "mode");
		//Rimanda alla view con la risposta
		MainDispatcher.getInstance().callView(sub_package + "ReviewInsert", request);
		break;
		
	case "GETCHOICE":
		
			
			//toUpperCase() mette in maiuscolo la scelta
		switch (choice.toUpperCase()) {

		case "L":
			MainDispatcher.getInstance().callView(sub_package + "ReviewRead", null);
			break;
	
		case "I":
			MainDispatcher.getInstance().callView(sub_package + "ReviewInsert", null);
			System.out.println("case i");
			break;
	
		case "M":
			MainDispatcher.getInstance().callView(sub_package + "ReviewUpdate", null);
			break;
	
		case "C":
			MainDispatcher.getInstance().callView(sub_package + "ReviewDelete", null);
			break;
	
		case "E":
			MainDispatcher.getInstance().callView("Login", null);
			break;
	
	
		case "B":
			MainDispatcher.getInstance().callView("HomeAdmin", null);
		break;
	
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}

		 }
		
	}
}
