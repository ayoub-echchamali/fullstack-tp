import { Component, Input } from '@angular/core';
import { ReviewDto } from '../../../models/dto/review.dto';
import { NgFor, NgOptimizedImage } from '@angular/common';
import { ReviewService } from '../../../services/review.service';

@Component({
  selector: 'app-reviews-display',
  standalone: true,
  imports: [NgFor, NgOptimizedImage],
  templateUrl: './reviews-display.component.html',
  styleUrl: './reviews-display.component.css'
})
export class ReviewsDisplayComponent {

  @Input() reviews: ReviewDto[] = [];

  @Input() restoId: number = 0;

  constructor(private readonly reviewService: ReviewService){}

  public deleteReview(review: ReviewDto){
    this.reviewService.deleteReview(this.restoId, review.id);
  }

}
