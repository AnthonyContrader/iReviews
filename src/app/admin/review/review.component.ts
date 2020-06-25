import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { ReviewDTO } from 'src/dto/reviewdto';
import { ReviewService } from 'src/service/review.service';
import { EsercizioDTO } from 'src/dto/eserciziodto';
import { TipologiaDTO } from 'src/dto/tipologiadto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { EsercizioService } from 'src/service/esercizio.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent  implements OnInit {

  esercizi: EsercizioDTO[];
  users: UserDTO[];
  reviewInsert: ReviewDTO= new ReviewDTO();
  reviews: ReviewDTO[];
  selected: ReviewDTO;

  constructor( private service: ReviewService,//private //userService: //UserService,
    private esercizioService: EsercizioService) {

  }



  ngOnInit() {
    this.clear();
    this.getAll();
    this.getEsercizi();
    this.getUsers();
  }
  getUsers() {
    this.service.userLogged
  }
  getEsercizi() {
    this.esercizioService.getAll().subscribe(esercizi=>this.esercizi=esercizi);
  }


  clear() {
    this.reviewInsert = new ReviewDTO();
  }

  close() {
    this.selected = null;
  }

  getAll() {
    //this.userService.getAll().subscribe(users=>this.users=users);
    this.esercizioService.getAll().subscribe(esercizi=>this.esercizi=esercizi);
    this.service.getAll().subscribe(reviews=>this.reviews=reviews);
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.getAll());
  }

  update(reviews: ReviewDTO) {
    this.service.update(reviews).subscribe(() => this.getAll());
  }

  insert(reviews: ReviewDTO) {
    this.service.insert(reviews).subscribe(() => this.getAll());
  }

  select(reviews: ReviewDTO) {
    this.selected = reviews;
  }

}
