package fr.polytech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.entity.ReviewEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private Integer note;

    @JsonProperty("publishDate")
    private LocalDate publishDate;

    @JsonProperty("editDate")
    private LocalDate editDate;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("resto")
    private Integer resto;

    public static ReviewDto buildFromEntity(ReviewEntity reviewEntity) {
        return ReviewDto.builder().name(reviewEntity.getName())
                .id(reviewEntity.getId())
                .comment(reviewEntity.getComment())
                .note(reviewEntity.getNote())
                .publishDate(reviewEntity.getPublishDate())
                .editDate(reviewEntity.getEditDate())
                .photo(reviewEntity.getPhoto())
                .resto(reviewEntity.getResto().getId())
                .build();
    }

}
