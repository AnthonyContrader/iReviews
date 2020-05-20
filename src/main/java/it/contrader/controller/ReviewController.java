package it.contrader.controller;

import it.contrader.dto.ReviewDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.ReviewService;

public class ReviewController implements Controller {
	
	private static String sub_package = "review.";
	private ReviewService reviewService;
	
	
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
		 
		 switch(mode) {
		
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
		 }
		
	}
}
