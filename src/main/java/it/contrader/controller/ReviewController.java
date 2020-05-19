package it.contrader.controller;

import it.contrader.dto.ReviewDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.ReviewService;

public class ReviewController implements Controller {
	
	private ReviewService reviewService;
	private static String sub_package = "user.";
	
  public ReviewController() {
		
	reviewService= new ReviewService();
	}

	@Override
	public void doControl(Request request) {
		
		 int id;
		  User user;
		 String negozio;
		 String testo;
		 int voto;
		 
		 String mode = (String) request.get("mode");
		 
		 switch(mode) {
		
	case "INSERT":
		id = (int) request.get("id");
		user = (User) request.getString("user");
		negozio = request.get("negozio").toString();
		testo = request.get("testo").toString();
		voto = (int) request.get("voto");
		
		//costruisce l'oggetto user da inserire
		ReviewDTO reviewtoinsert = new ReviewDTO(id, user, negozio,testo,voto);
		//invoca il service
		reviewService.insert(reviewtoinsert);
		request = new Request();
		request.put("mode", "mode");
		//Rimanda alla view con la risposta
		MainDispatcher.getInstance().callView(sub_package + "ReviewInsert", request);
		break;
		 }
		
	}
}
