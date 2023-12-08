package fr.polytech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "livres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivreEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "titre", columnDefinition = "varchar(255)", nullable = false)
    private String titre;

    @ManyToMany
    @JoinTable(name = "biblios_jn_livres",
            joinColumns = @JoinColumn(name = "livre"),
            inverseJoinColumns = @JoinColumn(name = "biblio"))
    private List<BiblioEntity> biblios;

    @OneToMany(mappedBy = "livre")
    private List<CommentaireEntity> commentaires;

}
