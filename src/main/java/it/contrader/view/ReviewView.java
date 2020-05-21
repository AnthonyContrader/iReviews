package it.contrader.view;

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
		
		/*
		System.out.println("----- .:INSERISCI IL TESTO DELLA RECENSIONE:. ----");
		this.testo=getInput();

        System.out.println("----- .:INSERISCI IL NOME DEL NEGOZIO :. ----");
		this.negozio=getInput();
        System.out.println("----- .:INSERISCI IL VOTO DELLA RECENSIONE:. ----");
		
		
		this.voto= Integer.valueOf(getInput());*/
		
	}


public void submit() {
	//System.out.print("submit");
	request = new Request();
	request.put("choice", choice);
	request.put("mode", "GETCHOICE");
	MainDispatcher.getInstance().callAction("Review", "doControl", this.request);
}


@Override
public void showResults(Request request) {
	// TODO Auto-generated method stub
	
}
}