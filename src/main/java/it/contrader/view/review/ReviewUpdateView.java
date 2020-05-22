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
	private Request request;
	
	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Review", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id della recensione da modificare");
		id = Integer.parseInt(getInput());
		System.out.println("Inserisci user_id del nuovo proprietario");
		user_id = Integer.parseInt(getInput());
		System.out.println("inserisci il nome negozio");
		negozio = getInput();
		System.out.println("Inserisci il testo della recensione");
		testo = getInput();
		System.out.println("Inserisci il voto della recensione(DA 0 A 10)");
		voto = Integer.parseInt(getInput());
		
		if(voto<0 || voto >10 ) {
		System.out.println("ERRORE IL VOTO DEVE ESSERE COMPRESO FRA 0 E 10");
		MainDispatcher.getInstance().callView( "Review", request);
		}
		
	}

	@Override
	public void submit() {
	    request = new Request();
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
