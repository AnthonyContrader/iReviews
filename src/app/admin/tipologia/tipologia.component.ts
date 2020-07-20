import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { TipologiaDTO } from 'src/dto/tipologiadto';
import { TipologiaService } from 'src/service/tipologia.service';

@Component({
  selector: 'app-tipologia',
  templateUrl: './tipologia.component.html',
  styleUrls: ['./tipologia.component.css']
})
export class TipologiaComponent extends AbstractCrudComponent<TipologiaDTO> implements OnInit {


  constructor(service: TipologiaService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new TipologiaDTO();
  }

  close() {
    this.selected = null;
  }
}
