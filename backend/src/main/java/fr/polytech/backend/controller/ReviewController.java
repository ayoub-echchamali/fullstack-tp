package fr.polytech.backend.controller;

import fr.polytech.backend.dto.request.AddRestoDto;
import fr.polytech.backend.dto.request.AddReviewDto;
import fr.polytech.backend.dto.response.RestoDto;
import fr.polytech.backend.dto.response.ReviewDto;
import fr.polytech.backend.dto.response.UrlDto;
import fr.polytech.backend.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/restaurants/{restoId}/reviews")
    public List<ReviewDto> getReviews(@PathVariable Integer restoId) {
        return reviewService.getReviews(restoId).stream().map(ReviewDto::buildFromEntity).toList();
    }
    @PostMapping("/restaurants/{restoId}/review")
    public ReviewDto addReview(@PathVariable Integer restoId, @Valid @RequestBody AddReviewDto addReviewDto) {
        return ReviewDto.buildFromEntity(this.reviewService.addReviewToResto(restoId, addReviewDto));
    }

    @PutMapping("/restaurants/{restoId}/reviews/{id}")
    public ReviewDto editReview(@PathVariable Integer id, @Valid @RequestBody AddReviewDto reviewDto) throws Exception {
        return ReviewDto.buildFromEntity(this.reviewService.editReview(id, reviewDto));
    }

    @DeleteMapping("/restaurants/{restoId}/reviews/{id}")
    public void deleteReview(@PathVariable Integer id) {
        this.reviewService.deleteReview(id);
    }

    @GetMapping("/restaurants/{restoId}/reviews/{id}/photo")
    public UrlDto getReviewPhotoById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.reviewService.getPhotoDownloadUrl(id)).build();
    }

    @PutMapping("/restaurants/{restoId}/reviews/{id}/photo")
    public UrlDto putReviewPhotoById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.reviewService.putPhotoDownloadUrl(id)).build();
    }

}
