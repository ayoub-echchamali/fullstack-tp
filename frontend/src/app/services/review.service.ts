import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReviewDto } from '../models/dto/review.dto';
import { UrlDto } from '../models/dto/url.dto';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private httpClient: HttpClient) {}

  public loadReviews(resto_id: number): Observable<ReviewDto[]> {
    return this.httpClient.get<ReviewDto[]>(`http://localhost:8080/restaurants/${resto_id}/reviews`);
  }

  public deleteReview(resto_id: number, review_id: number) {
    return this.httpClient.delete(`http://localhost:8080/restaurants/${resto_id}/reviews/${review_id}`);
    }

  public getReviewPhoto(resto_id: number, review_id: number): Observable<UrlDto> {
    return this.httpClient.get<UrlDto>(`http://localhost:8080/restaurants/${resto_id}/reviews/${review_id}/photo`);
  }
}
