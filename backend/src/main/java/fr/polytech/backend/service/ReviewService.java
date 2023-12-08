package fr.polytech.backend.service;

import fr.polytech.backend.dto.request.AddRestoDto;
import fr.polytech.backend.dto.request.AddReviewDto;
import fr.polytech.backend.entity.ReviewEntity;
import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.entity.enums.Tag;
import fr.polytech.backend.exception.InvalidValueException;
import fr.polytech.backend.exception.ResourceNotFoundException;
import fr.polytech.backend.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestoService restoService;
    private final S3Service s3Service;

    public List<ReviewEntity> getReviews(final Integer restoId) {
        final RestoEntity resto = this.restoService.getRestoById(restoId);
        return this.reviewRepository.findAllByResto(resto);
    }

    public ReviewEntity getReviewById(final Integer reviewId) {
        return this.reviewRepository.findById(reviewId).get();
    }

    public ReviewEntity addReviewToResto(final Integer restoId, final AddReviewDto reviewDto) {
        final RestoEntity resto = this.restoService.getRestoById(restoId);
        final ReviewEntity review = ReviewEntity.builder().name(reviewDto.getName()).comment(reviewDto.getComment()).note(reviewDto.getNote()).publishDate(LocalDate.now()).resto(resto).build();
        return this.reviewRepository.save(review);
    }

    public void deleteReview(final Integer id) {
        this.reviewRepository.deleteById(id);
    }

    public ReviewEntity editReview(int id, AddReviewDto reviewDto) throws Exception {
        if (reviewDto.getName() == null) {
            throw new InvalidValueException("New name cannot be null.");
        }
        final ReviewEntity reviewToUpdate = this.reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review with ID " + id + " doesn't exist"));
        reviewToUpdate.setName(reviewDto.getName());
        reviewToUpdate.setComment(reviewDto.getComment());
        reviewToUpdate.setNote(reviewDto.getNote());
        reviewRepository.save(reviewToUpdate);
        return reviewToUpdate;
    }

    public String getPhotoDownloadUrl(final Integer reviewId) {
        return this.s3Service.getDownloadUrlResto("review_ayoub_" + reviewId);
    }

    public String putPhotoDownloadUrl(final Integer restoId) {
        return this.s3Service.putDownloadUrlResto("review_ayoub_" + restoId);
    }

}
