package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.dto.ReviewDTO;

public class ReviewView  extends AbstractView{
	
	private Request request;
	private String choice;
		
public void showOptions() {
			
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");		
		this.choice = getInput();
		
	}

  @Override
  public void showResults(Request request) {
	 
	  if (request != null) {
			System.out.println("\n------------------- Gestione Recensioni ----------------\n");
			System.out.println("ID\tTesto\tNegozio\tVoto");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ReviewDTO> review = (List<ReviewDTO>) request.get("review");
			for (ReviewDTO r: review)
			System.out.println(r);
	  }
		
  }
  
   
  public void submit() {
	  
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Review", "doControl", this.request);
		
	  }
}