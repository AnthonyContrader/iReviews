import { UserDTO } from './userdto';
import { EsercizioDTO } from './eserciziodto';



export class ReviewDTO{

 id: number;
	
	
titolo: string;


testo: string;


voto: number;


 user: UserDTO;

 esercizio: EsercizioDTO;

}