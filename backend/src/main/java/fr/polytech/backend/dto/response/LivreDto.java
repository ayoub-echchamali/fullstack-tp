package fr.polytech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend.entity.LivreEntity;
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
public class LivreDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("titre")
    private String titre;

    @JsonProperty("commentaires")
    private List<CommentaireDto> commentaires;

    public static LivreDto buildFromEntity(LivreEntity livreEntity) {
        return LivreDto.builder()
                .id(livreEntity.getId())
                .titre(livreEntity.getTitre())
                .commentaires(livreEntity.getCommentaires() != null ? livreEntity.getCommentaires().stream().map(commentaireEntity -> CommentaireDto.buildFromEntity(commentaireEntity)).toList() : new ArrayList<>())
                .build();
    }

}
