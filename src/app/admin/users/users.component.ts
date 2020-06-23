import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 *
 * @author Vittorio Valent
 *
 * @see AbstractCrudComponent
 *
 */
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent  implements OnInit {
  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();

  constructor(private service: UserService) {

  }

  ngOnInit() {
    this.getUsers();;
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
