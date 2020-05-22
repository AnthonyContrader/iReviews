package it.contrader.view.review;

import it.contrader.controller.Request;
import it.contrader.controller.ReviewController;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ReviewDeleteView extends AbstractView{

	private Integer id;
	private final String mode = "DELETE";
	private Request request;
	private ReviewController controller =new ReviewController();

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		System.out.println("----- .:INSERISCI L'ID DELLA RECENSIONE DA ELIMINARE:. ----");
		id=Integer.parseInt(getInput().toString());
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		request = new Request();
		request.put("id", id);	
		request.put("mode", mode);
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Review", "doControl", request);
		
	}

}