package it.contrader.view.review;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ReviewUpdateView extends AbstractView {
	
	private int id;
	private int user_id;
	private String negozio;
	private String testo;
	private int voto;
	private final String mode = "UPDATE";

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Riview", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id dal quale vuoi la modifica");
		id = Integer.parseInt(getInput());
		System.out.println("Inserisci user_id");
		user_id = Integer.parseInt(getInput());
		System.out.println("inserisci il negozio");
		negozio = getInput();
		System.out.println("Inserisci il testo");
		testo = getInput();
		System.out.println("Inserisci il voto");
		voto = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("id", id);
		request.put("user_id", user_id);
		request.put("negozio", negozio);
		request.put("testo", testo);
		request.put("voto", voto);
		request.put("mode", mode);
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Review", "doControl", request);
		
	}

}
