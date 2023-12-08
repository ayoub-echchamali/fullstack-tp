package fr.polytech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "commentaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaireEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "texte", columnDefinition = "TEXT")
    private String texte;

    @ManyToOne()
    @JoinColumn(name = "livre")
    private LivreEntity livre;

}
