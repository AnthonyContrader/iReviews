package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class ReviewView  extends AbstractView{
	
	private String testo;
	
	private String negozio;
	
	private int voto;
	
	private Request request;
	
	
	
	
public void showOptions() {
		
		System.out.println("----- .:INSERISCI IL TESTO DELLA RECENSIONE:. ----");
		this.testo=getInput();

        System.out.println("----- .:INSERISCI IL NOME DEL NEGOZIO :. ----");
		this.negozio=getInput();
        System.out.println("----- .:INSERISCI IL VOTO DELLA RECENSIONE:. ----");
		
		
		this.voto= Integer.valueOf(getInput());
		
	}




@Override
public void showResults(Request request) {
	
	if(request!=null) {
    	System.out.println("\n INSERISCI QUI LA TUA RECENSIONE: ");
    	}
}




@Override
public void submit() {

	request = new Request();
	request.put("testo", this.testo);
	request.put("negozio", this.negozio);
	request.put("voto", this.voto);
	request.put("mode", "INSERT");
	MainDispatcher.getInstance().callAction("Review", "doControl", request);
	
}
	

}
