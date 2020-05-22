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
  
  public List<ReviewDTO> read(int user_id) {
	  return this.reviewService.read(user_id);
	  
  }

	@Override
	public void doControl(Request request) {
		
		 int id;
		 int user_id ;
		 String negozio;
		 String testo;
		 int voto;
		 
		 
		 String mode = (String) request.get("mode");
		 choice = (String) request.get("choice");
		  
		 switch(mode) {
		 
		case "REVIEWLIST":
			System.out.println("sono nella review");
			List<ReviewDTO> reviewDTO = reviewService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("review", reviewDTO);
			MainDispatcher.getInstance().callView("Review", request);
			break;
		
		 case "READ":
			if (request != null) {
				user_id = 0;
				System.out.println("tesr");
				user_id = Integer.parseInt(request.get("choice").toString());
				Request result = new Request();
				List<ReviewDTO> reviewDTO1 = reviewService.read(user_id);
				result.put("review", reviewDTO1);
				MainDispatcher.getInstance().callView(sub_package + "ReviewRead", request);
			}
			
			break;
			
		 case "DELETE":
				if (request != null) {
					id = 0;	
					System.out.println(request.get("choice").toString());	
					id = Integer.parseInt(request.get("id").toString());
				    reviewService.delete(id);
					MainDispatcher.getInstance().callView(sub_package + "ReviewDelete", request);
				}
				
				break;
	     
		
		 case "INSERT":
		  
		 user_id = (int) request.get("user_id");
		 negozio = request.get("negozio").toString();
		 testo = request.get("testo").toString();
		 voto = (int) request.get("voto");
		
		 //user.setId(1);
		 //costruisce l'oggetto user da inserire
		 ReviewDTO reviewtoinsert = new ReviewDTO(0, user_id, negozio,testo,voto);
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
