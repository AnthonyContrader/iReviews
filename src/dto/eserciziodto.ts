import { Usertype } from './usertype';
import { ReviewDTO } from './reviewdto';
import { LocalitaDTO } from './localitadto';
import { TipologiaDTO } from './tipologiadto';


/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * 
 * 
 * 
 */
export class EsercizioDTO {

     codice: number;
    
     nome:string ;
	
	 indirizzo: string;
	
	 prezzo_medio: number;
	
	//listReviews: Array<ReviewDTO>;
	
	 localita: LocalitaDTO;
	
	 tipologia: TipologiaDTO;

}