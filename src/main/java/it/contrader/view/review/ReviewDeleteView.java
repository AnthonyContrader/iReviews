package it.contrader.view.review;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ReviewDeleteView extends AbstractView{

	private Integer id;
	private final String mode = "DELETE";
	private Request request;

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La Rieview indicata è stata eliminata correttamente\n");
			MainDispatcher.getInstance().callView("Review", null);
		}	
	}

	@Override
	public void showOptions() {
		System.out.println("----- .:INSERISCI L'ID DELLA RECENSIONE DA ELIMINARE:. ----");
		id=Integer.parseInt(getInput().toString());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);	
		request.put("mode", mode);
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Review", "doControl", request);
		
	}

}