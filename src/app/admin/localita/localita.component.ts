import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { LocalitaDTO } from 'src/dto/localitadto';
import { LocalitaService } from 'src/service/localita.service';

@Component({
  selector: 'app-localita',
  templateUrl: './localita.component.html',
  styleUrls: ['./localita.component.css']
})
export class LocalitaComponent extends AbstractCrudComponent<LocalitaDTO> implements OnInit {


  constructor(service: LocalitaService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new LocalitaDTO();
  }

  close() {
    this.selected = null;
  }
}
