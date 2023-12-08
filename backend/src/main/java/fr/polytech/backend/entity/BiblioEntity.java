package fr.polytech.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "biblios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BiblioEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(255)", nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "biblios")
    private List<LivreEntity> livres;

}
