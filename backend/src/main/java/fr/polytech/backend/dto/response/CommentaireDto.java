package fr.polytech.backend.dto.response;

import fr.polytech.backend.entity.CommentaireEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaireDto {

    private Integer id;

    private String texte;

    public static CommentaireDto buildFromEntity(CommentaireEntity commentaireEntity) {
        return CommentaireDto.builder().id(commentaireEntity.getId()).texte(commentaireEntity.getTexte()).build();
    }

}
