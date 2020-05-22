package it.contrader.view.review;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ReviewDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.controller.ReviewController;

public class ReviewReadView extends AbstractView{
		
	private int user_id;
	private Request request;
	private final String mode = "READ";
	private ReviewController controller =new ReviewController();

	public ReviewReadView() {
		
	}

	@Override
	public void showResults(Request request) {
	
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		user_id = Integer.parseInt(getInput().toString());
		List<ReviewDTO> reviews = controller.read(user_id);
		System.out.println();
		reviews.forEach(review -> System.out.println(review.toString()));
		System.out.println();
	}

	/**
	 * impacchetta una request con l'id dell'utente di cui vogliamo vedere le
	 * recensioni e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("user_id", user_id);
		request.put("mode", mode);
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Review", "doControl", request);
	}

}
