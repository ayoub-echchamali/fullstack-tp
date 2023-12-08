package fr.polytech.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "author", columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(name = "comment", columnDefinition = "varchar(50)", nullable = false)
    private String comment;

    @Column(name = "note", columnDefinition = "integer default 0", nullable = false)
    @Min(0)
    @Max(3)
    private Integer note;

    @Column(name = "publish_date", columnDefinition = "date", nullable = false)
    private LocalDate publishDate;

    @Column(name = "edit_date", columnDefinition = "date")
    private LocalDate editDate;

    @Column(name = "photo", columnDefinition = "varchar(255)")
    private String photo;

    @ManyToOne()
    @JoinColumn(name = "resto")
    private RestoEntity resto;

}
