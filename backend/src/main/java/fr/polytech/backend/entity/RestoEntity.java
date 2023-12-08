package fr.polytech.backend.entity;

import fr.polytech.backend.entity.enums.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "restos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestoEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(90)", nullable = false)
    private String name;

    @Column(name = "address", columnDefinition = "varchar(255)", nullable = false)
    private String address;

    @Column(name = "avgReview", columnDefinition = "float")
    private Float avgReview;

    @Column(name = "photo", columnDefinition = "varchar(255)")
    private String photo;

    @Column(name = "tag", columnDefinition = "varchar(255)")
    private Tag tag;

    @OneToMany(mappedBy = "resto")
    private List<ReviewEntity> reviews;

    @OneToOne()
    @JoinColumn(name="finalReview")
    private FinalReviewEntity finalReview;

}
