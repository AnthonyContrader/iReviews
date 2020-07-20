import { LocalitaDTO } from './localitadto';
import { TipologiaDTO } from './tipologiadto';

export class EsercizioDTO {

     Id: number;
    
     nome: string;
	
	 indirizzo: string;
	
	 PrezzoMedio: number;
	
	 localita: LocalitaDTO;
	
	 tipologia: TipologiaDTO;

}