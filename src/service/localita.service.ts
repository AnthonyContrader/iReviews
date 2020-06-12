import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { LocalitaDTO } from 'src/dto/localitadto';

@Injectable({
  providedIn: 'root'
})
export class LocalitaService extends AbstractService<LocalitaDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'localita';
  }
}
