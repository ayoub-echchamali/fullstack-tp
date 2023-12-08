import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../../services/review.service';
import { ReviewDto } from '../../models/dto/review.dto';
import { RestoDto } from '../../models/dto/resto.dto';
import { RestoDetailsDisplayComponent } from './resto-details-display/resto-details-display.component';
import { ReviewsDisplayComponent } from './reviews-display/reviews-display.component';
import { AddReviewFormComponent } from './add-review-form/add-review-form.component';
import { ActivatedRoute } from '@angular/router';
import { RestoService } from '../../services/resto.service';

@Component({
  selector: 'app-review-details',
  standalone: true,
  imports: [RestoDetailsDisplayComponent, ReviewsDisplayComponent, AddReviewFormComponent],
  templateUrl: './resto-details.component.html',
  styleUrl: './resto-details.component.css'
})
export class RestoDetailsComponent implements OnInit{

  public reviews: ReviewDto[] = [];

  public restoId: number = 0

  public resto: RestoDto = {
    id: 0,
    name: "", 
    address: "", 
    avgReview: 0, 
    photo: "",
    tag: 0, 
    reviews: []
  };

  constructor(private readonly reviewService: ReviewService,  private restoService: RestoService, private route: ActivatedRoute){}

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.restoId = +params['id'];
    });
    this.restoService.getRestoById(this.restoId).subscribe(data => {
      this.resto = data;
    });
    this.getRestoPhoto(this.restoId)
    this.refreshReviews()
  }

  public refreshReviews() {
    this.reviewService.loadReviews(this.restoId).subscribe(value => {
      this.reviews = value;
      this.reviews.forEach(review => this.getPhoto(review));
    })
  }

  public getPhoto(review: ReviewDto): void {
    this.reviewService.getReviewPhoto(this.restoId, review.id).subscribe(urlDto => {
      review.photo = urlDto.url;
    });
  }

  public getRestoPhoto(restoId: number): void {
    this.restoService.getRestoPhoto(restoId).subscribe(urlDto => {
      this.resto.photo = urlDto.url;
    });
  }
  
}
