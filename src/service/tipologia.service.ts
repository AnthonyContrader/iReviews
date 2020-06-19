import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipologiaDTO } from 'src/dto/tipologiadto';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class TipologiaService extends AbstractService<TipologiaDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.nome='customer';
    this.type = 'tipologia';
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
