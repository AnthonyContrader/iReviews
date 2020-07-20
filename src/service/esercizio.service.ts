import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { EsercizioDTO } from 'src/dto/eserciziodto';

@Injectable({
  providedIn: 'root'
})
export class EsercizioService extends AbstractService<EsercizioDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'esercizio';
  }
}
