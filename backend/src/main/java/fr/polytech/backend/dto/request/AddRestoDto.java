package fr.polytech.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddRestoDto {

    @JsonProperty("name")
    @Size(max = 90)
    private String name;

    @JsonProperty("address")
    @Size(max = 255)
    private String address;

    @JsonProperty("tag")
    private Integer tag;

}
