import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ReviewDTO } from 'src/dto/reviewdto';

@Injectable({
  providedIn: 'root'
})
export class ReviewService extends AbstractService<ReviewDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'review';
  }
}
