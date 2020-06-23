import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

/**
 * Questa component si occupa di mostrare i dettagli di un utente (in questo caso aggiunge solo l'ID
 * alle informazioni già mostrate nella tabella generale). L'annotation "@Input()" prende il valore di dto
 * dalla UsersComponent ( usando il binding [dto]) e nel template ne mostra i dettagli. Questa component
 * non viene chiamata mediante routing ma viene mostrata solo quando dto non è nullo (usando la direttiva
 * *ngIf ).
 *
 * @author Vittorio Valent
 *
 * @see UsersComponent
 */
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['../users.component.css']
})
export class UserDetailsComponent  implements OnInit {

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: UserDTO;
  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();


  constructor(private service: UserService) {

  }

  ngOnInit() {
  }
  getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }

  deleteU(user: UserDTO) {
    this.service.deleteU(user.login).subscribe(() => this.getUsers());
  }


  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
  }

  insert(user: UserDTO) {
    console.log(user)
    this.service.insert(user).subscribe(() => this.getUsers());
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }

}
