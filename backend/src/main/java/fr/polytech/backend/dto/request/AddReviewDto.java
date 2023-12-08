package fr.polytech.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddReviewDto {

    @JsonProperty("name")
    @Size(max = 50)
    private String name;

    @JsonProperty("comment")
    @Size(max = 255)
    private String comment;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private Integer note;

}
