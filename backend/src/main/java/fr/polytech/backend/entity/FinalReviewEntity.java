package fr.polytech.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "finalReview")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalReviewEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "author", columnDefinition = "varchar(90)", nullable = false)
    private String name;

    @Column(name = "comment", columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(name = "note", columnDefinition = "integer default 0", nullable = false)
    @Min(0)
    @Max(3)
    private Integer note;

    @OneToOne()
    @JoinColumn(name = "resto")
    private RestoEntity resto;

}
