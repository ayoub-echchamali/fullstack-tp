import { Tag } from "../enum/tag.enum";
import { ReviewDto } from "./review.dto";

export interface RestoDto {
  id: number;
  name: string;
  address: string;
  avgReview: number;
  photo: string;
  tag: Tag;
  reviews: ReviewDto[];
  // finalReview: FinalReviewDto
}
