package fr.polytech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlDto {

    @JsonProperty("url")
    private String url;
}
