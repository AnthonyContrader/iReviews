import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { EsercizioService } from 'src/service/esercizio.service';
import { EsercizioDTO } from 'src/dto/eserciziodto';
import { LocalitaDTO } from 'src/dto/localitadto';
import { TipologiaDTO } from 'src/dto/tipologiadto';
import { TipologiaService } from 'src/service/tipologia.service';
import { LocalitaService } from 'src/service/localita.service';

@Component({
  selector: 'app-esercizio',
  templateUrl: './esercizio.component.html',
  styleUrls: ['./esercizio.component.css']
})
export class EsercizioComponent  implements OnInit {

  
  
 localitas: LocalitaDTO[];
 tipologie: TipologiaDTO[];
 esercizioInsert: EsercizioDTO= new EsercizioDTO();
 esercizi: EsercizioDTO[];
 selected: EsercizioDTO;

  constructor( private service: EsercizioService,private tipologiaService: TipologiaService, 
    private localitaService: LocalitaService) {
    
  }



  ngOnInit() {
    this.clear();
    this.getAll();
    this.getTipologia();
    this.getLocalita();
  }
  getTipologia() {
    this.tipologiaService.getAll().subscribe(tipologie=>this.tipologie=tipologie);
  }
  getLocalita() {
    this.localitaService.getAll().subscribe(localitas=>this.localitas=localitas);
  }
  

  clear() {
    this.esercizioInsert = new EsercizioDTO();
  }

  close() {
    this.selected = null;
  }

  getAll() {
    this.localitaService.getAll().subscribe(localitas=>this.localitas=localitas);
    this.tipologiaService.getAll().subscribe(tipologie=>this.tipologie=tipologie);
    this.service.getAll().subscribe(esercizi=>this.esercizi=esercizi);
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.getAll());
  }

  update(esercizio: EsercizioDTO) {
    this.service.update(esercizio).subscribe(() => this.getAll());
  }

  insert(esercizio: EsercizioDTO) {
    this.service.insert(esercizio).subscribe(() => this.getAll());
  }

  select(esercizio: EsercizioDTO) {
    this.selected = esercizio;
  }
}
