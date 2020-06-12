import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipologiaDTO } from 'src/dto/tipologiadto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class TipologiaService extends AbstractService<TipologiaDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'tipologia';
  }
}
