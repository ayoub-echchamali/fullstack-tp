package fr.polytech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend.entity.FinalReviewEntity;
import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.entity.ReviewEntity;
import fr.polytech.backend.entity.enums.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestoDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("avgReview")
    private Float avgReview;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("tag")
    private Tag tag;

    public static RestoDto buildFromEntity(RestoEntity restoEntity) {
        return RestoDto.builder()
                .id(restoEntity.getId())
                .name(restoEntity.getName())
                .address(restoEntity.getAddress())
                .avgReview(restoEntity.getAvgReview())
                .photo(restoEntity.getPhoto())
                .tag(restoEntity.getTag())
                .build();
    }
}