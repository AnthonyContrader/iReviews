import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { LocalitaDTO } from 'src/dto/localitadto';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class LocalitaService extends AbstractService<LocalitaDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.nome='customer';
    this.type = 'localita';
    this.port='8081';
  }

  auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;

    console.log(user.authorities + 'user');
    if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }

  userLogged(username: string) {
    // console.log('qua: ', this.auth());
     console.log(this.auth());
     return this.http.get('http://localhost:8081/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
    }
}