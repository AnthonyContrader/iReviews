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

     id: number;

     nome:string ;

	 indirizzo: string;

	 prezzoMedio: number;

	 localitaId: number

   localita: LocalitaDTO;

    tipologiaId: number;

   tipologia: TipologiaDTO;

   localitaCitta: String;

   tipologiaTipologia: string;


}
