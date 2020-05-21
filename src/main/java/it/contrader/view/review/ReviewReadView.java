package it.contrader.view.review;

import it.contrader.controller.Request;
import it.contrader.dto.ReviewDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ReviewReadView extends AbstractView{
	
	
	private int reviewid;
	private Request request;
	private final String mode = "READ";

	public ReviewReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ReviewDTO review = (ReviewDTO) request.get("review");
			System.out.println(review);
			MainDispatcher.getInstance().callView("Review", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della review:");
		reviewid = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		
		request = new Request();
		request.put("reviewid", reviewid);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Review", "doControl", request);
	}

}
